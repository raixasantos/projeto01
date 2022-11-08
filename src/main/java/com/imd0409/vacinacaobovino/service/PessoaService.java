package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Pessoa;
import com.imd0409.vacinacaobovino.rest.dto.PessoaDTO;

@Service
public interface PessoaService {
    public List<Pessoa> getListaPessoa();

    public Pessoa salvarPessoa(PessoaDTO pessoaDTO);// nova inscrição

    public void atualizaNome(Integer id, String novoNome); // novo met

    public void atualizaTelefone(Integer id, String novoTelefone); // editar telefone

    public void apagarPessoa(Integer id);

    public Optional<Pessoa> getPessoaById(Integer id);

    
}
