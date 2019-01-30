package com.example.demo.model;

import com.example.demo.model.enums.SituacaoTempo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Forecast {
    @Enumerated(EnumType.STRING)
    private SituacaoTempo situacaoTempo;
    private int maxTemp;
    private int minTemp;

    public SituacaoTempo getSituacaoTempo() {
        return situacaoTempo;
    }

    public void setSituacaoTempo(SituacaoTempo situacaoTempo) {
        this.situacaoTempo = situacaoTempo;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }
}
