package com.imd0409.vacinacaobovino.rest.dto;

import lombok.*;

/*
{
    "nome" : "Oxford",
    "ddg" : "000",
    "cnpj" : "000",
    "nacionalidadeIndustria" : "Inglesa",
    "cidade" : "Natal",
    "estado" : "RN",
    "cep" : "00000-000",
    "bairro" : "Lagoa Nova",
    "rua" : "Rua Maria",
    "numero" : "1",
}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FabricanteDTO {
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
