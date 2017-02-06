package com.rajni.connection.beans;

public interface AllConDetailsIntf {
	
	String getDbUser();
	String getDbPassword();
	String getDriverUrl();
	String getDriverClass();
	boolean isDataSource();
	String getLookupName();
}
