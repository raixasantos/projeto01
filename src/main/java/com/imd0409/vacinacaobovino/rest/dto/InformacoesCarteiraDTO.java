package com.imd0409.vacinacaobovino.rest.dto;

// import java.util.List;

// import com.imd0409.vacinacaobovino.model.Aplicacao;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class InformacoesCarteiraDTO {
    private Integer id;
    private BovinoDTO bovino;
    // private List<Aplicacao> aplicacoes; // substituir por DTO
}
