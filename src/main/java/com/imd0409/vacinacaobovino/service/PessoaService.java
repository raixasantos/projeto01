package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Pessoa;
import com.imd0409.vacinacaobovino.rest.dto.PessoaDTO;

@Service
public interface PessoaService {
    public List<Pessoa> getListaPessoa();

    public PessoaDTO salvarPessoa(Pessoa pessoa);//nova inscrição

    //public Pessoa salvarPessoa(Pessoa pessoa);

    public void apagarPessoa(Integer id);

    public void editarPessoa(Pessoa pessoa);

    public Optional<Pessoa> getPessoaById(Integer id);
}
