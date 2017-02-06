package com.rajni.connection.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.rajni.connection.beans.AllConDetailsIntf;

/**
 * @author rajni.ubhi
 *
 */
public class ContextConnectionFactory extends ConnectionFactory {

	private DataSource dataSource;
	private Context context;
		
	public ContextConnectionFactory(AllConDetailsIntf conDetails) {
		// TODO Auto-generated constructor stub
		super(conDetails);
		configure();
	}
	@Override
	void configure() {
		// TODO Auto-generated method stub
		try {
			this.context = new InitialContext();
			this.dataSource = (DataSource) context.lookup(conDetails.getLookupName());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		logger.info("ABOUT TO CONNECT WITH DB THROUGH CONTEXT!!!!!");
		return dataSource.getConnection();
	}

}
