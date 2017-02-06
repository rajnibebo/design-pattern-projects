package com.rajni.connection.beans;

/**
 * @author rajni.ubhi
 *
 */
public abstract class ConnectionDetails implements AllConDetailsIntf {
	protected ConnectionTypes conType;

	public ConnectionTypes getConType() {
		return conType;
	}
	public void setConType(ConnectionTypes conType) {
		this.conType = conType;
	}
	
}
