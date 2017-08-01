package com.celnet.dc.domain;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com.celnet.dc.domain.SystemParamter", description = "系统参数对象实体")
public class SystemParamter {
	
	@ApiModelProperty("系统参数-ID")
    private Integer id;

    private String hcLastop;

    private Date systemmodstamp;

    @ApiModelProperty("系统参数名称")
    private String name;

    @ApiModelProperty("系统参数说明")
    private String descC;

    @ApiModelProperty("系统参数SFID")
    private String sfid;

    private String hcErr;

    private Boolean isdeleted;

    private Date createddate;

    @ApiModelProperty("系统参数-数值")
    private String valueC;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescC() {
        return descC;
    }

    public void setDescC(String descC) {
        this.descC = descC == null ? null : descC.trim();
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

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getValueC() {
        return valueC;
    }

    public void setValueC(String valueC) {
        this.valueC = valueC == null ? null : valueC.trim();
    }
}