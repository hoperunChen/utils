package com.luckyrui.test.model;

import java.util.Date;

public class RptDailyAgingStat {
	private String dailyAgingId;

	private Date bussDate;

	private String storeId;

	private String storeCode;

	private String storeNameCs;

	private String storeNameCt;

	private String storeNameEn;

	private String storeNameJp;

	private String storeNameKr;

	private String acctId;

	private String acctName;

	private String acctType;

	private String acctTel;

	private String acctPaper;

	private String acctBalance;

	private String debtLess30;

	private String debtLess60;

	private String debtLess90;

	private String debtOver90;

	private String tenantId;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getDailyAgingId() {
		return dailyAgingId;
	}

	public void setDailyAgingId(String dailyAgingId) {
		this.dailyAgingId = dailyAgingId == null ? null : dailyAgingId.trim();
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

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId == null ? null : acctId.trim();
	}

	public String getAcctName() {
		return acctName;
	}

	public void setAcctName(String acctName) {
		this.acctName = acctName == null ? null : acctName.trim();
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType == null ? null : acctType.trim();
	}

	public String getAcctTel() {
		return acctTel;
	}

	public void setAcctTel(String acctTel) {
		this.acctTel = acctTel == null ? null : acctTel.trim();
	}

	public String getAcctPaper() {
		return acctPaper;
	}

	public void setAcctPaper(String acctPaper) {
		this.acctPaper = acctPaper == null ? null : acctPaper.trim();
	}

	public String getAcctBalance() {
		return acctBalance;
	}

	public void setAcctBalance(String acctBalance) {
		this.acctBalance = acctBalance;
	}

	public String getDebtLess30() {
		return debtLess30;
	}

	public void setDebtLess30(String debtLess30) {
		this.debtLess30 = debtLess30;
	}

	public String getDebtLess60() {
		return debtLess60;
	}

	public void setDebtLess60(String debtLess60) {
		this.debtLess60 = debtLess60;
	}

	public String getDebtLess90() {
		return debtLess90;
	}

	public void setDebtLess90(String debtLess90) {
		this.debtLess90 = debtLess90;
	}

	public String getDebtOver90() {
		return debtOver90;
	}

	public void setDebtOver90(String debtOver90) {
		this.debtOver90 = debtOver90;
	}
}