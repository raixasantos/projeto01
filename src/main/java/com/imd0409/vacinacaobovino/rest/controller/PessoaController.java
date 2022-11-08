package com.imd0409.vacinacaobovino.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.imd0409.vacinacaobovino.model.Pessoa;
import com.imd0409.vacinacaobovino.repository.PessoaRepository;
import com.imd0409.vacinacaobovino.rest.dto.PessoaDTO;
import com.imd0409.vacinacaobovino.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/")
    public Integer lerPesssoa() {
        System.out.println("Reagiu");
        return 1000;
    }

    @GetMapping("/obterListaPessoa")
    public List<Pessoa> showListaPessoa(){
        return pessoaService.getListaPessoa();
    }

    @GetMapping("/obterPessoaId/{id}")
    public PessoaDTO getById( @PathVariable Integer id ){
        return pessoaService
                .getPessoaById(id)
                .map( p -> converter(p) )
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado."));
    }

    private PessoaDTO converter(Pessoa pessoa){
        return PessoaDTO
                .builder()
                .nome(pessoa.getNome())
                .telefone(pessoa.getTelefone())
                .cpf(pessoa.getCpf())
                .email(pessoa.getEmail())
                .cidade(pessoa.getCidade())
                .estado(pessoa.getEstado())
                .cep(pessoa.getCep())
                .bairro(pessoa.getBairro())
                .rua(pessoa.getRua())
                .numero(pessoa.getNumero())
                .build();
    }

    @PostMapping("/adicionarPessoa")
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa salvarPessoa(final @RequestBody PessoaDTO pessoa) {
        return pessoaService.salvarPessoa(pessoa);
    }

    @PatchMapping("/editarNome/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNome(@PathVariable Integer id, @RequestBody PessoaDTO pessoaDTO) {
        String novoNome = pessoaDTO.getNome();
        pessoaService.atualizaNome(id, novoNome);
    }

    @PatchMapping("/editarTelefone/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTelefone(@PathVariable Integer id, @RequestBody PessoaDTO pessoaDTO) {
        String novoTelefone = pessoaDTO.getTelefone();
        pessoaService.atualizaTelefone(id, novoTelefone);
    }

    @DeleteMapping("/apagarPessoa/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagarPessoa(@PathVariable Integer id ){
        pessoaService.apagarPessoa(id);
    }

}
