package com.kozich.videohosting.entity.impl;

import com.kozich.videohosting.entity.DefaultEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentEntity extends DefaultEntity {
    private String userLogin;
    private int userId;
    //TODO: Check this out
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

    public CommentEntity(int userId, int videoId, String text, String srcPic) {
        this.id = 0;
        this.userId = userId;
        this.videoId = videoId;
        this.text = text;
        this.srcPic = srcPic;
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


}
