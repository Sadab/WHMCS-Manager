
package com.codeian.whmcsmanager.Model.Client.Domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Domain {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("orderid")
    @Expose
    private String orderid;
    @SerializedName("regtype")
    @Expose
    private String regtype;
    @SerializedName("domainname")
    @Expose
    private String domainname;
    @SerializedName("registrar")
    @Expose
    private String registrar;
    @SerializedName("regperiod")
    @Expose
    private String regperiod;
    @SerializedName("firstpaymentamount")
    @Expose
    private String firstpaymentamount;
    @SerializedName("recurringamount")
    @Expose
    private String recurringamount;
    @SerializedName("paymentmethod")
    @Expose
    private String paymentmethod;
    @SerializedName("paymentmethodname")
    @Expose
    private String paymentmethodname;
    @SerializedName("regdate")
    @Expose
    private String regdate;
    @SerializedName("expirydate")
    @Expose
    private String expirydate;
    @SerializedName("nextduedate")
    @Expose
    private String nextduedate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("subscriptionid")
    @Expose
    private String subscriptionid;
    @SerializedName("promoid")
    @Expose
    private String promoid;
    @SerializedName("dnsmanagement")
    @Expose
    private String dnsmanagement;
    @SerializedName("emailforwarding")
    @Expose
    private String emailforwarding;
    @SerializedName("idprotection")
    @Expose
    private String idprotection;
    @SerializedName("donotrenew")
    @Expose
    private String donotrenew;
    @SerializedName("notes")
    @Expose
    private String notes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getRegtype() {
        return regtype;
    }

    public void setRegtype(String regtype) {
        this.regtype = regtype;
    }

    public String getDomainname() {
        return domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }

    public String getRegistrar() {
        return registrar;
    }

    public void setRegistrar(String registrar) {
        this.registrar = registrar;
    }

    public String getRegperiod() {
        return regperiod;
    }

    public void setRegperiod(String regperiod) {
        this.regperiod = regperiod;
    }

    public String getFirstpaymentamount() {
        return firstpaymentamount;
    }

    public void setFirstpaymentamount(String firstpaymentamount) {
        this.firstpaymentamount = firstpaymentamount;
    }

    public String getRecurringamount() {
        return recurringamount;
    }

    public void setRecurringamount(String recurringamount) {
        this.recurringamount = recurringamount;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getPaymentmethodname() {
        return paymentmethodname;
    }

    public void setPaymentmethodname(String paymentmethodname) {
        this.paymentmethodname = paymentmethodname;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate;
    }

    public String getNextduedate() {
        return nextduedate;
    }

    public void setNextduedate(String nextduedate) {
        this.nextduedate = nextduedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubscriptionid() {
        return subscriptionid;
    }

    public void setSubscriptionid(String subscriptionid) {
        this.subscriptionid = subscriptionid;
    }

    public String getPromoid() {
        return promoid;
    }

    public void setPromoid(String promoid) {
        this.promoid = promoid;
    }

    public String getDnsmanagement() {
        return dnsmanagement;
    }

    public void setDnsmanagement(String dnsmanagement) {
        this.dnsmanagement = dnsmanagement;
    }

    public String getEmailforwarding() {
        return emailforwarding;
    }

    public void setEmailforwarding(String emailforwarding) {
        this.emailforwarding = emailforwarding;
    }

    public String getIdprotection() {
        return idprotection;
    }

    public void setIdprotection(String idprotection) {
        this.idprotection = idprotection;
    }

    public String getDonotrenew() {
        return donotrenew;
    }

    public void setDonotrenew(String donotrenew) {
        this.donotrenew = donotrenew;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
