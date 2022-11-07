package com.imd0409.vacinacaobovino.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 
public class PessoaDTO {

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
