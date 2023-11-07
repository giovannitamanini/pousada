package com.pousada.dto;

import com.pousada.enums.StatusPagamentoEnum;
import com.pousada.enums.StatusReservaEnum;
import com.pousada.enums.TipoReservaEnum;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReservaDTO {

    private int idReserva;
    private StatusReservaEnum statusReserva;
    private LocalDateTime dataHoraReserva;
    private TipoReservaEnum tipoReserva;
    private String nomeFuncionario;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int numeroDias;
    private Double valorReserva;
    private StatusPagamentoEnum statusPagamento;
    private int numeroQuarto;
    private String cpfHospede;

}
