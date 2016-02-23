package com.luckyrui.test.model;

import java.util.Date;

public class RptMemberInoutStat {
	private String memberStatId;

	private String bussMonth;

	private Date statDate;

	private String storeId;

	private String storeCode;

	private String storeNameCs;

	private String storeNameCt;

	private String storeNameEn;

	private String storeNameJp;

	private String storeNameKr;

	private Integer beginNum;

	private String beginAmt;

	private Integer openNum;

	private String openAmt;

	private String rechAmt;

	private String consThisAmt;

	private String consDiffAmt;

	private String adjustAmt;

	private Integer cancelNum;

	private String cancelAmt;

	private Integer endNum;

	private String endAmt;

	private String tenantId;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getMemberStatId() {
		return memberStatId;
	}

	public void setMemberStatId(String memberStatId) {
		this.memberStatId = memberStatId == null ? null : memberStatId.trim();
	}

	public String getBussMonth() {
		return bussMonth;
	}

	public void setBussMonth(String bussMonth) {
		this.bussMonth = bussMonth == null ? null : bussMonth.trim();
	}

	public Date getStatDate() {
		return statDate;
	}

	public void setStatDate(Date statDate) {
		this.statDate = statDate;
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

	public Integer getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(Integer beginNum) {
		this.beginNum = beginNum;
	}

	public String getBeginAmt() {
		return beginAmt;
	}

	public void setBeginAmt(String beginAmt) {
		this.beginAmt = beginAmt;
	}

	public Integer getOpenNum() {
		return openNum;
	}

	public void setOpenNum(Integer openNum) {
		this.openNum = openNum;
	}

	public String getOpenAmt() {
		return openAmt;
	}

	public void setOpenAmt(String openAmt) {
		this.openAmt = openAmt;
	}

	public String getRechAmt() {
		return rechAmt;
	}

	public void setRechAmt(String rechAmt) {
		this.rechAmt = rechAmt;
	}

	public String getConsThisAmt() {
		return consThisAmt;
	}

	public void setConsThisAmt(String consThisAmt) {
		this.consThisAmt = consThisAmt;
	}

	public String getConsDiffAmt() {
		return consDiffAmt;
	}

	public void setConsDiffAmt(String consDiffAmt) {
		this.consDiffAmt = consDiffAmt;
	}

	public String getAdjustAmt() {
		return adjustAmt;
	}

	public void setAdjustAmt(String adjustAmt) {
		this.adjustAmt = adjustAmt;
	}

	public Integer getCancelNum() {
		return cancelNum;
	}

	public void setCancelNum(Integer cancelNum) {
		this.cancelNum = cancelNum;
	}

	public String getCancelAmt() {
		return cancelAmt;
	}

	public void setCancelAmt(String cancelAmt) {
		this.cancelAmt = cancelAmt;
	}

	public Integer getEndNum() {
		return endNum;
	}

	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}

	public String getEndAmt() {
		return endAmt;
	}

	public void setEndAmt(String endAmt) {
		this.endAmt = endAmt;
	}
}