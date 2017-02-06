package com.rajni.connection.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;

import com.rajni.connection.beans.ConnectionDetails;
import com.rajni.connection.beans.ConnectionLoader;
import com.rajni.connection.beans.ConnectionTypes;
import com.rajni.connection.factory.ConnectionFactory;
import com.rajni.connection.factory.ContextConnectionFactory;
import com.rajni.connection.factory.ConventionalConnectionFactory;
import com.rajni.connection.loaders.PropsConnectionLoader;
import com.rajni.connection.loaders.XMLConnectionLoader;

/**
 * @author rajni.ubhi
 *
 */
public class DBConnectionStore {
	public static final String CON_SOURCE_XML = "XML";
	public static final String CON_SOURCE_PROPS = "PROPERTIES";

	private static EnumMap<ConnectionTypes, ConnectionFactory> xmlConFactories = new EnumMap<>(ConnectionTypes.class);
	private static EnumMap<ConnectionTypes, ConnectionFactory> propsConFactories = new EnumMap<>(ConnectionTypes.class);
	private static ConnectionLoader[] conLoaders = { new PropsConnectionLoader(), new XMLConnectionLoader() };
	
	private static final boolean[] enableLoaders = { true, true };
	private static final String[] conSources = { CON_SOURCE_PROPS, CON_SOURCE_XML };
	
	private static final int IDX_PROPS = 0;
	private static final int IDX_XML = 1;

	// object not needed 
	private DBConnectionStore() {		
	}
	private static void enableXML() {
		enableLoaders[IDX_PROPS] = false;
		enableLoaders[IDX_XML] = true;
	}

	private static void enableProps() {
		enableLoaders[IDX_PROPS] = true;
		enableLoaders[IDX_XML] = false;
	}

	static void configure() {
		for (int i = 0; i < conLoaders.length; i++) {
			ConnectionLoader loader = conLoaders[i];
			if (enableLoaders[i]) {
				Collection<ConnectionDetails> collection = loader.getConnectionDetails().values();
				for (ConnectionDetails conDetails : collection) {
					ConnectionFactory factory = null;
					if (conDetails.isDataSource()) {
						factory = new ContextConnectionFactory(conDetails);
					} else {
						factory = new ConventionalConnectionFactory(conDetails);
					}
					if(conSources[i] == CON_SOURCE_PROPS) {
						propsConFactories.put(conDetails.getConType(), factory);
					} else {
						xmlConFactories.put(conDetails.getConType(), factory);
					}
				}
			}
		}
	}
	
	public static Connection getConnectionFromXml(ConnectionTypes conTypes) throws SQLException {
		if(xmlConFactories.size() == 0) {
			enableXML();
			configure();
		}
		return xmlConFactories.get(conTypes).getConnection();
	}
	
	public static Connection getConnectionThroughProps(ConnectionTypes conTypes) throws SQLException {
		if(propsConFactories.size() == 0) {
			enableProps();
			configure();
		}
		return propsConFactories.get(conTypes).getConnection();
	}

	public static PreparedStatement addBindings(PreparedStatement stmt , ArrayList<String> params) throws SQLException {
		if(stmt != null ) {
			for(int i = 0 ; i < params.size() ; i++) {
				String param = params.get(i);
				stmt.setString(i+1, param);
			}
		}
		return stmt;
	}
}
