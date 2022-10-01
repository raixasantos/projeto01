package com.imd0409.projeto01.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Aplicacao")
public class Aplicacao {
    @EmbeddedId
    private AplicacaoKey id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "idVacina")
    private Vacina vacina;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "idCarteira")
    private CarteiraVacina carteiraVacina;

    @Column(name = "dose")
    private Integer dose;

    public Aplicacao() {
    }
    public AplicacaoKey getId() {
        return this.id;
    }

    public void setId(AplicacaoKey id) {
        this.id = id;
    }

    public Vacina getVacina() {
        return this.vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public CarteiraVacina getCarteiraVacina() {
        return this.carteiraVacina;
    }

    public void setCarteiraVacina(CarteiraVacina carteiraVacina) {
        this.carteiraVacina = carteiraVacina;
    }

    public Integer getDose() {
        return this.dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", vacina='" + getVacina() + "'" +
            ", carteiraVacina='" + getCarteiraVacina() + "'" +
            ", dose='" + getDose() + "'" +
            "}";
    }
}
