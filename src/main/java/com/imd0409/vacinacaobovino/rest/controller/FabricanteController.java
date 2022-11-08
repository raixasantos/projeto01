package com.imd0409.vacinacaobovino.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.imd0409.vacinacaobovino.model.Fabricante;
import com.imd0409.vacinacaobovino.repository.FabricanteRepository;
import com.imd0409.vacinacaobovino.rest.dto.FabricanteDTO;
import com.imd0409.vacinacaobovino.rest.dto.InformacoesFabricanteDTO;
import com.imd0409.vacinacaobovino.service.FabricanteService;


@RestController
@RequestMapping("/fabricante")
public class FabricanteController {
    
    @Autowired
    @Qualifier("fabricanteServiceImpl")
    FabricanteService fabricanteService;

    @Autowired
    FabricanteRepository fabricanteRepository;

    @PostMapping("/adicionarFabricante")
    @ResponseStatus(HttpStatus.CREATED)
    public int adicionarFabricante( @RequestBody FabricanteDTO dto ){
        Fabricante fabricante = fabricanteService.adicionarFabricante(dto);
        return fabricante.getId();
    }

    @GetMapping("/obterFabricantePorId/{id}")
    public InformacoesFabricanteDTO obterFabricantePorId( @PathVariable Integer id ){
        return fabricanteService
                .obterFabricantePorId(id)
                .map( p -> converter(p) )
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Fabricante não encontrado."));
    }

    private InformacoesFabricanteDTO converter(Fabricante fabricante) {
        return InformacoesFabricanteDTO
                .builder()
                .id(fabricante.getId())
                .nome(fabricante.getNome())
                .ddg(fabricante.getDdg())
                .cnpj(fabricante.getCnpj())
                .nacionalidadeIndustria(fabricante.getNacionalidadeIndustria())
                .cidade(fabricante.getCidade())
                .estado(fabricante.getEstado())
                .cep(fabricante.getCep())
                .bairro(fabricante.getBairro())
                .rua(fabricante.getRua())
                .numero(fabricante.getNumero())
                .build();
    }

    @PutMapping("/editarFabricante/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editarFabricante(@PathVariable Integer id ,
                             @RequestBody FabricanteDTO dto){
        fabricanteService.editarFabricante(id, dto.getNome(), dto.getDdg(), dto.getCnpj(), null, dto.getCidade(), dto.getEstado(), dto.getCep(), dto.getBairro(), dto.getRua(), dto.getNumero());
    }

    @DeleteMapping("/apagarFabricante/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagarFabricante( @PathVariable Integer id ){
        fabricanteService.apagarFabricante(id);
    }
}
