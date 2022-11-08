package com.imd0409.vacinacaobovino.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.imd0409.vacinacaobovino.exception.RegraNegocioException;
import com.imd0409.vacinacaobovino.model.Bovino;
import com.imd0409.vacinacaobovino.repository.BovinoRepository;
import com.imd0409.vacinacaobovino.rest.dto.BovinoDTO;
import com.imd0409.vacinacaobovino.service.BovinoService;
import com.imd0409.vacinacaobovino.service.CarteiraService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BovinoServiceImpl implements BovinoService{

    @Autowired
    BovinoRepository bovinoRepository;
    
    @Autowired
    @Qualifier("carteiraServiceImpl")
    CarteiraService carteiraService;

    @Override
    public Integer adicionarBovino(BovinoDTO bovinoDTO) {
       
        Bovino bovino = new Bovino();
        bovino.setNome(bovinoDTO.getNome());
        bovino.setAniversario(bovinoDTO.getAniversario());
        bovino.setSexo(bovinoDTO.getSexo());
        bovino.setCor(bovinoDTO.getCor());
        bovino.setPeso(bovinoDTO.getPeso());
        bovino.setChifre(bovinoDTO.getChifre());
        bovinoRepository.save(bovino);
        
        return bovino.getId();
    }

    @Override
    public List<Bovino> obterListaBovino() {
        return bovinoRepository.findAll();
    }

    @Override
    public Optional<Bovino> obterBovinoPorId(Integer id) {
        return bovinoRepository.findById(id);
    }

    @Override
    public void editarPeso(Integer id, Float novoPeso) {
        bovinoRepository.findById(id).map( bovino -> {bovino.setPeso(novoPeso);
            return bovinoRepository.save(bovino);}).orElseThrow(() -> new RegraNegocioException("Código do bovino inválido."));
    }

    @Override
    public void editarChifre(Integer id, Boolean novoChifre) {
        bovinoRepository.findById(id).map( bovino -> {bovino.setChifre(novoChifre);
            return bovinoRepository.save(bovino);}).orElseThrow(() -> new RegraNegocioException("Código do bovino inválido."));
    }

    @Override
    public void apagarBovino(Integer id) {
        bovinoRepository.findById(id)
                .map( bovino -> {
                    bovinoRepository.delete(bovino);
                    return bovino;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Bovino não encontrado") );    
    }

}
