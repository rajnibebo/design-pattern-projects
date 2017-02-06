package com.rajni.connection.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rajni.ubhi
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ConDataSources")
public class ConDataSource {
	@XmlElement(name="isDataSource")
	private boolean isDataSource;
	@XmlElement(name="ConnectionSource")
	private List<ContextConnectionDetail> connectionSources;
	
	public boolean isDataSource() {
		return isDataSource;
	}
	public void setDataSource(boolean isDataSource) {
		this.isDataSource = isDataSource;
	}
	public List<ContextConnectionDetail> getConnectionSources() {
		return connectionSources;
	}
	public void setConnectionSources(List<ContextConnectionDetail> connectionSources) {
		this.connectionSources = connectionSources;
	}
	
	public String toString() {
		return "Context:List:"+connectionSources;
	}
	
}
