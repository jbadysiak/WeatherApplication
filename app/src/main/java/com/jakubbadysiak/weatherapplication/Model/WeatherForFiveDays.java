package com.jakubbadysiak.weatherapplication.Model;

import java.util.List;

/**
 * Created by JakubBadysiak on 03.07.2017.
 */

public class WeatherForFiveDays {
    private int cod;
    private double message;
    private int cnt;
    private List<ForecastWeather> list;
    private City city;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<ForecastWeather> getList() {
        return list;
    }

    public void setList(List<ForecastWeather> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
