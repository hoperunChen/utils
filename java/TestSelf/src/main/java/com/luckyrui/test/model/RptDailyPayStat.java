package com.luckyrui.test.model;

import java.util.Date;

public class RptDailyPayStat {
    private String timePayId;

    private Date bussDate;

    private String saleMode;

    private String storeId;

    private String storeCode;

    private String storeNameCs;

    private String storeNameCt;

    private String storeNameEn;

    private String storeNameJp;

    private String storeNameKr;

    private String payId;

    private String payCode;

    private String payNameCs;

    private String payNameCt;

    private String payNameEn;

    private String payNameJp;

    private String payNameKr;

    private Integer payNum;

    private String payAmount;

    private String giveAmount;

    private String overAmount;
    
    private String tenantId;
    
    

    public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getTimePayId() {
        return timePayId;
    }

    public void setTimePayId(String timePayId) {
        this.timePayId = timePayId == null ? null : timePayId.trim();
    }

    public Date getBussDate() {
        return bussDate;
    }

    public void setBussDate(Date bussDate) {
        this.bussDate = bussDate;
    }

    public String getSaleMode() {
        return saleMode;
    }

    public void setSaleMode(String saleMode) {
        this.saleMode = saleMode == null ? null : saleMode.trim();
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

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    public String getPayNameCs() {
        return payNameCs;
    }

    public void setPayNameCs(String payNameCs) {
        this.payNameCs = payNameCs == null ? null : payNameCs.trim();
    }

    public String getPayNameCt() {
        return payNameCt;
    }

    public void setPayNameCt(String payNameCt) {
        this.payNameCt = payNameCt == null ? null : payNameCt.trim();
    }

    public String getPayNameEn() {
        return payNameEn;
    }

    public void setPayNameEn(String payNameEn) {
        this.payNameEn = payNameEn == null ? null : payNameEn.trim();
    }

    public String getPayNameJp() {
        return payNameJp;
    }

    public void setPayNameJp(String payNameJp) {
        this.payNameJp = payNameJp == null ? null : payNameJp.trim();
    }

    public String getPayNameKr() {
        return payNameKr;
    }

    public void setPayNameKr(String payNameKr) {
        this.payNameKr = payNameKr == null ? null : payNameKr.trim();
    }

    public Integer getPayNum() {
        return payNum;
    }

    public void setPayNum(Integer payNum) {
        this.payNum = payNum;
    }

    public String getPayAmount()
    {
        return payAmount;
    }

    public void setPayAmount(String payAmount)
    {
        this.payAmount = payAmount;
    }

    public String getGiveAmount()
    {
        return giveAmount;
    }

    public void setGiveAmount(String giveAmount)
    {
        this.giveAmount = giveAmount;
    }

    public String getOverAmount()
    {
        return overAmount;
    }

    public void setOverAmount(String overAmount)
    {
        this.overAmount = overAmount;
    }
}