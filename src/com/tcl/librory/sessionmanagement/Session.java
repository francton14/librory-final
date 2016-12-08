/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcl.librory.sessionmanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author inno.zilmar
 */
public class Session {

    private Connection c = null;
    private final Properties properties;

    public Session() throws IOException, InstantiationException, SQLException, IllegalAccessException {
	properties = new Properties();
	properties.load(getClass().getResourceAsStream("../resources/settings.properties"));
	org.sqlite.JDBC.class.newInstance();
	c = DriverManager.getConnection("jdbc:sqlite:" + properties.getProperty("session.filename"));
	c.setAutoCommit(false);
	initialize();
    }

    private void initialize() throws SQLException {
	try (Statement stmt = c.createStatement()) {
	    String sql = "CREATE TABLE IF NOT EXISTS user (userid BIGINT PRIMARY KEY NOT NULL);";
	    stmt.executeUpdate(sql);
	    c.commit();
	}
    }

    public void removeUserID() throws SQLException {
	Statement stmt = c.createStatement();
	stmt.executeUpdate("DELETE FROM user;");
	c.commit();
    }

    public void addUserID(long userID) throws SQLException {
	Statement stmt = c.createStatement();
	removeUserID();
	stmt.executeUpdate("INSERT INTO user VALUES(" + userID + ");");
	c.commit();
    }

    public Long getUserID() throws SQLException {
	Long id = null;
	Statement stmt = c.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT userid FROM user LIMIT 1");
	while (rs.next()) {
	    id = rs.getLong("userid");
	}
	return id;
    }

}
