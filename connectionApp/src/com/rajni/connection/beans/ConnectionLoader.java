package com.rajni.connection.beans;

import java.util.HashMap;

public abstract class ConnectionLoader {
	protected HashMap<ConnectionTypes, ConnectionDetails> connectionDetails = new HashMap<>();
	
	public ConnectionLoader() {
		// TODO Auto-generated constructor stub
		loadConfiguration();
	}
	
	public abstract void loadConfiguration();
	
	public ConnectionDetails getConnectionDetail(ConnectionTypes type) {
		if(connectionDetails.size() != 0) {
			return connectionDetails.get(type);
		}
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
