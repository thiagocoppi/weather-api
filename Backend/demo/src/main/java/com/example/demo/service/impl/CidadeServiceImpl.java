package com.example.demo.service.impl;

import com.example.demo.model.Cidades;
import com.example.demo.repository.CidadeRepositoy;
import com.example.demo.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepositoy cidadeRepositoy;



    @Override
    public Cidades salvarCidade(Cidades cidade) {
        return cidadeRepositoy.save(cidade);
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
