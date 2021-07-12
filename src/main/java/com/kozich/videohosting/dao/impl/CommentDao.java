package com.kozich.videohosting.dao.impl;

import com.kozich.videohosting.connectionpool.ProxyConnection;
import com.kozich.videohosting.connectionpool.impl.ConnectionPoolImpl;
import com.kozich.videohosting.dao.DefaultDao;
import com.kozich.videohosting.entity.impl.CommentEntity;
import com.kozich.videohosting.exception.DBException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class CommentDao implements DefaultDao<CommentEntity> {
    private static ConnectionPoolImpl connectionPool;

    static {
        try {
            connectionPool = ConnectionPoolImpl.getInstance();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //TODO: need to finish this part (add logger)
        }
    }

    private static final String CREATE_COMMENT =
            "INSERT INTO videohosting.comments(id_user, id_video, comment) " +
                    "values(?, ?, ?);";
    private static final String UPDATE_COMMENT =
            "UPDATE videohosting.comments" +
                    "SET comment = ?" +
                    "WHERE id = ?;";
    private static final String SELECT_ALL_COMMENTS_BY_ID_VIDEO =
            "SELECT comments.id, users.login, videos.id, comments.text, pictures.src FROM videohosting.comments" +
                    "JOIN videohosting.users ON comments.id_user = users.id" +
                    "JOIN videohosting.videos ON videos.id = comments.id_video" +
                    "JOIN videohosting.pictures ON pictures.id = users.id_pic" +
                    "WHERE id_video = ?";

    @Override
    public boolean create(CommentEntity entity) throws SQLException, DBException {
        ProxyConnection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_COMMENT);
            statement.setInt(1, entity.getUserId());
            statement.setInt(2, entity.getVideoId());
            statement.setString(3, entity.getText());
            statement.executeUpdate();
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            //TODO: logger
        } finally {
            connectionPool.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean update(CommentEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(CommentEntity entity) throws SQLException, DBException {
        return false;
    }

    @Override
    public List<CommentEntity> findAll() throws SQLException {
        return null;
    }

    public List<CommentEntity> findAllByVideoId(int videoId) throws SQLException, DBException {
        ProxyConnection connection = null;
        List<CommentEntity> comments = new LinkedList<>();
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_COMMENTS_BY_ID_VIDEO);
            statement.setInt(1, videoId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CommentEntity entity = new CommentEntity(resultSet);
                comments.add(entity);
            }
            return comments;
        } catch (InterruptedException e) {
            e.printStackTrace();
            //TODO: logger
        } finally {
            connectionPool.closeConnection(connection);
        }
        return comments;
    }
}


