package com.luckyrui.test.model;

public class DimReportColumnName  extends MongoModelDef {
	
	private static final long serialVersionUID = 7594652799186602445L;
	
	private String id;
		
	private String 	tenant_id;
	
	private String column_name;
	
	private String column_name_alias;
	
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

	

}
