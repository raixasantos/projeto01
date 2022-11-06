package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imd0409.vacinacaobovino.model.Fabricante;
import com.imd0409.vacinacaobovino.repository.FabricanteRepository;
import com.imd0409.vacinacaobovino.rest.dto.FabricanteDTO;

@Component
public class FabricanteServiceImpl implements FabricanteService {
    
    @Autowired
    FabricanteRepository fabricanteRepository;

    @Override
    public List<Fabricante> getListaFabricante() {
        return fabricanteRepository.findAll();
    }
    @Override
    public Fabricante salvarFabricante(FabricanteDTO dto) {
        Fabricante fabricante = new Fabricante();
        
        fabricante.setNome(dto.getNome());
        fabricante.setDdg(dto.getDdg());
        fabricante.setCnpj(dto.getCnpj());
        fabricante.setNacionalidadeIndustria(dto.getNacionalidadeIndustria());
        fabricante.setCidade(dto.getCidade());
        fabricante.setEstado(dto.getEstado());
        fabricante.setCep(dto.getCep());
        fabricante.setBairro(dto.getBairro());
        fabricante.setRua(dto.getRua());
        fabricante.setNumero(dto.getNumero());

        fabricanteRepository.save(fabricante);
        return fabricante;
    }
    @Override
    public void apagarFabricante(Integer id) {
        fabricanteRepository.deleteById(id);
        
    }
    @Override
    public void editarFabricante(Fabricante fabricante) {
        fabricanteRepository.save(fabricante);
        
    }
    @Override
    public Optional<Fabricante> getFabricanteById(Integer id) {
        return fabricanteRepository.findById(id);
    }
}
