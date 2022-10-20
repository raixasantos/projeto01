package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imd0409.vacinacaobovino.model.Vacina;
import com.imd0409.vacinacaobovino.repository.VacinaRepository;

@Component
public class VacinaServiceImpl implements VacinaService {

    @Autowired
    VacinaRepository vacinaRepository;

    @Override
    public void salvarVacina(Vacina vacina) {
        vacinaRepository.save(vacina);
    }

    @Override
    public List<Vacina> getListaVacina() {
        return vacinaRepository.findAll();
    }

    @Override
    public void apagarVacina(Integer id) {
        vacinaRepository.deleteById(id);        
    }

    @Override
    public void editarVacina(Vacina vacina) {
        vacinaRepository.save(vacina);
        
    }

    @Override
    public Optional<Vacina> getVacinaById(Integer id) {
        return vacinaRepository.findById(id);
    }
}