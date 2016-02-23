package com.luckyrui.test.model;


public class DimReportColumn {

	//id
	private String id;
	//报表编码
	private String report_code;
	//报表名称
	private String report_name;
	//报表列编码
	private String column_code;
	//报表列名称
	private String column_name;
	//别名
	private String column_name_alias;
				   
	//报表列id
	private String column_id;
	// 企业ID
	private String tenant_id;
	// 字段状态 0隐藏1显示
	private String column_status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	public String getReport_name() {
		return report_name;
	}
	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}
	public String getColumn_code() {
		return column_code;
	}
	public void setColumn_code(String column_code) {
		this.column_code = column_code;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public String getColumn_name_alias() {
		return column_name_alias;
	}
	public void setColumn_name_alias(String column_name_alias) {
		this.column_name_alias = column_name_alias;
	}
	public String getColumn_id() {
		return column_id;
	}
	public void setColumn_id(String column_id) {
		this.column_id = column_id;
	}
	public String getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}
	public String getColumn_status() {
		return column_status;
	}
	public void setColumn_status(String column_status) {
		this.column_status = column_status;
	}
}
