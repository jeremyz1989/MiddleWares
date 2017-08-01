package com.celnet.dc.domain;

import java.util.Date;

public class TAccount {

	private String genderC;

    private Boolean isdeleted;

    private String namefieldC;

    private String name;

    private String permanentaddressC;

    private String contactaddressC;

    private String sfid;

    private String clubregisteredphoneC;

    private String contractstatusC;

    private Integer id;

    private String masterrecordid;

    private Date createddate;

    private String nameandbahnsC;

    private String bahnsC;

    private Boolean shimaoyezhuC;

    private Date systemmodstamp;

    private String emailC;

    private String datebirthC;

    private String commonlyphoneC;

    private Boolean isdeleteC;

    private String guid;
    
    private String phone;
    
    private String spareClubregisteredphoneC;
    
    public String getSpareClubregisteredphoneC() {
		return spareClubregisteredphoneC;
	}

	public void setSpareClubregisteredphoneC(String spareClubregisteredphoneC) {
		this.spareClubregisteredphoneC = spareClubregisteredphoneC;
	}

	public String getGenderC() {
		return genderC;
	}

	public void setGenderC(String genderC) {
		this.genderC = genderC;
	}

	public Boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getNamefieldC() {
		return namefieldC;
	}

	public void setNamefieldC(String namefieldC) {
		this.namefieldC = namefieldC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermanentaddressC() {
		return permanentaddressC;
	}

	public void setPermanentaddressC(String permanentaddressC) {
		this.permanentaddressC = permanentaddressC;
	}

	public String getContactaddressC() {
		return contactaddressC;
	}

	public void setContactaddressC(String contactaddressC) {
		this.contactaddressC = contactaddressC;
	}

	public String getSfid() {
		return sfid;
	}

	public void setSfid(String sfid) {
		this.sfid = sfid;
	}

	public String getClubregisteredphoneC() {
		return clubregisteredphoneC;
	}

	public void setClubregisteredphoneC(String clubregisteredphoneC) {
		this.clubregisteredphoneC = clubregisteredphoneC;
	}

	public String getContractstatusC() {
		return contractstatusC;
	}

	public void setContractstatusC(String contractstatusC) {
		this.contractstatusC = contractstatusC;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMasterrecordid() {
		return masterrecordid;
	}

	public void setMasterrecordid(String masterrecordid) {
		this.masterrecordid = masterrecordid;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getNameandbahnsC() {
		return nameandbahnsC;
	}

	public void setNameandbahnsC(String nameandbahnsC) {
		this.nameandbahnsC = nameandbahnsC;
	}

	public String getBahnsC() {
		return bahnsC;
	}

	public void setBahnsC(String bahnsC) {
		this.bahnsC = bahnsC;
	}

	public Boolean getShimaoyezhuC() {
		return shimaoyezhuC;
	}

	public void setShimaoyezhuC(Boolean shimaoyezhuC) {
		this.shimaoyezhuC = shimaoyezhuC;
	}

	public Date getSystemmodstamp() {
		return systemmodstamp;
	}

	public void setSystemmodstamp(Date systemmodstamp) {
		this.systemmodstamp = systemmodstamp;
	}

	public String getEmailC() {
		return emailC;
	}

	public void setEmailC(String emailC) {
		this.emailC = emailC;
	}

	public String getDatebirthC() {
		return datebirthC;
	}

	public void setDatebirthC(String datebirthC) {
		this.datebirthC = datebirthC;
	}

	public String getCommonlyphoneC() {
		return commonlyphoneC;
	}

	public void setCommonlyphoneC(String commonlyphoneC) {
		this.commonlyphoneC = commonlyphoneC;
	}

	public Boolean getIsdeleteC() {
		return isdeleteC;
	}

	public void setIsdeleteC(Boolean isdeleteC) {
		this.isdeleteC = isdeleteC;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccountsource() {
		return accountsource;
	}

	public void setAccountsource(String accountsource) {
		this.accountsource = accountsource;
	}

	private String accountsource;
    

	@Override
	public String toString() {
		return "TAccount [genderC=" + genderC + ", isdeleted=" + isdeleted + ", namefieldC=" + namefieldC + ", name="
				+ name + ", permanentaddressC=" + permanentaddressC + ", contactaddressC=" + contactaddressC + ", sfid="
				+ sfid + ", clubregisteredphoneC=" + clubregisteredphoneC + ", contractstatusC=" + contractstatusC
				+ ", id=" + id + ", masterrecordid=" + masterrecordid + ", createddate=" + createddate
				+ ", nameandbahnsC=" + nameandbahnsC + ", bahnsC=" + bahnsC + ", shimaoyezhuC=" + shimaoyezhuC
				+ ", systemmodstamp=" + systemmodstamp + ", emailC=" + emailC + ", datebirthC=" + datebirthC
				+ ", commonlyphoneC=" + commonlyphoneC + ", isdeleteC=" + isdeleteC + ", guid=" + guid + ", phone="
				+ phone + ", spareClubregisteredphoneC=" + spareClubregisteredphoneC + ", accountsource="
				+ accountsource + "]";
	}

}
