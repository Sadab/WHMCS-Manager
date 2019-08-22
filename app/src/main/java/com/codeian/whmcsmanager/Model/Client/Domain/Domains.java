
package com.codeian.whmcsmanager.Model.Client.Domain;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Domains {

    @SerializedName("domain")
    @Expose
    private List<Domain> domain = null;

    public List<Domain> getDomain() {
        return domain;
    }

    public void setDomain(List<Domain> domain) {
        this.domain = domain;
    }

}
