package com.pousada.domain.entity;

import com.pousada.enums.StatusPagamentoEnum;
import com.pousada.enums.StatusReservaEnum;
import com.pousada.enums.TipoReservaEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReserva;

    @Enumerated(EnumType.STRING)
    private StatusReservaEnum statusReserva;

    private LocalDateTime dataHoraReserva;

    @Enumerated(EnumType.STRING)
    private TipoReservaEnum tipoReserva;

    private String nomeFuncionario;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private int numeroDias;

    private Double valorReserva;

    @Enumerated(EnumType.STRING)
    private StatusPagamentoEnum statusPagamento;

    private int numeroQuarto;

    private String cpfHospede;

}
