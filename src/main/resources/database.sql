DROP DATABASE IF EXISTS pousada;

CREATE DATABASE pousada;

USE pousada;

CREATE TABLE informacao_pousada (
	nome VARCHAR(45),
    endereco_1 VARCHAR(60),
    endereco_2 VARCHAR(60),
    cep VARCHAR(9),
    telefone VARCHAR(15),
    email VARCHAR(45),
    web_site VARCHAR(100),
    facebook VARCHAR(100),
    instagram VARCHAR(100),
    whatsapp VARCHAR(100)
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

CREATE TABLE acomodacao (
	id INT PRIMARY KEY AUTO_INCREMENT,
	numero INT DEFAULT 0,
    tipo VARCHAR(100) NOT NULL,
    valor_diaria DECIMAL(6,2) NOT NULL,
	descricao_hospedes VARCHAR(50) NOT NULL,
    descricao_camas VARCHAR(50) DEFAULT "-",
    mais_informacoes VARCHAR(1000) NOT NULL,
    amenidades VARCHAR(500) NOT NULL,
	condicoes VARCHAR(200) NOT NULL
);

CREATE TABLE imagem_acomodacao (
	id INT PRIMARY KEY,
    url VARCHAR(255),
    id_acomodacao INT NOT NULL,
    FOREIGN KEY (id_acomodacao) REFERENCES acomodacao(id)
);

CREATE TABLE reserva (
	id INT PRIMARY KEY AUTO_INCREMENT,
    status_reserva VARCHAR(10) DEFAULT "CONFIRMADA",
    data_hora TIMESTAMP NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    check_in DATE NOT NULL,
    check_out DATE NOT NULL,
    numero_dias INT NOT NULL,
    custo DECIMAL(6,2) NOT NULL,
    status_pagamento VARCHAR(30) DEFAULT "PENDENTE",
    id_acomodacao INT NOT NULL,  
    id_hospede INT NOT NULL, 
    FOREIGN KEY (id_acomodacao) REFERENCES acomodacao(id),
    FOREIGN KEY (id_hospede) REFERENCES hospede(id)
);

CREATE TABLE estadia (
	id INT PRIMARY KEY AUTO_INCREMENT,
    status_estadia VARCHAR(15) DEFAULT "EM_ANDAMENTO",
	check_in DATE NOT NULL,
    check_out DATE NOT NULL,
    numero_dias INT NOT NULL,
    custo DECIMAL(6,2) NOT NULL,
    status_pagamento VARCHAR(30) DEFAULT "PENDENTE",
    id_acomodacao INT NOT NULL,
    id_hospede INT NOT NULL,
    id_reserva INT NOT NULL,
    FOREIGN KEY (id_acomodacao) REFERENCES acomodacao(id),
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
