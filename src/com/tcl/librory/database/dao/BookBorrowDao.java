/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcl.librory.database.dao;

import com.tcl.librory.models.BookBorrow;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author franc.margallo
 */
public interface BookBorrowDao extends GenericDao<BookBorrow> {
    
    public List<BookBorrow> getBeyondDueDate(Date date) throws SQLException;
    
    public List<BookBorrow> getBorrowedBooks() throws SQLException;
    
    public List<BookBorrow> getBorrowedBooks(String filter) throws SQLException;
    
}
