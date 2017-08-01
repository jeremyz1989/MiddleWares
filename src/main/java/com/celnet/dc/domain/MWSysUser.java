package com.celnet.dc.domain;

import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class MWSysUser {
    private String guid;

    private String username;
    
    private String password;

    private String email;

    private String phone;

    private String fixedphone;

    private String realname;

    private String unit;

    private String gender;

    private String deleteflg;

    private Date createddate;

    private Date updatedate;

    private String createduserguid;

    private String updateuserguid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    @NotBlank(message="用户名不能为空") 
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @NotBlank(message="邮箱不能为空") 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @NotBlank(message="电话不能为空") 
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getFixedphone() {
        return fixedphone;
    }

    public void setFixedphone(String fixedphone) {
        this.fixedphone = fixedphone == null ? null : fixedphone.trim();
    }

    @NotBlank(message="真实姓名不能为空") 
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
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

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getCreateduserguid() {
        return createduserguid;
    }

    public void setCreateduserguid(String createduserguid) {
        this.createduserguid = createduserguid == null ? null : createduserguid.trim();
    }

    public String getUpdateuserguid() {
        return updateuserguid;
    }

    public void setUpdateuserguid(String updateuserguid) {
        this.updateuserguid = updateuserguid == null ? null : updateuserguid.trim();
    }

    @NotNull(message="密码不能为null") 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}