package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Fabricante;
import com.imd0409.vacinacaobovino.rest.dto.FabricanteDTO;

@Service
public interface FabricanteService {
    public Fabricante adicionarFabricante(FabricanteDTO fabricanteDTO);
    public List<Fabricante> getListaFabricante();
    public Optional<Fabricante> obterFabricantePorId(Integer id);
    public Fabricante obterFabricantePorVacinaId(Integer id);
    public void editarFabricante(Fabricante fabricante); 
    public void editarFabricante(Integer id, String nome, String ddg, String cnpj, String nacionalidadeIndustria, String cidade, String estado, String cep, String bairro, String rua, String numero);
    public void apagarFabricante(Integer id);
}
