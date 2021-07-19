package com.kozich.videohosting.controller;

import com.kozich.videohosting.connectionpool.impl.ConnectionPoolImpl;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.sql.SQLException;

@WebListener
public class ControllerListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        try {
            ConnectionPoolImpl.getInstance().destroyAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
