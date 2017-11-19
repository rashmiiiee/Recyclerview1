package com.example.rashmi.myapplication;

/**
 * Created by QCS2015 on 19-11-2017.
 */

public class Movie {
    String name;
    String description;
    int id;

    public Movie(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String movie) {
        this.name = movie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
