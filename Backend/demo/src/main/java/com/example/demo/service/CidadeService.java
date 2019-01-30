package com.example.demo.service;

import com.example.demo.model.Cidades;

import java.util.Optional;


public interface CidadeService {

    Cidades salvarCidade(Cidades cidade);

    Optional<Cidades> getCidade(Long id);

    Cidades editCidades(Cidades cidade);

    void removeCidade(Long id);

    Iterable<Cidades> findAllCities();
}
