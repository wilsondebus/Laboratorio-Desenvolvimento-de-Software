CREATE TABLE alunos(
	id INT auto_increment PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade INT,
    curso VARCHAR(50) NOT NULL
);

INSERT INTO alunos(nome, idade, curso)
VALUES 
("João", 20, "Matemática"),
("Maria", 22, "História"),
("Pedro", 21, "Ciência da Computação"),
("Ana", 19, "Biologia"),
("Carlos", 23, "Economia"); 

CREATE TABLE professores(
	id INT auto_increment PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade INT NOT NULL,
    disciplina VARCHAR(50) NOT NULL
); 

INSERT INTO professores(nome, idade, disciplina) 
VALUES 
("Ricardo", 47, "Laboratório de Desenvolvimento"),
("Marcia", 55, "Anatomia"),
("Zamberlam", 53, "Pesquisa e Ordenação"),
("Irene", 39, "Histologia"); 

CREATE TABLE matriculas(
	id INT auto_increment PRIMARY KEY,
    id_aluno INT, 
    id_professor INT,
    data_matricula DATE NOT NULL,
    
    FOREIGN KEY (id_aluno) references alunos(id),
    FOREIGN KEY (id_professor) references professores(id)
);
desc matriculas; 

INSERT INTO matriculas(id_aluno, id_professor, data_matricula)
VALUES 
(1, 1, '2025-01-15'),
(2, 1, '2025-01-15'),
(3, 2, '2023-06-02'),
(4, 3, '2026-02-01'),
(5, 3, '2021-06-03');
