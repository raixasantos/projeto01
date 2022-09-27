package com.imd0409.projeto01.model.enums;

public enum Sexo {
    FEMALE("Female"),
    MALE("Male");

    private String nome;

    Sexo(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
