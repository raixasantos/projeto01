package com.imd0409.vacinacaobovino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imd0409.vacinacaobovino.exception.RegraNegocioException;
import com.imd0409.vacinacaobovino.model.Aplicacao;
import com.imd0409.vacinacaobovino.model.Carteira;
import com.imd0409.vacinacaobovino.model.Vacina;
import com.imd0409.vacinacaobovino.repository.AplicacaoRepository;
import com.imd0409.vacinacaobovino.repository.CarteiraRepository;
import com.imd0409.vacinacaobovino.repository.VacinaRepository;
import com.imd0409.vacinacaobovino.rest.dto.NovaAplicacaoDTO;

@Component
public class AplicacaoServiceImpl implements AplicacaoService {

    @Autowired
    AplicacaoRepository aplicacaoRepository;
    
    @Autowired
    CarteiraService carteiraService;
    
    @Autowired
    VacinaRepository vacinaRepository;

    @Override
    public Integer salvarAplicacao(NovaAplicacaoDTO aplicacao) {
        Integer idCarteiraRecebido = aplicacao.getIdCarteira();
        Carteira carteira = carteiraService.obterCarteira(idCarteiraRecebido);
        
        Integer idVacinaRecebido = aplicacao.getIdVacina();
        Optional<Vacina> vacina = vacinaRepository.findById(idVacinaRecebido);
        Boolean existeVacinaComIdRecebido = !vacina.isEmpty();
        if (!existeVacinaComIdRecebido) {
            throw new RegraNegocioException(
                "Vacina não encontrada!"
            );
        }

        Aplicacao novaAplicacao = new Aplicacao();
        novaAplicacao.setCarteira(carteira);
        novaAplicacao.setData(aplicacao.getData());
        novaAplicacao.setDose(aplicacao.getDose());
        novaAplicacao.setVacina(vacina.get());
        aplicacaoRepository.save(novaAplicacao);
        return novaAplicacao.getId();
    }

    @Override
    public List<Aplicacao> obterListaAplicacao() {
        return aplicacaoRepository.findAll();
    }

}
