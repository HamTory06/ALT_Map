package com.example.alt_map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Weather_API() {
    private static String API_key = "814ea831f9adecdf0164966dbecab1ce";

    public static String get(String lat, String lon) throws MalformedURLException {
        URL API_url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + API_key);



        return
    }
}
