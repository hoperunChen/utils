package com.luckyrui.test.model;

import java.math.BigDecimal;
import java.util.Date;

public class AccBillPay {
    private String id;

    private String tenantId;

    private String orgId;

    private Date bussDate;

    private String billNum;

    private String payId;

    private String payName;

    private String payCode;

    private Byte payNum;

    private BigDecimal payAmount;

    private BigDecimal curAmount;

    private Date payTime;

    private String payRemark;

    private String cashDevice;

    private String cashier;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public Date getBussDate() {
        return bussDate;
    }

    public void setBussDate(Date bussDate) {
        this.bussDate = bussDate;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum == null ? null : billNum.trim();
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName == null ? null : payName.trim();
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    public Byte getPayNum() {
        return payNum;
    }

    public void setPayNum(Byte payNum) {
        this.payNum = payNum;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getCurAmount() {
        return curAmount;
    }

    public void setCurAmount(BigDecimal curAmount) {
        this.curAmount = curAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark == null ? null : payRemark.trim();
    }

    public String getCashDevice() {
        return cashDevice;
    }

    public void setCashDevice(String cashDevice) {
        this.cashDevice = cashDevice == null ? null : cashDevice.trim();
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier == null ? null : cashier.trim();
    }
}