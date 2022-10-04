package com.imd0409.projeto01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imd0409.projeto01.model.Pessoa;

@Service
public interface PessoaService {
    public List<Pessoa> getListaPessoa();
    public Pessoa salvarPessoa(Pessoa pessoa);
}
