package com.tcl.librory.database.dao;

import com.tcl.librory.models.Librarian;
import java.sql.SQLException;

/**
 * Created by franc on 12/8/2016.
 */
public interface LibrarianDao extends GenericDao<Librarian> {
    
    public Librarian showByUsername(String username) throws SQLException;
    
}
