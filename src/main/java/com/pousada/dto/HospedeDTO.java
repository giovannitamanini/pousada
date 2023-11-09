package com.pousada.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HospedeDTO {

    private int id;

    private String cpf;

    private String nome;

    private String sobrenome;

    private LocalDate dataNascimento;

    private String email;

    private String endereco;

    private String nacionalidade;

    private String profissao;

}
