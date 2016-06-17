package com.luckyrui.test.model;

import java.util.Date;

public class RptTimeOrderStat {
	private String timeOrderId;

	private Date bussDate;

	private String bussTime;

	private String storeId;

	private String storeCode;

	private String storeNameCs;

	private String storeNameCt;

	private String storeNameEn;

	private String storeNameJp;

	private String storeNameKr;

	private String totalAmount;

	private String netAmount;

	private String outAmount;

	private String acExcludeOutAmount;// ac不含外卖

	private String takeCash;

	private String operTake;

	private String sendOper;

	private String compSend;

	private String averageTime;// 平均时间

	private double averageAmount;// 订单平均金额（含外送费）

	private String orderNum;

	private String tenantId;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getTimeOrderId() {
		return timeOrderId;
	}

	public void setTimeOrderId(String timeOrderId) {
		this.timeOrderId = timeOrderId == null ? null : timeOrderId.trim();
	}

	public Date getBussDate() {
		return bussDate;
	}

	public void setBussDate(Date bussDate) {
		this.bussDate = bussDate;
	}

	public String getBussTime() {
		return bussTime;
	}

	public void setBussTime(String bussTime) {
		this.bussTime = bussTime == null ? null : bussTime.trim();
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

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}

	public String getOutAmount() {
		return outAmount;
	}

	public void setOutAmount(String outAmount) {
		this.outAmount = outAmount;
	}

	public String getTakeCash() {
		return takeCash;
	}

	public void setTakeCash(String takeCash) {
		this.takeCash = takeCash;
	}

	public String getOperTake() {
		return operTake;
	}

	public void setOperTake(String operTake) {
		this.operTake = operTake;
	}

	public String getSendOper() {
		return sendOper;
	}

	public void setSendOper(String sendOper) {
		this.sendOper = sendOper;
	}

	public String getCompSend() {
		return compSend;
	}

	public void setCompSend(String compSend) {
		this.compSend = compSend;
	}

	public String getAcExcludeOutAmount() {
		return acExcludeOutAmount;
	}

	public void setAcExcludeOutAmount(String acExcludeOutAmount) {
		this.acExcludeOutAmount = acExcludeOutAmount;
	}

	public String getAverageTime() {
		return averageTime;
	}

	public void setAverageTime(String averageTime) {
		this.averageTime = averageTime;
	}

	public double getAverageAmount() {
		return averageAmount;
	}

	public void setAverageAmount(double averageAmount) {
		this.averageAmount = averageAmount;
	}

}