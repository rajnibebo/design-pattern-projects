package com.rajni.connection.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ConDriverManagers")
public class ConDManager {
	@XmlElement(name="isDataSource")
	private boolean isDataSource;
	@XmlElement(name="connectionSource")
	private List<DManagerConnectionDetail> connectionSources;
	
	public boolean isDataSource() {
		return isDataSource;
	}
	public void setDataSource(boolean isDataSource) {
		this.isDataSource = isDataSource;
	}
	public List<DManagerConnectionDetail> getConnectionSources() {
		return connectionSources;
	}
	public void setConnectionSources(List<DManagerConnectionDetail> connectionSources) {
		this.connectionSources = connectionSources;
	}
	
	public String toString() {
		return "DManagerConSource:list:"+connectionSources;
	}
	
	
}
