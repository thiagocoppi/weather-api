package com.example.demo.service.impl;

import com.example.demo.converter.ForecastConverter;
import com.example.demo.model.Forecast;
import com.example.demo.model.Weather;
import com.example.demo.service.ForecastService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ForecastServiceImpl implements ForecastService {

    @Autowired
    private ForecastConverter forecastConverter;

    @Value("${url.api}")
    private String urlApi;

    @Override
    public Weather getForecastByCity(String city) {
        try {
            HttpResponse<JsonNode> jsonNode = Unirest.get(urlApi + "/forecast")
                    .queryString("q", city)
                    .queryString("APPID", "f7707e598f583a09d76d519481bb2cf4")
                    .queryString("units", "metric")
                    .asJson();
            return forecastConverter.convertToForecast(jsonNode.getBody().getObject());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }
}
