package com.rajni.connection.beans;


public enum ConnectionTypes {
	MYSQL , MYSQL_DS, ORACLE ,ORACLE_DS ,PERVASIVE ,PERVASIVE_DS;
	
	public static ConnectionTypes getConnectionTypes(String value) {
		if(value != null) {
			System.out.println("Value is not null : "+value);
			if(value.equalsIgnoreCase(ConnectionTypes.MYSQL.toString())) {
				return ConnectionTypes.MYSQL;
			} else if(value.equalsIgnoreCase(ConnectionTypes.MYSQL_DS.toString())) {
				return ConnectionTypes.MYSQL_DS;
			} else if(value.equalsIgnoreCase(ConnectionTypes.ORACLE.toString())) {
				return ConnectionTypes.ORACLE;
			} else if(value.equalsIgnoreCase(ConnectionTypes.ORACLE_DS.toString())) {
				return ConnectionTypes.ORACLE_DS;
			} else if(value.equalsIgnoreCase(ConnectionTypes.PERVASIVE.toString())) {
				return ConnectionTypes.PERVASIVE;
			} else if(value.equalsIgnoreCase(ConnectionTypes.PERVASIVE_DS.toString())) {
				return ConnectionTypes.PERVASIVE_DS;
			}
		}
		return null;
	}
}
