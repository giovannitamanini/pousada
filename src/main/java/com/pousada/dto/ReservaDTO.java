package com.pousada.dto;

import com.pousada.enums.StatusPagamentoEnum;
import com.pousada.enums.StatusReservaEnum;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReservaDTO {

    private int id;

    private StatusReservaEnum statusReserva = StatusReservaEnum.EM_ESPERA;

    private LocalDateTime dataHora = LocalDateTime.now();

    private LocalDate checkIn;

    private LocalDate checkOut;

    private int numeroPernoites;

    private Double custo;

    private StatusPagamentoEnum statusPagamento = StatusPagamentoEnum.PENDENTE;

    private int idAcomodacao;

    private int idHospede;

}
