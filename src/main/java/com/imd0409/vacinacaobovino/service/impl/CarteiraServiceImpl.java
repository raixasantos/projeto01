package com.imd0409.vacinacaobovino.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imd0409.vacinacaobovino.exception.RegraNegocioException;
import com.imd0409.vacinacaobovino.model.Bovino;
import com.imd0409.vacinacaobovino.model.Carteira;
import com.imd0409.vacinacaobovino.repository.BovinoRepository;
import com.imd0409.vacinacaobovino.repository.CarteiraRepository;
import com.imd0409.vacinacaobovino.rest.dto.NovaCarteiraDTO;
import com.imd0409.vacinacaobovino.service.CarteiraService;

@Component
public class CarteiraServiceImpl implements CarteiraService {

    @Autowired
    BovinoRepository bovinoRepository;

    @Autowired
    CarteiraRepository carteiraRepository;

    @Override
    public List<Carteira> obterListaCarteira() {
        return carteiraRepository.findAll();
    }

    @Override
    public Integer salvarCarteira(NovaCarteiraDTO carteira) {
        Integer idBovinoRecebido = carteira.getIdBovino();
        Bovino bovino = bovinoRepository
                .findById(idBovinoRecebido)
                .orElseThrow(() -> 
                    new RegraNegocioException("Bovino não encontrado.")
                );

        Boolean existeCarteiraComIdRecebido = carteiraRepository
                .findByBovino(bovino)
                .isPresent();
        if (existeCarteiraComIdRecebido) {
            throw new RegraNegocioException(
                    "Carteira com o id do bovino " + idBovinoRecebido + " já existe!"
            );
        }

        Carteira novaCarteira = new Carteira();
        novaCarteira.setBovino(bovino);
        carteiraRepository.save(novaCarteira);
        return novaCarteira.getId();
    }

    @Override
    public Carteira obterCarteira(Integer id) {
        Optional<Carteira> carteira = carteiraRepository.findById(id);
        Boolean existeCarteiraComIdRecebido = !carteira.isEmpty();
        if (!existeCarteiraComIdRecebido) {
            throw new RegraNegocioException(
                "Carteira com id " + id + " não encontrada!"
            );
        }
        
        return carteira.get();
    }

    @Override
    public Carteira obterCarteiraPorIdBovino(Integer idBovino) {
        Optional<Carteira> carteira = carteiraRepository.encontrarPorIdBovino(idBovino);
        Boolean existeCarteiraComIdRecebido = !carteira.isEmpty();
        if (!existeCarteiraComIdRecebido) {
            throw new RegraNegocioException(
                "Carteira do bovino de id " + idBovino + " não encontrada!"
            );
        }
        
        return carteira.get();
    }

    @Override
    public void apagarCarteira(Integer id) {
        carteiraRepository.findById(id)
            .map( carteira -> {
                carteiraRepository.delete(carteira);
                return carteira;
            })
            .orElseThrow(() -> new RegraNegocioException("Carteira não encontrada!") );
        // carteiraRepository.deleteById(id);
    }

}
