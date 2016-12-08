package com.tcl.librory.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by franc on 12/8/2016.
 */
public class DBConnection {

    private static Connection connection;

    static {
	Properties properties = new Properties();
	try {
	    properties.load(DBConnection.class.getResourceAsStream("../resources/settings.properties"));
	    Class.forName(properties.getProperty("database.driver")).newInstance();
	    connection = DriverManager.getConnection(properties.getProperty("database.url") + properties.getProperty("database.name"),
		    properties.getProperty("database.username"), properties.getProperty("database.password"));
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static Connection getConnection() {
	return connection;
    }

}
