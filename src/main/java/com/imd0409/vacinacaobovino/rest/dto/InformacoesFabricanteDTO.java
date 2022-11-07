package com.imd0409.vacinacaobovino.rest.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class InformacoesFabricanteDTO {
    private Integer id;
    private String nome;
    private String ddg;
    private String cnpj;
    private String nacionalidadeIndustria;
    private String cidade;
    private String estado;
    private String cep;
    private String bairro;
    private String rua;
    private String numero;
}
