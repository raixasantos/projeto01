package com.imd0409.vacinacaobovino.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.server.ResponseStatusException;

import com.imd0409.vacinacaobovino.repository.BovinoRepository;

import com.imd0409.vacinacaobovino.model.Bovino;
import com.imd0409.vacinacaobovino.service.BovinoService;

import com.imd0409.vacinacaobovino.rest.dto.BovinoDTO;

@RequestMapping("/bovino")
@RestController
public class BovinoController {

    @Autowired
    private BovinoRepository bovinos;
     
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
    public Integer showFormBovino(final @RequestBody BovinoDTO bovino){
        return bovinoService.salvarBovino(bovino);
    }

    @GetMapping("/obterListaBovino")
    public List<Bovino> showListaBovino(){
        return bovinoService.getListaBovino();
    }


    @GetMapping("/obterBovinoPorId/{id}")
    public BovinoDTO getById( @PathVariable Integer id ){
        return bovinoService
                .getBovinoById(id)
                .map( p -> converter(p) )
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Bovino não encontrado."));
    }

    private BovinoDTO converter(Bovino bovino){
        return BovinoDTO
                .builder()
                .nome(bovino.getNome())
                .aniversario(bovino.getAniversario())
                .sexo(bovino.getSexo())
                .cor(bovino.getCor())
                .peso(bovino.getPeso())
                .chifre(bovino.getChifre())
                .build();
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

    @PatchMapping("/editarPeso/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePeso(@PathVariable Integer id, @RequestBody BovinoDTO bovinoDTO) {
        Float novoPeso = bovinoDTO.getPeso();
        bovinoService.atualizarPeso(id, novoPeso);
    }

    @PatchMapping("/editarChifre/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateChifre(@PathVariable Integer id, @RequestBody BovinoDTO bovinoDTO) {
        Boolean novoChifre = bovinoDTO.getChifre();
        bovinoService.atualizarChifre(id, novoChifre);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping("/apagarBovino/{id}")
    public void apagarBovino(@PathVariable Integer id){
        bovinos.findById(id)
                .map( bovino -> {
                    bovinos.delete(bovino);
                    return bovino;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Bovino não encontrado") );
    }

    
}