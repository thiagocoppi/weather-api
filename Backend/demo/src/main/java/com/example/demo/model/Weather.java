package com.example.demo.model;

import com.example.demo.model.enums.SituacaoTempo;

import java.util.List;

public class Weather {
    private String nomeCidade;
    private List<Forecast> listaPrevisao;

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }


    public List<Forecast> getListaPrevisao() {
        return listaPrevisao;
    }

    public void setListaPrevisao(List<Forecast> listaPrevisao) {
        this.listaPrevisao = listaPrevisao;
    }
}
