package com.imd0409.vacinacaobovino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imd0409.vacinacaobovino.model.Aplicacao;
import com.imd0409.vacinacaobovino.repository.AplicacaoRepository;

@Component
public class AplicacaoServiceImpl implements AplicacaoService{

    @Autowired
    AplicacaoRepository aplicacaoRepository;

    @Override
    public List<Aplicacao> getListaAplicacao() {
        return aplicacaoRepository.findAll();
    }

    @Override
    public Aplicacao salvarAplicacao(Aplicacao aplicacao) {
        return aplicacaoRepository.save(aplicacao);
    }

    
}
