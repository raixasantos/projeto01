package com.imd0409.projeto01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imd0409.projeto01.model.Vacina;

@Service
public interface VacinaService {
    
    public void salvarVacina(Vacina vacina);
    public List<Vacina> getListaVacina();

}
