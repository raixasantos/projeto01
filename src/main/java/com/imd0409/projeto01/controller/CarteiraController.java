package com.imd0409.projeto01.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imd0409.projeto01.model.Carteira;
import com.imd0409.projeto01.service.CarteiraService;

@Controller
@RequestMapping("/carteira")
public class CarteiraController {
    @Autowired
    @Qualifier("carteiraServiceImpl")
    CarteiraService carteiraService;

    @RequestMapping("/getCarteira/{id}")
    public String showListaCarteira(@PathVariable Integer id, Model model){
        
        Optional<Carteira> carteira = carteiraService.getCarteiraByIdBovino(id);
        model.addAttribute("carteira", carteira);
        return "bovino/carteiraVacinacao";
    }

    
}
