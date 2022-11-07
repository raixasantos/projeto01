package com.imd0409.vacinacaobovino.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
    public Bovino salvarBovino(BovinoDTO bovinoDTO) {
       
        Bovino bovino = new Bovino();
        bovino.setNome(bovinoDTO.getNome());
        bovino.setAniversario(bovinoDTO.getAniversario());
        bovino.setSexo(bovinoDTO.getSexo());
        bovino.setCor(bovinoDTO.getCor());
        bovino.setPeso(bovinoDTO.getPeso());
        bovino.setChifre(bovinoDTO.getChifre());
        bovinoRepository.save(bovino);
        
        return bovino;
    }

    @Override
    public List<Bovino> getListaBovino() {
        return bovinoRepository.findAll();
    }

    @Override
    public void apagarBovino(Integer id) {
        bovinoRepository.deleteById(id);        
    }

    @Override
    public void editarBovino(Bovino bovino) {
        bovinoRepository.save(bovino);
        
    }

    @Override
    public void atualizarPeso(Integer id, Float novoPeso) {
        bovinoRepository.findById(id).map( bovino -> {bovino.setPeso(novoPeso);
            return bovinoRepository.save(bovino);}).orElseThrow(() -> new RegraNegocioException("Código do bovino inválido."));
    }

    @Override
    public Optional<Bovino> getBovinoById(Integer id) {
        return bovinoRepository.findById(id);
    }

}
