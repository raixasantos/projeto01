package com.imd0409.vacinacaobovino.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imd0409.vacinacaobovino.model.Pessoa;
import com.imd0409.vacinacaobovino.repository.PessoaRepository;
import com.imd0409.vacinacaobovino.service.PessoaService;
import com.imd0409.vacinacaobovino.rest.dto.EditarPessoaDTO;
import com.imd0409.vacinacaobovino.rest.dto.PessoaDTO;

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

    clientesRepository
            .findById(id)
            .map( cliente -> {
                cliente.setNome(nome);
                return clientesRepository.save(cliente);
            }).orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));
    }

    @Override
    public void atualizaNome(EditarPessoaDTO pessoaDTO, String novoNome) {
        Pessoa pessoa = new Pessoa();
        pessoaRepository.findBy(pessoaDTO.getId()).map()
    }

    @Override
    public void apagarPessoa(Integer id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public void editarPessoa(PessoaDTO pessoaDTO) {
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
    }

    @Override
    public Optional<Pessoa> getPessoaById(Integer id) {
        return pessoaRepository.findById(id);
    }
}
