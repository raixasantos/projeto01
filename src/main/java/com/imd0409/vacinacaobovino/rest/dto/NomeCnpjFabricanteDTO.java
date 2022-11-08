package com.imd0409.vacinacaobovino.rest.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class NomeCnpjFabricanteDTO {
    private String nome;
    private String cnpj;    
}
