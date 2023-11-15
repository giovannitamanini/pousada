package com.pousada.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name = "hospede")
public class HospedeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
