/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcl.librory.database.dao.impl;

import com.tcl.librory.database.DBConnection;
import com.tcl.librory.database.dao.BookBorrowDao;
import com.tcl.librory.database.dao.BookDao;
import com.tcl.librory.database.dao.LibrarianDao;
import com.tcl.librory.models.BookBorrow;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class BookBorrowDaoImpl implements BookBorrowDao {

    private Properties properties;
    private LibrarianDao librarianDao;
    private BookDao bookDao;

    public BookBorrowDaoImpl() throws IOException {
	properties = new Properties();
	properties.load(getClass().getResourceAsStream("../../../resources/queries.properties"));
	librarianDao = new LibrarianDaoImpl();
	bookDao = new BookDaoImpl();
    }

    @Override
    public List<BookBorrow> all() throws SQLException {
	try (Statement statement = DBConnection.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(properties.getProperty("query.bookborrow.all"))) {
	    List<BookBorrow> bookBorrows = new ArrayList<>();
	    while (resultSet.next()) {
		BookBorrow bookBorrow = new BookBorrow();
		bookBorrow.setId(resultSet.getLong("id"));
		bookBorrow.setBook(bookDao.show(resultSet.getLong("book_id")));
		bookBorrow.setBorrower(resultSet.getString("borrower"));
		bookBorrow.setLibrarian(librarianDao.show(resultSet.getLong("librarian_id")));
		bookBorrow.setStartDate(resultSet.getDate("start_date"));
		bookBorrow.setDueDate(resultSet.getDate("due_date"));
		bookBorrow.setReturnedDate(resultSet.getDate("returned_date"));
		bookBorrows.add(bookBorrow);
	    }
	    return bookBorrows;
	}
    }

    @Override
    public void insert(BookBorrow data) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.bookborrow.insert"))) {
	    statement.setLong(1, data.getBook().getId());
	    statement.setString(2, data.getBorrower());
	    statement.setLong(3, data.getLibrarian().getId());
	    statement.setDate(4, new java.sql.Date(data.getStartDate().getTime()));
	    statement.setDate(5, new java.sql.Date(data.getDueDate().getTime()));
	    statement.setDate(6, new java.sql.Date(data.getReturnedDate().getTime()));
	    statement.execute();
	}
    }

    @Override
    public BookBorrow show(Long id) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.bookborrow.show"))) {
	    statement.setLong(1, id);
	    try (ResultSet resultSet = statement.executeQuery()) {
		BookBorrow bookBorrow = null;
		if (resultSet.next()) {
		    bookBorrow = new BookBorrow();
		    bookBorrow.setId(resultSet.getLong("id"));
		    bookBorrow.setBook(bookDao.show(resultSet.getLong("book_id")));
		    bookBorrow.setBorrower(resultSet.getString("borrower"));
		    bookBorrow.setLibrarian(librarianDao.show(resultSet.getLong("librarian_id")));
		    bookBorrow.setStartDate(resultSet.getDate("start_date"));
		    bookBorrow.setDueDate(resultSet.getDate("due_date"));
		    bookBorrow.setReturnedDate(resultSet.getDate("returned_date"));
		}
		return bookBorrow;
	    }
	}
    }

    @Override
    public List<BookBorrow> show(String filter) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.bookborrow.filter"))) {
	    statement.setString(1, filter);
	    try (ResultSet resultSet = statement.executeQuery()) {
		List<BookBorrow> bookBorrows = new ArrayList<>();
		while (resultSet.next()) {
		    BookBorrow bookBorrow = new BookBorrow();
		    bookBorrow.setId(resultSet.getLong("id"));
		    bookBorrow.setBook(bookDao.show(resultSet.getLong("book_id")));
		    bookBorrow.setBorrower(resultSet.getString("borrower"));
		    bookBorrow.setLibrarian(librarianDao.show(resultSet.getLong("librarian_id")));
		    bookBorrow.setStartDate(resultSet.getDate("start_date"));
		    bookBorrow.setDueDate(resultSet.getDate("due_date"));
		    bookBorrow.setReturnedDate(resultSet.getDate("returned_date"));
		    bookBorrows.add(bookBorrow);
		}
		return bookBorrows;
	    }
	}
    }

    @Override
    public void update(BookBorrow data) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.bookborrow.update"))) {
	    statement.setLong(1, data.getBook().getId());
	    statement.setString(2, data.getBorrower());
	    statement.setLong(3, data.getLibrarian().getId());
	    statement.setDate(4, new java.sql.Date(data.getStartDate().getTime()));
	    statement.setDate(5, new java.sql.Date(data.getDueDate().getTime()));
	    statement.setDate(6, new java.sql.Date(data.getReturnedDate().getTime()));
	    statement.setLong(7, data.getId());
	    statement.execute();
	}
    }

    @Override
    public void delete(Long id) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.bookborrow.delete"))) {
	    statement.setLong(1, id);
	    statement.execute();
	}
    }

    @Override
    public List<BookBorrow> getBeyondDueDate(Date date) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.bookborrow.beyond_due_date"))) {
	    statement.setDate(1, new java.sql.Date(date.getTime()));
	    try (ResultSet resultSet = statement.executeQuery()) {
		List<BookBorrow> bookBorrows = new ArrayList<>();
		while (resultSet.next()) {
		    BookBorrow bookBorrow = new BookBorrow();
		    bookBorrow.setId(resultSet.getLong("id"));
		    bookBorrow.setBook(bookDao.show(resultSet.getLong("book_id")));
		    bookBorrow.setBorrower(resultSet.getString("borrower"));
		    bookBorrow.setLibrarian(librarianDao.show(resultSet.getLong("librarian_id")));
		    bookBorrow.setStartDate(resultSet.getDate("start_date"));
		    bookBorrow.setDueDate(resultSet.getDate("due_date"));
		    bookBorrow.setReturnedDate(resultSet.getDate("returned_date"));
		    bookBorrows.add(bookBorrow);
		}
		return bookBorrows;
	    }
	}
    }

    @Override
    public List<BookBorrow> getBorrowedBooks() throws SQLException {
	try (Statement statement = DBConnection.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(properties.getProperty("query.bookborrow.borrowed_books"))) {
	    List<BookBorrow> bookBorrows = new ArrayList<>();
	    while (resultSet.next()) {
		BookBorrow bookBorrow = new BookBorrow();
		bookBorrow.setId(resultSet.getLong("id"));
		bookBorrow.setBook(bookDao.show(resultSet.getLong("book_id")));
		bookBorrow.setBorrower(resultSet.getString("borrower"));
		bookBorrow.setLibrarian(librarianDao.show(resultSet.getLong("librarian_id")));
		bookBorrow.setStartDate(resultSet.getDate("start_date"));
		bookBorrow.setDueDate(resultSet.getDate("due_date"));
		bookBorrow.setReturnedDate(resultSet.getDate("returned_date"));
		bookBorrows.add(bookBorrow);
	    }
	    return bookBorrows;
	}
    }

    @Override
    public List<BookBorrow> getBorrowedBooks(String filter) throws SQLException {
	try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(properties.getProperty("query.bookborrow.borrowed_books_filter"))) {
	    statement.setString(1, filter);
	    try (ResultSet resultSet = statement.executeQuery()) {
		List<BookBorrow> bookBorrows = new ArrayList<>();
		while (resultSet.next()) {
		    BookBorrow bookBorrow = new BookBorrow();
		    bookBorrow.setId(resultSet.getLong("id"));
		    bookBorrow.setBook(bookDao.show(resultSet.getLong("book_id")));
		    bookBorrow.setBorrower(resultSet.getString("borrower"));
		    bookBorrow.setLibrarian(librarianDao.show(resultSet.getLong("librarian_id")));
		    bookBorrow.setStartDate(resultSet.getDate("start_date"));
		    bookBorrow.setDueDate(resultSet.getDate("due_date"));
		    bookBorrow.setReturnedDate(resultSet.getDate("returned_date"));
		    bookBorrows.add(bookBorrow);
		}
		return bookBorrows;
	    }
	}
    }

}
