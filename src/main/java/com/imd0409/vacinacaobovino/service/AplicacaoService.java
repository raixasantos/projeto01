package com.imd0409.vacinacaobovino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Aplicacao;

@Service
public interface AplicacaoService {
    
    public List<Aplicacao> getListaAplicacao();
    public Aplicacao salvarAplicacao(Aplicacao aplicacao);
}
