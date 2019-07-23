
package com.codeian.whmcsmanager.Model.Client.Products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("clientid")
    @Expose
    private String clientid;
    @SerializedName("orderid")
    @Expose
    private String orderid;
    @SerializedName("pid")
    @Expose
    private String pid;
    @SerializedName("regdate")
    @Expose
    private String regdate;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("translated_name")
    @Expose
    private String translatedName;
    @SerializedName("groupname")
    @Expose
    private String groupname;
    @SerializedName("translated_groupname")
    @Expose
    private String translatedGroupname;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("dedicatedip")
    @Expose
    private String dedicatedip;
    @SerializedName("serverid")
    @Expose
    private String serverid;
    @SerializedName("servername")
    @Expose
    private String servername;
    @SerializedName("serverip")
    @Expose
    private String serverip;
    @SerializedName("serverhostname")
    @Expose
    private String serverhostname;
    @SerializedName("suspensionreason")
    @Expose
    private String suspensionreason;
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
    @SerializedName("billingcycle")
    @Expose
    private String billingcycle;
    @SerializedName("nextduedate")
    @Expose
    private String nextduedate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("subscriptionid")
    @Expose
    private String subscriptionid;
    @SerializedName("promoid")
    @Expose
    private String promoid;
    @SerializedName("overideautosuspend")
    @Expose
    private String overideautosuspend;
    @SerializedName("overidesuspenduntil")
    @Expose
    private String overidesuspenduntil;
    @SerializedName("ns1")
    @Expose
    private String ns1;
    @SerializedName("ns2")
    @Expose
    private String ns2;
    @SerializedName("assignedips")
    @Expose
    private String assignedips;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("diskusage")
    @Expose
    private String diskusage;
    @SerializedName("disklimit")
    @Expose
    private String disklimit;
    @SerializedName("bwusage")
    @Expose
    private String bwusage;
    @SerializedName("bwlimit")
    @Expose
    private String bwlimit;
    @SerializedName("lastupdate")
    @Expose
    private String lastupdate;
    @SerializedName("customfields")
    @Expose
    private Customfields customfields;
    @SerializedName("configoptions")
    @Expose
    private Configoptions configoptions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTranslatedName() {
        return translatedName;
    }

    public void setTranslatedName(String translatedName) {
        this.translatedName = translatedName;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getTranslatedGroupname() {
        return translatedGroupname;
    }

    public void setTranslatedGroupname(String translatedGroupname) {
        this.translatedGroupname = translatedGroupname;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDedicatedip() {
        return dedicatedip;
    }

    public void setDedicatedip(String dedicatedip) {
        this.dedicatedip = dedicatedip;
    }

    public String getServerid() {
        return serverid;
    }

    public void setServerid(String serverid) {
        this.serverid = serverid;
    }

    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername;
    }

    public String getServerip() {
        return serverip;
    }

    public void setServerip(String serverip) {
        this.serverip = serverip;
    }

    public String getServerhostname() {
        return serverhostname;
    }

    public void setServerhostname(String serverhostname) {
        this.serverhostname = serverhostname;
    }

    public String getSuspensionreason() {
        return suspensionreason;
    }

    public void setSuspensionreason(String suspensionreason) {
        this.suspensionreason = suspensionreason;
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

    public String getBillingcycle() {
        return billingcycle;
    }

    public void setBillingcycle(String billingcycle) {
        this.billingcycle = billingcycle;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getOverideautosuspend() {
        return overideautosuspend;
    }

    public void setOverideautosuspend(String overideautosuspend) {
        this.overideautosuspend = overideautosuspend;
    }

    public String getOveridesuspenduntil() {
        return overidesuspenduntil;
    }

    public void setOveridesuspenduntil(String overidesuspenduntil) {
        this.overidesuspenduntil = overidesuspenduntil;
    }

    public String getNs1() {
        return ns1;
    }

    public void setNs1(String ns1) {
        this.ns1 = ns1;
    }

    public String getNs2() {
        return ns2;
    }

    public void setNs2(String ns2) {
        this.ns2 = ns2;
    }

    public String getAssignedips() {
        return assignedips;
    }

    public void setAssignedips(String assignedips) {
        this.assignedips = assignedips;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDiskusage() {
        return diskusage;
    }

    public void setDiskusage(String diskusage) {
        this.diskusage = diskusage;
    }

    public String getDisklimit() {
        return disklimit;
    }

    public void setDisklimit(String disklimit) {
        this.disklimit = disklimit;
    }

    public String getBwusage() {
        return bwusage;
    }

    public void setBwusage(String bwusage) {
        this.bwusage = bwusage;
    }

    public String getBwlimit() {
        return bwlimit;
    }

    public void setBwlimit(String bwlimit) {
        this.bwlimit = bwlimit;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

    public Customfields getCustomfields() {
        return customfields;
    }

    public void setCustomfields(Customfields customfields) {
        this.customfields = customfields;
    }

    public Configoptions getConfigoptions() {
        return configoptions;
    }

    public void setConfigoptions(Configoptions configoptions) {
        this.configoptions = configoptions;
    }

}
