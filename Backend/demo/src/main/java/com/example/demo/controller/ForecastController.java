package com.example.demo.controller;

import com.example.demo.model.Weather;
import com.example.demo.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/forecast")
public class ForecastController {

    @Autowired
    private ForecastService forecastService;

    @RequestMapping(method = RequestMethod.GET)
    public Weather getWeatherByCity(@RequestParam("city") String city){
        return forecastService.getForecastByCity(city);
    }
}
