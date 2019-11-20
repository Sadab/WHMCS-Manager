package com.codeian.whmcsmanager.Network;

import com.codeian.whmcsmanager.BuildConfig;
import com.codeian.whmcsmanager.Model.Client.Actions.ClientCloseRoot;
import com.codeian.whmcsmanager.Model.Client.Actions.ClientDelRoot;
import com.codeian.whmcsmanager.Model.Client.DataModel;
import com.codeian.whmcsmanager.Model.Client.Domain.ClientDomainRoot;
import com.codeian.whmcsmanager.Model.Client.Products.ClientProductsRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetService {

    String accessKey = BuildConfig.accessKey;
    String username = BuildConfig.username;
    String password = BuildConfig.password;
    String FINAL_URL = "/includes/api.php?username="+username+"&"+"password="+password+"&responsetype=json&action=GetClients&accesskey="+accessKey;

    @GET(FINAL_URL)
    Call<DataModel> getClientsService();

    @GET("/includes/api.php")
    Call<ClientProductsRoot> getClientProductsService(
            @Query("action") String actionName,
            @Query("username") String apiUsername,
            @Query("password") String apiPassword,
            @Query("accesskey") String apiAccessKey,
            @Query("responsetype") String apiResponseType,
            @Query("clientid") String userId
    );

    @GET("/includes/api.php")
    Call<ClientDomainRoot> getClientDomainService (
            @Query("action") String actionName,
            @Query("username") String apiUsername,
            @Query("password") String apiPassword,
            @Query("accesskey") String apiAccessKey,
            @Query("responsetype") String apiResponseType,
            @Query("stats") boolean stats,
            @Query("clientid") String userId
    );

    @GET("/includes/api.php")
    Call<ClientDelRoot> getClientDeleteService (
            @Query("action") String actionName,
            @Query("username") String apiUsername,
            @Query("password") String apiPassword,
            @Query("clientid") String clientId,
            @Query("accesskey") String apiAccessKey,
            @Query("responsetype") String responseType
    );

    @GET("/includes/api.php")
    Call<ClientCloseRoot> getClientCloseService (
            @Query("action") String actionName,
            @Query("username") String apiUsername,
            @Query("password") String apiPassword,
            @Query("clientid") String clientId,
            @Query("accesskey") String apiAccessKey,
            @Query("responsetype") String responseType
    );
}
