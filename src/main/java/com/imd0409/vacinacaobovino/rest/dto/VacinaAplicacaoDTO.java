package com.imd0409.vacinacaobovino.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacinaAplicacaoDTO {
    private String nome;
    private int periodoEmDias;
    private String informacoesExtras;
}
