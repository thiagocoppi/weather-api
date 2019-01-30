package com.example.demo.controller;

import com.example.demo.model.Cidades;
import com.example.demo.service.CidadeService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(method = RequestMethod.POST)
    public Cidades salvarCidade(@RequestBody Cidades cidades){
        return cidadeService.salvarCidade(cidades);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Cidades buscarCidade(@RequestParam("id") Long id) {
        Optional<Cidades> cidade = cidadeService.getCidade(id);

        if (cidade.isPresent()) {
            return cidade.get();
        } else {
            throw new ServiceException("Não foi encontrado nenhuma cidade com o ID: " + String.valueOf(id));
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Cidades editCidade(@RequestBody Cidades cidade) {
        Optional<Cidades> cidadeBuscada = cidadeService.getCidade(cidade.getId());

        if (cidadeBuscada.isPresent()) {
            cidade.setId(cidadeBuscada.get().getId());
            return cidadeService.salvarCidade(cidade);
        } else {
            throw new ServiceException("Não foi encontrado nenhuma cidade com o ID: " + String.valueOf(cidade.getId()));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeCidade(@RequestParam("id") Long id) {
        cidadeService.removeCidade(id);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public Iterable<Cidades> getAllCidades() {
        return cidadeService.findAllCities();
    }
}
