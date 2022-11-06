package com.imd0409.vacinacaobovino.rest.dto;

import java.util.List;

import com.imd0409.vacinacaobovino.model.Aplicacao;
import com.imd0409.vacinacaobovino.model.Fabricante;

import lombok.*;

/*
{
    "nome" : "Pfizer",
    "periodoEmDias" : 10,
    "informacoesExtras" : "...",
}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacinaDTO {
    private String nome;
    private List<Fabricante> fabricantes;
    private int periodoEmDias;
    private String informacoesExtras;
    private List<Aplicacao> aplicacoes; 
}
