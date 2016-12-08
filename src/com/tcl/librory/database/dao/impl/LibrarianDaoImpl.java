package com.tcl.librory.database.dao.impl;

import com.tcl.librory.database.DBConnection;
import com.tcl.librory.database.dao.LibrarianDao;
import com.tcl.librory.models.Librarian;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by franc on 12/8/2016.
 */
public class LibrarianDaoImpl implements LibrarianDao {

    private Properties properties;

    public LibrarianDaoImpl() throws IOException {
	properties = new Properties();
	properties.load(getClass().getResourceAsStream("../../../resources/queries.properties"));
    }

    @Override
    public List<Librarian> all() throws SQLException {
	try (Statement statement = DBConnection.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(properties.getProperty("query.librarian.all"))) {
	    List<Librarian> librarien = new ArrayList<>();
	    while (resultSet.next()) {
		Librarian librarian = new Librarian();
		librarian.setId(resultSet.getLong("id"));
		librarian.setUsername(resultSet.getString("username"));
		librarian.setPassword(resultSet.getString("password"));
		librarian.setFirstName(resultSet.getString("first_name"));
		librarian.setLastName(resultSet.getString("last_name"));
		librarien.add(librarian);
	    }
	    return librarien;
	}
    }

    @Override
    public void insert(Librarian data) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.librarian.insert"))) {
	    statement.setString(1, data.getUsername());
	    statement.setString(2, data.getPassword());
	    statement.setString(3, data.getFirstName());
	    statement.setString(4, data.getLastName());
	    statement.execute();
	}
    }

    @Override
    public Librarian show(Long id) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.librarian.show"))) {
	    statement.setLong(1, id);
	    try (ResultSet resultSet = statement.executeQuery()) {		
		Librarian librarian = null;
		if (resultSet.next()) {
		    librarian = new Librarian();
		    librarian.setId(resultSet.getLong("id"));
		    librarian.setUsername(resultSet.getString("username"));
		    librarian.setPassword(resultSet.getString("password"));
		    librarian.setFirstName(resultSet.getString("first_name"));
		    librarian.setLastName(resultSet.getString("last_name"));
		}
		return librarian;
	    }
	}
    }

    @Override
    public List<Librarian> show(String filter) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.librarian.filter"))) {
	    statement.setString(1, filter);
	    try (ResultSet resultSet = statement.executeQuery()) {
		List<Librarian> librarians = new ArrayList<>();
		while (resultSet.next()) {
		    Librarian librarian = new Librarian();
		    librarian.setId(resultSet.getLong("id"));
		    librarian.setUsername(resultSet.getString("username"));
		    librarian.setPassword(resultSet.getString("password"));
		    librarian.setFirstName(resultSet.getString("first_name"));
		    librarian.setLastName(resultSet.getString("last_name"));
		    librarians.add(librarian);
		}
		return librarians;
	    }
	}
    }

    @Override
    public void update(Librarian data) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.librarian.update"))) {
	    statement.setString(1, data.getUsername());
	    statement.setString(2, data.getPassword());
	    statement.setString(3, data.getFirstName());
	    statement.setString(4, data.getLastName());
	    statement.setLong(5, data.getId());
	    statement.execute();
	}
    }

    @Override
    public void delete(Long id) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.librarian.delete"))) {
	    statement.setLong(1, id);
	    statement.execute();
	}
    }

    @Override
    public Librarian showByUsername(String username) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.librarian.username_show"))) {
	    statement.setString(1, username);
	    try (ResultSet resultSet = statement.executeQuery()) {
		Librarian librarian = null;
		if (resultSet.next()) {
		    librarian = new Librarian();
		    librarian.setId(resultSet.getLong("id"));
		    librarian.setUsername(resultSet.getString("username"));
		    librarian.setPassword(resultSet.getString("password"));
		    librarian.setFirstName(resultSet.getString("first_name"));
		    librarian.setLastName(resultSet.getString("last_name"));
		}
		return librarian;
	    }
	}
    }
    
}
