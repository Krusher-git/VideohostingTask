package com.kozich.videohosting.entity;

public enum UserRole {
    UNSIGNED(0),
    ADMIN(1),
    MODERATOR(2),
    USER(3);
    private int id;

    UserRole(int id) {
        this.id = id;
    }

    public static UserRole of(int id) {
        for (UserRole role : values()) {
            if (role.getId() == id) {
                return role;
            }
        }
        return UNSIGNED;
    }

    public int getId() {
        return id;
    }
}
