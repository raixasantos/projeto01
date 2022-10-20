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
import com.imd0409.vacinacaobovino.model.Vacina;
import com.imd0409.vacinacaobovino.service.FabricanteService;
import com.imd0409.vacinacaobovino.service.VacinaService;

@Controller
@RequestMapping("/vacina")
public class VacinaController {
    
    @Autowired
    @Qualifier("vacinaServiceImpl")
    VacinaService vacinaService;

    @Autowired
    @Qualifier("fabricanteServiceImpl")
    FabricanteService fabricanteService;

    @GetMapping("/getListaVacina")
    public String showListaVacina(Model model){

        List<Vacina> vacinas = vacinaService.getListaVacina();
        model.addAttribute("vacinas", vacinas);
        return "vacina/listaVacinas";

    }

    @RequestMapping("/showFormVacina")
    public String showFormVacina(Model model){

        model.addAttribute("vacina", new Vacina());
        List<Fabricante> fabricantes = fabricanteService.getListaFabricante();
        model.addAttribute("fabricantes", fabricantes);
        return "vacina/cadastroVacinas";
    }

    @RequestMapping("/adicionarVacina")
    public String showFormVacina(@ModelAttribute("vacina") Vacina vacina, Model model){

        vacinaService.salvarVacina(vacina);
        return "redirect:/vacina/getListaVacina";
    }

    @GetMapping("/showUpdateFormVacina/{id}")
    public String showUpdateFormVacina(@PathVariable Integer id, Model model){

        Optional<Vacina> vacina = vacinaService.getVacinaById(id);
        model.addAttribute("vacina", vacina);
        List<Fabricante> fabricantes = fabricanteService.getListaFabricante();
        model.addAttribute("fabricantes", fabricantes);
        return "vacina/editarVacina";
    }

    @RequestMapping("/editarVacina")
    public String editarVacina(@ModelAttribute("vacina") Vacina vacina, Model model){

        vacinaService.editarVacina(vacina);
        return "redirect:/vacina/getListaVacina";
    
    }

    @RequestMapping("/apagarVacina/{id}")
    public String apagarVacina(@PathVariable Integer id){

        vacinaService.apagarVacina(id);
        return "redirect:/vacina/getListaVacina";
    }

}
