package com.rajni.connection.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.rajni.connection.beans.ConnectionDetails;
import com.rajni.connection.beans.ConnectionTypes;

public class ConventionalConnectionFactory extends ConnectionFactory{

	private String driverClass;
	private String driverUrl;
	private String dbUser;
	private String dbPassword;
	private ConnectionTypes conType;
	
	private static boolean[] driversLoaded = {false,false,false};
	
	private static final int IDX_ORACLE = 0;
	private static final int IDX_MYSQL = 1;
	private static final int IDX_PERVASIVE = 2;
	
	public ConventionalConnectionFactory(ConnectionDetails conDetails) {
		super(conDetails);
		// TODO Auto-generated constructor stub
		this.conType = conDetails.getConType();
		configure();
	}

	@Override
	void configure() {
		// TODO Auto-generated method stub
		try {
			if(conType == ConnectionTypes.ORACLE) {
				if(!driversLoaded[IDX_ORACLE]) {
					Class.forName(driverClass);  //uncomment later 
					driversLoaded[IDX_ORACLE] = true;
				} 
			} else if(conType == ConnectionTypes.MYSQL) {
				if(!driversLoaded[IDX_MYSQL]) {
					Class.forName(driverClass);  //uncomment later
					driversLoaded[IDX_MYSQL] = true;
				}
			} else if(conType == ConnectionTypes.PERVASIVE) {
				if(!driversLoaded[IDX_PERVASIVE]) {
					Class.forName(driverClass);   //uncomment later
					driversLoaded[IDX_PERVASIVE] = true;
				}
			} 
			this.driverClass = conDetails.getDriverClass();
			this.driverUrl = conDetails.getDriverUrl();
			this.dbUser = conDetails.getDbUser();
			this.dbPassword = conDetails.getDbPassword();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return DriverManager.getConnection(driverUrl, dbUser, dbPassword);
	}

}
