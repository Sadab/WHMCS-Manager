package com.codeian.whmcsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.codeian.whmcsmanager.Model.Client;
import com.codeian.whmcsmanager.Model.Clients;
import com.codeian.whmcsmanager.Model.DataModel;
import com.codeian.whmcsmanager.Network.ApiHandler;
import com.codeian.whmcsmanager.Network.GetService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get Client List
        getClientList();

    }

    private void getClientList(){

        GetService service = ApiHandler.getRetrofitInstance().create(GetService.class);
        Call<DataModel> dataModelClient = service.getClients();
        dataModelClient.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if(response.isSuccessful()){
                    DataModel body = response.body();
                    Clients clientList = body.getClients();
                    clientList.getClient().size();
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
