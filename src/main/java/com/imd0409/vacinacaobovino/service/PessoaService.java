package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.imd0409.vacinacaobovino.model.Pessoa;
import com.imd0409.vacinacaobovino.rest.dto.PessoaDTO;

@Service
public interface PessoaService {
    public Integer adicionarPessoa(PessoaDTO pessoaDTO);// nova inscrição
    public List<Pessoa> obterListaPessoa();
    public Optional<Pessoa> obterPessoaPorId(Integer id);
    public void editarNome(Integer id, String novoNome); // novo met
    public void editarTelefone(Integer id, String novoTelefone); // editar telefone
    public void apagarPessoa(Integer id);    
    public UserDetails loadUserByUsername(String username);
    public UserDetails autenticar(Pessoa pessoa);
}
