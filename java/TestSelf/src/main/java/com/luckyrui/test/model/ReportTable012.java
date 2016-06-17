package com.luckyrui.test.model;

 
import java.util.Date;

/**
 * 
 *  对应报表：12-前台账单明细付款查询
 * 
 * @author lyy
 *
 */

public class ReportTable012  extends MongoModelDef{

	 
	private static final long serialVersionUID = 6441714307397801068L;
	
    private String id;

	/**
	  * 账单编号
	  */
	private String bussId; 
	/**
	  * 业务日期
	  */
    private Date bussDate; 

    /**
	  * 菜品ID 
	  */
	private String dishId; 
	 /**
	  * 菜品编号
	  */
	private String dishCode; 
	/**
	  * 菜品名称
	  */
	private String dishName; 
	/**
	  * 菜品单价
	  */
	private int dishPrice; 
	/**
	  * 菜品单位
	  */
	private String dishUnit; 
	/**
	  * 菜品数量
	  */
	private int dishNum; 
	
	/**
	  * 菜品金额
	  */
	private int dishAmount; 
	/**
	  * 实结金额
	  */
	private int realAmount; 
	/**
	  * 折扣率
	  */
	private int discRatio; 
	/**
	  * 类别名称
	  */
	private String sortName; 
	/**
	  * 菜品属性
	  */
	private String dishAttribute; 
	/**
	  * 操作属性
	  */
	private String operAttribute; 
	/**
	  * 点菜时间
	  */
	private String orderTime; 
	/**
	  * 口味备注
	  */
	private String tasteRemark; 
	/**
	  * 做法备注
	  */
	private String practiceRemark; 
	
	
	 public String getBussId() {
		return bussId;
	}

	public void setBussId(String bussId) {
		this.bussId = bussId;
	}

	public Date getBussDate() {
		return bussDate;
	}

	public void setBussDate(Date bussDate) {
		this.bussDate = bussDate;
	}

	public String getDishId() {
		return dishId;
	}

	public void setDishId(String dishId) {
		this.dishId = dishId;
	}

	public String getDishCode() {
		return dishCode;
	}

	public void setDishCode(String dishCode) {
		this.dishCode = dishCode;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public int getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(int dishPrice) {
		this.dishPrice = dishPrice;
	}

	public String getDishUnit() {
		return dishUnit;
	}

	public void setDishUnit(String dishUnit) {
		this.dishUnit = dishUnit;
	}

	public int getDishNum() {
		return dishNum;
	}

	public void setDishNum(int dishNum) {
		this.dishNum = dishNum;
	}

	public int getDishAmount() {
		return dishAmount;
	}

	public void setDishAmount(int dishAmount) {
		this.dishAmount = dishAmount;
	}

	public int getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(int realAmount) {
		this.realAmount = realAmount;
	}

	public int getDiscRatio() {
		return discRatio;
	}

	public void setDiscRatio(int discRatio) {
		this.discRatio = discRatio;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getDishAttribute() {
		return dishAttribute;
	}

	public void setDishAttribute(String dishAttribute) {
		this.dishAttribute = dishAttribute;
	}

	public String getOperAttribute() {
		return operAttribute;
	}

	public void setOperAttribute(String operAttribute) {
		this.operAttribute = operAttribute;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getTasteRemark() {
		return tasteRemark;
	}

	public void setTasteRemark(String tasteRemark) {
		this.tasteRemark = tasteRemark;
	}

	public String getPracticeRemark() {
		return practiceRemark;
	}

	public void setPracticeRemark(String practiceRemark) {
		this.practiceRemark = practiceRemark;
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
