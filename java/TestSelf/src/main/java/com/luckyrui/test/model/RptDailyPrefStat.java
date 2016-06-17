package com.luckyrui.test.model;

import java.util.Date;

public class RptDailyPrefStat {
	private String dailyPrefId;

	private Date bussDate;

	private String storeId;

	private String storeCode;

	private String storeNameCs;

	private String storeNameCt;

	private String storeNameEn;

	private String storeNameJp;

	private String storeNameKr;

	private String reasonId;

	private String reasonNameCs;

	private String reasonNameCt;

	private String reasonNameEn;

	private String reasonNameJp;

	private String reasonNameKr;

	private String discount;

	private String discountGive;

	private String maling;

	private String tenantId;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getDailyPrefId() {
		return dailyPrefId;
	}

	public void setDailyPrefId(String dailyPrefId) {
		this.dailyPrefId = dailyPrefId == null ? null : dailyPrefId.trim();
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

	public String getReasonNameCs() {
		return reasonNameCs;
	}

	public void setReasonNameCs(String reasonNameCs) {
		this.reasonNameCs = reasonNameCs == null ? null : reasonNameCs.trim();
	}

	public String getReasonNameCt() {
		return reasonNameCt;
	}

	public void setReasonNameCt(String reasonNameCt) {
		this.reasonNameCt = reasonNameCt == null ? null : reasonNameCt.trim();
	}

	public String getReasonNameEn() {
		return reasonNameEn;
	}

	public void setReasonNameEn(String reasonNameEn) {
		this.reasonNameEn = reasonNameEn == null ? null : reasonNameEn.trim();
	}

	public String getReasonNameJp() {
		return reasonNameJp;
	}

	public void setReasonNameJp(String reasonNameJp) {
		this.reasonNameJp = reasonNameJp == null ? null : reasonNameJp.trim();
	}

	public String getReasonNameKr() {
		return reasonNameKr;
	}

	public void setReasonNameKr(String reasonNameKr) {
		this.reasonNameKr = reasonNameKr == null ? null : reasonNameKr.trim();
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getDiscountGive() {
		return discountGive;
	}

	public void setDiscountGive(String discountGive) {
		this.discountGive = discountGive;
	}

	public String getMaling() {
		return maling;
	}

	public void setMaling(String maling) {
		this.maling = maling;
	}
}