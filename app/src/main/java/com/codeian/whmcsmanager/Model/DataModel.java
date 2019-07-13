package com.codeian.whmcsmanager.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {

    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("totalresults")
    @Expose
    private String totalresults;
    @SerializedName("startnumber")
    @Expose
    private Integer startnumber;
    @SerializedName("numreturned")
    @Expose
    private Integer numreturned;
    @SerializedName("clients")
    @Expose
    private Clients clients;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

}
