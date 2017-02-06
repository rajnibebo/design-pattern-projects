package com.rajni.connection.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rajni.ubhi
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="DBConf")
public class DBConf {
	@XmlElement(name="ConDataSources")
	private ConDataSource conDataSource;
	@XmlElement(name="ConDriverManagers")
	private ConDManager conDManager;
	
	public ConDataSource getConDataSource() {
		return conDataSource;
	}
	public void setConDataSource(ConDataSource conDataSource) {
		this.conDataSource = conDataSource;
	}
	public ConDManager getConDManager() {
		return conDManager;
	}
	public void setConDManager(ConDManager conDManager) {
		this.conDManager = conDManager;
	}
	public String toString() {
		return conDataSource+"\n"+conDManager;
	}
}
