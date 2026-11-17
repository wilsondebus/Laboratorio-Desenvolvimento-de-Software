CREATE database ClienteServidor;

USE ClienteServidor;

CREATE TABLE pessoa(
	id INT auto_increment PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sexo VARCHAR(10),
    idioma VARCHAR(30)
);