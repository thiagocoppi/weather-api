package com.example.demo.service;

import com.example.demo.model.Weather;

public interface ForecastService {

    Weather getForecastByCity(String city);
}
