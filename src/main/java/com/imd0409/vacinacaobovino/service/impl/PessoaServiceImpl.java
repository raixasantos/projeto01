package com.imd0409.vacinacaobovino.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.imd0409.vacinacaobovino.exception.RegraNegocioException;
import com.imd0409.vacinacaobovino.model.Pessoa;
import com.imd0409.vacinacaobovino.repository.PessoaRepository;
import com.imd0409.vacinacaobovino.service.PessoaService;
import com.imd0409.vacinacaobovino.rest.dto.PessoaDTO;
import com.imd0409.vacinacaobovino.security.*;

@Component
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> getListaPessoa() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa salvarPessoa(PessoaDTO pessoaDTO) {// nova inscricao
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setTelefone(pessoaDTO.getTelefone());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setEmail(pessoaDTO.getEmail());
        pessoa.setCidade(pessoaDTO.getCidade());
        pessoa.setEstado(pessoaDTO.getEstado());
        pessoa.setCep(pessoaDTO.getCep());
        pessoa.setBairro(pessoaDTO.getBairro());
        pessoa.setRua(pessoaDTO.getRua());
        pessoa.setNumero(pessoaDTO.getNumero());
        pessoaRepository.save(pessoa);
        return pessoa;
    }

    @Override
    public void atualizaNome(Integer id, String novoNome) {
        pessoaRepository.findById(id).map( pessoa -> {pessoa.setNome(novoNome);
            return pessoaRepository.save(pessoa);}).orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));
    }

    @Override
    public void atualizaTelefone(Integer id, String novoTelefone) {
        pessoaRepository.findById(id).map( pessoa -> {pessoa.setTelefone(novoTelefone);
            return pessoaRepository.save(pessoa);}).orElseThrow(() -> new RegraNegocioException("Código de telefone do cliente inválido."));
    }

    @Override
    public void apagarPessoa(Integer id) {
        pessoaRepository.deleteById(id);
    }


    @Override
    public Optional<Pessoa> getPessoaById(Integer id) {
        return pessoaRepository.findById(id);
    }

    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Pessoa pessoa = pessoaRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados."));

        String[] roles = pessoa.getPapel() == "ADMIN" ? new String[] { "ADMIN", "USER" } : new String[] { "USER" };

        return User
                .builder()
                .username(pessoa.getLogin())
                .password(pessoa.getSenha())
                .roles(roles)
                .build();

        /*
         * Usuário em memória
         * if(!username.equals("cicrano")){
         * throw new UsernameNotFoundException("Usuário não encontrado na base.");
         * }
         * 
         * return User
         * .builder()
         * .username("cicrano")
         * .password(passwordEncoder.encode("123"))
         * .roles("USER")
         * .build();
         */
    }
}
