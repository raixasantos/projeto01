package com.imd0409.projeto01.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AplicacaoKey implements Serializable {
    @Column(name = "idVacina")
    private Integer idVacina;

    @Column(name = "idCarteira")
    private Integer idCarteira;

    public AplicacaoKey() {
    }

    public AplicacaoKey(Integer idVacina, Integer idCarteira) {
        this.idVacina = idVacina;
        this.idCarteira = idCarteira;
    }

    public Integer getIdVacina() {
        return this.idVacina;
    }

    public void setIdVacina(Integer idVacina) {
        this.idVacina = idVacina;
    }

    public Integer getIdCarteira() {
        return this.idCarteira;
    }

    public void setIdCarteira(Integer idCarteira) {
        this.idCarteira = idCarteira;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AplicacaoKey)) {
            return false;
        }
        AplicacaoKey aplicacaoKey = (AplicacaoKey) o;
        return Objects.equals(idVacina, aplicacaoKey.idVacina) && Objects.equals(idCarteira, aplicacaoKey.idCarteira);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVacina, idCarteira);
    }
}
