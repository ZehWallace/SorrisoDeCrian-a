﻿---------------------------------------------------------------------------
---------------------------------------------------------------------------
---	Universidade Federal de São Carlos - Campus Sorocaba 		---
---	Bacharelado em Ciência da Computação				---
---	Sorriso de Criança						---
---									---
---		Bruno Pereira						---
---		Celso Araujo Filho					---
---		Cristiano Silva						---
---		Pedro Brito Junior					---
---		Yasmin Beatriz Alves da Silva 				---
---									---
---------------------------------------------------------------------------
---------------------------------------------------------------------------

--criação do banco

--CREATE DATABASE SorrisoDeCrianca;

CREATE TABLE LOGIN 
(
	USUARIO VARCHAR(20) PRIMARY KEY,
	SENHA VARCHAR(20) NOT NULL,
	PRIVILEGIO VARCHAR(5) NOT NULL CHECK (PRIVILEGIO IN ('admin', 'comum'))
);

CREATE TABLE CRIANCA
(
	ID NUMERIC PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(100) NOT NULL,
	DATA_NASCIMENTO DATE NOT NULL,
	RG VARCHAR(9) NOT NULL,
	SEXO VARCHAR (9) NOT NULL CHECK (SEXO IN ('Masculino', 'Feminino')),
	STATUS VARCHAR (7) NOT NULL CHECK (STATUS IN ('Ativo', 'Inativo')),
	ENDERECO VARCHAR(200),
	NOME_RESPONSAVEL VARCHAR(100),
	TEL_CONTATO VARCHAR(11),
	OBSERVACAO VARCHAR(300)
);

CREATE TABLE VOLUNTARIO
(
	ID NUMERIC PRIMARY KEY AUTO_INCREMENT,
	NOME VARCHAR(100) NOT NULL,
	DATA_NASCIMENTO DATE NOT NULL,
	RG VARCHAR(9) NOT NULL,
	CPF VARCHAR(11) NOT NULL,
	SEXO VARCHAR (9) NOT NULL CHECK (SEXO IN ('Masculino', 'Feminino')),
	OCUPACAO VARCHAR(50) NOT NULL,
	ENDERECO VARCHAR(200),
	TEL_CONTATO VARCHAR(11),
	EMAIL VARCHAR(20),
	OBSERVACAO VARCHAR(300)
);

CREATE TABLE PRESENCA
(
	CRIANCA NUMERIC NOT NULL,
	DATA_PRESENCA DATE NOT NULL,
	STATUS VARCHAR (1) NOT NULL CHECK (STATUS IN ('P', 'F')),
	CONSTRAINT FK_CRIANCA FOREIGN KEY (CRIANCA) REFERENCES CRIANCA(ID),
	CONSTRAINT PK_PRESENCA PRIMARY KEY (CRIANCA,DATA_PRESENCA)	
);

-- população para teste

INSERT INTO LOGIN VALUES('admin', 'sysadmin', 'admin');
INSERT INTO LOGIN VALUES('professor', 'professor', 'comum'); 

INSERT INTO CRIANCA (NOME, DATA_NASCIMENTO, RG, SEXO, STATUS, ENDERECO, NOME_RESPONSAVEL, TEL_CONTATO, OBSERVACAO) VALUES('João Paulo', '2008-12-10', '911225341', 'Masculino', 'Ativo', 'Rua 20 de Janeiro, n80', 'Paula Paulo','1598966548', '');
INSERT INTO CRIANCA (NOME, DATA_NASCIMENTO, RG, SEXO, STATUS, ENDERECO, NOME_RESPONSAVEL, TEL_CONTATO, OBSERVACAO) VALUES('Maria Clara', '2007-11-08', '418757896', 'Feminino', 'Ativo', 'Rua 20 de Janeiro, n127', 'Maria Souza','1598276598', '');

INSERT INTO VOLUNTARIO VALUES(0,'Jaqueline Silva', '1990-06-08', '429434121', '42603235800', 'Feminino', 'Professora', 'Av Principal n1187', '1599874561', 'email@email.com', '');

INSERT INTO PRESENCA VALUES(1,'2016-09-14','P');
INSERT INTO PRESENCA VALUES(1,'2016-09-15','F');
INSERT INTO PRESENCA VALUES(1,'2016-09-16','P');
INSERT INTO PRESENCA VALUES(2,'2016-09-14','P');
INSERT INTO PRESENCA VALUES(2,'2016-09-15','P');
INSERT INTO PRESENCA VALUES(2,'2016-09-16','F');

-- criação do usuário do banco

/* CREATE USER sistemasorrisodecrianca WITH PASSWORD 'syssdc';
GRANT SELECT ON LOGIN TO sistemasorrisodecrianca;
GRANT SELECT, INSERT, UPDATE ON CRIANCA TO sistemasorrisodecrianca;
GRANT SELECT, INSERT, UPDATE ON VOLUNTARIO TO sistemasorrisodecrianca;
GRANT SELECT, INSERT ON PRESENCA TO sistemasorrisodecrianca; */

-- h2 cipher user and password

/*user
34z474kw94owc0m4g0trw4xs7ksmbkpc2mtc
senha
57cbggmymby8e2zbpcvu9c742zfke8kqpkw0 ya7xmo23j18gjut1q8az61hcsqg1z46jcjcw */
