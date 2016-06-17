package com.luckyrui.test.model;

import java.util.Date;

public class RptDailyCompStat {
	private String dailyCompId;

	private Date bussDate;

	private String storeId;

	private String storeCode;

	private String storeNameCs;

	private String storeNameCt;

	private String storeNameEn;

	private String storeNameJp;

	private String storeNameKr;

	private String reasonId;

	private String reasonName;

	private Short compNum;

	private String tenantId;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getDailyCompId() {
		return dailyCompId;
	}

	public void setDailyCompId(String dailyCompId) {
		this.dailyCompId = dailyCompId == null ? null : dailyCompId.trim();
	}

	public Date getBussDate() {
		return bussDate;
	}

	public void setBussDate(Date bussDate) {
		this.bussDate = bussDate;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId == null ? null : storeId.trim();
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode == null ? null : storeCode.trim();
	}

	public String getStoreNameCs() {
		return storeNameCs;
	}

	public void setStoreNameCs(String storeNameCs) {
		this.storeNameCs = storeNameCs == null ? null : storeNameCs.trim();
	}

	public String getStoreNameCt() {
		return storeNameCt;
	}

	public void setStoreNameCt(String storeNameCt) {
		this.storeNameCt = storeNameCt == null ? null : storeNameCt.trim();
	}

	public String getStoreNameEn() {
		return storeNameEn;
	}

	public void setStoreNameEn(String storeNameEn) {
		this.storeNameEn = storeNameEn == null ? null : storeNameEn.trim();
	}

	public String getStoreNameJp() {
		return storeNameJp;
	}

	public void setStoreNameJp(String storeNameJp) {
		this.storeNameJp = storeNameJp == null ? null : storeNameJp.trim();
	}

	public String getStoreNameKr() {
		return storeNameKr;
	}

	public void setStoreNameKr(String storeNameKr) {
		this.storeNameKr = storeNameKr == null ? null : storeNameKr.trim();
	}

	public String getReasonId() {
		return reasonId;
	}

	public void setReasonId(String reasonId) {
		this.reasonId = reasonId == null ? null : reasonId.trim();
	}

	public String getReasonName() {
		return reasonName;
	}

	public void setReasonName(String reasonName) {
		this.reasonName = reasonName == null ? null : reasonName.trim();
	}

	public Short getCompNum() {
		return compNum;
	}

	public void setCompNum(Short compNum) {
		this.compNum = compNum;
	}
}