package com.imd0409.projeto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.imd0409.projeto01.model.Bovino;
import com.imd0409.projeto01.repository.BovinoRepository;

@Component
public class BovinoServiceImpl implements BovinoService{

    @Autowired
    BovinoRepository bovinoRepository;
    
    @Autowired
    @Qualifier("carteiraServiceImpl")
    CarteiraService carteiraService;

    @Override
    public void salvarBovino(Bovino bovino) {
        bovinoRepository.save(bovino);
        carteiraService.salvarCarteira(bovino);
    }

    @Override
    public List<Bovino> getListaBovino() {
        return bovinoRepository.findAll();
    }

    @Override
    public void apagarBovino(Integer id) {
        bovinoRepository.deleteById(id);        
    }

    @Override
    public void editarBovino(Bovino bovino) {
        bovinoRepository.save(bovino);
        
    }

    @Override
    public Optional<Bovino> getBovinoById(Integer id) {
        return bovinoRepository.findById(id);
    }

}
