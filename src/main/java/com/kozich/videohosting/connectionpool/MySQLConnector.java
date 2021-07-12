package com.kozich.videohosting.connectionpool;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MySQLConnector {
    private static final String RESOURCE_FILE = "db";
    private static final String BUNDLE_URL = "url";
    private static final String BUNDLE_USER = "user";
    private static final String BUNDLE_PASSWORD = "password";

    public static ProxyConnection getConnection() throws SQLException {
        ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_FILE);
        String url = bundle.getString(BUNDLE_URL);
        String user = bundle.getString(BUNDLE_USER);
        String password = bundle.getString(BUNDLE_PASSWORD);
        ProxyConnection connection = new ProxyConnection(DriverManager.getConnection(url, user, password));
        return connection;
    }
}
