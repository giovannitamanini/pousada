package com.pousada.dto;

import com.pousada.enums.StatusPagamentoEnum;
import com.pousada.enums.StatusReservaEnum;
import com.pousada.enums.TipoReservaEnum;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReservaDTO {

    private int id;

    private StatusReservaEnum statusReserva;

    private LocalDateTime dataHora;

    private TipoReservaEnum tipo;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private int numeroDias;

    private Double custo;

    private StatusPagamentoEnum statusPagamento;

    private int idQuarto;

    private int idHospede;

}
