package com.celnet.dc.domain;

import java.util.Date;

public class MWApiList {
    private String guid;

    private String deleteflg;

    private Date createddate;

    private String createduserguid;

    private Date updatedate;

    private String updateuserguid;

    private String apicnname;

    private String handlerClassnameC;

    private String apienname;

    private String successLogDays;

    private String errorLogDays;

    private String callType;

    private String status;

    private String endpoint;

    private String version;

    private String remark;

    private String apiAppName;

    private String authoritedAppKey;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
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

    public String getApicnname() {
        return apicnname;
    }

    public void setApicnname(String apicnname) {
        this.apicnname = apicnname == null ? null : apicnname.trim();
    }

    public String getHandlerClassnameC() {
        return handlerClassnameC;
    }

    public void setHandlerClassnameC(String handlerClassnameC) {
        this.handlerClassnameC = handlerClassnameC == null ? null : handlerClassnameC.trim();
    }

    public String getApienname() {
        return apienname;
    }

    public void setApienname(String apienname) {
        this.apienname = apienname == null ? null : apienname.trim();
    }

    public String getSuccessLogDays() {
        return successLogDays;
    }

    public void setSuccessLogDays(String successLogDays) {
        this.successLogDays = successLogDays == null ? null : successLogDays.trim();
    }

    public String getErrorLogDays() {
        return errorLogDays;
    }

    public void setErrorLogDays(String errorLogDays) {
        this.errorLogDays = errorLogDays == null ? null : errorLogDays.trim();
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType == null ? null : callType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint == null ? null : endpoint.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getApiAppName() {
        return apiAppName;
    }

    public void setApiAppName(String apiAppName) {
        this.apiAppName = apiAppName == null ? null : apiAppName.trim();
    }

    public String getAuthoritedAppKey() {
        return authoritedAppKey;
    }

    public void setAuthoritedAppKey(String authoritedAppKey) {
        this.authoritedAppKey = authoritedAppKey == null ? null : authoritedAppKey.trim();
    }
}