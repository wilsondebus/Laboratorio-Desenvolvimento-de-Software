CREATE database empresa; 
USE empresa;

CREATE TABLE funcionarios(
	id INT PRIMARY KEY auto_increment,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    genero VARCHAR(20) NOT NULL, 
    cargo VARCHAR(30) NOT NULL,
    salario DOUBLE NOT NULL
);

USE empresa;
SELECT * FROM funcionarios;