package com.kozich.videohosting.dao;

import com.kozich.videohosting.connectionpool.ProxyConnection;
import com.kozich.videohosting.connectionpool.impl.ConnectionPoolImpl;
import com.kozich.videohosting.entity.AbstractEntity;
import com.kozich.videohosting.exception.DAOException;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<T extends AbstractEntity> {
    protected static ConnectionPoolImpl connectionPool;
    protected ProxyConnection connection;

    static {
        try {
            connectionPool = ConnectionPoolImpl.getInstance();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //TODO: need to finish this part (add logger)
        }
    }

    public abstract boolean create(T entity) throws SQLException, DAOException;

    public abstract boolean update(T entity) throws SQLException, DAOException;

    public abstract boolean delete(T entity) throws SQLException, DAOException;

    public abstract List<T> findAll() throws SQLException, DAOException;
}
