package com.imd0409.projeto01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imd0409.projeto01.model.Pessoa;
import com.imd0409.projeto01.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    @Qualifier("pessoaServiceImpl")
    PessoaService pessoaService;

    @RequestMapping("/showFormPessoa")
    public String showFormPessoa(Model model){
        model.addAttribute("pessoa", new Pessoa());
        return "pessoa/cadastroPessoas";
    }

    @RequestMapping("/addPessoa")
    public String showFormPesssoa(@ModelAttribute("pessoa") Pessoa pessoa,  Model model){
        Pessoa novaPessoa = pessoaService.salvarPessoa(pessoa);
        model.addAttribute("pessoa", novaPessoa);
        return showListaPessoa(model);
    }

    @RequestMapping("/getListaPessoas")
    public String showListaPessoa(Model model){

        List<Pessoa> pessoas = pessoaService.getListaPessoa();
        model.addAttribute("pessoas",pessoas);
        return "pessoa/listaPessoas";
    }

    @GetMapping("/showUpdateFormPessoa/{id}")
    public String showUpdateFormPessoa(@PathVariable Integer id, Model model){

        Optional<Pessoa> pessoa = pessoaService.getPessoaById(id);
        model.addAttribute("pessoa", pessoa);
        return "pessoa/editarPessoa";
    }

    @RequestMapping("/editarPessoa")
    public String editarPessoa(@ModelAttribute("pessoa") Pessoa pessoa, Model model){

        pessoaService.editarPessoa(pessoa);
        return "redirect:/pessoa/getListaPessoas";
    
    }

    @RequestMapping("/apagarPessoa/{id}")
    public String apagarBovino(@PathVariable Integer id){

        pessoaService.apagarPessoa(id);
        return "redirect:/pessoa/getListaPessoas";
    }
}
