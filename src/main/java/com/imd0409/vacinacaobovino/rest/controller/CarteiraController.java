package com.imd0409.vacinacaobovino.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imd0409.vacinacaobovino.model.Carteira;
import com.imd0409.vacinacaobovino.rest.dto.NovaCarteiraDTO;
import com.imd0409.vacinacaobovino.service.CarteiraService;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {
    @Autowired
    CarteiraService carteiraService;

    @PostMapping("/adicionarCarteira")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer adicionarCarteira(@RequestBody NovaCarteiraDTO carteira) {
        return carteiraService.salvarCarteira(carteira);
    }

    @GetMapping("/obterCarteiraPorIdBovino/{idBovino}")
    public Carteira obterCarteiraPorIdBovino(@PathVariable Integer idBovino){        
        return carteiraService.obterCarteiraPorIdBovino(idBovino);
    }

    
}
