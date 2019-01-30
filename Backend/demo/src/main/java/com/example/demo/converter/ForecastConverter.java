package com.example.demo.converter;

import com.example.demo.model.Forecast;
import com.example.demo.model.Weather;
import com.example.demo.model.enums.SituacaoTempo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ForecastConverter {

    public Weather convertToForecast(JSONObject jsonObject){
        Weather weather = new Weather();
        List<Forecast> forecastList = new ArrayList<>();
        weather.setNomeCidade(jsonObject.getJSONObject("city").getString("name"));

        JSONArray jsonArray = jsonObject.getJSONArray("list");


        for (int i = 0; i < jsonArray.length() ; i+=8) {
            JSONObject jsonObjectArray = jsonArray.getJSONObject(i);
            Forecast forecast = new Forecast();
            forecast.setMaxTemp(jsonObjectArray.getJSONObject("main").getInt("temp_max"));
            forecast.setMinTemp(jsonObjectArray.getJSONObject("main").getInt("temp_min"));
            switch (jsonObjectArray.getJSONArray("weather").getJSONObject(0).getString("main")) {
                case "Clouds":
                    forecast.setSituacaoTempo(SituacaoTempo.NUBLADO);
                    break;
                case "Rain":
                    forecast.setSituacaoTempo(SituacaoTempo.CHUVA);
                    break;
                case "Drizzle":
                    forecast.setSituacaoTempo(SituacaoTempo.CHUVA);
                    break;
                case "Sky":
                    forecast.setSituacaoTempo(SituacaoTempo.SOL);
                    break;
                default:
                    forecast.setSituacaoTempo(SituacaoTempo.SOL);
            }
            forecastList.add(forecast);
        }
        weather.setListaPrevisao(forecastList);

        return weather;
    }
}
