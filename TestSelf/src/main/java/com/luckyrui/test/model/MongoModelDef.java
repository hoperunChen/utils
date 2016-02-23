/**
 * 
 */
package com.luckyrui.test.model;

/**
 * @author Xue Chen
 *
 */
public class MongoModelDef implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3870199199155771537L;
	/**
	 * 
	 */
	private String tenantId;
	/**
	 * 
	 */
	private String organizationId;
	
	/**
	 * 
	 */
	public MongoModelDef() {
		// TODO Auto-generated constructor stub
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

}
