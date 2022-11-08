package com.imd0409.vacinacaobovino.rest.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imd0409.vacinacaobovino.model.Bovino;
import com.imd0409.vacinacaobovino.model.Carteira;
import com.imd0409.vacinacaobovino.rest.dto.BovinoDTO;
import com.imd0409.vacinacaobovino.rest.dto.CarteirasDTO;
import com.imd0409.vacinacaobovino.rest.dto.InformacoesCarteiraDTO;
import com.imd0409.vacinacaobovino.rest.dto.NovaCarteiraDTO;
import com.imd0409.vacinacaobovino.service.BovinoService;
import com.imd0409.vacinacaobovino.service.CarteiraService;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {
    @Autowired
    CarteiraService carteiraService;
    BovinoService bovinoService;

    @PostMapping("/adicionarCarteira")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer adicionarCarteira(@RequestBody NovaCarteiraDTO carteira) {
        return carteiraService.salvarCarteira(carteira);
    }

    @DeleteMapping("/apagarCarteira/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void apagarCarteira(@PathVariable Integer id) {
        carteiraService.apagarCarteira(id);
    }


    @GetMapping("/obterCarteira/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public InformacoesCarteiraDTO obterCarteira(@PathVariable Integer id){
        Carteira carteiraEncontrada = carteiraService.obterCarteira(id);
        return converter(carteiraEncontrada);
    }

    @GetMapping("/obterCarteiraPorIdBovino/{idBovino}")
    @ResponseStatus(HttpStatus.FOUND)
    public InformacoesCarteiraDTO obterCarteiraPorIdBovino(@PathVariable Integer idBovino){
        Carteira carteiraEncontrada = carteiraService.obterCarteiraPorIdBovino(idBovino);
        return converter(carteiraEncontrada);
    }

    @GetMapping("/obterListaCarteira")
    @ResponseStatus(HttpStatus.FOUND)
    public CarteirasDTO obterListaCarteira(){
        List<Carteira> carteirasEncontradas = carteiraService.obterListaCarteira();
        return converterCarteiras(carteirasEncontradas);
    }

    private CarteirasDTO converterCarteiras(List<Carteira> carteiras) {
        return CarteirasDTO
            .builder()
            .carteiras(converter(carteiras))
            .build();
    }

    private List<InformacoesCarteiraDTO> converter(List<Carteira> carteiras) {
        if(CollectionUtils.isEmpty(carteiras)){
            return Collections.emptyList();
        }
        return carteiras
            .stream()
            .map(
                carteira -> converter(carteira)
            ).collect(Collectors.toList());
    }

    private InformacoesCarteiraDTO converter(Carteira carteira) {
        return InformacoesCarteiraDTO
            .builder()
            .id(carteira.getId())
            .bovino(converter(carteira.getBovino()))
            .build();
    }
    
    private BovinoDTO converter(Bovino bovino){
        return BovinoDTO
                .builder()
                .nome(bovino.getNome())
                .aniversario(bovino.getAniversario())
                .sexo(bovino.getSexo())
                .cor(bovino.getCor())
                .peso(bovino.getPeso())
                .chifre(bovino.getChifre())
                .build();
    }
}
