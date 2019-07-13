package com.codeian.whmcsmanager.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clients {

    @SerializedName("client")
    @Expose
    private List<Client> client = null;

    public List<Client> getClient() {
        return client;
    }

    public void setClient(List<Client> client) {
        this.client = client;
    }

}