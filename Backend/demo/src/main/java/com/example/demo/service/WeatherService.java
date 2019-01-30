package com.example.demo.service;

import com.example.demo.converter.WeatherConverter;
import com.example.demo.model.Weather;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private WeatherConverter weatherConverter;

    @Value("${url.api}")
    private String urlApi;

    /**
     * Realiza a requisiçao pro serviço de previsao do tempo do dia corrente.
     * @param city Cidade para realizar a requisiçao
     * @return JSON da cidade.
     */
    public Weather getWeatherByCity(String city) {
        try {

            HttpResponse<JsonNode> jsonNode = Unirest.get(urlApi + "/weather")
                    .queryString("q", city)
                    .queryString("APPID", "f7707e598f583a09d76d519481bb2cf4")
                    .queryString("units", "metric")
                    .asJson();


            return weatherConverter.converterToWeather(jsonNode.getBody().getObject());
        } catch (Exception e ) {
            e.printStackTrace();
        }

        return null;
    }

}
