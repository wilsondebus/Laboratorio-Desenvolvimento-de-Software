create database BDAula01; 
show databases; 
use BDAula01; 

CREATE TABLE pessoa(
	id int auto_increment PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sexo VARCHAR(1) NOT NULL,
    idioma VARCHAR(10) NOT NULL
);

show tables;
desc pessoa; 

INSERT INTO pessoa(nome, sexo, idioma)
VALUES 
("Ricardo", "M", "Português"),
("Rafael", "M", "Português"),
("Antony", "M", "Francês"),
("Joe", "M", "Espanhol"),
("Mary", "F", "Inglês");
