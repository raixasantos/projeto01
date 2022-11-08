package com.imd0409.vacinacaobovino.rest.dto;

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
public class NovaVacinaDTO {
    private String nome;
    private int periodoEmDias;
    private String informacoesExtras;
    private Integer idFabricante;
}
