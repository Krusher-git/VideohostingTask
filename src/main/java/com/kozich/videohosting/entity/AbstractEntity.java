package com.kozich.videohosting.entity;


public abstract class AbstractEntity {
    protected int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
