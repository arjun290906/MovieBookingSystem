package com.example.booking;

import java.sql.Time;

public class Movie {
    private String name;
    private String genre;
    private int duration;
    private Time showTime;

    public Movie(String name, String genre, int duration, Time showTime) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.showTime = showTime;
    }

    public String getName() { return name; }
    public String getGenre() { return genre; }
    public int getDuration() { return duration; }
    public Time getShowTime() { return showTime; }
}
