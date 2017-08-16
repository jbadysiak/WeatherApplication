package com.jakubbadysiak.weatherapplication.Model;

/**
 * Created by JakubBadysiak on 03.07.2017.
 */

public class City {
    private double id;
    private String name;
    private Coord coord;
    private String country;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
