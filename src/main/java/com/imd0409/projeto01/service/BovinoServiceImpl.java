package com.imd0409.projeto01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imd0409.projeto01.model.Bovino;
import com.imd0409.projeto01.repository.BovinoRepository;

@Component
public class BovinoServiceImpl implements BovinoService{

    @Autowired
    BovinoRepository bovinoRepository;

    @Override
    public void salvarBovino(Bovino bovino) {
        bovinoRepository.save(bovino);
    }

    @Override
    public List<Bovino> getListaBovino() {
        return bovinoRepository.findAll();
    }

}
