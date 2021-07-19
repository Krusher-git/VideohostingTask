package com.kozich.videohosting.entity.impl;

import com.kozich.videohosting.entity.AbstractEntity;
import com.kozich.videohosting.entity.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserEntity extends AbstractEntity {
    private String login;
    private String email;
    private String password;
    private UserRole role;
    private PictureEntity picture;

    {
        picture = new PictureEntity();
    }

    public UserEntity() {

    }
    public UserEntity(PictureEntity picture){
        this.picture = picture;
    }

    public UserEntity(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt(1);
        this.login = resultSet.getString(2);
        this.email = resultSet.getString(3);
        this.password = resultSet.getString(4);
        this.role = UserRole.of(resultSet.getInt(5));
        this.picture.setId(resultSet.getInt(6));
        this.picture.setSrc(resultSet.getString(7));
        this.picture.setAlt(resultSet.getString(8));
    }

    public UserEntity(String login, String email, String password, int role, PictureEntity picture) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = UserRole.of(role);
        this.picture.setId(picture.getId());
        this.picture.setSrc(picture.getSrc());
        this.picture.setAlt(picture.getAlt());
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public PictureEntity getPicture() {
        return picture;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setPicture(PictureEntity picture) {
        this.picture = picture;
    }
}
