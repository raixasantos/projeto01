package com.imd0409.vacinacaobovino.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imd0409.vacinacaobovino.model.Pessoa;
import com.imd0409.vacinacaobovino.repository.PessoaRepository;
import com.imd0409.vacinacaobovino.rest.dto.EditarPessoaDTO;
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

    @PostMapping("/adicionarPessoa")
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa salvarPessoa(final @RequestBody PessoaDTO pessoa) {// salvar dados do usuario
        return pessoaService.salvarPessoa(pessoa);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNome(@PathVariable Integer id, @RequestBody EditarPessoaDTO pessoa) {
        String novoNome = pessoa.getNome();
        pessoaService.atualizaNome(pessoa, novoNome);
    }

    /*
     * @PatchMapping("{id}")
     * 
     * @ResponseStatus(HttpStatus.NO_CONTENT)
     * public void editarPessoa(final @RequestBody PessoaDTO pessoa) {
     * pessoaService.editarPessoa(pessoa);
     * }
     */

}
