package com.luckyrui.test.model;

public class DimReason implements java.io.Serializable
{
    /**
     * @author cr
     * @description
     */
    private static final long serialVersionUID = -7532266176288814548L;

    private String reasonId;

    private String reasonNameCs;

    private String reasonNameCt;

    private String reasonNameEn;

    private String reasonNameJp;

    private String reasonNameKr;

    private String reasonTypeId;

    private String reasonTypeName;

    private String reasonStatus;

    private String tenantId;

    public String getReasonId() {
        return reasonId;
    }

    public void setReasonId(String reasonId) {
        this.reasonId = reasonId == null ? null : reasonId.trim();
    }

    public String getReasonNameCs() {
        return reasonNameCs;
    }

    public void setReasonNameCs(String reasonNameCs) {
        this.reasonNameCs = reasonNameCs == null ? null : reasonNameCs.trim();
    }

    public String getReasonNameCt() {
        return reasonNameCt;
    }

    public void setReasonNameCt(String reasonNameCt) {
        this.reasonNameCt = reasonNameCt == null ? null : reasonNameCt.trim();
    }

    public String getReasonNameEn() {
        return reasonNameEn;
    }

    public void setReasonNameEn(String reasonNameEn) {
        this.reasonNameEn = reasonNameEn == null ? null : reasonNameEn.trim();
    }

    public String getReasonNameJp() {
        return reasonNameJp;
    }

    public void setReasonNameJp(String reasonNameJp) {
        this.reasonNameJp = reasonNameJp == null ? null : reasonNameJp.trim();
    }

    public String getReasonNameKr() {
        return reasonNameKr;
    }

    public void setReasonNameKr(String reasonNameKr) {
        this.reasonNameKr = reasonNameKr == null ? null : reasonNameKr.trim();
    }

    public String getReasonTypeId() {
        return reasonTypeId;
    }

    public void setReasonTypeId(String reasonTypeId) {
        this.reasonTypeId = reasonTypeId == null ? null : reasonTypeId.trim();
    }

    public String getReasonTypeName() {
        return reasonTypeName;
    }

    public void setReasonTypeName(String reasonTypeName) {
        this.reasonTypeName = reasonTypeName == null ? null : reasonTypeName.trim();
    }

    public String getReasonStatus() {
        return reasonStatus;
    }

    public void setReasonStatus(String reasonStatus) {
        this.reasonStatus = reasonStatus == null ? null : reasonStatus.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }
}