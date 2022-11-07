package com.imd0409.vacinacaobovino.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.imd0409.vacinacaobovino.rest.dto.PessoaDTO;

import javax.persistence.Column;

@Entity
@Table(name = "Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "telefone", length = 11)
    private String telefone;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "email", length = 100)
    private String email;

    // Endereço
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

    @Column
    @NotEmpty(message = "{campo.login.obrigatorio}")
    private String login;

    @Column
    @NotEmpty(message = "{campo.senha.obrigatorio}")
    private String senha;
    
    @Column
    private String admin;

    
    public Pessoa() {
    }

    public Pessoa(String nome, String telefone, String cpf, String email, String cidade, String estado, String cep,
            String bairro, String rua, String numero) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
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

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLogin() {
        return this.nome;
    }

    public void setLogin(String nome) {
        this.nome = nome;
    }
    
    public String getSenha() {
        return this.nome;
    }

    public void setSenha(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nome='" + getNome() + "'" +
                ", telefone='" + getTelefone() + "'" +
                ", cpf='" + getCpf() + "'" +
                ", email='" + getEmail() + "'" +
                ", cidade='" + getCidade() + "'" +
                ", estado='" + getEstado() + "'" +
                ", cep='" + getCep() + "'" +
                ", bairro='" + getBairro() + "'" +
                ", rua='" + getRua() + "'" +
                ", numero='" + getNumero() + "'" +
                "}";
    }


}
