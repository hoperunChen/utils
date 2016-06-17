package com.luckyrui.test.model;

import java.math.BigDecimal;
import java.util.Date;

public class RptMonthOrganBalance {
    private String memberStatId;

    private String bussMonth;

    private Date statDate;

    private String openStoreId;

    private String openStoreCode;

    private String openStoreNameCs;

    private String openStoreNameCt;

    private String openStoreNameEn;

    private String openStoreNameJp;

    private String openStoreNameKr;

    private String consStoreId;

    private String consStoreCode;

    private String consStoreNameCs;

    private String consStoreNameCt;

    private String consStoreNameEn;

    private String consStoreNameJp;

    private String consStoreNameKr;

    private BigDecimal rechAmt;

    private BigDecimal consAmt;

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

    public String getOpenStoreId() {
        return openStoreId;
    }

    public void setOpenStoreId(String openStoreId) {
        this.openStoreId = openStoreId == null ? null : openStoreId.trim();
    }

    public String getOpenStoreCode() {
        return openStoreCode;
    }

    public void setOpenStoreCode(String openStoreCode) {
        this.openStoreCode = openStoreCode == null ? null : openStoreCode.trim();
    }

    public String getOpenStoreNameCs() {
        return openStoreNameCs;
    }

    public void setOpenStoreNameCs(String openStoreNameCs) {
        this.openStoreNameCs = openStoreNameCs == null ? null : openStoreNameCs.trim();
    }

    public String getOpenStoreNameCt() {
        return openStoreNameCt;
    }

    public void setOpenStoreNameCt(String openStoreNameCt) {
        this.openStoreNameCt = openStoreNameCt == null ? null : openStoreNameCt.trim();
    }

    public String getOpenStoreNameEn() {
        return openStoreNameEn;
    }

    public void setOpenStoreNameEn(String openStoreNameEn) {
        this.openStoreNameEn = openStoreNameEn == null ? null : openStoreNameEn.trim();
    }

    public String getOpenStoreNameJp() {
        return openStoreNameJp;
    }

    public void setOpenStoreNameJp(String openStoreNameJp) {
        this.openStoreNameJp = openStoreNameJp == null ? null : openStoreNameJp.trim();
    }

    public String getOpenStoreNameKr() {
        return openStoreNameKr;
    }

    public void setOpenStoreNameKr(String openStoreNameKr) {
        this.openStoreNameKr = openStoreNameKr == null ? null : openStoreNameKr.trim();
    }

    public String getConsStoreId() {
        return consStoreId;
    }

    public void setConsStoreId(String consStoreId) {
        this.consStoreId = consStoreId == null ? null : consStoreId.trim();
    }

    public String getConsStoreCode() {
        return consStoreCode;
    }

    public void setConsStoreCode(String consStoreCode) {
        this.consStoreCode = consStoreCode == null ? null : consStoreCode.trim();
    }

    public String getConsStoreNameCs() {
        return consStoreNameCs;
    }

    public void setConsStoreNameCs(String consStoreNameCs) {
        this.consStoreNameCs = consStoreNameCs == null ? null : consStoreNameCs.trim();
    }

    public String getConsStoreNameCt() {
        return consStoreNameCt;
    }

    public void setConsStoreNameCt(String consStoreNameCt) {
        this.consStoreNameCt = consStoreNameCt == null ? null : consStoreNameCt.trim();
    }

    public String getConsStoreNameEn() {
        return consStoreNameEn;
    }

    public void setConsStoreNameEn(String consStoreNameEn) {
        this.consStoreNameEn = consStoreNameEn == null ? null : consStoreNameEn.trim();
    }

    public String getConsStoreNameJp() {
        return consStoreNameJp;
    }

    public void setConsStoreNameJp(String consStoreNameJp) {
        this.consStoreNameJp = consStoreNameJp == null ? null : consStoreNameJp.trim();
    }

    public String getConsStoreNameKr() {
        return consStoreNameKr;
    }

    public void setConsStoreNameKr(String consStoreNameKr) {
        this.consStoreNameKr = consStoreNameKr == null ? null : consStoreNameKr.trim();
    }

    public BigDecimal getRechAmt() {
        return rechAmt;
    }

    public void setRechAmt(BigDecimal rechAmt) {
        this.rechAmt = rechAmt;
    }

    public BigDecimal getConsAmt() {
        return consAmt;
    }

    public void setConsAmt(BigDecimal consAmt) {
        this.consAmt = consAmt;
    }
}