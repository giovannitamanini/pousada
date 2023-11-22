package com.pousada.domain.entity;

import com.pousada.enums.StatusPagamentoEnum;
import com.pousada.enums.StatusReservaEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity(name = "reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private StatusReservaEnum statusReserva;

    private LocalDateTime dataHora;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private int numeroPernoites;

    private Double custo;

    @Enumerated(EnumType.STRING)
    private StatusPagamentoEnum statusPagamento;

    private int idAcomodacao;

    private int idHospede;

}
