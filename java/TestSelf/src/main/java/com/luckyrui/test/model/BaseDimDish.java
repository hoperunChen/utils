package com.luckyrui.test.model;
/**
 * 菜品维度表
 * @author Xue Chen
 *
 */
public class BaseDimDish extends MongoModelDef  {
	/**
	 * Name	Code	Data Type	Length	Precision	Primary	Foreign Key	Mandatory
	 */

	private static final long serialVersionUID = 7594652799186602449L;
	/**
	 * 菜品ID dish_id varchar(36) 36 TRUE FALSE TRUE
	 */
	private String dishId;
	/**
	 * 菜品编号 dish_code varchar(10) 10 FALSE FALSE FALSE
	 */
	private String dishCode;
	/**
	 * 菜品名称简体 dish_name_cs varchar(30) 30 FALSE FALSE FALSE
	 */
	private String dishNameCs;
	/**
	 * 菜品名称繁体 dish_name_ct varchar(30) 30 FALSE FALSE FALSE
	 */
	private String dishNameCt;
	/**
	 * 菜品名称英语 dish_name_en varchar(30) 30 FALSE FALSE FALSE
	 */
	private String dishNameEn;
	/**
	 * 菜品名称日语 dish_name_jp varchar(30) 30 FALSE FALSE FALSE
	 */
	private String dishNameJp;
	/**
	 * 菜品名称韩语 dish_name_kr varchar(30) 30 FALSE FALSE FALSE
	 */
	private String dishNameKr;
	/**
	 * 菜品属性 dish_proper varchar(10) 10 FALSE FALSE FALSE
	 */
	private String dishProper;
	/**
	 * 菜品状态 dish_status varchar(10) 10 FALSE FALSE FALSE
	 */
	private String dishStatus;
	/**
	 * 菜品拼音代码 dish_phonetic varchar(20) 20 FALSE FALSE FALSE
	 */
	private String dishPhonetic;
	/**
	 * 菜品五笔代码 dish_fivepen varchar(20) 20 FALSE FALSE FALSE
	 */
	private String dishFivepen;
	/**
	 * 类别ID cate_id varchar(36) 36 FALSE FALSE FALSE
	 */
	private String cateId;
	/**
	 * 类别代码 cate_code varchar(10) 10 FALSE FALSE FALSE
	 */
	private String cateCode;
	/**
	 * 类别名称简体 cate_name_cs varchar(30) 30 FALSE FALSE FALSE
	 */
	private String cateNameCs;
	/**
	 * 类别名称繁体 cate_name_ct varchar(30) 30 FALSE FALSE FALSE
	 */
	private String cateNameCt;
	/**
	 * 类别名称英语 cate_name_en varchar(30) 30 FALSE FALSE FALSE
	 */
	private String cateNameEn;
	/**
	 * 类别名称日语 cate_name_jp varchar(30) 30 FALSE FALSE FALSE
	 */
	private String cateNameJp;
	/**
	 * 类别名称韩语 cate_name_kr varchar(30) 30 FALSE FALSE FALSE
	 */
	private String cateNameKr;

	public BaseDimDish() {
		// TODO Auto-generated constructor stub
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

	public String getDishNameCs() {
		return dishNameCs;
	}

	public void setDishNameCs(String dishNameCs) {
		this.dishNameCs = dishNameCs;
	}

	public String getDishNameCt() {
		return dishNameCt;
	}

	public void setDishNameCt(String dishNameCt) {
		this.dishNameCt = dishNameCt;
	}

	public String getDishNameEn() {
		return dishNameEn;
	}

	public void setDishNameEn(String dishNameEn) {
		this.dishNameEn = dishNameEn;
	}

	public String getDishNameJp() {
		return dishNameJp;
	}

	public void setDishNameJp(String dishNameJp) {
		this.dishNameJp = dishNameJp;
	}

	public String getDishNameKr() {
		return dishNameKr;
	}

	public void setDishNameKr(String dishNameKr) {
		this.dishNameKr = dishNameKr;
	}

	public String getDishProper() {
		return dishProper;
	}

	public void setDishProper(String dishProper) {
		this.dishProper = dishProper;
	}

	public String getDishStatus() {
		return dishStatus;
	}

	public void setDishStatus(String dishStatus) {
		this.dishStatus = dishStatus;
	}

	public String getDishPhonetic() {
		return dishPhonetic;
	}

	public void setDishPhonetic(String dishPhonetic) {
		this.dishPhonetic = dishPhonetic;
	}

	public String getDishFivepen() {
		return dishFivepen;
	}

	public void setDishFivepen(String dishFivepen) {
		this.dishFivepen = dishFivepen;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateNameCs() {
		return cateNameCs;
	}

	public void setCateNameCs(String cateNameCs) {
		this.cateNameCs = cateNameCs;
	}

	public String getCateNameCt() {
		return cateNameCt;
	}

	public void setCateNameCt(String cateNameCt) {
		this.cateNameCt = cateNameCt;
	}

	public String getCateNameEn() {
		return cateNameEn;
	}

	public void setCateNameEn(String cateNameEn) {
		this.cateNameEn = cateNameEn;
	}

	public String getCateNameJp() {
		return cateNameJp;
	}

	public void setCateNameJp(String cateNameJp) {
		this.cateNameJp = cateNameJp;
	}

	public String getCateNameKr() {
		return cateNameKr;
	}

	public void setCateNameKr(String cateNameKr) {
		this.cateNameKr = cateNameKr;
	}

	
}
