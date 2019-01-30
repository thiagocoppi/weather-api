package com.example.demo.converter;

import com.example.demo.model.enums.SituacaoTempo;
import com.example.demo.model.Weather;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class WeatherConverter {

    /**
     * Realiza a conversao para o modelo de dados.
     * @param jsonObject JSON Object que vem do resultado da chamada.
     * @return Retorna o modelo de dados da previsao do tempo.
     */
    public Weather converterToWeather(JSONObject jsonObject) {
        Weather weather = new Weather();
//        weather.setNomeCidade(jsonObject.getString("name"));
//
//        //Nao foi validado todos os possivel casos da situaçao, nao encontrei na doc todos os casos
//        switch (jsonObject.getJSONArray("weather").getJSONObject(0).getString("main")) {
//            case "Clouds":
//                weather.setSituacaoTempo(SituacaoTempo.NUBLADO);
//            break;
//            case "Rain":
//                weather.setSituacaoTempo(SituacaoTempo.CHUVA);
//            break;
//            case "Drizzle":
//                weather.setSituacaoTempo(SituacaoTempo.CHUVA);
//            break;
//            case "Sky":
//                weather.setSituacaoTempo(SituacaoTempo.SOL);
//            break;
//            default:
//                weather.setSituacaoTempo(SituacaoTempo.SOL);
//
//        }

        return weather;
    }
}
