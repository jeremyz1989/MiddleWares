package com.celnet.dc.domain;

import java.util.Date;

public class MWApiLog {
    private String guid;

    private String apienname;

    private String endpoint;

    private String callType;

    private Date startTime;

    private Date endTime;

    private String duration;

    private String stackTrace;

    private Date lastRetryTime;

    private String requestText;

    private String responseText;

    private String exceptionMsg;

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

    public String getApienname() {
        return apienname;
    }

    public void setApienname(String apienname) {
        this.apienname = apienname == null ? null : apienname.trim();
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint == null ? null : endpoint.trim();
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType == null ? null : callType.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace == null ? null : stackTrace.trim();
    }

    public Date getLastRetryTime() {
        return lastRetryTime;
    }

    public void setLastRetryTime(Date lastRetryTime) {
        this.lastRetryTime = lastRetryTime;
    }

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText == null ? null : requestText.trim();
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText == null ? null : responseText.trim();
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg == null ? null : exceptionMsg.trim();
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