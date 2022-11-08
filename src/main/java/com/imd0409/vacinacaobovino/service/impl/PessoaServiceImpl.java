package com.imd0409.vacinacaobovino.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.imd0409.vacinacaobovino.exception.RegraNegocioException;
import com.imd0409.vacinacaobovino.model.Pessoa;
import com.imd0409.vacinacaobovino.repository.PessoaRepository;
import com.imd0409.vacinacaobovino.service.PessoaService;
import com.imd0409.vacinacaobovino.rest.dto.PessoaDTO;

@Component
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    PessoaRepository pessoaRepository;

    @Transactional
    @Override
    public Integer adicionarPessoa(PessoaDTO pessoaDTO) {// nova inscricao
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
        pessoa.setLogin(pessoaDTO.getLogin());
        pessoa.setSenha(pessoaDTO.getSenha());
        pessoa.setPapel(pessoaDTO.getPapel());
        pessoaRepository.save(pessoa);
        return pessoa.getId();
    }

    @Override
    public List<Pessoa> obterListaPessoa() {
        return pessoaRepository.findAll();
    }

    @Override
    public void editarNome(Integer id, String novoNome) {
        pessoaRepository.findById(id).map( pessoa -> {pessoa.setNome(novoNome);
            return pessoaRepository.save(pessoa);}).orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));
    }

    @Override
    public void editarTelefone(Integer id, String novoTelefone) {
        pessoaRepository.findById(id).map( pessoa -> {pessoa.setTelefone(novoTelefone);
            return pessoaRepository.save(pessoa);}).orElseThrow(() -> new RegraNegocioException("Código de telefone do cliente inválido."));
    }

    @Override
    public Optional<Pessoa> obterPessoaPorId(Integer id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public void apagarPessoa(Integer id) {
        pessoaRepository.findById(id)
                .map( pessoa -> {
                    pessoaRepository.delete(pessoa );
                    return pessoa;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Pessoa não encontrada") );
    }

    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Pessoa pessoa = pessoaRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
        
        String[] roles = new String[] {};
        if(pessoa.getPapel() == "GESTOR") {
            roles =  new String[] { "GESTOR", "VETERINARIO", "PROPRIETARIO" };
        } else if(pessoa.getPapel() == "VETERINARIO"){
            roles =  new String[] { "VETERINARIO", "PROPRIETARIO" };
        } else {
            roles =  new String[] { "PROPRIETARIO" };
        }
        
        return User
                .builder()
                .username(pessoa.getLogin())
                .password(pessoa.getSenha())
                .roles(roles)
                .build();
    }

    public UserDetails autenticar(Pessoa pessoa){
        UserDetails user = loadUserByUsername(pessoa.getLogin());
        boolean senhasBatem = passwordEncoder.matches(pessoa.getSenha(), user.getPassword());

        if(senhasBatem){
            return user;
        }

        throw new RegraNegocioException("Senha inválida");
    }
}
