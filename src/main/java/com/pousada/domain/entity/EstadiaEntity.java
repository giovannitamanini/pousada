package com.pousada.domain.entity;

import com.pousada.enums.StatusEstadiaEnum;
import com.pousada.enums.StatusPagamentoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name = "estadia")
public class EstadiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private StatusEstadiaEnum statusEstadia;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private int numeroPernoites;

    private Double custo;

    @Enumerated(EnumType.STRING)
    private StatusPagamentoEnum statusPagamento;

    private int idAcomodacao;

    private int idHospede;

    private int idReserva;

}
