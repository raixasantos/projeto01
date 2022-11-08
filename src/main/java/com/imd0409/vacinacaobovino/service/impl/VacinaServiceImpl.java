package com.imd0409.vacinacaobovino.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.imd0409.vacinacaobovino.exception.RegraNegocioException;
import com.imd0409.vacinacaobovino.model.Fabricante;
import com.imd0409.vacinacaobovino.model.Vacina;
import com.imd0409.vacinacaobovino.repository.FabricanteRepository;
import com.imd0409.vacinacaobovino.repository.VacinaRepository;
import com.imd0409.vacinacaobovino.rest.dto.NovaVacinaDTO;
import com.imd0409.vacinacaobovino.service.VacinaService;

@Component
public class VacinaServiceImpl implements VacinaService {

    @Autowired
    VacinaRepository vacinaRepository;

    @Autowired
    FabricanteRepository fabricanteRepository;

    @Override
    public Vacina adicionarVacina(NovaVacinaDTO dto) {
        Integer idFabricanteRecebido = dto.getIdFabricante();
        Optional<Fabricante> fabricante = fabricanteRepository.findById(idFabricanteRecebido);
        Boolean existeFabricanteComIdRecebido = !fabricante.isEmpty();
        if (!existeFabricanteComIdRecebido) {
            throw new RegraNegocioException(
                "Fabricante não encontrado!"
            );
        }
        
        Vacina vacina = new Vacina();        
        vacina.setNome(dto.getNome());
        vacina.setPeriodoEmDias(dto.getPeriodoEmDias());
        vacina.setInformacoesExtras(dto.getInformacoesExtras());
        vacina.addFabricante(fabricante.get());  
        vacinaRepository.save(vacina);
        return vacina;
    }

    @Override
    public List<Vacina> obterListaVacina() {
        return vacinaRepository.findAll();
    }

    @Override
    public Optional<Vacina> obterVacinaPorId(Integer id) {
        return vacinaRepository.findById(id);
    }

    @Override
    public void atualizarVacina(Vacina vacina) {
        vacinaRepository.save(vacina);
        
    }

    @Override
    public void editarVacina(Integer id, String nome, int periodoEmDias, String informacoesExtras) {
        vacinaRepository
            .findById(id)
            .map( vacina -> {
                vacina.setNome(nome);
                vacina.setInformacoesExtras(informacoesExtras);
                vacina.setPeriodoEmDias(periodoEmDias);                
                
                return vacinaRepository.save(vacina);
            }).orElseThrow();
    }

    @Override
    public void apagarVacina(Integer id) {
        vacinaRepository.findById(id)
                .map( vacina -> {
                    vacinaRepository.delete(vacina );
                    return vacina;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Vacina não encontrado") );        
    }
}
