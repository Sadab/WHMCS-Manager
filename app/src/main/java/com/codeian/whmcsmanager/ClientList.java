package com.codeian.whmcsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.codeian.whmcsmanager.Adapters.ClientsAdapter;
import com.codeian.whmcsmanager.Model.Client.Clients;
import com.codeian.whmcsmanager.Model.Client.DataModel;
import com.codeian.whmcsmanager.Network.ApiHandler;
import com.codeian.whmcsmanager.Network.GetService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientList extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);

        //Bindings
        recyclerView = findViewById(R.id.clientListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Get Client List
        getClientList();
    }

    private void getClientList(){

        GetService service = ApiHandler.getRetrofitInstance().create(GetService.class);
        Call<DataModel> dataModelClient = service.getClients();
        dataModelClient.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                DataModel body = response.body();
                Clients clientList = body.getClients();
                recyclerView.setAdapter(new ClientsAdapter(ClientList.this, clientList.getClient()));
                clientList.getClient().size();
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
