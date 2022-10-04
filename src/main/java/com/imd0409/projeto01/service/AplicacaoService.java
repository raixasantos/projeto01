package com.imd0409.projeto01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imd0409.projeto01.model.Aplicacao;

@Service
public interface AplicacaoService {
    
    public List<Aplicacao> getListaAplicacao();
    public Aplicacao salvarAplicacao(Aplicacao aplicacao);
}
