package com.imd0409.vacinacaobovino.rest.dto;

import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Data
@NoArgsConstructor
@Builder 
public class PessoaDTO {
    
    private String nome;

    public PessoaDTO(String nome) {
        this.nome = nome;
    }

   
}
