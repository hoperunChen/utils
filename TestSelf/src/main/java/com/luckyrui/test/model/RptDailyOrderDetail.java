package com.luckyrui.test.model;

import java.util.Date;


public class RptDailyOrderDetail {
    private String dailyOrderId;

    private Date bussDate;

    private String bussDateStr;// 时间格式字符串串

    private String orderChannel;

    private String orderSource;

    private String storeId;

    private String storeCode;

    private String storeNameCs;

    private String storeNameCt;

    private String storeNameEn;

    private String storeNameJp;

    private String storeNameKr;

    private String ordNum;

    private String likeman;

    private String mobile;

    private String address;

    private String totalAmount;

    private String netAmount;

    private String outAmount;

    private Date comeTime;

    private Date cashTime;

    private Date takeTime;

    private Date operTime;

    private Date sendTime;

    private Date compTime;

    private Date canTime;

    private String canType;

    private String canName;

    private Integer takeCash;

    private Integer operTake;

    private Integer sendOper;

    private Integer compSend;
    
    private String tenantId;
    
    

    public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getDailyOrderId() {
        return dailyOrderId;
    }

    public void setDailyOrderId(String dailyOrderId) {
        this.dailyOrderId = dailyOrderId == null ? null : dailyOrderId.trim();
    }

    public Date getBussDate() {
        return bussDate;
    }

    public void setBussDate(Date bussDate) {
        this.bussDate = bussDate;
    }

    public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel == null ? null : orderChannel.trim();
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource == null ? null : orderSource.trim();
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

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum == null ? null : ordNum.trim();
    }

    public String getLikeman() {
        return likeman;
    }

    public void setLikeman(String likeman) {
        this.likeman = likeman == null ? null : likeman.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public String getNetAmount()
    {
        return netAmount;
    }

    public void setNetAmount(String netAmount)
    {
        this.netAmount = netAmount;
    }

    public String getOutAmount()
    {
        return outAmount;
    }

    public void setOutAmount(String outAmount)
    {
        this.outAmount = outAmount;
    }

    public Date getComeTime() {
        return comeTime;
    }

    public void setComeTime(Date comeTime) {
        this.comeTime = comeTime;
    }

    public Date getCashTime() {
        return cashTime;
    }

    public void setCashTime(Date cashTime) {
        this.cashTime = cashTime;
    }

    public Date getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(Date takeTime) {
        this.takeTime = takeTime;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getCompTime() {
        return compTime;
    }

    public void setCompTime(Date compTime) {
        this.compTime = compTime;
    }

    public Date getCanTime() {
        return canTime;
    }

    public void setCanTime(Date canTime) {
        this.canTime = canTime;
    }

    public String getCanType() {
        return canType;
    }

    public void setCanType(String canType) {
        this.canType = canType == null ? null : canType.trim();
    }

    public String getCanName() {
        return canName;
    }

    public void setCanName(String canName) {
        this.canName = canName == null ? null : canName.trim();
    }

    public Integer getTakeCash() {
        return takeCash;
    }

    public void setTakeCash(Integer takeCash) {
        this.takeCash = takeCash;
    }

    public Integer getOperTake() {
        return operTake;
    }

    public void setOperTake(Integer operTake) {
        this.operTake = operTake;
    }

    public Integer getSendOper() {
        return sendOper;
    }

    public void setSendOper(Integer sendOper) {
        this.sendOper = sendOper;
    }

    public Integer getCompSend() {
        return compSend;
    }

    public void setCompSend(Integer compSend) {
        this.compSend = compSend;
    }

    public String getBussDateStr()
    {
        return bussDateStr;
    }

    public void setBussDateStr(String bussDateStr)
    {
        this.bussDateStr = bussDateStr;
    }

}