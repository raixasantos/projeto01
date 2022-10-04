package com.imd0409.projeto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imd0409.projeto01.model.Pessoa;
import com.imd0409.projeto01.repository.PessoaRepository;

@Component
public class PessoaServiceImpl implements PessoaService{
    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> getListaPessoa() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    
    @Override
    public void apagarPessoa(Integer id) {
        pessoaRepository.deleteById(id);        
    }

    @Override
    public void editarPessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        
    }

    @Override
    public Optional<Pessoa> getPessoaById(Integer id) {
        return pessoaRepository.findById(id);
    }
}
