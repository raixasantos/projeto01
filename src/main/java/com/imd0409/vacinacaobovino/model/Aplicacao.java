package com.imd0409.vacinacaobovino.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Aplicacao")
public class Aplicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idCarteira")
    private Carteira carteira;

    @ManyToOne
    @JoinColumn(name = "idVacina")
    private Vacina vacina;

    @Column(name = "dose")
    private Integer dose;

    @Column(name = "data")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    public Aplicacao() {
    }

    public Aplicacao(Vacina vacina, Carteira carteira, Integer dose) {
        this.vacina = vacina;
        this.carteira = carteira;
        this.dose = dose;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Carteira getCarteira() {
        return this.carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public Vacina getVacina() {
        return this.vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Integer getDose() {
        return this.dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", carteira='" + getCarteira() + "'" +
            ", vacina='" + getVacina() + "'" +
            ", dose='" + getDose() + "'" +
            ", data='" + getData() + "'" +
            "}";
    }
}
