/*
*
sudo apt-get install -y mariadb-server
#comando em linha unica:#
sudo mysql -e "CREATE USER 'angularjs'@'localhost' IDENTIFIED BY 'angularjs';
GRANT ALL PRIVILEGES ON *.angularjs TO 'angularjs'@'localhost';
FLUSH PRIVILEGES;select Host,User from mysql.user;"
*
*/

CREATE DATABASE angularjs;

use angularjs;

CREATE TABLE IF NOT EXISTS `empresa` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `cnpj` VARCHAR(45) NULL,
    `razaoSocial` VARCHAR(45) NULL,
    `endereco` VARCHAR(45) NULL
);

CREATE TABLE IF NOT EXISTS `vaga` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nome` VARCHAR(100) NOT NULL,
    `especificacaoDoCargo` VARCHAR(255) NULL,
    `remuneracao` VARCHAR(20) NULL,
    `valeTransporte` BOOLEAN NULL,
    `valeRefeicao` BOOLEAN NULL,
    `uf` VARCHAR(2) NULL,
    `turno` VARCHAR(20) NULL,
    `formaDeContratacao` VARCHAR(45) NULL,
    `empresa_id` INT NULL,
    FOREIGN KEY (empresa_id) REFERENCES empresa(id)
);   

CREATE TABLE IF NOT EXISTS `candidato` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `dataNascimento` VARCHAR(45) NULL,
    `cpf` VARCHAR(45) NULL,
    `nome` VARCHAR(45) NULL,
    `estadoCivil` VARCHAR(45) NULL,
    `sexo` VARCHAR(45) NULL,
    `endereco` VARCHAR(45) NULL 
);
  
CREATE TABLE IF NOT EXISTS `experiencia` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `cargo` VARCHAR(45) NULL,
    `funcao` VARCHAR(45) NULL,
    `candidato_id` INT NULL,
    FOREIGN KEY (candidato_id) REFERENCES candidato(id)
);

/*INSERTS
insert into candidato values (1,'01/01/1991','123456','joão da silva', 'casado', 'masculino', 'endereco qualquer do joao');
insert into candidato values (2,'03/03/1993','345678','maria pereira', 'casado', 'feminino', 'endereco qualquer da maria');
insert into candidato values (3,'02/02/1994','234567','ana de alencar', 'solteiro', 'feminino', 'endereco qualquer do ana');
insert into candidato values (4,'02/02/1992','456789','jose de sousa', 'casado', 'masculino', 'endereco qualquer do jose');

insert into empresa values (1,'123456','software4you', 'endereco qualquer da software4you');
insert into empresa values (2,'345678','casa do sistema', 'endereco qualquer da casa do sistema');
insert into empresa values (3,'234567','tech soft', 'endereco qualquer tech soft');
insert into empresa values (4,'456789','fabrica soft LDTA', 'endereco qualquer da fabrica soft LDTA');

insert into vaga (nome,remuneracao) values ('Analista de Sistemas Sr','6200');
insert into vaga (nome,remuneracao) values ('Programador Full Stack','7800');
insert into vaga (nome,remuneracao) values ('Analista de Sistemas Jr','2800');

insert into experiencia (cargo,funcao) values ('Programador Front End Jr','construcao de aplicacoes web');
insert into experiencia (cargo,funcao) values ('Angular Web Developer','desenvolvimento de aplicacoes com angular');
insert into experiencia (cargo,funcao) values ('Cientista de Dados','Analise de big data e geracao de relatorios');
*/
