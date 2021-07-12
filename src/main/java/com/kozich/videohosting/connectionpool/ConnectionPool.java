package com.kozich.videohosting.connectionpool;


import com.kozich.videohosting.exception.DBException;

import java.sql.SQLException;

public interface ConnectionPool {
    ProxyConnection getConnection() throws InterruptedException;

    void closeConnection(ProxyConnection connection) throws DBException;

    void destroyAll() throws SQLException;
}
