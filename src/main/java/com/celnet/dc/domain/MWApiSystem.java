package com.celnet.dc.domain;

import java.util.Date;

public class MWApiSystem {
    private String guid;

    private String apiSystemName;

    private String authoritedAppkey;

    private String secretKey;

    private String status;

    private String deleteflg;

    private Date createddate;

    private String createduserguid;

    private Date updatedate;

    private String updateuserguid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getApiSystemName() {
        return apiSystemName;
    }

    public void setApiSystemName(String apiSystemName) {
        this.apiSystemName = apiSystemName == null ? null : apiSystemName.trim();
    }

    public String getAuthoritedAppkey() {
        return authoritedAppkey;
    }

    public void setAuthoritedAppkey(String authoritedAppkey) {
        this.authoritedAppkey = authoritedAppkey == null ? null : authoritedAppkey.trim();
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey == null ? null : secretKey.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDeleteflg() {
        return deleteflg;
    }

    public void setDeleteflg(String deleteflg) {
        this.deleteflg = deleteflg == null ? null : deleteflg.trim();
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getCreateduserguid() {
        return createduserguid;
    }

    public void setCreateduserguid(String createduserguid) {
        this.createduserguid = createduserguid == null ? null : createduserguid.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getUpdateuserguid() {
        return updateuserguid;
    }

    public void setUpdateuserguid(String updateuserguid) {
        this.updateuserguid = updateuserguid == null ? null : updateuserguid.trim();
    }
}