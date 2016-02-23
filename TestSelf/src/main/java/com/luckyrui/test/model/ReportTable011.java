package com.luckyrui.test.model;

import java.util.Date;

 /**
  * model对应报表：11-前台账单流水查询
  * @author  lyyabb
  *
  */

public class ReportTable011 extends MongoModelDef {
 
	private static final long serialVersionUID = 2233131900040137685L;

    private String id;
	/**
	 *  桌位ID
	 */
	private  String tabId;
	/**
	 * 门店名称
	 */
	private  String orgName; 
	/**
	 * 账单编号
	 */
	private  String billNum; 
	/**
	 * 桌位名称
	 */
	private  String tabName; 
	/**
	 * 开台时间
	 */
	private  String openTime; 
	/**
	 * 结账时间
	 */
	private  String closeTime; 
	/**
	 * 菜品小计
	 */
    private String dishTotal;// 菜品小计
	/**
	 * 总服务费
	 */
    private String srvAmount;

	/**
	 * 折扣金额
	 */
    private String discount;

	/**
	 * 折让金额
	 */
    private String discountGive;

	/**
	 * 抹零金额
	 */
    private String maling;

	/**
	 * 奉送金额
	 */
    private String giveAmount;

	/**
	 * 实结金额
	 */
    private String billAmount;

	/**
	 * 礼券超收
	 */
    private String overCoupon;
	
	/**
	 * 预打时间
	 */
	private String preprintTime; 
	/**
	 * 预打次数
	 */
	private  String preprintCount; 
	/**
	 * 账单来源
	 */
	private  String billSource; 
	/**
	 * 营业模式
	 */
	private  String busMode; 
	/**
	 * 账单属性
	 */
	private  String billAttribute; 
	/**
	 * 消费客数
	 */
	private  int guests; 
	/**
	 * 业务日期
	 */
	private  Date bussDate; 
	/**
	 * 收款员
	 */
	private  String closePerson; 
	/**
	 * 服务员
	 */
	private  String waitPerson; 
	/**
	 * 优惠人
	 */
	private  String perfPerson; 
	/**
	 * 发票数量
	 */
	private  int receiptNum; 
	/**
	 * 发票金额
	 */
    private String receiptAmount;

	/**
	 * 账单备注
	 */
	private  String billRemark;
	/**
	 * 市场区域
	 */
	private String marketArea;
	/**
	 * 运营区域
	 */
	private String operateArea;
	/**
	 * 督导区域
	 */
	private String supervisionArea;
	
	private String uploadTime;
	
	public String getTabId() {
		return tabId;
	}

	public void setTabId(String tabId) {
		this.tabId = tabId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getBillNum() {
		return billNum;
	}

	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}




	public String getPreprintTime() {
		return preprintTime;
	}

	public void setPreprintTime(String preprintTime) {
		this.preprintTime = preprintTime;
	}

	public String getPreprintCount() {
		return preprintCount;
	}

	public void setPreprintCount(String preprintCount) {
		this.preprintCount = preprintCount;
	}

	public String getBillSource() {
		return billSource;
	}

	public void setBillSource(String billSource) {
		this.billSource = billSource;
	}

	public String getBusMode() {
		return busMode;
	}

	public void setBusMode(String busMode) {
		this.busMode = busMode;
	}

	public String getBillAttribute() {
		return billAttribute;
	}

	public void setBillAttribute(String billAttribute) {
		this.billAttribute = billAttribute;
	}

	public int getGuests() {
		return guests;
	}

	public void setGuests(int guests) {
		this.guests = guests;
	}

	public Date getBussDate() {
		return bussDate;
	}

	public void setBussDate(Date bussDate) {
		this.bussDate = bussDate;
	}

	public String getClosePerson() {
		return closePerson;
	}

	public void setClosePerson(String closePerson) {
		this.closePerson = closePerson;
	}

	public String getWaitPerson() {
		return waitPerson;
	}

	public void setWaitPerson(String waitPerson) {
		this.waitPerson = waitPerson;
	}

	public String getPerfPerson() {
		return perfPerson;
	}

	public void setPerfPerson(String perfPerson) {
		this.perfPerson = perfPerson;
	}

	public int getReceiptNum() {
		return receiptNum;
	}

	public void setReceiptNum(int receiptNum) {
		this.receiptNum = receiptNum;
	}

	public String getBillRemark() {
		return billRemark;
	}

	public void setBillRemark(String billRemark) {
		this.billRemark = billRemark;
	}

	public String getMarketArea() {
		return marketArea;
	}

	public void setMarketArea(String marketArea) {
		this.marketArea = marketArea;
	}

	public String getOperateArea() {
		return operateArea;
	}

	public void setOperateArea(String operateArea) {
		this.operateArea = operateArea;
	}

	public String getSupervisionArea() {
		return supervisionArea;
	}

	public void setSupervisionArea(String supervisionArea) {
		this.supervisionArea = supervisionArea;
	}

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getDishTotal()
    {
        return dishTotal;
    }

    public void setDishTotal(String dishTotal)
    {
        this.dishTotal = dishTotal;
    }

    public String getSrvAmount()
    {
        return srvAmount;
    }

    public void setSrvAmount(String srvAmount)
    {
        this.srvAmount = srvAmount;
    }

    public String getDiscount()
    {
        return discount;
    }

    public void setDiscount(String discount)
    {
        this.discount = discount;
    }

    public String getDiscountGive()
    {
        return discountGive;
    }

    public void setDiscountGive(String discountGive)
    {
        this.discountGive = discountGive;
    }

    public String getMaling()
    {
        return maling;
    }

    public void setMaling(String maling)
    {
        this.maling = maling;
    }

    public String getGiveAmount()
    {
        return giveAmount;
    }

    public void setGiveAmount(String giveAmount)
    {
        this.giveAmount = giveAmount;
    }

    public String getBillAmount()
    {
        return billAmount;
    }

    public void setBillAmount(String billAmount)
    {
        this.billAmount = billAmount;
    }

    public String getOverCoupon()
    {
        return overCoupon;
    }

    public void setOverCoupon(String overCoupon)
    {
        this.overCoupon = overCoupon;
    }

    public String getReceiptAmount()
    {
        return receiptAmount;
    }

    public void setReceiptAmount(String receiptAmount)
    {
        this.receiptAmount = receiptAmount;
    }

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

}
