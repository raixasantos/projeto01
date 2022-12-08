package com.imd0409.vacinacaobovino.rest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
import com.imd0409.vacinacaobovino.rest.dto.InformacoesFabricanteDTO;
import com.imd0409.vacinacaobovino.rest.dto.InformacoesVacinaDTO;
import com.imd0409.vacinacaobovino.rest.dto.NomeCnpjFabricanteDTO;
import com.imd0409.vacinacaobovino.rest.dto.NovaVacinaDTO;
import com.imd0409.vacinacaobovino.rest.dto.VacinaDTO;
import com.imd0409.vacinacaobovino.rest.dto.VacinasDTO;
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

    @Autowired
    FabricanteService fabricanteService;


    @PostMapping("/adicionarVacina")
    @ResponseStatus(HttpStatus.CREATED)
    public int adicionarVacina( @RequestBody NovaVacinaDTO dto ){
        Vacina vacina = vacinaService.adicionarVacina(dto);
        return vacina.getId();
    }

    @GetMapping("/obterListaVacina")
    public List<VacinaDTO> obterListaVacina(){
        List<Vacina> vacinas = vacinaService.obterListaVacina();
        List<VacinaDTO> vacinasDTO = new ArrayList<VacinaDTO>();
        for (Vacina vacina : vacinas) {
            List<InformacoesFabricanteDTO> fabricantes = new ArrayList<InformacoesFabricanteDTO>();
            for(Fabricante fabricante : vacina.getFabricantes()) {
                fabricantes.add(converterFabricante(fabricante));
            }

            vacinasDTO.add(new VacinaDTO(
                vacina.getNome(), fabricantes, 
                vacina.getPeriodoEmDias(), vacina.getInformacoesExtras()
            ));
        }
        return vacinasDTO;
    }


    private InformacoesFabricanteDTO converterFabricante(Fabricante fabricante) {
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

    private VacinasDTO converterVacinas(List<Vacina> vacinas) {
        return VacinasDTO
            .builder()
            .vacinas(converter(vacinas))
            .build();
    }

    private List<InformacoesVacinaDTO> converter(List<Vacina> vacinas) {
        if(CollectionUtils.isEmpty(vacinas)){
            return Collections.emptyList();
        }
        return vacinas
            .stream()
            .map(
                vacina -> converter(vacina)
            ).collect(Collectors.toList());
    }

    private InformacoesVacinaDTO converter(Vacina vacina) {
        Fabricante fabricanteRecebido = fabricanteService.obterFabricantePorVacinaId(vacina.getId());
        return InformacoesVacinaDTO
                .builder()
                .id(vacina.getId())
                .nome(vacina.getNome())
                .informacoesExtras(vacina.getInformacoesExtras())
                .fabricante(converter(fabricanteRecebido))
                .periodoEmDias(vacina.getPeriodoEmDias())
                .build();
    }

    private NomeCnpjFabricanteDTO converter(Fabricante fabricante) {
        return NomeCnpjFabricanteDTO
            .builder()
            .nome(fabricante.getNome())
            .cnpj(fabricante.getCnpj())
            .build();
    }

    @GetMapping("/obterVacinaPorId/{id}")
    public InformacoesVacinaDTO obterVacinaPorId( @PathVariable Integer id ){
        return (InformacoesVacinaDTO) vacinaService
                .obterVacinaPorId(id)
                .map( p -> converter(p) )
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacina não encontrado."));
    }

    @PatchMapping("/editarVacina/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateVacina(@PathVariable Integer id , @RequestBody VacinaDTO dto){
        vacinaService.editarVacina(id, dto.getNome(), dto.getPeriodoEmDias(),dto.getInformacoesExtras());
    }

    @DeleteMapping("/apagarVacina/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagarVacina( @PathVariable Integer id ){
        vacinaService.apagarVacina(id);
    }

    
}
