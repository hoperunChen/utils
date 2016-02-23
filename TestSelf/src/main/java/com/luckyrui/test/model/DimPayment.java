package com.luckyrui.test.model;

public class DimPayment {
    private String payId;

    private String payCode;

    private String payNameCs;

    private String payNameCt;

    private String payNameEn;

    private String payNameJp;

    private String payNameKr;

    private String payTypeCode;

    private String payTypeName;

    private String payStatus;

    private String tenantId;

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

    public String getPayTypeCode() {
        return payTypeCode;
    }

    public void setPayTypeCode(String payTypeCode) {
        this.payTypeCode = payTypeCode == null ? null : payTypeCode.trim();
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName == null ? null : payTypeName.trim();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }
}