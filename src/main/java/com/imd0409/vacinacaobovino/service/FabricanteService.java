package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Fabricante;
import com.imd0409.vacinacaobovino.rest.dto.FabricanteDTO;

@Service
public interface FabricanteService {

    public List<Fabricante> getListaFabricante();
    public Optional<Fabricante> getFabricanteById(Integer id);
    public Fabricante salvarFabricante(FabricanteDTO fabricanteDTO);
    public void apagarFabricante(Integer id);
    public void editarFabricante(Fabricante fabricante); 
    
}
