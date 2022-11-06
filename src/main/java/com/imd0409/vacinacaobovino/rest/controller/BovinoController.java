package com.imd0409.vacinacaobovino.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imd0409.vacinacaobovino.model.Bovino;
import com.imd0409.vacinacaobovino.service.BovinoService;

import com.imd0409.vacinacaobovino.rest.dto.BovinoDTO;

//@Controller
@RequestMapping("/bovino")
@RestController
public class BovinoController {
     
    @Autowired
    @Qualifier("bovinoServiceImpl")
    BovinoService bovinoService;

    @GetMapping("/opcoesBovino")
    public String showBovinos(){
        return "bovino/bovinos";
    }

    @RequestMapping("/showFormBovino")
    public String showBovinos(Model model){

        model.addAttribute("bovino", new Bovino());
        List<Bovino> bovinos = bovinoService.getListaBovino();
        model.addAttribute("bovinos", bovinos);
        return "bovino/cadastroBovinos";
    }

    @PostMapping("/adicionarBovino")
    @ResponseStatus(HttpStatus.CREATED)
    public Bovino showFormBovino(final @RequestBody BovinoDTO bovino){
        return bovinoService.salvarBovino(bovino);
    }

    @GetMapping("/getListaBovino")
    public String showListaBovino(Model model){

        List<Bovino> bovinos = bovinoService.getListaBovino();
        model.addAttribute("bovinos", bovinos);
        return "bovino/listaAnimaisCarteiraVacinacao";

    }

    @GetMapping("/showUpdateFormBovino/{id}")
    public String showUpdateFormBovino(@PathVariable Integer id, Model model){

        Optional<Bovino> bovino = bovinoService.getBovinoById(id);
        model.addAttribute("bovino", bovino);
        return "bovino/editarBovino";
    }

    @RequestMapping("/editarBovino")
    public String editarBovino(@ModelAttribute("bovino") Bovino bovino, Model model){

        bovinoService.editarBovino(bovino);
        return "redirect:/bovino/getListaBovino";
    
    }

    @RequestMapping("/apagarBovino/{id}")
    public String apagarBovino(@PathVariable Integer id){

        bovinoService.apagarBovino(id);
        return "redirect:/bovino/getListaBovino";
    }

    
}