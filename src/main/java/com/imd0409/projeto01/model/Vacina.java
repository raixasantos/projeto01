package com.imd0409.projeto01.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "fabricante", length = 50)
    private String fabricante;

    @Column(name = "periodoEmDias")
    private int periodoEmDias;

    @Column(name = "quantidadeDeMls")
    private float quantidadeDeMls;

    @Column(name = "informacoesExtras", length = 150)
    private String informacoesExtras;

    @OneToMany(mappedBy = "Vacina", fetch = FetchType.LAZY)
    private Set<Aplicacao> aplicacoes;
    
    public Vacina() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return this.fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getPeriodoEmDias() {
        return this.periodoEmDias;
    }

    public void setPeriodoEmDias(int periodoEmDias) {
        this.periodoEmDias = periodoEmDias;
    }

    public float getQuantidadeDeMls() {
        return this.quantidadeDeMls;
    }

    public void setQuantidadeDeMls(float quantidadeDeMls) {
        this.quantidadeDeMls = quantidadeDeMls;
    }

    public String getInformacoesExtras() {
        return this.informacoesExtras;
    }

    public void setInformacoesExtras(String informacoesExtras) {
        this.informacoesExtras = informacoesExtras;
    }

    public Set<Aplicacao> getAplicacoes() {
        return this.aplicacoes;
    }

    public void setAplicacoes(Set<Aplicacao> aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", fabricante='" + getFabricante() + "'" +
            ", periodoEmDias='" + getPeriodoEmDias() + "'" +
            ", quantidadeDeMls='" + getQuantidadeDeMls() + "'" +
            ", informacoesExtras='" + getInformacoesExtras() + "'" +
            ", aplicacoes='" + getAplicacoes() + "'" +
            "}";
    }
}
