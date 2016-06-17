package com.luckyrui.test.model;

import java.util.Date;

public class ReportTable013 extends MongoModelDef {
	/**
	 * @author liuzhengzhen
	 * @description
	 */
	private static final long serialVersionUID = 8580084132541280600L;

    private String id;
	/**
	 * 账单编号
	 */
	private String billNum;
	/**
	 * 业务日期
	 */
	private Date bussDate;

	private String payId;

	private String payName;

	private String payCode;

	private String payNum;

	private String payAmount;

	private String payRemark;

	public String getBillNum() {
		return billNum;
	}

	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}

	public Date getBussDate() {
		return bussDate;
	}

	public void setBussDate(Date bussDate) {
		this.bussDate = bussDate;
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public String getPayNum() {
		return payNum;
	}

	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getPayRemark() {
		return payRemark;
	}

	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

}
