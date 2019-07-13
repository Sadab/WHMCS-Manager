package com.codeian.whmcsmanager.Network;

import com.codeian.whmcsmanager.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHandler {

    private static Retrofit retrofit;
    private static final String BASE_URL = BuildConfig.BASE_URL;

    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            //Initialize the Instance
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
