
package com.codeian.whmcsmanager.Model.Client.Products;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customfields {

    @SerializedName("customfield")
    @Expose
    private List<Object> customfield = null;

    public List<Object> getCustomfield() {
        return customfield;
    }

    public void setCustomfield(List<Object> customfield) {
        this.customfield = customfield;
    }

}
