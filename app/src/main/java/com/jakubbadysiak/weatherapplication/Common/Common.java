package com.jakubbadysiak.weatherapplication.Common;

import android.support.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JakubBadysiak on 29.06.2017.
 */

public class Common {
    public static String API_KEY = "d9ba15a1f4e6b6d63b6cefdc5ecf4769";
    public static String API_LINK = "http://api.openweathermap.org/data/2.5/weather";
    public static String API_LINK_FORECAST = "http://api.openweathermap.org/data/2.5/forecast";

    @NonNull
    public static String apiRequest(String lat, String lng){
        StringBuilder sb = new StringBuilder(API_LINK);
        sb.append(String.format("?lat=%s&lon=%s&APPID=%s&units=metric",lat,lng,API_KEY));
        return sb.toString();
    }

    @NonNull
    public static String apiRequestForecast(String lat, String lng){
        StringBuilder sb = new StringBuilder(API_LINK_FORECAST);
        sb.append(String.format("?lat=%s&lon=%s&APPID=%s&units=metric",lat,lng,API_KEY));
        return sb.toString();
    }

    public static String unixTimeStampToDateTime(double unixTimeStamp){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        date.setTime((long)unixTimeStamp*1000);
        return dateFormat.format(date);
    }

    public static String getImage(String icon){
        return String.format("http://openweathermap.org/img/w/%s.png",icon);
    }

    public static String getDateNow(){
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
