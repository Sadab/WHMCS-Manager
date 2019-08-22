
package com.codeian.whmcsmanager.Model.Client.Domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientDomainRoot {

    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("clientid")
    @Expose
    private String clientid;
    @SerializedName("domainid")
    @Expose
    private Object domainid;
    @SerializedName("totalresults")
    @Expose
    private String totalresults;
    @SerializedName("startnumber")
    @Expose
    private Integer startnumber;
    @SerializedName("numreturned")
    @Expose
    private Integer numreturned;
    @SerializedName("domains")
    @Expose
    private Domains domains;

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

    public Object getDomainid() {
        return domainid;
    }

    public void setDomainid(Object domainid) {
        this.domainid = domainid;
    }

    public String getTotalresults() {
        return totalresults;
    }

    public void setTotalresults(String totalresults) {
        this.totalresults = totalresults;
    }

    public Integer getStartnumber() {
        return startnumber;
    }

    public void setStartnumber(Integer startnumber) {
        this.startnumber = startnumber;
    }

    public Integer getNumreturned() {
        return numreturned;
    }

    public void setNumreturned(Integer numreturned) {
        this.numreturned = numreturned;
    }

    public Domains getDomains() {
        return domains;
    }

    public void setDomains(Domains domains) {
        this.domains = domains;
    }

}
