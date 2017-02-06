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
@XmlRootElement(name="connectionSource")
public class DManagerConnectionDetail extends ConnectionDetails {
	@XmlAttribute(name="name")
	private String name;
	@XmlElement(name="driverClass")
	private String driverClass;
	@XmlElement(name="dburl")
	private String driverUrl;
	@XmlElement(name="dbuser")
	private String dbUser;
	@XmlElement(name="dbpassword")
	private String dbPassword;
	
	public DManagerConnectionDetail() {
		// TODO Auto-generated constructor stub
		this.conType = ConnectionTypes.getConnectionTypes(name);
	}
	
	public void setDriverClass(String className) {
		this.driverClass = className;
	}
	public String getDriverUrl() {
		return driverUrl;
	}
	public void setDriverUrl(String driverUrl) {
		this.driverUrl = driverUrl;
	}
	public String getDbUser() {
		return dbUser;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	
	public String toString() {
		return "name:"+driverUrl;
	}

	@Override
	public String getDriverClass() {
		// TODO Auto-generated method stub
		return driverClass;
	}
	@Override
	public boolean isDataSource() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getLookupName() {
		// TODO Auto-generated method stub
		return null;
	}

}
