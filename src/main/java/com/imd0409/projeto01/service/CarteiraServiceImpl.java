package com.imd0409.projeto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imd0409.projeto01.model.Carteira;
import com.imd0409.projeto01.repository.CarteiraRepository;

@Component
public class CarteiraServiceImpl implements CarteiraService{

    @Autowired
    CarteiraRepository carteiraRepository;

    @Override
    public List<Carteira> getListaCarteira() {
        return carteiraRepository.findAll();
    }

    @Override
    public Carteira salvarCarteira(Carteira carteira) {
        return carteiraRepository.save(carteira);
    }

    @Override
    public Optional<Carteira> getCarteiraById(Integer id) {
        return carteiraRepository.findById(id);
    }

    
}
