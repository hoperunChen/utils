package com.luckyrui.test.model;

 
import java.util.Date;

/**
 * 
 *  对应报表：12-前台账单明细付款查询 付款
 * 
 * @author yuanjs
 *
 */

public class ReportTable012_1  extends MongoModelDef{

	 
	private static final long serialVersionUID = -752046420689658679L;
	
	/**
	  * 付款方式
	  */
	private String payMethod; 
	/**
	  * 付款金额
	  */
    private int payAmount; 
    /**
	  * 付款号码
	  */
	private String payNum; 
	 /**
	  * 付款备注
	  */
	private String payRemark;
	
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public int getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}
	public String getPayNum() {
		return payNum;
	}
	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}
	public String getPayRemark() {
		return payRemark;
	}
	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	} 
}
