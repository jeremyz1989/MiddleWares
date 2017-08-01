package com.celnet.dc.domain;

import java.util.Date;

public class ProductOrder {
    private Integer id;

    private String ordernumC;

    private Date receivedtimeC;

    private Date createddate;

    private String categoryC;

    private String buynameC;

    private String buyphoneC;

    private String sfid;

    private String hcErr;

    private Date ordercomfirmtimeC;

    private Date arrivetimeC;

    private String name;

    private String hcLastop;

    private Date systemmodstamp;

    private Date lastmodifieddate;

    private String reimbursenumC;

    private Date createtimeC;

    private String productnameC;

    private Boolean isdeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdernumC() {
        return ordernumC;
    }

    public void setOrdernumC(String ordernumC) {
        this.ordernumC = ordernumC == null ? null : ordernumC.trim();
    }

    public Date getReceivedtimeC() {
        return receivedtimeC;
    }

    public void setReceivedtimeC(Date receivedtimeC) {
        this.receivedtimeC = receivedtimeC;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getCategoryC() {
        return categoryC;
    }

    public void setCategoryC(String categoryC) {
        this.categoryC = categoryC == null ? null : categoryC.trim();
    }

    public String getBuynameC() {
        return buynameC;
    }

    public void setBuynameC(String buynameC) {
        this.buynameC = buynameC == null ? null : buynameC.trim();
    }

    public String getBuyphoneC() {
        return buyphoneC;
    }

    public void setBuyphoneC(String buyphoneC) {
        this.buyphoneC = buyphoneC == null ? null : buyphoneC.trim();
    }

    public String getSfid() {
        return sfid;
    }

    public void setSfid(String sfid) {
        this.sfid = sfid == null ? null : sfid.trim();
    }

    public String getHcErr() {
        return hcErr;
    }

    public void setHcErr(String hcErr) {
        this.hcErr = hcErr == null ? null : hcErr.trim();
    }

    public Date getOrdercomfirmtimeC() {
        return ordercomfirmtimeC;
    }

    public void setOrdercomfirmtimeC(Date ordercomfirmtimeC) {
        this.ordercomfirmtimeC = ordercomfirmtimeC;
    }

    public Date getArrivetimeC() {
        return arrivetimeC;
    }

    public void setArrivetimeC(Date arrivetimeC) {
        this.arrivetimeC = arrivetimeC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getHcLastop() {
        return hcLastop;
    }

    public void setHcLastop(String hcLastop) {
        this.hcLastop = hcLastop == null ? null : hcLastop.trim();
    }

    public Date getSystemmodstamp() {
        return systemmodstamp;
    }

    public void setSystemmodstamp(Date systemmodstamp) {
        this.systemmodstamp = systemmodstamp;
    }

    public Date getLastmodifieddate() {
        return lastmodifieddate;
    }

    public void setLastmodifieddate(Date lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    public String getReimbursenumC() {
        return reimbursenumC;
    }

    public void setReimbursenumC(String reimbursenumC) {
        this.reimbursenumC = reimbursenumC == null ? null : reimbursenumC.trim();
    }

    public Date getCreatetimeC() {
        return createtimeC;
    }

    public void setCreatetimeC(Date createtimeC) {
        this.createtimeC = createtimeC;
    }

    public String getProductnameC() {
        return productnameC;
    }

    public void setProductnameC(String productnameC) {
        this.productnameC = productnameC == null ? null : productnameC.trim();
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}