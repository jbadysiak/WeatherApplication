package com.jakubbadysiak.weatherapplication.Client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakubbadysiak.weatherapplication.Service.WeatherApiService;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by JakubBadysiak on 03.07.2017.
 */

public class WeatherClient {
    private String baseUrl = "http://10.0.2.2:8080";
    private WeatherApiService apiService;

    public WeatherClient(String baseUrl) {
        this.baseUrl = baseUrl;
        Gson gson = new GsonBuilder()
                .setLenient()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(this.baseUrl)
                .setConverter(new GsonConverter(gson))
                .build();

        apiService = restAdapter.create(WeatherApiService.class);

    }
    public WeatherApiService getApiService()
    {
        return apiService;
    }
}
