DROP DATABASE IF EXISTS pousada;

CREATE DATABASE pousada;

USE pousada;

CREATE TABLE informacao_pousada (
	nome VARCHAR(45),
    endereco VARCHAR(60),
    telefone VARCHAR(15),
    email VARCHAR(45),
    web_site VARCHAR(100),
    instagram VARCHAR(45)
);

CREATE TABLE hospede (
	id INT PRIMARY KEY AUTO_INCREMENT,
	cpf VARCHAR(14) NOT NULL,
    nome VARCHAR(45) NOT NULL,
    sobrenome VARCHAR(45) NOT NULL,
    data_nascimento DATE NOT NULL,
    email VARCHAR(45) NOT NULL,
	endereco VARCHAR(100) NOT NULL,
    nacionalidade VARCHAR(2) NOT NULL,
    profissao VARCHAR(20) NOT NULL
);

CREATE TABLE quarto (
	id INT PRIMARY KEY,
	numero INT NOT NULL,
	tipo VARCHAR(45) NOT NULL,
	status_quarto VARCHAR(15) NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	valor_diaria DECIMAL(6,2) NOT NULL 
);

CREATE TABLE reserva (
	id INT PRIMARY KEY AUTO_INCREMENT,
    status_reserva VARCHAR(10) NOT NULL,
    data_hora TIMESTAMP NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    check_in DATE NOT NULL,
    check_out DATE NOT NULL,
    numero_dias INT NOT NULL,
    custo DECIMAL(6,2) NOT NULL,
    status_pagamento VARCHAR(30) NOT NULL,
    id_quarto INT NOT NULL,  
    id_hospede INT NOT NULL, 
    FOREIGN KEY (id_quarto) REFERENCES quarto(id),
    FOREIGN KEY (id_hospede) REFERENCES hospede(id)
);

CREATE TABLE estadia (
	id INT PRIMARY KEY AUTO_INCREMENT,
	check_in DATE NOT NULL,
    check_out DATE NOT NULL,
    numero_dias INT NOT NULL,
    custo DECIMAL(6,2) NOT NULL,
    status_pagamento VARCHAR(30) NOT NULL,
    id_quarto INT NOT NULL,
    id_hospede INT NOT NULL,
    id_reserva INT NOT NULL,
    FOREIGN KEY (id_quarto) REFERENCES quarto(id),
    FOREIGN KEY (id_hospede) REFERENCES hospede(id),
	FOREIGN KEY (id_reserva) REFERENCES reserva(id)
);

CREATE TABLE hospede_estadia (
	id_estadia INT NOT NULL,  
    id_hospede INT NOT NULL,  
    FOREIGN KEY (id_estadia) REFERENCES estadia(id),
    FOREIGN KEY (id_hospede) REFERENCES hospede(id)
);

CREATE TABLE servico_pousada (
	id INT PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL
);

CREATE TABLE servico_consumido (
	id INT PRIMARY KEY,
    data_hora TIMESTAMP NOT NULL,
    custo DECIMAL(8,2) NOT NULL,
    id_estadia INT NOT NULL,  
    id_servico_pousada INT NOT NULL,
    FOREIGN KEY (id_estadia) REFERENCES estadia(id),
    FOREIGN KEY (id_servico_pousada) REFERENCES servico_pousada(id)
);
