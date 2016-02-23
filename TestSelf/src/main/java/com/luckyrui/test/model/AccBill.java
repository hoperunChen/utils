package com.luckyrui.test.model;

import java.math.BigDecimal;
import java.util.Date;

public class AccBill {
    private String id;

    private String tenantId;

    private String orgId;

    private String tabId;

    private Date bussDate;

    private String billNum;

    private String serialNum;

    private Integer guests;

    private Date openTime;

    private Date closeTime;

    private String closeDevice;

    private String openPerson;

    private String closePerson;

    private String waitPerson;

    private String perfPerson;

    private String discScheId;

    private BigDecimal discRadio;

    private String srvTypeId;

    private BigDecimal srvAmount;

    private BigDecimal discount;

    private BigDecimal discountGive;

    private BigDecimal maling;

    private BigDecimal giveAmount;

    private Byte receiptNum;

    private BigDecimal receiptAmount;

    private Date preprintTime;

    private Byte preprintCount;

    private BigDecimal dishTotal;

    private BigDecimal billAmount;

    private BigDecimal payAmount;

    private BigDecimal overCoupon;

    private String billStatus;

    private String billRemark;

    private String billAttribute;

    private String billSource;

    private String busMode;

    private Byte man;

    private Byte woman;

    private Byte children;

    private Byte theaged;

    private String discReason;

    private String discGiveReason;

    private String maliReason;

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

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId == null ? null : tabId.trim();
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

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getCloseDevice() {
        return closeDevice;
    }

    public void setCloseDevice(String closeDevice) {
        this.closeDevice = closeDevice == null ? null : closeDevice.trim();
    }

    public String getOpenPerson() {
        return openPerson;
    }

    public void setOpenPerson(String openPerson) {
        this.openPerson = openPerson == null ? null : openPerson.trim();
    }

    public String getClosePerson() {
        return closePerson;
    }

    public void setClosePerson(String closePerson) {
        this.closePerson = closePerson == null ? null : closePerson.trim();
    }

    public String getWaitPerson() {
        return waitPerson;
    }

    public void setWaitPerson(String waitPerson) {
        this.waitPerson = waitPerson == null ? null : waitPerson.trim();
    }

    public String getPerfPerson() {
        return perfPerson;
    }

    public void setPerfPerson(String perfPerson) {
        this.perfPerson = perfPerson == null ? null : perfPerson.trim();
    }

    public String getDiscScheId() {
        return discScheId;
    }

    public void setDiscScheId(String discScheId) {
        this.discScheId = discScheId == null ? null : discScheId.trim();
    }

    public BigDecimal getDiscRadio() {
        return discRadio;
    }

    public void setDiscRadio(BigDecimal discRadio) {
        this.discRadio = discRadio;
    }

    public String getSrvTypeId() {
        return srvTypeId;
    }

    public void setSrvTypeId(String srvTypeId) {
        this.srvTypeId = srvTypeId == null ? null : srvTypeId.trim();
    }

    public BigDecimal getSrvAmount() {
        return srvAmount;
    }

    public void setSrvAmount(BigDecimal srvAmount) {
        this.srvAmount = srvAmount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscountGive() {
        return discountGive;
    }

    public void setDiscountGive(BigDecimal discountGive) {
        this.discountGive = discountGive;
    }

    public BigDecimal getMaling() {
        return maling;
    }

    public void setMaling(BigDecimal maling) {
        this.maling = maling;
    }

    public BigDecimal getGiveAmount() {
        return giveAmount;
    }

    public void setGiveAmount(BigDecimal giveAmount) {
        this.giveAmount = giveAmount;
    }

    public Byte getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(Byte receiptNum) {
        this.receiptNum = receiptNum;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public Date getPreprintTime() {
        return preprintTime;
    }

    public void setPreprintTime(Date preprintTime) {
        this.preprintTime = preprintTime;
    }

    public Byte getPreprintCount() {
        return preprintCount;
    }

    public void setPreprintCount(Byte preprintCount) {
        this.preprintCount = preprintCount;
    }

    public BigDecimal getDishTotal() {
        return dishTotal;
    }

    public void setDishTotal(BigDecimal dishTotal) {
        this.dishTotal = dishTotal;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getOverCoupon() {
        return overCoupon;
    }

    public void setOverCoupon(BigDecimal overCoupon) {
        this.overCoupon = overCoupon;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus == null ? null : billStatus.trim();
    }

    public String getBillRemark() {
        return billRemark;
    }

    public void setBillRemark(String billRemark) {
        this.billRemark = billRemark == null ? null : billRemark.trim();
    }

    public String getBillAttribute() {
        return billAttribute;
    }

    public void setBillAttribute(String billAttribute) {
        this.billAttribute = billAttribute == null ? null : billAttribute.trim();
    }

    public String getBillSource() {
        return billSource;
    }

    public void setBillSource(String billSource) {
        this.billSource = billSource == null ? null : billSource.trim();
    }

    public String getBusMode() {
        return busMode;
    }

    public void setBusMode(String busMode) {
        this.busMode = busMode == null ? null : busMode.trim();
    }

    public Byte getMan() {
        return man;
    }

    public void setMan(Byte man) {
        this.man = man;
    }

    public Byte getWoman() {
        return woman;
    }

    public void setWoman(Byte woman) {
        this.woman = woman;
    }

    public Byte getChildren() {
        return children;
    }

    public void setChildren(Byte children) {
        this.children = children;
    }

    public Byte getTheaged() {
        return theaged;
    }

    public void setTheaged(Byte theaged) {
        this.theaged = theaged;
    }

    public String getDiscReason() {
        return discReason;
    }

    public void setDiscReason(String discReason) {
        this.discReason = discReason == null ? null : discReason.trim();
    }

    public String getDiscGiveReason() {
        return discGiveReason;
    }

    public void setDiscGiveReason(String discGiveReason) {
        this.discGiveReason = discGiveReason == null ? null : discGiveReason.trim();
    }

    public String getMaliReason() {
        return maliReason;
    }

    public void setMaliReason(String maliReason) {
        this.maliReason = maliReason == null ? null : maliReason.trim();
    }
}