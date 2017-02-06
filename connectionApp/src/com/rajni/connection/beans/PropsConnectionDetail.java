package com.rajni.connection.beans;

public class PropsConnectionDetail extends ConnectionDetails {
	private boolean isDataSource;
	private String driverClass;
	private String driverUrl;
	private String dbUser;
	private String dbPassword;
	private String lookupName;
	
	public boolean isDataSource() {
		return isDataSource;
	}
	public void setDataSource(boolean isDataSource) {
		this.isDataSource = isDataSource;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getDriverUrl() {
		return driverUrl;
	}
	public void setDriverUrl(String driverUrl) {
		this.driverUrl = driverUrl;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	public String getLookupName() {
		return lookupName;
	}
	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}
}
