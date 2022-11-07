package com.imd0409.vacinacaobovino.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.imd0409.vacinacaobovino.model.Fabricante;
import com.imd0409.vacinacaobovino.model.Vacina;
import com.imd0409.vacinacaobovino.repository.VacinaRepository;
import com.imd0409.vacinacaobovino.rest.dto.FabricanteDTO;
import com.imd0409.vacinacaobovino.rest.dto.InformacoesVacinaDTO;
import com.imd0409.vacinacaobovino.rest.dto.VacinaDTO;
import com.imd0409.vacinacaobovino.service.FabricanteService;
import com.imd0409.vacinacaobovino.service.VacinaService;

@RestController
@RequestMapping("/vacina")
public class VacinaController {
    
    @Autowired
    @Qualifier("vacinaServiceImpl")
    VacinaService vacinaService;


    @Autowired
    @Qualifier("vacinaRepository")
    VacinaRepository vacinaRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public int save( @RequestBody VacinaDTO dto ){
        Vacina vacina = vacinaService.salvarVacina(dto);
        return vacina.getId();
    }

    @GetMapping("{id}")
    public InformacoesVacinaDTO getVacinaById( @PathVariable Integer id ){
        return (InformacoesVacinaDTO) vacinaService
                .getVacinaById(id)
                .map( p -> converter(p) )
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacina não encontrado."));
    }

    private Object converter(Vacina p) {
        return InformacoesVacinaDTO
                .builder()
                .id(p.getId())
                .nome(p.getNome())
                .informacoesExtras(p.getInformacoesExtras())
                .build();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        vacinaRepository.findById(id)
                .map( vacina -> {
                    vacinaRepository.delete(vacina );
                    return vacina;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Vacina não encontrado") );

    }
}
