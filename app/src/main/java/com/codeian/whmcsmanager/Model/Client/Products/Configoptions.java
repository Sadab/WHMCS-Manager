
package com.codeian.whmcsmanager.Model.Client.Products;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Configoptions {

    @SerializedName("configoption")
    @Expose
    private List<Object> configoption = null;

    public List<Object> getConfigoption() {
        return configoption;
    }

    public void setConfigoption(List<Object> configoption) {
        this.configoption = configoption;
    }

}
