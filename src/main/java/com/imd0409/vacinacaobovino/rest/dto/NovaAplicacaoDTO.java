package com.imd0409.vacinacaobovino.rest.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class NovaAplicacaoDTO {
    private Integer idCarteira;
    private Integer idVacina;
    private Integer dose;
    private LocalDate data;
}
