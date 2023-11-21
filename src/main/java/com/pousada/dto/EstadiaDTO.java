package com.pousada.dto;

import com.pousada.enums.StatusEstadiaEnum;
import com.pousada.enums.StatusPagamentoEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EstadiaDTO {

    private int id;

    private StatusEstadiaEnum statusEstadia;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private int numeroDias;

    private Double custo;

    private StatusPagamentoEnum statusPagamento;

    private int idAcomodacao;

    private int idHospede;

    private int idReserva;

}
