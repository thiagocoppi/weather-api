package com.example.demo.service.impl;

import com.example.demo.model.Cidades;
import com.example.demo.repository.CidadeRepositoy;
import com.example.demo.service.CidadeService;
import com.example.demo.service.ForecastService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepositoy cidadeRepositoy;

    @Autowired
    private ForecastService forecastService;


    @Override
    public Cidades salvarCidade(Cidades cidade) {
        if (forecastService.checkIfCityReturnForecast(cidade.getNome())) {
            return cidadeRepositoy.save(cidade);
        } else {
            throw new ServiceException("Para a cidade " + cidade.getNome() + " não foi encontrado nenhuma previsão, tente cadastrar outra");
        }


    }

    @Override
    public Optional<Cidades> getCidade(Long id) {
        return cidadeRepositoy.findById(id);
    }

    @Override
    public Cidades editCidades(Cidades cidade) {
        return cidadeRepositoy.save(cidade);
    }

    @Override
    public void removeCidade(Long id) {
        cidadeRepositoy.deleteById(id);
    }

    @Override
    public Iterable<Cidades> findAllCities() {
        return cidadeRepositoy.findAll();
    }

}
