package com.imd0409.vacinacaobovino.rest.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imd0409.vacinacaobovino.model.Aplicacao;
import com.imd0409.vacinacaobovino.model.Vacina;
import com.imd0409.vacinacaobovino.rest.dto.AplicacoesDTO;
import com.imd0409.vacinacaobovino.rest.dto.InformacoesAplicacaoDTO;
import com.imd0409.vacinacaobovino.rest.dto.NovaAplicacaoDTO;
import com.imd0409.vacinacaobovino.rest.dto.VacinaAplicacaoDTO;
import com.imd0409.vacinacaobovino.service.AplicacaoService;
import com.imd0409.vacinacaobovino.service.VacinaService;

@RestController
@RequestMapping("/aplicacao")
public class AplicacaoController {
    @Autowired
    AplicacaoService aplicacaoService;

    @Autowired
    VacinaService vacinaService;

    @PostMapping("/adicionarAplicacao")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer adicionarAplicacao(@RequestBody NovaAplicacaoDTO aplicacao){
        return aplicacaoService.salvarAplicacao(aplicacao);
    }

    @GetMapping("/obterListaAplicacao")
    @ResponseStatus(HttpStatus.FOUND)
    public AplicacoesDTO obterListaAplicacao(){ // adicionar nome do boi
        List<Aplicacao> aplicacoesEncontradas = aplicacaoService.obterListaAplicacao();
        return converterAplicacoes(aplicacoesEncontradas);
    }

    private AplicacoesDTO converterAplicacoes(List<Aplicacao> aplicacoes) {
        return AplicacoesDTO
            .builder()
            .aplicacoes(converter(aplicacoes))
            .build();
    }

    private List<InformacoesAplicacaoDTO> converter(List<Aplicacao> aplicacoes) {
        if(CollectionUtils.isEmpty(aplicacoes)) {
            return Collections.emptyList();
        }
        return aplicacoes
            .stream()
            .map(
                aplicacao -> converter(aplicacao)
            ).collect(Collectors.toList());
    }

    private InformacoesAplicacaoDTO converter(Aplicacao aplicacao) {
        return InformacoesAplicacaoDTO
            .builder()
            .data(aplicacao.getData())
            .dose(aplicacao.getDose())
            .vacina(converter(aplicacao.getVacina()))
            .build();
    }

    private VacinaAplicacaoDTO converter(Vacina vacina) {
        return VacinaAplicacaoDTO
                .builder()
                .nome(vacina.getNome())
                .periodoEmDias(vacina.getPeriodoEmDias())
                .informacoesExtras(vacina.getInformacoesExtras())
                .build();
    }
}
