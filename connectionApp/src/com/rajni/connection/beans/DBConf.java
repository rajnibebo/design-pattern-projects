package com.rajni.connection.beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
	
	public static void main(String[] args) {
		InputStream is;
		try {
			is = new FileInputStream("C:/Users/acbd/workspace/Html5Workspace/connectionApp/src/com/rajni/connection/beans/DBConf.xml");
			if (is != null) {
				JAXBContext jc;
				try {
					// test unmarshaling
					jc = JAXBContext.newInstance(DBConf.class);
					Unmarshaller u = jc.createUnmarshaller();
					DBConf profile = (DBConf) u.unmarshal(is);
					System.out.println(profile);
					System.out.println();
					
				} catch (JAXBException e) {
					e.printStackTrace();

				}
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
