package com.imd0409.vacinacaobovino.rest.dto;

import java.util.List;

import com.imd0409.vacinacaobovino.model.Aplicacao;
import com.imd0409.vacinacaobovino.model.Fabricante;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class InformacoesVacinaDTO {
    private Integer id;
    private String nome;
    private List<Fabricante> fabricantes;
    private int periodoEmDias;
    private String informacoesExtras;
    private List<Aplicacao> aplicacoes; 
}
