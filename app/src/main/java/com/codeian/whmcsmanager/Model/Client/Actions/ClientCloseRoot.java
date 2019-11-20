
package com.codeian.whmcsmanager.Model.Client.Actions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientCloseRoot {

    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("clientid")
    @Expose
    private String clientid;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

}
