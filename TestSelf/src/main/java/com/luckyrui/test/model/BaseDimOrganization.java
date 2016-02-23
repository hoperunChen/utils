package com.luckyrui.test.model;

import java.util.Date;
/**
 * 机构维度表
 * @author Xue Chen
 *
 */
public class BaseDimOrganization extends MongoModelDef {

	/**
	 * 
	 */
	private static final long serialVersionUID = -646849747729868325L;

	/**
	 * 门店ID store_id varchar(36) 36 TRUE FALSE TRUE
	 */
	private String storeId;
	/**
	 * 门店代码 store_code varchar(20) 20 FALSE FALSE FALSE
	 */
	private String storeCode;
	/**
	 * 门店名称简体 store_name_cs varchar(30) 30 FALSE FALSE FALSE
	 */
	private String storeNameCs;
	/**
	 * 门店名称繁体 store_name_ct varchar(30) 30 FALSE FALSE FALSE
	 */
	private String storeNameCt;
	/**
	 * 门店名称英语 store_name_en varchar(30) 30 FALSE FALSE FALSE
	 */
	private String storeNameEn;
	/**
	 * 门店名称日语 store_name_jp varchar(30) 30 FALSE FALSE FALSE
	 */
	private String storeNameJp;
	/**
	 * 门店名称韩语 store_name_kr varchar(30) 30 FALSE FALSE FALSE
	 */
	private String storeNameKr;
	/**
	 * 门店所在国家 store_country varchar(30) 30 FALSE FALSE FALSE
	 */
	private String storeCountry;
	/**
	 * 门店所在省份 store_province varchar(30) 30 FALSE FALSE FALSE
	 */
	private String storeProvince;
	/**
	 * 门店所在城市 store_city varchar(30) 30 FALSE FALSE FALSE
	 */
	private String storeCity;
	/**
	 * 门店所在区县 store_county varchar(30) 30 FALSE FALSE FALSE
	 */
	private String storeCounty;
	/**
	 * 门店显示顺序 store_order smallint FALSE FALSE FALSE
	 */
	private String storeOrder;
	/**
	 * 经营方式 buss_mode varchar(30) 30 FALSE FALSE FALSE
	 */
	private String bussMode;
	/**
	 * 店面级别 store_level varchar(30) 30 FALSE FALSE FALSE
	 */
	private String storeLevel;
	/**
	 * 商圈类型 district_type varchar(30) 30 FALSE FALSE FALSE
	 */
	private String districtType;
	/**
	 * 开业日期 open_date date FALSE FALSE FALSE
	 */
	private Date openDate;
	/**
	 * 营业面积 buss_area decimal(12,2) 12 2 FALSE FALSE FALSE
	 */
	private String bussArea;
	/**
	 * 企业法人 legal_person varchar(30) 30 FALSE FALSE FALSE
	 */
	private String legalPerson;
	/**
	 * 门店状态 store_status varchar(36) 36 FALSE FALSE FALSE
	 */
	private String storeStatus;
	/**
	 * 市场区域 
	 * 一级区域ID one_id varchar(36) 36 FALSE FALSE FALSE
	 */
	private String oneId;
	/**
	 * 市场区域 
	 * 一级区域代码 one_code varchar(20) 20 FALSE FALSE FALSE
	 */
	private String oneCode;
	/**
	 * 市场区域 
	 * 一级区域名称简体 one_name_cs varchar(30) 30 FALSE FALSE FALSE
	 */
	private String oneNameCs;
	/**
	 * 一级区域名称繁体 one_name_ct varchar(30) 30 FALSE FALSE FALSE
	 */
	private String oneNameCt;
	/**
	 * 一级区域名称英语 one_name_en varchar(30) 30 FALSE FALSE FALSE
	 */
	private String oneNameEn;
	/**
	 * 一级区域名称日语 one_name_jp varchar(30) 30 FALSE FALSE FALSE
	 */
	private String oneNameJp;
	/**
	 * 一级区域名称韩语 one_name_kr varchar(30) 30 FALSE FALSE FALSE
	 */
	private String oneNameKr;
	/**
	 *  营运区域
	 * 二级区域ID two_id varchar(36) 36 FALSE FALSE FALSE
	 */
	private String twoId;
	/**
	 *  营运区域
	 * 二级区域代码 two_code varchar(20) 20 FALSE FALSE FALSE
	 */
	private String twoCode;
	/**
	 *  营运区域
	 * 二级区域名称简体 two_name_cs varchar(30) 30 FALSE FALSE FALSE
	 */
	private String twoNameCs;
	/**
	 * 二级区域名称繁体 two_name_ct varchar(30) 30 FALSE FALSE FALSE
	 */
	private String twoNameCt;
	/**
	 * 二级区域名称英语 two_name_en varchar(30) 30 FALSE FALSE FALSE
	 */
	private String twoNameEn;
	/**
	 * 二级区域名称日语 two_name_jp varchar(30) 30 FALSE FALSE FALSE
	 */
	private String twoNameJp;
	/**
	 * 二级区域名称韩语 two_name_kr varchar(30) 30 FALSE FALSE FALSE
	 */
	private String twoNameKr;
	/**
	 * 督导区域
	 * 三级区域ID thr_id varchar(36) 36 FALSE FALSE FALSE
	 */
	private String thrId;
	/**
	 * 督导区域
	 * 三级区域代码 thr_code varchar(20) 20 FALSE FALSE FALSE
	 */
	private String thrCode;
	/**
	 * 督导区域
	 * 三级区域名称简体 thr_name_cs varchar(30) 30 FALSE FALSE FALSE
	 */
	private String  thrNameCs;
	/**
	 * 三级区域名称繁体 thr_name_ct varchar(30) 30 FALSE FALSE FALSE
	 */
	private String thrNameCt;
	/**
	 * 三级区域名称英语 thr_name_en varchar(30) 30 FALSE FALSE FALSE
	 */
	private String thrNameEn;
	/**
	 * 三级区域名称日语 thr_name_jp varchar(30) 30 FALSE FALSE FALSE
	 */
	private String thrNameJp;
	/**
	 * 三级区域名称韩语 thr_name_kr varchar(30) 30 FALSE FALSE FALSE
	 */
	private String thrNameKr;

