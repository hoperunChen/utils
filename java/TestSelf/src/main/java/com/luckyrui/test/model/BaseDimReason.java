package com.luckyrui.test.model;
/**
 * 原因维度表
 * @author Xue Chen
 *
 */
public class BaseDimReason extends MongoModelDef {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4597093329904799056L;

	/**
	 * 原因ID reason_id varchar(36) 36 TRUE FALSE TRUE
	 */
	private String reasonId;
	/**
	 * 原因名称简体 reason_name_cs varchar(20) 20 FALSE FALSE FALSE
	 */
	private String  reasonNameCs;
	/**
	 * 原因名称繁体 reason_name_ct varchar(20) 20 FALSE FALSE FALSE
	 */
	private String reasonNameCt;
	/**
	 * 原因名称英语 reason_name_en varchar(20) 20 FALSE FALSE FALSE
	 */
	private String reasonNameEn;
	/**
	 * 原因名称日语 reason_name_jp varchar(20) 20 FALSE FALSE FALSE
	 */
	private String reasonNameJp;
	/**
	 * 原因名称韩语 reason_name_kr varchar(20) 20 FALSE FALSE FALSE
	 */
	private String reasonNameKr;
	/**
	 * 原因类型ID reason_type_id varchar(36) 36 FALSE FALSE FALSE
	 */
	private String reasonTypeId;
	/**
	 * 原因类型名称 reason_type_name varchar(20) 20 FALSE FALSE FALSE
	 */
	private String  reasonTypeName;
	/**
	 * 原因状态 reason_status varchar(36) 36 FALSE FALSE FALSE
	 */
	private String reasonStatus;
	/**
	 * 租户ID tenant_id varchar(36) 36 FALSE FALSE FALSE
	 */
	private String tenantId;
	
	public BaseDimReason() {
	}

	public String getReasonId() {
		return reasonId;
	}

	public void setReasonId(String reasonId) {
		this.reasonId = reasonId;
	}

	public String getReasonNameCs() {
		return reasonNameCs;
	}

	public void setReasonNameCs(String reasonNameCs) {
		this.reasonNameCs = reasonNameCs;
	}

	public String getReasonNameCt() {
		return reasonNameCt;
	}

	public void setReasonNameCt(String reasonNameCt) {
		this.reasonNameCt = reasonNameCt;
	}

	public String getReasonNameEn() {
		return reasonNameEn;
	}

	public void setReasonNameEn(String reasonNameEn) {
		this.reasonNameEn = reasonNameEn;
	}

	public String getReasonNameJp() {
		return reasonNameJp;
	}

	public void setReasonNameJp(String reasonNameJp) {
		this.reasonNameJp = reasonNameJp;
	}

	public String getReasonNameKr() {
		return reasonNameKr;
	}

	public void setReasonNameKr(String reasonNameKr) {
		this.reasonNameKr = reasonNameKr;
	}

	public String getReasonTypeId() {
		return reasonTypeId;
	}

	public void setReasonTypeId(String reasonTypeId) {
		this.reasonTypeId = reasonTypeId;
	}

	public String getReasonTypeName() {
		return reasonTypeName;
	}

	public void setReasonTypeName(String reasonTypeName) {
		this.reasonTypeName = reasonTypeName;
	}

	public String getReasonStatus() {
		return reasonStatus;
	}

	public void setReasonStatus(String reasonStatus) {
		this.reasonStatus = reasonStatus;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
	

}
