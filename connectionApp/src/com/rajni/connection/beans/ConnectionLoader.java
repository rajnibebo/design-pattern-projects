package com.rajni.connection.beans;

import java.util.HashMap;

import org.apache.log4j.Logger;

/**
 * @author rajni.ubhi
 *
 */
public abstract class ConnectionLoader {
	protected HashMap<ConnectionTypes, ConnectionDetails> connectionDetails = new HashMap<>();
	protected static Logger logger = Logger.getLogger(ConnectionLoader.class);
	
	public ConnectionLoader() {
		// TODO Auto-generated constructor stub
		loadConfiguration();
	}
	
	public abstract void loadConfiguration();
	
	public ConnectionDetails getConnectionDetail(ConnectionTypes type) {
		logger.info("CONNECTION LOADER loading the connection detail");
		if(connectionDetails.size() != 0) {
			return connectionDetails.get(type);
		}
		logger.info("FINAL LIST :::: "+connectionDetails);
		return null;
	}

	public HashMap<ConnectionTypes, ConnectionDetails> getConnectionDetails() {
		return connectionDetails;
	}

	/*public void setConnectionDetails(
			HashMap<ConnectionTypes, ConnectionDetails> connectionDetails) {
		this.connectionDetails = connectionDetails;
	}
	*/
	
}