	public BaseDimOrganization() {
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
		this.setOrganizationId(storeId);
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreNameCs() {
		return storeNameCs;
	}

	public void setStoreNameCs(String storeNameCs) {
		this.storeNameCs = storeNameCs;
	}

	public String getStoreNameCt() {
		return storeNameCt;
	}

	public void setStoreNameCt(String storeNameCt) {
		this.storeNameCt = storeNameCt;
	}

	public String getStoreNameEn() {
		return storeNameEn;
	}

	public void setStoreNameEn(String storeNameEn) {
		this.storeNameEn = storeNameEn;
	}

	public String getStoreNameJp() {
		return storeNameJp;
	}

	public void setStoreNameJp(String storeNameJp) {
		this.storeNameJp = storeNameJp;
	}

	public String getStoreNameKr() {
		return storeNameKr;
	}

	public void setStoreNameKr(String storeNameKr) {
		this.storeNameKr = storeNameKr;
	}

	public String getStoreCountry() {
		return storeCountry;
	}

	public void setStoreCountry(String storeCountry) {
		this.storeCountry = storeCountry;
	}

	public String getStoreProvince() {
		return storeProvince;
	}

	public void setStoreProvince(String storeProvince) {
		this.storeProvince = storeProvince;
	}

	public String getStoreCity() {
		return storeCity;
	}

	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}

	public String getStoreCounty() {
		return storeCounty;
	}

	public void setStoreCounty(String storeCounty) {
		this.storeCounty = storeCounty;
	}

	public String getStoreOrder() {
		return storeOrder;
	}

	public void setStoreOrder(String storeOrder) {
		this.storeOrder = storeOrder;
	}

	public String getBussMode() {
		return bussMode;
	}

