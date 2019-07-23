
package com.codeian.whmcsmanager.Model.Client.Products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientProductsRoot {

    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("clientid")
    @Expose
    private String clientid;
    @SerializedName("serviceid")
    @Expose
    private Object serviceid;
    @SerializedName("pid")
    @Expose
    private Object pid;
    @SerializedName("domain")
    @Expose
    private Object domain;
    @SerializedName("totalresults")
    @Expose
    private String totalresults;
    @SerializedName("startnumber")
    @Expose
    private Integer startnumber;
    @SerializedName("numreturned")
    @Expose
    private Integer numreturned;
    @SerializedName("products")
    @Expose
    private Products products;

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

    public Object getServiceid() {
        return serviceid;
    }

    public void setServiceid(Object serviceid) {
        this.serviceid = serviceid;
    }

    public Object getPid() {
        return pid;
    }

    public void setPid(Object pid) {
        this.pid = pid;
    }

    public Object getDomain() {
        return domain;
    }

    public void setDomain(Object domain) {
        this.domain = domain;
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

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

}
