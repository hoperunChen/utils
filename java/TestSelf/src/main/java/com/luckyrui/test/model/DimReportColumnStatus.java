package com.luckyrui.test.model;


public class DimReportColumnStatus 
{
	// id
	private String id;
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
