package com.imd0409.vacinacaobovino.rest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class AplicacoesDTO {
    private List<InformacoesAplicacaoDTO> aplicacoes;
}
