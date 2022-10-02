package com.imd0409.projeto01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imd0409.projeto01.model.Fabricante;
import com.imd0409.projeto01.service.FabricanteService;

@Controller
@RequestMapping("/fabricante")
public class FabricanteController {
    
    @Autowired
    @Qualifier("fabricanteServiceImpl")
    FabricanteService fabricanteService;

    @GetMapping("/getListaFabricante")
    public String showListaFabricante(Model model) {
        
        List<Fabricante> fabricantes = fabricanteService.getListaFabricante();
        model.addAttribute("fabricantes", fabricantes);
        return "redirect:/";
    }
}
