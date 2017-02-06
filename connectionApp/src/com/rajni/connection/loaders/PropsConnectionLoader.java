package com.rajni.connection.loaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.rajni.connection.beans.AllConDetailsIntf;
import com.rajni.connection.beans.ConnectionLoader;
import com.rajni.connection.beans.ConnectionTypes;
import com.rajni.connection.beans.PropsConnectionDetail;

/**
 * @author rajni.ubhi
 *
 */
public class PropsConnectionLoader extends ConnectionLoader {

	@Override
	public void loadConfiguration() {
		// TODO Auto-generated method stub
		// read from properties file here 
		
		try {
			Properties props = new Properties();
			FileInputStream fin = new FileInputStream(AllConDetailsIntf.LOAD_PROPS);
			props.load(fin);
			
			int size = props.keySet().size()/7;
			System.out.println(size);
			for(int i = 1 ; i <= size; i++) {
				
				PropsConnectionDetail dbCon = new PropsConnectionDetail();
				dbCon.setConType(ConnectionTypes.getConnectionTypes(props.getProperty("type"+i)));
				dbCon.setDataSource(Boolean.valueOf(props.getProperty("isDataSource"+i)));
				dbCon.setLookupName(props.getProperty("datasource"+i));
				dbCon.setDriverClass(props.getProperty("class"+i));
				dbCon.setDriverUrl(props.getProperty("dbUrl"+i));
				dbCon.setDbUser(props.getProperty("dbUser"+i));
				dbCon.setDbPassword(props.getProperty("dbPassword"+i));
				//System.out.println("ConType : "+dbCon.getConType());
				connectionDetails.put(dbCon.getConType(), dbCon);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
