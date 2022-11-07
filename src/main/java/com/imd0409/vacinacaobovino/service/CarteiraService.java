package com.imd0409.vacinacaobovino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Carteira;
import com.imd0409.vacinacaobovino.rest.dto.NovaCarteiraDTO;

@Service
public interface CarteiraService {

    public Integer salvarCarteira(NovaCarteiraDTO carteira);
    public List<Carteira> obterListaCarteira();
    public Carteira obterCarteiraPorIdBovino(Integer id);
    
}
