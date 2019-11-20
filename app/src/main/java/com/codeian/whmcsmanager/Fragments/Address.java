package com.codeian.whmcsmanager.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codeian.whmcsmanager.BuildConfig;
import com.codeian.whmcsmanager.ClientList;
import com.codeian.whmcsmanager.Model.Client.Actions.ClientCloseRoot;
import com.codeian.whmcsmanager.Model.Client.Actions.ClientDelRoot;
import com.codeian.whmcsmanager.Network.ApiHandler;
import com.codeian.whmcsmanager.Network.GetService;
import com.codeian.whmcsmanager.R;
import com.codeian.whmcsmanager.SingleClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Address extends Fragment {

    View view;
    private Button delClient;
    private Button closeClient;
    private String accessKey = BuildConfig.accessKey;
    private String username = BuildConfig.username;
    private String password = BuildConfig.password;

    public Address() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.single_client_address_frag, container, false);
        delClient = view.findViewById(R.id.btnDelClient);
        closeClient = view.findViewById(R.id.btnCloseClient);
        SingleClient singleClient = (SingleClient) getActivity();
        final String clientId = singleClient.getClientId();

        delClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetService service = ApiHandler.getRetrofitInstance().create(GetService.class);
                Call<ClientDelRoot> clientDelRootCall = service.getClientDeleteService("DeleteClient", username, password, clientId, accessKey, "json");

                clientDelRootCall.enqueue(new Callback<ClientDelRoot>() {
                    @Override
                    public void onResponse(Call<ClientDelRoot> call, Response<ClientDelRoot> response) {
                        if (response.isSuccessful()) {
                            ClientDelRoot body = response.body();
                            if (body.getResult().contains("success")){
                                Toast.makeText(getContext(), "Client Deleted", Toast.LENGTH_LONG).show();
                                Intent startClientList = new Intent(getContext(), ClientList.class);
                                startActivity(startClientList);
                            } else {
                                Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ClientDelRoot> call, Throwable t) {
                        //@TODO
                        //Have to write edge case here
                    }
                });
            }
        });

        closeClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetService service = ApiHandler.getRetrofitInstance().create(GetService.class);
                Call<ClientCloseRoot> clientCloseRootCall = service.getClientCloseService("CloseClient", username, password, clientId, accessKey, "json");

                clientCloseRootCall.enqueue(new Callback<ClientCloseRoot>() {
                    @Override
                    public void onResponse(Call<ClientCloseRoot> call, Response<ClientCloseRoot> response) {
                        if(response.isSuccessful()){
                            ClientCloseRoot body = response.body();
                            if (body.getResult().contains("success")){
                                Toast.makeText(getContext(), "Client Closed Successfully", Toast.LENGTH_LONG).show();
                                Intent startClientList = new Intent(getContext(), ClientList.class);
                                startActivity(startClientList);
                            } else {
                                Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ClientCloseRoot> call, Throwable t) {
                        //@TODO
                        //Have to write edge case here
                    }
                });
            }
        });

        return view;
    }


}
