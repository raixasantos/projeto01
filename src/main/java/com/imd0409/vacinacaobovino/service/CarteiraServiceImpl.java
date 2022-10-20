package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imd0409.vacinacaobovino.model.Bovino;
import com.imd0409.vacinacaobovino.model.Carteira;
import com.imd0409.vacinacaobovino.repository.CarteiraRepository;

@Component
public class CarteiraServiceImpl implements CarteiraService{

    @Autowired
    CarteiraRepository carteiraRepository;

    @Override
    public List<Carteira> getListaCarteira() {
        return carteiraRepository.findAll();
    }

    @Override
    public Carteira salvarCarteira(Bovino bovino) {
        Carteira carteira = new Carteira();
        carteira.setBovino(bovino);
        return carteiraRepository.save(carteira);
    }

    @Override
    public Optional<Carteira> getCarteiraByIdBovino(Integer id) {
        return carteiraRepository.encontrarPorIdBovino(id);
    }
    
}
