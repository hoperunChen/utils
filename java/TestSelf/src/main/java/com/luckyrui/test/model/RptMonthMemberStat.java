package com.luckyrui.test.model;

import java.math.BigDecimal;
import java.util.Date;

public class RptMonthMemberStat {
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

    private BigDecimal beginAmt;

    private Integer openNum;

    private BigDecimal openAmt;

    private BigDecimal rechAmt;

    private BigDecimal consThisAmt;

    private BigDecimal consDiffAmt;

    private BigDecimal adjustAmt;

    private Integer cancelNum;

    private BigDecimal cancelAmt;

    private Integer endNum;

    private BigDecimal endAmt;

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

    public BigDecimal getBeginAmt() {
        return beginAmt;
    }

    public void setBeginAmt(BigDecimal beginAmt) {
        this.beginAmt = beginAmt;
    }

    public Integer getOpenNum() {
        return openNum;
    }

    public void setOpenNum(Integer openNum) {
        this.openNum = openNum;
    }

    public BigDecimal getOpenAmt() {
        return openAmt;
    }

    public void setOpenAmt(BigDecimal openAmt) {
        this.openAmt = openAmt;
    }

    public BigDecimal getRechAmt() {
        return rechAmt;
    }

    public void setRechAmt(BigDecimal rechAmt) {
        this.rechAmt = rechAmt;
    }

    public BigDecimal getConsThisAmt() {
        return consThisAmt;
    }

    public void setConsThisAmt(BigDecimal consThisAmt) {
        this.consThisAmt = consThisAmt;
    }

    public BigDecimal getConsDiffAmt() {
        return consDiffAmt;
    }

    public void setConsDiffAmt(BigDecimal consDiffAmt) {
        this.consDiffAmt = consDiffAmt;
    }

    public BigDecimal getAdjustAmt() {
        return adjustAmt;
    }

    public void setAdjustAmt(BigDecimal adjustAmt) {
        this.adjustAmt = adjustAmt;
    }

    public Integer getCancelNum() {
        return cancelNum;
    }

    public void setCancelNum(Integer cancelNum) {
        this.cancelNum = cancelNum;
    }

    public BigDecimal getCancelAmt() {
        return cancelAmt;
    }

    public void setCancelAmt(BigDecimal cancelAmt) {
        this.cancelAmt = cancelAmt;
    }

    public Integer getEndNum() {
        return endNum;
    }

    public void setEndNum(Integer endNum) {
        this.endNum = endNum;
    }

    public BigDecimal getEndAmt() {
        return endAmt;
    }

    public void setEndAmt(BigDecimal endAmt) {
        this.endAmt = endAmt;
    }
}