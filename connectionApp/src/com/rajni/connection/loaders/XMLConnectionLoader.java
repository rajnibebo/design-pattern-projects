package com.rajni.connection.loaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.rajni.connection.beans.ConDManager;
import com.rajni.connection.beans.ConDataSource;
import com.rajni.connection.beans.ConnectionLoader;
import com.rajni.connection.beans.ConnectionTypes;
import com.rajni.connection.beans.ContextConnectionDetail;
import com.rajni.connection.beans.DBConf;
import com.rajni.connection.beans.DManagerConnectionDetail;

public class XMLConnectionLoader extends ConnectionLoader{

	private static DBConf instance = null;
	@Override
	public void loadConfiguration() {
		// TODO Auto-generated method stub
		// read from xml file here
		InputStream is;
		try {
			is = new FileInputStream("C:/Users/acbd/workspace/Html5Workspace/connectionApp/src/com/rajni/connection/beans/DBConf.xml");
			if (is != null) {
				JAXBContext jc;
				try {
					// test unmarshaling
					jc = JAXBContext.newInstance(DBConf.class);
					Unmarshaller u = jc.createUnmarshaller();
					instance = (DBConf) u.unmarshal(is);
					if(instance != null) {
						ConDataSource conDataSource = instance.getConDataSource();
						for(ContextConnectionDetail conDetail : conDataSource.getConnectionSources()) {
							conDetail.setConType(ConnectionTypes.getConnectionTypes(conDetail.getName()));
							connectionDetails.put(conDetail.getConType(), conDetail);
						}
						ConDManager conManager = instance.getConDManager();
						for(DManagerConnectionDetail conDetail : conManager.getConnectionSources()) {
							conDetail.setConType(ConnectionTypes.getConnectionTypes(conDetail.getName()));
							connectionDetails.put(conDetail.getConType(), conDetail);
						}
					}
				} catch (JAXBException e) {
					e.printStackTrace();

				}
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println();
		XMLConnectionLoader x = new XMLConnectionLoader();
	//	x.loadConfiguration();
		System.out.println(x.connectionDetails);
	}

}
