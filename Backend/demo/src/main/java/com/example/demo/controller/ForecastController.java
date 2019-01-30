package com.example.demo.controller;

import com.example.demo.model.Weather;
import com.example.demo.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/forecast")
public class ForecastController {

    @Autowired
    private ForecastService forecastService;

    @RequestMapping(method = RequestMethod.GET)
    public Weather getWeatherByCity(@RequestParam("city") String city) {
        return forecastService.getForecastByCity(city);
    }
}
