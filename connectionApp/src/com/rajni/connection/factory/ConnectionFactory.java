package com.rajni.connection.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rajni.connection.beans.AllConDetailsIntf;

public abstract class ConnectionFactory {

	protected AllConDetailsIntf conDetails = null;

	public ConnectionFactory(AllConDetailsIntf conDetails) {
		// TODO Auto-generated constructor stub
		this.conDetails = conDetails;
	}

	abstract void configure();

	public abstract Connection getConnection() throws SQLException;

	public void closeResources(Connection connection, Statement stmt,
			ResultSet rst) throws Exception {
		// TODO Auto-generated method stub
		if (rst != null) {
			rst.close();
		}

		if (stmt != null) {
			stmt.close();
		}

		if (connection != null) {
			connection.close();
		}

	}
}
