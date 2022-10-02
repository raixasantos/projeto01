package com.imd0409.projeto01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imd0409.projeto01.model.Vacina;
import com.imd0409.projeto01.repository.VacinaRepository;

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
}