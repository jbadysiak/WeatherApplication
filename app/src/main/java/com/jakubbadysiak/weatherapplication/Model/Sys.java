package com.jakubbadysiak.weatherapplication.Model;

/**
 * Created by JakubBadysiak on 29.06.2017.
 */

public class Sys {
    private double message;
    private String country;
    private double sunrise;
    private double sunset;
    private String pod;

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getSunrise() {
        return sunrise;
    }

    public void setSunrise(double sunrise) {
        this.sunrise = sunrise;
    }

    public double getSunset() {
        return sunset;
    }

    public void setSunset(double sunset) {
        this.sunset = sunset;
    }

    public String getPod() {return pod;}

    public void setPod(String pod) { this.pod = pod; }
}
