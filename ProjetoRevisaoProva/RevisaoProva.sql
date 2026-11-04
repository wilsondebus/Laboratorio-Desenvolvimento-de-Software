CREATE database RevisaoProva;
show databases;
USE RevisaoProva;

CREATE TABLE Categorias(
	id INT auto_increment PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE Produtos(
	id INT auto_increment PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    preco DOUBLE NOT NULL,
    quantidade INT NOT NULL,
    categoria_id INT,
    
    FOREIGN KEY (categoria_id) references Categorias(id)
);

USE RevisaoProva;

INSERT INTO Categorias (nome)
VALUES ('Eletrônicos');

SELECT * FROM CATEGORIAS;
SELECT * FROM PRODUTOS;
