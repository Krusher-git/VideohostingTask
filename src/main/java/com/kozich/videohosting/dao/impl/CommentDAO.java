package com.kozich.videohosting.dao.impl;

import com.kozich.videohosting.connectionpool.ProxyConnection;
import com.kozich.videohosting.dao.AbstractDAO;
import com.kozich.videohosting.entity.impl.CommentEntity;
import com.kozich.videohosting.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class CommentDAO extends AbstractDAO<CommentEntity> {


    private static final String SQL_CREATE_COMMENT =
            "INSERT INTO comments(id_user, id_video, comment) " +
                    "values(?, ?, ?);";
    private static final String SQL_UPDATE_COMMENT =
            "UPDATE comments" +
                    "SET comment = ?" +
                    "WHERE id = ?;";
    private static final String SQL_SELECT_ALL_COMMENTS_BY_ID_VIDEO =
            "SELECT comments.id, users.login, videos.id, comments.text, pictures.src FROM comments" +
                    "JOIN users ON comments.id_user = users.id" +
                    "JOIN videos ON videos.id = comments.id_video" +
                    "JOIN pictures ON pictures.id = users.id_pic" +
                    "WHERE id_video = ?";

    @Override
    public boolean create(CommentEntity entity) throws SQLException, DAOException {
        connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_CREATE_COMMENT);
            statement.setInt(1, entity.getUserId());
            statement.setInt(2, entity.getVideoId());
            statement.setString(3, entity.getText());
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
    public boolean update(CommentEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(CommentEntity entity) throws SQLException, DAOException {
        return false;
    }

    @Override
    public List<CommentEntity> findAll() throws SQLException {
        return null;
    }

    public List<CommentEntity> findAllByVideoId(int videoId) throws SQLException, DAOException {
        ProxyConnection connection = null;
        List<CommentEntity> comments = new LinkedList<>();
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL_COMMENTS_BY_ID_VIDEO);
            statement.setInt(1, videoId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CommentEntity entity = new CommentEntity(resultSet);
                comments.add(entity);
            }
            return comments;
        } catch (InterruptedException e) {
            //TODO: logger
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection);
        }
    }
}


