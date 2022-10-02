package com.imd0409.projeto01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imd0409.projeto01.model.Fabricante;
import com.imd0409.projeto01.repository.FabricanteRepository;

@Component
public class FabricanteServiceImpl implements FabricanteService {
    
    @Autowired
    FabricanteRepository fabricanteRepository;

    @Override
    public List<Fabricante> getListaFabricante() {
        return fabricanteRepository.findAll();
    }
}
