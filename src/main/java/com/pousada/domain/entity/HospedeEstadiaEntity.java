package com.pousada.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "hospedeEstadia")
public class HospedeEstadiaEntity {

    @EmbeddedId
    private HospedeEstadiaId hospedeEstadiaId;
}
