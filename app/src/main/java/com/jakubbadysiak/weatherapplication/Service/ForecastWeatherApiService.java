package com.jakubbadysiak.weatherapplication.Service;

import com.jakubbadysiak.weatherapplication.Model.ForecastWeather;
import com.jakubbadysiak.weatherapplication.Model.OpenWeatherMap;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by JakubBadysiak on 03.07.2017.
 */

public interface ForecastWeatherApiService {

    @POST("/forecastweather/add")
    Integer addWeather(@Body ForecastWeather forecastWeather);

    @GET("/forecastweather/get")
    OpenWeatherMap getWeather();
}
