package com.pousada.dto;

import lombok.Data;

@Data
public class AcomodacaoDTO {

    private int id;

    private int numero;

    private String tipo;

    private double valorDiaria;

    private String descricaoHospedes;

    private String descricaoCamas;

    private String maisInformacoes;

    private String amenidades;

    private String condicoes;

}
