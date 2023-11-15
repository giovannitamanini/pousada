package com.pousada.domain.entity;

import com.pousada.enums.StatusPagamentoEnum;
import com.pousada.enums.StatusReservaEnum;
import com.pousada.enums.TipoReservaEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity(name = "reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Enumerated(EnumType.STRING)
    private StatusReservaEnum statusReserva;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private TipoReservaEnum tipo;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private int numeroDias;

    private Double custo;

    @Enumerated(EnumType.STRING)
    private StatusPagamentoEnum statusPagamento;

    private int idAcomodacao;

    private int idHospede;

}
