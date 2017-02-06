package com.rajni.connection.beans;

/**
 * @author rajni.ubhi
 *
 */
public interface AllConDetailsIntf {
	String LOAD_XML = "C:/Users/acbd/workspace/Html5Workspace/e_shop/src/com/rajni/connection/beans/DBConf.xml";
	String LOAD_PROPS = "C:/Users/acbd/workspace/Html5Workspace/e_shop/src/com/rajni/connection/beans/DBConf.properties";
	String getDbUser();
	String getDbPassword();
	String getDriverUrl();
	String getDriverClass();
	boolean isDataSource();
	String getLookupName();
}
