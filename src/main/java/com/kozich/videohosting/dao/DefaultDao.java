package com.kozich.videohosting.dao;

import com.kozich.videohosting.entity.DefaultEntity;
import com.kozich.videohosting.exception.DBException;

import java.sql.SQLException;
import java.util.List;

public interface DefaultDao<T extends DefaultEntity> {
    boolean create(T entity) throws SQLException, DBException;

    boolean update(T entity) throws SQLException, DBException;

    boolean delete(T entity) throws SQLException, DBException;

    List<T> findAll() throws SQLException, DBException;
}
