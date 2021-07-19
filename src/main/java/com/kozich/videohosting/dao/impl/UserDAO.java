package com.kozich.videohosting.dao.impl;

import com.kozich.videohosting.dao.AbstractDAO;
import com.kozich.videohosting.entity.impl.UserEntity;
import com.kozich.videohosting.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UserDAO extends AbstractDAO<UserEntity> {

    private static final String RESOURCE_FILE = "db";
    private static final String DEFAULT_PICTURE_ID = "idDefaultProfilePicture";
    private static final String SQL_CREATE_USER =
            "INSERT INTO users(login, email, password, id_role, id_pic) " +
                    "VALUES(?, ?, ?, ?, ?)";

    @Override
    public boolean create(UserEntity entity) throws SQLException, DAOException {
        connection = null;
        ResourceBundle bundle = ResourceBundle.getBundle(RESOURCE_FILE);
        int id_pic = Integer.parseInt(bundle.getString(DEFAULT_PICTURE_ID));
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_CREATE_USER);
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getEmail());
            statement.setString(3, entity.getPassword());
            statement.setInt(4, entity.getRole().getId());
            statement.setInt(5, id_pic);
            statement.executeUpdate();
            return true;
        } catch (InterruptedException e) {
            //TODO: logger
            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection);
        }
    }

    @Override
    public boolean update(UserEntity entity) throws SQLException, DAOException {
        return false;
    }

    @Override
    public boolean delete(UserEntity entity) throws SQLException, DAOException {
        return false;
    }

    @Override
    public List<UserEntity> findAll() throws SQLException, DAOException {
        return null;
    }
}
