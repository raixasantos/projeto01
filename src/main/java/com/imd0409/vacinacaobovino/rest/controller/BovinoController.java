package com.imd0409.vacinacaobovino.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.server.ResponseStatusException;

import com.imd0409.vacinacaobovino.model.Bovino;
import com.imd0409.vacinacaobovino.service.BovinoService;

import com.imd0409.vacinacaobovino.rest.dto.BovinoDTO;

@RequestMapping("/bovino")
@RestController
public class BovinoController {
     
    @Autowired
    @Qualifier("bovinoServiceImpl")
    BovinoService bovinoService;

    @PostMapping("/adicionarBovino")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer adicionarBovino(final @RequestBody BovinoDTO bovino){
        return bovinoService.adicionarBovino(bovino);
    }

    @GetMapping("/obterListaBovino")
    public List<Bovino> obterListaBovino(){
        return bovinoService.obterListaBovino();
    }


    @GetMapping("/obterBovinoPorId/{id}")
    public BovinoDTO obterBovinoPorId( @PathVariable Integer id ){
        return bovinoService
                .obterBovinoPorId(id)
                .map( p -> converter(p) )
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Bovino não encontrado."));
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

    @PatchMapping("/editarPeso/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editarPeso(@PathVariable Integer id, @RequestBody BovinoDTO bovinoDTO) {
        Float novoPeso = bovinoDTO.getPeso();
        bovinoService.editarPeso(id, novoPeso);
    }

    @PatchMapping("/editarChifre/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editarChifre(@PathVariable Integer id, @RequestBody BovinoDTO bovinoDTO) {
        Boolean novoChifre = bovinoDTO.getChifre();
        bovinoService.editarChifre(id, novoChifre);
    }

    @DeleteMapping("/apagarBovino/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagarBovino(@PathVariable Integer id){
        bovinoService.apagarBovino(id);
    }

    
}