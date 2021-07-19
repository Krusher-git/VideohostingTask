package com.kozich.videohosting.dao.impl;

import com.kozich.videohosting.dao.AbstractDAO;
import com.kozich.videohosting.entity.impl.VideoEntity;
import com.kozich.videohosting.exception.DAOException;

import java.sql.SQLException;
import java.util.List;

public class VideoDAO extends AbstractDAO<VideoEntity> {
    @Override
    public boolean create(VideoEntity entity) throws SQLException, DAOException {
        return false;
    }

    @Override
    public boolean update(VideoEntity entity) throws SQLException, DAOException {
        return false;
    }

    @Override
    public boolean delete(VideoEntity entity) throws SQLException, DAOException {
        return false;
    }

    @Override
    public List<VideoEntity> findAll() throws SQLException, DAOException {
        return null;
    }
}
