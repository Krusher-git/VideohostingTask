package com.kozich.videohosting.entity.impl;

import com.kozich.videohosting.entity.DefaultEntity;
import com.kozich.videohosting.entity.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserEntity extends DefaultEntity {
    private String login;
    private String email;
    private String password;
    private UserRole role;
    private String srcPicture;

    public UserEntity(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt(1);
        this.login = resultSet.getString(2);
        this.email = resultSet.getString(3);
        this.password = resultSet.getString(4);
        this.role = UserRole.of(resultSet.getInt(5));
        this.srcPicture = resultSet.getString(6);
    }

    public UserEntity(String login, String email, String password, int role, String srcPicture) {
        this.id = 0;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = UserRole.of(role);
        this.srcPicture = srcPicture;
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
}
