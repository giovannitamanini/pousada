package com.pousada.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Setter
@Getter
@Embeddable
public class HospedeEstadiaId implements Serializable {

    @Column(name = "id_hospede")
    private int idHospede;

    @Column(name = "id_estadia")
    private int idEstadia;

}