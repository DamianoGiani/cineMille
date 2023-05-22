package com.example.CineMilleProject.models;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    private Long id;
    private String title;
    private String director;
    private String genre;
    private String description;
    private int duration;
    private String releaseDate;
    private double rating;
    private String coverImage;
    private String trailer;
    private List<String> actors;
    private String theater;
    private LocalDate release;
    private LocalDate startDay;
    private LocalDate finishDay;


    private boolean isActive;

    // Constructor
    public Movie(Long id,String title, String director, String genre, String description, int duration, String releaseDate,
                double rating, String coverImage, String trailer, List<String> actors, String theater,LocalDate release) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.description = description;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.coverImage = coverImage;
        this.trailer = trailer;
        this.actors = actors;
        this.theater = theater;
        this.release=release;
    }

    public Movie(){}
    public Movie(String title, String director, String genre,boolean isActive,LocalDate startDay,LocalDate finishDay){
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.isActive = isActive;
        this.startDay = startDay;
        this.finishDay = finishDay;
    }

    public Movie(String title, String director, String genre, String description, int duration, String releaseDate,
                double rating, String coverImage, String trailer, List<String> actors, String theater,LocalDate release) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.description = description;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.coverImage = coverImage;
        this.trailer = trailer;
        this.actors = actors;
        this.theater = theater;
        this.release=release;
    }
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }
    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    //toString()

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", releaseDate='" + releaseDate + '\'' +
                ", rating=" + rating +
                ", coverImage='" + coverImage + '\'' +
                ", trailer='" + trailer + '\'' +
                ", actors=" + actors +
                ", theater='" + theater + '\'' +
                ", release=" + release +
                ", startDay=" + startDay +
                ", finishDay=" + finishDay +
                ", isActive=" + isActive +
                '}';
    }

    public LocalDate getFinishDay() {
        return finishDay;
    }

    public void setFinishDay(LocalDate finishDay) {
        this.finishDay = finishDay;
    }

}
