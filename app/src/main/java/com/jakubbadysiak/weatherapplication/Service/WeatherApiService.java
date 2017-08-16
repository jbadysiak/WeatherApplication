package com.jakubbadysiak.weatherapplication.Service;

import com.jakubbadysiak.weatherapplication.Model.OpenWeatherMap;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by JakubBadysiak on 02.07.2017.
 */

public interface WeatherApiService {

    @POST("/weather/add")
    Integer addWeather(@Body OpenWeatherMap openWeatherMap);

    @GET("/weather/get")
    OpenWeatherMap getWeather();
}
