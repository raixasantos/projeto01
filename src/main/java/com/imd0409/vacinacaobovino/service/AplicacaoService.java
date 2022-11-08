package com.imd0409.vacinacaobovino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Aplicacao;
import com.imd0409.vacinacaobovino.rest.dto.NovaAplicacaoDTO;

@Service
public interface AplicacaoService {
    
    public Integer salvarAplicacao(NovaAplicacaoDTO aplicacao);
    public List<Aplicacao> obterListaAplicacao();
}
