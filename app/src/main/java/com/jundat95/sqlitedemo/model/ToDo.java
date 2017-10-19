package com.jundat95.sqlitedemo.model;

/**
 * Created by tinhngo on 12/09/2017.
 */

public class ToDo {

    private String key;
    private String title;
    private String description;
    private String date;
    private int status;

    public ToDo(String key, String title, String description, String date, int status) {
        this.key = key;
        this.title = title;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public ToDo(String key, String title, String description, String date) {
        this.key = key;
        this.title = title;
        this.description = description;
        this.date = date;
        this.status = 0;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
