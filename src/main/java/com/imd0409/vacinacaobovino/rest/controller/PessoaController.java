package com.imd0409.vacinacaobovino.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imd0409.vacinacaobovino.model.Pessoa;
import com.imd0409.vacinacaobovino.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    
    @GetMapping("/")
    public Integer lerPesssoa(){
        System.out.println("Reagiu");
        return 1000;
    }
}
