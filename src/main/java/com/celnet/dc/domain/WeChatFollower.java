package com.celnet.dc.domain;

import java.util.Date;

public class WeChatFollower {
    private Integer id;

    private Date createddate;

    private Boolean isdeleted;

    private String accountC;

    private String name;

    private Date systemmodstamp;

    private String sfid;

    private String hcErr;

    private String hcLastop;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getAccountC() {
        return accountC;
    }

    public void setAccountC(String accountC) {
        this.accountC = accountC == null ? null : accountC.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getSystemmodstamp() {
        return systemmodstamp;
    }

    public void setSystemmodstamp(Date systemmodstamp) {
        this.systemmodstamp = systemmodstamp;
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

    public String getHcLastop() {
        return hcLastop;
    }

    public void setHcLastop(String hcLastop) {
        this.hcLastop = hcLastop == null ? null : hcLastop.trim();
    }
}