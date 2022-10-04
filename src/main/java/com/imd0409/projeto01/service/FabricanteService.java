package com.imd0409.projeto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.projeto01.model.Fabricante;

@Service
public interface FabricanteService {

    public List<Fabricante> getListaFabricante();
    public Optional<Fabricante> getFabricanteById(Integer id);
    public void salvarFabricante(Fabricante fabricante);
    public void apagarFabricante(Integer id);
    public void editarFabricante(Fabricante fabricante); 
    
}
