package com.imd0409.projeto01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.imd0409.projeto01.model.Carteira;

@Service
public interface CarteiraService {
    
    public List<Carteira> getListaCarteira();
    public Carteira salvarCarteira(Carteira carteira);
    public Optional<Carteira> getCarteiraById(Integer id);
}
