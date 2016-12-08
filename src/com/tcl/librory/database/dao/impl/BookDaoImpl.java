/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcl.librory.database.dao.impl;

import com.tcl.librory.database.DBConnection;
import com.tcl.librory.database.dao.BookDao;
import com.tcl.librory.database.dao.LibrarianDao;
import com.tcl.librory.models.Book;
import com.tcl.librory.models.Genre;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BookDaoImpl implements BookDao {

    private Properties properties;
    private LibrarianDao librarianDao;

    public BookDaoImpl() throws IOException {
	properties = new Properties();
	properties.load(getClass().getResourceAsStream("../../../resources/queries.properties"));
	librarianDao = new LibrarianDaoImpl();
    }

    @Override
    public List<Book> all() throws SQLException {
	try (Statement statement = DBConnection.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(properties.getProperty("query.book.all"))) {
	    List<Book> books = new ArrayList<>();
	    while (resultSet.next()) {
		Book book = new Book();
		book.setId(resultSet.getLong("id"));
		book.setControlNumber(resultSet.getLong("control_number"));
		book.setIsbn(resultSet.getString("isbn"));
		book.setTitle(resultSet.getString("title"));
		book.setAuthor(resultSet.getString("author"));
		book.setPublisher(resultSet.getString("publisher"));
		book.setPublishedDate(resultSet.getDate("published_date"));
		book.setGenre(Genre.valueOf(resultSet.getString("genre")));
		book.setLibrarian(librarianDao.show(resultSet.getLong("librarian_id")));
		books.add(book);
	    }
	    return books;
	}
    }

    @Override
    public void insert(Book data) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.book.insert"))) {
	    statement.setLong(1, data.getControlNumber());
	    statement.setString(2, data.getIsbn());
	    statement.setString(3, data.getTitle());
	    statement.setString(4, data.getAuthor());
	    statement.setString(5, data.getPublisher());
	    statement.setDate(6, new java.sql.Date(data.getPublishedDate().getTime()));
	    statement.setString(7, data.getGenre().name());
	    statement.setLong(8, data.getLibrarian().getId());
	    statement.execute();
	}
    }

    @Override
    public Book show(Long id) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.book.show"))) {
	    statement.setLong(1, id);
	    try (ResultSet resultSet = statement.executeQuery()) {
		Book book = null;
		if (resultSet.next()) {
		    book = new Book();
		    book.setId(resultSet.getLong("id"));
		    book.setControlNumber(resultSet.getLong("control_number"));
		    book.setIsbn(resultSet.getString("isbn"));
		    book.setTitle(resultSet.getString("title"));
		    book.setAuthor(resultSet.getString("author"));
		    book.setPublisher(resultSet.getString("publisher"));
		    book.setPublishedDate(resultSet.getDate("published_date"));
		    book.setGenre(Genre.valueOf(resultSet.getString("genre")));
		    book.setLibrarian(librarianDao.show(resultSet.getLong("librarian_id")));
		}
		return book;
	    }
	}
    }

    @Override
    public List<Book> show(String filter) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.book.filter"))) {
	    statement.setString(1, filter);
	    try (ResultSet resultSet = statement.executeQuery()) {
		List<Book> books = new ArrayList<>();
		while (resultSet.next()) {
		    Book book = new Book();
		    book.setId(resultSet.getLong("id"));
		    book.setControlNumber(resultSet.getLong("control_number"));
		    book.setIsbn(resultSet.getString("isbn"));
		    book.setTitle(resultSet.getString("title"));
		    book.setAuthor(resultSet.getString("author"));
		    book.setPublisher(resultSet.getString("publisher"));
		    book.setPublishedDate(resultSet.getDate("published_date"));
		    book.setGenre(Genre.valueOf(resultSet.getString("genre")));
		    book.setLibrarian(librarianDao.show(resultSet.getLong("librarian_id")));
		    books.add(book);
		}
		return books;
	    }
	}
    }

    @Override
    public void update(Book data) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.book.update"))) {
	    statement.setLong(1, data.getControlNumber());
	    statement.setString(1, data.getIsbn());
	    statement.setString(2, data.getTitle());
	    statement.setString(3, data.getAuthor());
	    statement.setString(4, data.getPublisher());
	    statement.setDate(5, new java.sql.Date(data.getPublishedDate().getTime()));
	    statement.setString(6, data.getGenre().name());
	    statement.setLong(7, data.getLibrarian().getId());
	    statement.setLong(8, data.getId());
	    statement.execute();
	}
    }

    @Override
    public void delete(Long id) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.book.delete"))) {
	    statement.setLong(1, id);
	    statement.execute();
	}
    }

}
