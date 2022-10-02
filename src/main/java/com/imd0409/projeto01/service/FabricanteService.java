package com.imd0409.projeto01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imd0409.projeto01.model.Fabricante;

@Service
public interface FabricanteService {

    public List<Fabricante> getListaFabricante();
    
}
