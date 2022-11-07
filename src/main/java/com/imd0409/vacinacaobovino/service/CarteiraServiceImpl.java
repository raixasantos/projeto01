package com.imd0409.vacinacaobovino.service;

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
                .orElseThrow(() -> new RegraNegocioException("Bovino não encontrado."));

        Boolean existeCarteiraComIdRecebido = carteiraRepository
                .encontrarPorIdBovino(idBovinoRecebido)
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
    public Carteira obterCarteiraPorIdBovino(Integer idBovino) {
        Optional<Carteira> carteira = carteiraRepository.encontrarPorIdBovino(idBovino);
        Boolean existeCarteiraComIdRecebido = carteira.isPresent();
        if (!existeCarteiraComIdRecebido) {
            throw new RegraNegocioException(
                "Carteira do bovino de id " + idBovino + " não encontrada!"
            );
        }

        return carteira.get();
    }

}
