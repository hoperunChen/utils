package com.luckyrui.test.model;

import java.math.BigDecimal;
import java.util.Date;

public class AccBillDtl {
    private String id;

    private String tenantId;

    private String orgId;

    private String tabId;

    private Date bussDate;

    private String billNum;

    private String dishId;

    private String dishName;

    private BigDecimal dishPrice;

    private String dishUnit;

    private BigDecimal dishNum;

    private BigDecimal dishAmount;

    private BigDecimal realAmount;

    private BigDecimal prefAmount;

    private BigDecimal singAmount;

    private BigDecimal discount;

    private BigDecimal discountGive;

    private BigDecimal maling;

    private BigDecimal assistNum;

    private BigDecimal assistAmount;

    private String takeMode;

    private BigDecimal takeRadio;

    private BigDecimal takeAmount;

    private String dishAttribute;

    private String operAttribute;

    private String tasteRemark;

    private String practiceRemark;

    private Date orderTime;

    private Date backTime;

    private Date urgeTime;

    private Date riseTime;

    private Short orderSeq;

    private String orderDevice;

    private String orderPerson;

    private String orderRemark;

    private String comboId;

    private String reasonId;

    private String cookId;

    private String operator;

    private String approver;

    private Date operTime;

    private String operLink;

    private String tickCode;

    private BigDecimal discRatio;

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

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId == null ? null : dishId.trim();
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName == null ? null : dishName.trim();
    }

    public BigDecimal getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(BigDecimal dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishUnit() {
        return dishUnit;
    }

    public void setDishUnit(String dishUnit) {
        this.dishUnit = dishUnit == null ? null : dishUnit.trim();
    }

    public BigDecimal getDishNum() {
        return dishNum;
    }

    public void setDishNum(BigDecimal dishNum) {
        this.dishNum = dishNum;
    }

    public BigDecimal getDishAmount() {
        return dishAmount;
    }

    public void setDishAmount(BigDecimal dishAmount) {
        this.dishAmount = dishAmount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public BigDecimal getPrefAmount() {
        return prefAmount;
    }

    public void setPrefAmount(BigDecimal prefAmount) {
        this.prefAmount = prefAmount;
    }

    public BigDecimal getSingAmount() {
        return singAmount;
    }

    public void setSingAmount(BigDecimal singAmount) {
        this.singAmount = singAmount;
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

    public BigDecimal getAssistNum() {
        return assistNum;
    }

    public void setAssistNum(BigDecimal assistNum) {
        this.assistNum = assistNum;
    }

    public BigDecimal getAssistAmount() {
        return assistAmount;
    }

    public void setAssistAmount(BigDecimal assistAmount) {
        this.assistAmount = assistAmount;
    }

    public String getTakeMode() {
        return takeMode;
    }

    public void setTakeMode(String takeMode) {
        this.takeMode = takeMode == null ? null : takeMode.trim();
    }

    public BigDecimal getTakeRadio() {
        return takeRadio;
    }

    public void setTakeRadio(BigDecimal takeRadio) {
        this.takeRadio = takeRadio;
    }

    public BigDecimal getTakeAmount() {
        return takeAmount;
    }

    public void setTakeAmount(BigDecimal takeAmount) {
        this.takeAmount = takeAmount;
    }

    public String getDishAttribute() {
        return dishAttribute;
    }

    public void setDishAttribute(String dishAttribute) {
        this.dishAttribute = dishAttribute == null ? null : dishAttribute.trim();
    }

    public String getOperAttribute() {
        return operAttribute;
    }

    public void setOperAttribute(String operAttribute) {
        this.operAttribute = operAttribute == null ? null : operAttribute.trim();
    }

    public String getTasteRemark() {
        return tasteRemark;
    }

    public void setTasteRemark(String tasteRemark) {
        this.tasteRemark = tasteRemark == null ? null : tasteRemark.trim();
    }

    public String getPracticeRemark() {
        return practiceRemark;
    }

    public void setPracticeRemark(String practiceRemark) {
        this.practiceRemark = practiceRemark == null ? null : practiceRemark.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public Date getUrgeTime() {
        return urgeTime;
    }

    public void setUrgeTime(Date urgeTime) {
        this.urgeTime = urgeTime;
    }

    public Date getRiseTime() {
        return riseTime;
    }

    public void setRiseTime(Date riseTime) {
        this.riseTime = riseTime;
    }

    public Short getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Short orderSeq) {
        this.orderSeq = orderSeq;
    }

    public String getOrderDevice() {
        return orderDevice;
    }

    public void setOrderDevice(String orderDevice) {
        this.orderDevice = orderDevice == null ? null : orderDevice.trim();
    }

    public String getOrderPerson() {
        return orderPerson;
    }

    public void setOrderPerson(String orderPerson) {
        this.orderPerson = orderPerson == null ? null : orderPerson.trim();
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    public String getComboId() {
        return comboId;
    }

    public void setComboId(String comboId) {
        this.comboId = comboId == null ? null : comboId.trim();
    }

    public String getReasonId() {
        return reasonId;
    }

    public void setReasonId(String reasonId) {
        this.reasonId = reasonId == null ? null : reasonId.trim();
    }

    public String getCookId() {
        return cookId;
    }

    public void setCookId(String cookId) {
        this.cookId = cookId == null ? null : cookId.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver == null ? null : approver.trim();
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getOperLink() {
        return operLink;
    }

    public void setOperLink(String operLink) {
        this.operLink = operLink == null ? null : operLink.trim();
    }

    public String getTickCode() {
        return tickCode;
    }

    public void setTickCode(String tickCode) {
        this.tickCode = tickCode == null ? null : tickCode.trim();
    }

    public BigDecimal getDiscRatio() {
        return discRatio;
    }

    public void setDiscRatio(BigDecimal discRatio) {
        this.discRatio = discRatio;
    }
}