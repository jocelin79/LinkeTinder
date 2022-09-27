CREATE TABLE candidato (
id SERIAL PRIMARY KEY,
nome CHARACTER VARYING(50) NOT NULL,
sobrenome CHARACTER VARYING(50) NOT NULL,
data_nascimento DATE NOT NULL,
email CHARACTER VARYING(50) NOT NULL,
cpf CHARACTER VARYING(50) NOT NULL,
pais_onde_reside CHARACTER VARYING(50) NOT NULL,
cep CHARACTER VARYING(50) NOT NULL,
descricao CHARACTER VARYING(200),
senha CHARACTER VARYING(11) NOT NULL
);

CREATE TABLE empresa (
id SERIAL PRIMARY KEY,
nome CHARACTER VARYING(50) NOT NULL,
cnpj CHARACTER VARYING(50) NOT NULL,
email CHARACTER VARYING(50) NOT NULL,
pais_onde_reside CHARACTER VARYING(50) NOT NULL,
cep CHARACTER VARYING(50) NOT NULL,
descricao CHARACTER VARYING(200),
senha CHARACTER VARYING(22) NOT NULL
);

CREATE TABLE competencia (
id SERIAL PRIMARY KEY,
descricao CHARACTER VARYING(200) NOT NULL
);

CREATE TABLE vaga (
id SERIAL PRIMARY KEY,
descricao CHARACTER VARYING(200) NOT NULL,
local_da_vaga CHARACTER VARYING(200) NOT NULL,
idEmpresa INT REFERENCES empresa(id) NOT NULL
);

CREATE TABLE candidato_competencia(
id SERIAL PRIMARY KEY,
idCandidato INT REFERENCES candidato(id) NOT NULL,
idCompetencia INT REFERENCES competencia(id) NOT NULL
);

CREATE TABLE empresa_competencia(
id SERIAL PRIMARY KEY,
idVaga INT REFERENCES vaga(id) NOT NULL,
idCompetencia INT REFERENCES competencia(id) NOT NULL
);


INSERT INTO competencia (descricao) VALUES ('java');
INSERT INTO competencia (descricao) VALUES ('groovy');
INSERT INTO competencia (descricao) VALUES ('angular');
INSERT INTO competencia (descricao) VALUES ('mysql');

INSERT INTO candidato (nome, sobrenome, data_nascimento, email, cpf, pais_onde_reside, cep, descricao, senha) VALUES ('Mario', 'Coin', '1996-09-26', 'mario@nintendo.com', '11122233345', 'Brasil', '99090900', 'jogador de LOL', 'mario123');
INSERT INTO candidato (nome, sobrenome, data_nascimento, email, cpf, pais_onde_reside, cep, descricao, senha) VALUES ('Luigi', 'Coin', '1995-08-25', 'luigi@nintendo.com', '22334456', 'Brasil', '88080800', 'jogador de Valorant', 'luigi123');
INSERT INTO candidato (nome, sobrenome, data_nascimento, email, cpf, pais_onde_reside, cep, descricao, senha) VALUES ('Peach', 'Princess', '1994-07-24', 'peach@nintendo.com', '33344455567', 'Argentina', '77070700', 'jogadora de Runeterra', 'peach123');
INSERT INTO candidato (nome, sobrenome, data_nascimento, email, cpf, pais_onde_reside, cep, descricao, senha) VALUES ('Bowser', 'Koopa', '1993-06-23', 'bowser@nintendo.com', '44455566678', 'China', '66060600', 'jogador de Free Fire', 'bowser123');
INSERT INTO candidato (nome, sobrenome, data_nascimento, email, cpf, pais_onde_reside, cep, descricao, senha) VALUES ('Yoshi', 'Dino', '1992-05-22', 'yoshi@nintendo.com', '55566677789', 'Paraguai', '55050500', '', 'yoshi123');

INSERT INTO empresa (nome, cnpj, email, pais_onde_reside, cep, descricao, senha) VALUES ('Espetos', '11111111111111', 'espetos@zmail.com', 'Brasil', '11010100', 'Temos os melhores espetinhos.', 'espetos123');
INSERT INTO empresa (nome, cnpj, email, pais_onde_reside, cep, descricao, senha) VALUES ('Pasteis', '22222222222222', 'pasteis@zmail.com', 'Brasil', '22020200', 'Temos os melhores pasteis.', 'pasteis123');
INSERT INTO empresa (nome, cnpj, email, pais_onde_reside, cep, descricao, senha) VALUES ('Sopas', '33333333333333', 'sopas@zmail.com', 'Peru', '33030300', 'Temos as melhores sopas.', 'sopas123');
INSERT INTO empresa (nome, cnpj, email, pais_onde_reside, cep, descricao, senha) VALUES ('Tortas', '44444444444444', 'tortas@zmail.com', 'Equador', '44040400', 'Temos as melhores tortas.', 'tortas123');
INSERT INTO empresa (nome, cnpj, email, pais_onde_reside, cep, descricao, senha) VALUES ('Driks', '55555555555555', 'driks@zmail.com', 'Chile', '55050500', '', 'drinks123');
