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

import com.imd0409.vacinacaobovino.model.Fabricante;
import com.imd0409.vacinacaobovino.service.FabricanteService;


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
        return "fabricante/listaFabricante";
    }

    @RequestMapping("/showFormFabricante")
    public String showFormFabricante(Model model){

        model.addAttribute("fabricante", new Fabricante());
        return "fabricante/cadastroFabricante";
    }

    @RequestMapping("/adicionarFabricante")
    public String showFormFabricante(@ModelAttribute("fabricante") Fabricante fabricante,  Model model){

        fabricanteService.salvarFabricante(fabricante);
        model.addAttribute("fabricante", fabricante);
        return "redirect:/fabricante/getListaFabricante";
    }

    @RequestMapping("/showUpdateFormFabricante/{id}")
    public String showUpdateFormFabricante(@PathVariable Integer id, Model model){

        Optional<Fabricante> fabricante = fabricanteService.getFabricanteById(id);
        model.addAttribute("fabricante", fabricante);
        return "fabricante/editarFabricante";
    }

    @RequestMapping("/editarFabricante")
    public String editarFabricante(@ModelAttribute("fabricante") Fabricante fabricante, Model model){

        fabricanteService.editarFabricante(fabricante);
        return "redirect:/fabricante/getListaFabricante";
    
    }

    @RequestMapping("/apagarFabricante/{id}")
    public String apagarVacina(@PathVariable Integer id){

        fabricanteService.apagarFabricante(id);
        return "redirect:/fabricante/getListaFabricante";
    }

}
