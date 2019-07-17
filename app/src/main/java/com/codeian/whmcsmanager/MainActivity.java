package com.codeian.whmcsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.codeian.whmcsmanager.Adapters.ClientsAdapter;
import com.codeian.whmcsmanager.Model.Client.Clients;
import com.codeian.whmcsmanager.Model.Client.DataModel;
import com.codeian.whmcsmanager.Network.ApiHandler;
import com.codeian.whmcsmanager.Network.GetService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    /*private RecyclerView recyclerView;*/
    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bindings
        gridLayout = findViewById(R.id.gridLayout);
/*        recyclerView = findViewById(R.id.clientListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/

        /*//Get Client List
        getClientList();*/

        //Grid
        setSingleEvent(gridLayout);

    }

    /*private void getClientList(){

        GetService service = ApiHandler.getRetrofitInstance().create(GetService.class);
        Call<DataModel> dataModelClient = service.getClients();
        dataModelClient.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                    DataModel body = response.body();
                    Clients clientList = body.getClients();
                    recyclerView.setAdapter(new ClientsAdapter(MainActivity.this, clientList.getClient()));
                    clientList.getClient().size();
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }*/

    private void setSingleEvent(GridLayout gridLayout){
        for(int i = 0; i<gridLayout.getChildCount(); i++){
            CardView cardView = (CardView) gridLayout.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finalI == 0){
                        Intent intent = new Intent(MainActivity.this, ClientList.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Clicked @ position " + finalI, Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
