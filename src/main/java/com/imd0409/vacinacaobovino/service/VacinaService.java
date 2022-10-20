package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Vacina;

@Service
public interface VacinaService {
    
    public List<Vacina> getListaVacina();
    public Optional<Vacina> getVacinaById(Integer id);
    public void salvarVacina(Vacina vacina);
    public void apagarVacina(Integer id);
    public void editarVacina(Vacina vacina);   

}
