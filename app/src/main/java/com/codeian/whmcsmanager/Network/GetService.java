package com.codeian.whmcsmanager.Network;

import com.codeian.whmcsmanager.BuildConfig;
import com.codeian.whmcsmanager.Model.Client.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetService {

    String accessKey = BuildConfig.accessKey;
    String username = BuildConfig.username;
    String password = BuildConfig.password;
    String FINAL_URL = "/includes/api.php?username="+username+"&"+"password="+password+"&responsetype=json&action=GetClients&accesskey="+accessKey;

    @GET(FINAL_URL)
    Call<DataModel> getClientsService();
}
