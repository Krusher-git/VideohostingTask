package com.kozich.videohosting.entity.impl;

import com.kozich.videohosting.entity.AbstractEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PictureEntity extends AbstractEntity {
    private String src;
    private String alt;

    public PictureEntity() {

    }

    public PictureEntity(String src, String alt) {
        this.src = src;
        this.alt = alt;
    }

    public PictureEntity(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt(1);
        this.src = resultSet.getString(2);
        this.alt = resultSet.getString(3);
    }

    public String getSrc() {
        return src;
    }

    public String getAlt() {
        return alt;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
