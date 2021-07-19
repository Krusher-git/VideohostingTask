package com.kozich.videohosting.entity.impl;

import com.kozich.videohosting.entity.AbstractEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoEntity extends AbstractEntity {
    private String title;
    private String srcVideo;
    private int userId;
    private String userLogin;
    private PictureEntity picture;


    {
        picture = new PictureEntity();
    }

    public VideoEntity() {
    }

    public VideoEntity(PictureEntity picture) {
        this.picture = picture;
    }

    public VideoEntity(String title, String srcVideo, int userId, int pictureId) {
        this.title = title;
        this.srcVideo = srcVideo;
        this.userId = userId;
        this.picture.setId(pictureId);
    }

    public VideoEntity(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt(1);
        this.title = resultSet.getString(2);
        this.srcVideo = resultSet.getString(3);
        this.userId = resultSet.getInt(4);
        this.userLogin = resultSet.getString(5);
        this.picture.setId(resultSet.getInt(6));
        this.picture.setSrc(resultSet.getString(7));
        this.picture.setAlt(resultSet.getString(8));
    }

    public String getTitle() {
        return title;
    }

    public String getSrcVideo() {
        return srcVideo;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public PictureEntity getPicture() {
        return picture;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSrcVideo(String srcVideo) {
        this.srcVideo = srcVideo;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setPicture(PictureEntity picture) {
        this.picture = picture;
    }


}
