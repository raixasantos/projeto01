package com.imd0409.projeto01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imd0409.projeto01.model.Fabricante;
import com.imd0409.projeto01.model.Vacina;
import com.imd0409.projeto01.service.FabricanteService;
import com.imd0409.projeto01.service.VacinaService;

@Controller
@RequestMapping("/vacina")
public class VacinaController {
    
    @Autowired
    @Qualifier("vacinaServiceImpl")
    VacinaService vacinaService;

    @Autowired
    @Qualifier("fabricanteServiceImpl")
    FabricanteService fabricanteService;

    @GetMapping("/listarVacinas")
    public String showVacinas(){
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
    public String showFormVacina(@ModelAttribute("vacina") Vacina vacina,  Model model){

        vacinaService.salvarVacina(vacina);
        // save de fabricante_vacina
        model.addAttribute("vacina", vacina);
        return "redirect:/vacina/getListaVacina";
    }

    @GetMapping("/getListaVacina")
    public String showListaVacina(Model model){

        List<Vacina> vacinas = vacinaService.getListaVacina();
        model.addAttribute("vacinas", vacinas);
        return "vacina/listaVacinas";

    }

    // editar

    // excluir

}