	public void setBussMode(String bussMode) {
		this.bussMode = bussMode;
	}

	public String getStoreLevel() {
		return storeLevel;
	}

	public void setStoreLevel(String storeLevel) {
		this.storeLevel = storeLevel;
	}

	public String getDistrictType() {
		return districtType;
	}

	public void setDistrictType(String districtType) {
		this.districtType = districtType;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getBussArea() {
		return bussArea;
	}

	public void setBussArea(String bussArea) {
		this.bussArea = bussArea;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(String storeStatus) {
		this.storeStatus = storeStatus;
	}

	public String getOneId() {
		return oneId;
	}

	public void setOneId(String oneId) {
		this.oneId = oneId;
	}

	public String getOneCode() {
		return oneCode;
	}

	public void setOneCode(String oneCode) {
		this.oneCode = oneCode;
	}

	public String getOneNameCs() {
		return oneNameCs;
	}

	public void setOneNameCs(String oneNameCs) {
		this.oneNameCs = oneNameCs;
	}

	public String getOneNameCt() {
		return oneNameCt;
	}

	public void setOneNameCt(String oneNameCt) {
		this.oneNameCt = oneNameCt;
	}

	public String getOneNameEn() {
		return oneNameEn;
	}

	public void setOneNameEn(String oneNameEn) {
		this.oneNameEn = oneNameEn;
	}

	public String getOneNameJp() {
		return oneNameJp;
	}

	public void setOneNameJp(String oneNameJp) {
		this.oneNameJp = oneNameJp;
	}

	public String getOneNameKr() {
		return oneNameKr;
	}

	public void setOneNameKr(String oneNameKr) {
		this.oneNameKr = oneNameKr;
	}

	public String getTwoId() {
		return twoId;
	}

	public void setTwoId(String twoId) {
		this.twoId = twoId;
	}

	public String getTwoCode() {
		return twoCode;
	}

	public void setTwoCode(String twoCode) {
		this.twoCode = twoCode;
	}

	public String getTwoNameCs() {
		return twoNameCs;
	}

	public void setTwoNameCs(String twoNameCs) {
		this.twoNameCs = twoNameCs;
	}

	public String getTwoNameCt() {
		return twoNameCt;
	}

	public void setTwoNameCt(String twoNameCt) {
		this.twoNameCt = twoNameCt;
	}

	public String getTwoNameEn() {
		return twoNameEn;
	}

	public void setTwoNameEn(String twoNameEn) {
		this.twoNameEn = twoNameEn;
	}

	public String getTwoNameJp() {
		return twoNameJp;
	}

	public void setTwoNameJp(String twoNameJp) {
		this.twoNameJp = twoNameJp;
	}

	public String getTwoNameKr() {
		return twoNameKr;
	}

	public void setTwoNameKr(String twoNameKr) {
		this.twoNameKr = twoNameKr;
	}

	public String getThrId() {
		return thrId;
	}

	public void setThrId(String thrId) {
		this.thrId = thrId;
	}

	public String getThrCode() {
		return thrCode;
	}

	public void setThrCode(String thrCode) {
		this.thrCode = thrCode;
	}

	public String getThrNameCs() {
		return thrNameCs;
	}

	public void setThrNameCs(String thrNameCs) {
		this.thrNameCs = thrNameCs;
	}

	public String getThrNameCt() {
		return thrNameCt;
	}

	public void setThrNameCt(String thrNameCt) {
		this.thrNameCt = thrNameCt;
	}

	public String getThrNameEn() {
		return thrNameEn;
	}

	public void setThrNameEn(String thrNameEn) {
		this.thrNameEn = thrNameEn;
	}

	public String getThrNameJp() {
		return thrNameJp;
	}

	public void setThrNameJp(String thrNameJp) {
		this.thrNameJp = thrNameJp;
	}

	public String getThrNameKr() {
		return thrNameKr;
	}

	public void setThrNameKr(String thrNameKr) {
		this.thrNameKr = thrNameKr;
	}
	
	

}
