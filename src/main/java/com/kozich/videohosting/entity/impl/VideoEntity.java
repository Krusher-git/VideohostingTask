package com.kozich.videohosting.entity.impl;

import com.kozich.videohosting.entity.DefaultEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoEntity extends DefaultEntity {
    private String title;
    private String srcVideo;
    private String userLogin;
    private String srcPicture;

    public VideoEntity(String title, String srcVideo, String userLogin, String srcPicture) {
        id = 0;
        this.title = title;
        this.userLogin = userLogin;
        this.srcVideo = srcVideo;
        this.srcPicture = srcPicture;

    }

    public VideoEntity(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt(1);
        this.title = resultSet.getString(2);
        this.srcVideo = resultSet.getString(3);
        this.userLogin = resultSet.getString(4);
        this.srcPicture = resultSet.getString(5);
    }

    public String getTitle() {
        return title;
    }

    public String getSrcVideo() {
        return srcVideo;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getSrcPicture() {
        return srcPicture;
    }

}
