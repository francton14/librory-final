package com.tcl.librory.database.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by franc on 12/8/2016.
 */
public interface GenericDao<T> {

    public List<T> all() throws SQLException;

    public void insert(T data) throws SQLException;

    public T show(Long id) throws SQLException;

    public List<T> show(String filter) throws SQLException;

    public void update(T data) throws SQLException;

    public void delete(Long id) throws SQLException;

}
