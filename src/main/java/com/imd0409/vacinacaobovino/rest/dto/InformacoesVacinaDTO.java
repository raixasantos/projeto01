package com.imd0409.vacinacaobovino.rest.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class InformacoesVacinaDTO {
    private Integer id;
    private String nome;
    private NomeCnpjFabricanteDTO fabricante;
    private int periodoEmDias;
    private String informacoesExtras;
}
