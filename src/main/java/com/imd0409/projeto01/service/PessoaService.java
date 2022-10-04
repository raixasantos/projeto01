package com.imd0409.projeto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.projeto01.model.Pessoa;

@Service
public interface PessoaService {
    public List<Pessoa> getListaPessoa();
    public Pessoa salvarPessoa(Pessoa pessoa);
    public void apagarPessoa(Integer id);
    public void editarPessoa(Pessoa pessoa);
    public Optional<Pessoa> getPessoaById(Integer id);
}
