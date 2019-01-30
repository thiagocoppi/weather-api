package com.example.demo.controller;

import com.example.demo.model.Weather;
import com.example.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    /**
     * Realiza a pesquisa da previsao atual do tempo pela cidade
     * @param city Cidade que deseja pesquisar
     * @return JSON da previsao do tempo
     */
    @RequestMapping(path = "/weather", method = RequestMethod.GET)
    public Weather findWeatherByCity(@RequestParam("city") String city) {
        return weatherService.getWeatherByCity(city);
    }
}
