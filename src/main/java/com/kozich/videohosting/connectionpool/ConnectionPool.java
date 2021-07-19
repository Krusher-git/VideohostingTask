package com.kozich.videohosting.connectionpool;


import com.kozich.videohosting.exception.DAOException;

import java.sql.SQLException;

public interface ConnectionPool {
    ProxyConnection getConnection() throws InterruptedException;

    void closeConnection(ProxyConnection connection) throws DAOException;

    void destroyAll() throws SQLException;
}
