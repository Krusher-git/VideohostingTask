package com.kozich.videohosting.connectionpool.impl;

import com.kozich.videohosting.connectionpool.ConnectionPool;
import com.kozich.videohosting.connectionpool.MySQLConnector;
import com.kozich.videohosting.connectionpool.ProxyConnection;
import com.kozich.videohosting.exception.DAOException;

import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPoolImpl implements ConnectionPool {
    private static ConnectionPoolImpl connectionPool = null;
    private ArrayBlockingQueue<ProxyConnection> connectionQueue;
    private final int POOL_SIZE = 8;
    private static final Lock lock = new ReentrantLock();

    private ConnectionPoolImpl() throws SQLException {
        connectionQueue = new ArrayBlockingQueue<>(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            ProxyConnection connection = MySQLConnector.getConnection();
            connectionQueue.offer(connection);
        }
    }

    public static ConnectionPoolImpl getInstance() throws SQLException {
        try {
            lock.lock();
            if (connectionPool == null) {
                return new ConnectionPoolImpl();
            }
            return connectionPool;
        } finally {
            lock.unlock();
        }
    }


    @Override
    public ProxyConnection getConnection() throws InterruptedException {
        ProxyConnection connection;
        connection = connectionQueue.take();
        return connection;
    }

    @Override
    public void closeConnection(ProxyConnection connection) throws DAOException {
        if (connection == null) {
            //TODO: logger

            throw new DAOException();
        }
        /*TODO: need to fix this part.

         */
        boolean isReturned = false;
        while (!isReturned) {
            isReturned = connectionQueue.offer(connection);
        }
    }

    @Override
    public void destroyAll() throws SQLException {
        for (ProxyConnection connection : connectionQueue) {
            connection.close();
        }
        connectionQueue.clear();
    }
}
