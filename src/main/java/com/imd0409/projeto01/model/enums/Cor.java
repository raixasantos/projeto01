package com.imd0409.projeto01.model.enums;

public enum Cor {
    MOURACLARA("mouraclara"),
    MOURAESCURO("mouraescuro"),
    VERMELHOCHITADO("vermelhochitado"),
    CHITACLARO("chitaclaro"),
    VERMELHAGARGANTILHA("vermelhagargantilha"),
    VERMELHO("vermelho"),
    AMARELO("amarelo"),
    CHITADACLARA("chitadaclara"),
    AMARELAGARGANTILHA("amarelagargantilha"),
    ROSILHACLARA("rosilhaclara"),
    AMARELACHITADA("amarelachitada"),
    LARANJA("laranja"),
    PRETO("preto"),
    BRANCO("branco"),
    OUTRAS("outras");

    private String nome;

    Cor(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
