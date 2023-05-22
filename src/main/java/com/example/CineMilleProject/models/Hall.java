package com.example.CineMilleProject.models;

import java.util.List;

public class Hall {
    private int number;
    private int capacity;
    private String type;

    private List<Movie> allMovie;

    public Hall(){}

    public Hall(int number, int capacity, String type, List<Movie> allMovie) {
        this.number = number;
        this.capacity = capacity;
        this.type = type;
        this.allMovie = allMovie;
    }

    public Hall(int number, int capacity, String type) {
        this.number = number;
        this.capacity = capacity;
        this.type = type;

    }

    @Override
    public String toString() {
        return "Hall{" +
                "number=" + number +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                ", allMovie=" + allMovie +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Movie> getAllMovie() {
        return allMovie;
    }

    public void setAllMovie(List<Movie> allMovie) {
        this.allMovie = allMovie;
    }
}
