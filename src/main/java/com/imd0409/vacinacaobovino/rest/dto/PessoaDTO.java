package com.imd0409.vacinacaobovino.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private Integer id;
    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private String cidade;
    private String estado;
    private String cep;
    private String bairro;
    private String rua;
    private String numero;
    
}
