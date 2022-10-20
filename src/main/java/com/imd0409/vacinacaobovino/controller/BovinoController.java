package com.imd0409.vacinacaobovino.controller;

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

import com.imd0409.vacinacaobovino.model.Bovino;
import com.imd0409.vacinacaobovino.service.BovinoService;

@Controller
@RequestMapping("/bovino")
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

    @RequestMapping("/adicionarBovino")
    public String showFormBovino(@ModelAttribute("bovino") Bovino bovino,  Model model){

        bovinoService.salvarBovino(bovino);
        model.addAttribute("bovino", bovino);
        return "redirect:/bovino/getListaBovino";
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
