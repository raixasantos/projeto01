package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Vacina;
import com.imd0409.vacinacaobovino.rest.dto.NovaVacinaDTO;

@Service
public interface VacinaService {
    public Vacina adicionarVacina(NovaVacinaDTO dto);
    public List<Vacina> obterListaVacina();
    public Optional<Vacina> obterVacinaPorId(Integer id);
    public void atualizarVacina(Vacina vacina); 
    public void editarVacina(Integer id, String nome, int periodoEmDias, String informacoesExtras);
    public void apagarVacina(Integer id);
}
