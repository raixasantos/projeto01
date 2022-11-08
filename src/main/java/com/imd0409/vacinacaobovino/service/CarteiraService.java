package com.imd0409.vacinacaobovino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Carteira;
import com.imd0409.vacinacaobovino.rest.dto.NovaCarteiraDTO;

@Service
public interface CarteiraService {
    public Integer adicionarCarteira(NovaCarteiraDTO carteira);
    public List<Carteira> obterListaCarteira();
    public Carteira obterCarteira(Integer id);
    public Carteira obterCarteiraPorIdBovino(Integer id);
    public void apagarCarteira(Integer id);
    
}
