package com.imd0409.vacinacaobovino.rest.dto;

import java.util.List;

import lombok.*;

/*
{
    "nome" : "Pfizer",
    "periodoEmDias" : 10,
    "informacoesExtras" : "..."
}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacinaDTO {
    // alterar fabricantes e aplicações para o tipo DTO 
    private String nome;
    private List<InformacoesFabricanteDTO> fabricantes;
    private int periodoEmDias;
    private String informacoesExtras;
}
