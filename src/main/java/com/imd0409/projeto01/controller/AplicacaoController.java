package com.imd0409.projeto01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imd0409.projeto01.model.Aplicacao;
import com.imd0409.projeto01.service.AplicacaoService;

@Controller
@RequestMapping("/aplicacao")
public class AplicacaoController {
    @Autowired
    @Qualifier("aplicacaoServiceImpl")
    AplicacaoService aplicacaoService;

    @RequestMapping("/showFormAplicacao")
    public String showFormAplicacao(Model model){
        model.addAttribute("aplicacao", new Aplicacao());
        return "bovino/cadastroAplicacoes";
    }

    @RequestMapping("/addAplicacao")
    public String showFormPesssoa(@ModelAttribute("aplicacao") Aplicacao aplicacao,  Model model){
        Aplicacao novaAplicacao = aplicacaoService.salvarAplicacao(aplicacao);
        model.addAttribute("aplicacao", novaAplicacao);
        return showListaAplicacao(model);
    }

    @RequestMapping("/getListaAplicacoes")
    public String showListaAplicacao(Model model){

        List<Aplicacao> aplicacoes = aplicacaoService.getListaAplicacao();
        model.addAttribute("aplicacoes",aplicacoes);
        return "bovino/listaAplicacoes";

    }
}
