package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Pessoa;
import com.imd0409.vacinacaobovino.rest.dto.EditarPessoaDTO;
import com.imd0409.vacinacaobovino.rest.dto.PessoaDTO;

@Service
public interface PessoaService {
    public List<Pessoa> getListaPessoa();

    public Pessoa salvarPessoa(PessoaDTO pessoaDTO);// nova inscrição

    public void atualizaNome(EditarPessoaDTO pessoa, String novoNome); // novo met

    public void apagarPessoa(Integer id);

    public void editarPessoa(PessoaDTO pessoaDTO); // nova inscricao

    public Optional<Pessoa> getPessoaById(Integer id);
}
