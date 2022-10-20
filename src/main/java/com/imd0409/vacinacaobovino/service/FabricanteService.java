package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Fabricante;

@Service
public interface FabricanteService {

    public List<Fabricante> getListaFabricante();
    public Optional<Fabricante> getFabricanteById(Integer id);
    public void salvarFabricante(Fabricante fabricante);
    public void apagarFabricante(Integer id);
    public void editarFabricante(Fabricante fabricante); 
    
}
