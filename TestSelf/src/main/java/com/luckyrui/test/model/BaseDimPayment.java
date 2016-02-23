package com.luckyrui.test.model;
/**
 * 付款维度表
 * @author Xue Chen
 *
 */
public class BaseDimPayment extends MongoModelDef {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8225001170474352317L;
	/**
	 * 付款ID pay_id varchar(36) 36 TRUE FALSE TRUE
	 */
	private String payId;
	/**
	 * 付款代码 pay_code varchar(10) 10 FALSE FALSE FALSE
	 */
	private String payCode;
	/**
	 * 付款名称简体 pay_name_cs varchar(20) 20 FALSE FALSE FALSE
	 */
	private String payNameCs;
	/**
	 * 付款名称繁体 pay_name_ct varchar(20) 20 FALSE FALSE FALSE
	 */
	private String payNameCt;
	/**
	 * 付款名称英语 pay_name_en varchar(20) 20 FALSE FALSE FALSE
	 */
	private String payNameEn;
	/**
	 * 付款名称日语 pay_name_jp varchar(20) 20 FALSE FALSE FALSE
	 */
	private String payNameJp;
	/**
	 * 付款名称韩语 pay_name_kr varchar(20) 20 FALSE FALSE FALSE
	 */
	private String payNameKr;
	/**
	 * 付款类型代码 pay_type_code varchar(20) 20 FALSE FALSE FALSE
	 */
	private String payTypeCode;
	/**
	 * 付款类型名称 pay_type_name varchar(20) 20 FALSE FALSE FALSE
	 */
	private String payTypeName;
	/**
	 * 付款状态 pay_status varchar(20) 20 FALSE FALSE FALSE
	 */
	private String payStatus;

	public BaseDimPayment() {
		// TODO Auto-generated constructor stub
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getPayNameCs() {
		return payNameCs;
	}

	public void setPayNameCs(String payNameCs) {
		this.payNameCs = payNameCs;
	}

	public String getPayNameCt() {
		return payNameCt;
	}

	public void setPayNameCt(String payNameCt) {
		this.payNameCt = payNameCt;
	}

	public String getPayNameEn() {
		return payNameEn;
	}

	public void setPayNameEn(String payNameEn) {
		this.payNameEn = payNameEn;
	}

	public String getPayNameJp() {
		return payNameJp;
	}

	public void setPayNameJp(String payNameJp) {
		this.payNameJp = payNameJp;
	}

	public String getPayNameKr() {
		return payNameKr;
	}

	public void setPayNameKr(String payNameKr) {
		this.payNameKr = payNameKr;
	}

	public String getPayTypeCode() {
		return payTypeCode;
	}

	public void setPayTypeCode(String payTypeCode) {
		this.payTypeCode = payTypeCode;
	}

	public String getPayTypeName() {
		return payTypeName;
	}

	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

}
