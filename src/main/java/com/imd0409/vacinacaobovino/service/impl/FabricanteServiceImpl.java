package com.imd0409.vacinacaobovino.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.imd0409.vacinacaobovino.exception.RegraNegocioException;
import com.imd0409.vacinacaobovino.model.Fabricante;
import com.imd0409.vacinacaobovino.repository.FabricanteRepository;
import com.imd0409.vacinacaobovino.rest.dto.FabricanteDTO;
import com.imd0409.vacinacaobovino.service.FabricanteService;

@Component
public class FabricanteServiceImpl implements FabricanteService {
    
    @Autowired
    FabricanteRepository fabricanteRepository;

    @Override
    public Fabricante adicionarFabricante(FabricanteDTO dto) {
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
    public List<Fabricante> getListaFabricante() {
        return fabricanteRepository.findAll();
    }

    @Override
    public Optional<Fabricante> obterFabricantePorId(Integer id) {
        return fabricanteRepository.findById(id);
    }

    @Override
    public Fabricante obterFabricantePorVacinaId(Integer id) {
        List<Fabricante> fabricante = fabricanteRepository.findFabricantesByVacinasId(id);
        if(fabricante.isEmpty()) {
            throw new RegraNegocioException(
                "Fabricante não encontrado!"
            );
        }
        return fabricante.get(0);
    }
    
    @Override
    public void editarFabricante(Fabricante fabricante) {
        fabricanteRepository.save(fabricante);
        
    }

    @Override
    public void editarFabricante(Integer id, String nome, String ddg, String cnpj, String nacionalidadeIndustria,
            String cidade, String estado, String cep, String bairro, String rua, String numero) {
        fabricanteRepository
            .findById(id)
            .map( fabricante -> {
                fabricante.setNome(nome);
                fabricante.setDdg(ddg);
                fabricante.setCnpj(cnpj);
                fabricante.setNacionalidadeIndustria(nacionalidadeIndustria);
                fabricante.setCidade(cidade);
                fabricante.setEstado(estado);
                fabricante.setCep(cep);
                fabricante.setBairro(bairro);
                fabricante.setRua(rua);
                fabricante.setNumero(numero);
                
                return fabricanteRepository.save(fabricante);
            }).orElseThrow();
    }

    @Override
    public void apagarFabricante(Integer id) {
        fabricanteRepository.findById(id)
                .map( fabricante -> {
                    fabricanteRepository.delete(fabricante );
                    return fabricante;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Fabricante não encontrado") );
    }
}
