package com.kozich.videohosting.dao.impl;

import com.kozich.videohosting.dao.AbstractDAO;
import com.kozich.videohosting.entity.impl.PictureEntity;
import com.kozich.videohosting.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PictureDAO extends AbstractDAO<PictureEntity> {
    private static final String SQL_FIND_ALL_PICTURES =
            "SELECT * FROM pictures;";
    private static final String SQL_UPDATE_PICTURE =
            "UPDATE pictures" +
                    "SET AND alt = ?" +
                    "WHERE id = ?";
    private static final String SQL_CREATE_PICTURE =
            "INSERT INTO pictures(src, alt) VALUES(?, ?);";

    @Override
    public boolean create(PictureEntity entity) throws SQLException, DAOException {
        connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_CREATE_PICTURE);
            statement.setString(1, entity.getSrc());
            statement.setString(2, entity.getAlt());
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
    public boolean update(PictureEntity entity) throws SQLException, DAOException {
        connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_PICTURE);
            statement.setString(1, entity.getAlt());
            statement.setInt(2, entity.getId());
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
    public boolean delete(PictureEntity entity) throws SQLException, DAOException {
        return false;
    }

    @Override
    public List<PictureEntity> findAll() throws SQLException, DAOException {
        connection = null;
        List<PictureEntity> pictures = new LinkedList<>();
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_PICTURES);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PictureEntity picture = new PictureEntity(resultSet);
                pictures.add(picture);
            }
            return pictures;
        } catch (InterruptedException e) {
            //TODO: logger
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection);
        }
    }
}

