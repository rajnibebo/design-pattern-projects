package com.rajni.connection.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rajni.ubhi
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ConnectionSource")
public class ContextConnectionDetail extends ConnectionDetails {
	
	@XmlAttribute(name="name")
	private String name;
	@XmlElement(name="value")
	private String lokupName;
	
	public ContextConnectionDetail() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "name:"+conType;
	}
	@Override
	public String getDbUser() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getDbPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getDriverUrl() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getDriverClass() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isDataSource() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String getLookupName() {
		// TODO Auto-generated method stub
		return lokupName;
	}
	
}
