package com.kozich.videohosting.entity.impl;

import com.kozich.videohosting.entity.AbstractEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentEntity extends AbstractEntity {
    private int userId;
    private String userLogin;
    private int videoId;
    private String text;
    private String srcPic;

    public CommentEntity(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt(1);
        this.userLogin = resultSet.getString(2);
        this.videoId = resultSet.getInt(3);
        this.text = resultSet.getString(4);
        this.srcPic = resultSet.getString(5);
    }

    public CommentEntity(int userId, int videoId, String text) {
        this.userId = userId;
        this.videoId = videoId;
        this.text = text;
    }

    public String getSrcPic() {
        return srcPic;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public int getVideoId() {
        return videoId;
    }

    public int getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSrcPic(String srcPic) {
        this.srcPic = srcPic;
    }
}
