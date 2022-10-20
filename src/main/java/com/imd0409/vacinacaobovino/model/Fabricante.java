package com.imd0409.vacinacaobovino.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Fabricante")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "ddg", length = 11)
    private String ddg;

    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Column(name = "nacionalidadeIndustria", length = 50)
    private String nacionalidadeIndustria;

    //Endereço
    @Column(name = "cidade", length = 50)
    private String cidade;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "cep", length = 50)
    private String cep;

    @Column(name = "bairro", length = 50)
    private String bairro;

    @Column(name = "rua", length = 50)
    private String rua;

    @Column(name = "numero", length = 50)
    private String numero;

    @ManyToMany
    @JoinTable(
        name = "fabricanteVacina", 
        joinColumns = @JoinColumn(name = "idFabricante"), 
        inverseJoinColumns = @JoinColumn(name = "idVacina"))
    private List<Vacina> vacinas;

    public Fabricante() {
    }

    public Fabricante(String nome, String ddg, String cnpj, String nacionalidadeIndustria, String cidade, String estado, String cep, String bairro, String rua, String numero) {
        this.nome = nome;
        this.ddg = ddg;
        this.cnpj = cnpj;
        this.nacionalidadeIndustria = nacionalidadeIndustria;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDdg() {
        return this.ddg;
    }

    public void setDdg(String ddg) {
        this.ddg = ddg;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNacionalidadeIndustria() {
        return this.nacionalidadeIndustria;
    }

    public void setNacionalidadeIndustria(String nacionalidadeIndustria) {
        this.nacionalidadeIndustria = nacionalidadeIndustria;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Vacina> getVacinas() {
        return this.vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", ddg='" + getDdg() + "'" +
            ", cnpj='" + getCnpj() + "'" +
            ", nacionalidadeIndustria='" + getNacionalidadeIndustria() + "'" +
            ", cidade='" + getCidade() + "'" +
            ", estado='" + getEstado() + "'" +
            ", cep='" + getCep() + "'" +
            ", bairro='" + getBairro() + "'" +
            ", rua='" + getRua() + "'" +
            ", numero='" + getNumero() + "'" +
            ", vacinas='" + getVacinas() + "'" +
            "}";
    }
}
