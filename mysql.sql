/****
    *
    sudo apt-get install -y mariadb-server
    sudo mysql;
    CREATE DATABASE angularjs;
    CREATE USER 'angularjs'@'localhost' IDENTIFIED BY 'angularjs';
    GRANT ALL PRIVILEGES ON angularjs.* TO 'angularjs'@'localhost';
    FLUSH PRIVILEGES;
    SHOW GRANTS FOR 'angularjs'@'localhost';
    sudo systemctl restart mysql;
    mysql -u angularjs -D angularjs -p
    *
****/

CREATE DATABASE angularjs;

use angularjs;

CREATE TABLE IF NOT EXISTS `empresa` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `cnpj` VARCHAR(45) NULL,
    `razaoSocial` VARCHAR(45) NULL,
    `endereco` VARCHAR(45) NULL,
    `bairro` VARCHAR(45) NULL,
    `uf` VARCHAR(45) NULL,
    `cidade` VARCHAR(45) NULL,
    `cep` VARCHAR(45) NULL,
    `email` VARCHAR(45) NULL,
    `telefone` VARCHAR(45) NULL
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

insert into empresa (id, cnpj, razaoSocial, endereco) values (1,'123456','software4you', 'Rua São Paulo, 886, Jardim da Conquista');
insert into empresa (id, cnpj, razaoSocial, endereco) values (2,'345678','casa do sistema', 'Avenida Paulo Matarazzo, 726, Jardim Virgínia');
insert into empresa (id, cnpj, razaoSocial, endereco) values (3,'234567','tech soft', 'Rua Davina da Silva Rosa Gurgel, 456, Jardim Campos do Conde II');
insert into empresa (id, cnpj, razaoSocial, endereco) values (4,'456789','fabrica soft LDTA', 'Rua Galiléia, 803, Residencial Júlia Caparroz');

insert into vaga (nome, remuneracao, empresa_id) values ('Analista de Sistemas Sr','6200',1);
insert into vaga (nome, remuneracao, empresa_id) values ('Programador Full Stack','7800',1);
insert into vaga (nome, remuneracao, empresa_id) values ('Analista de Sistemas Jr','2800',2);


insert into candidato values (1,'01/01/1991','123456','joão da silva', 'casado', 'masculino', 'Rua São Paulo, 886, Jardim da Conquista');
insert into candidato values (2,'03/03/1993','345678','maria pereira', 'casado', 'feminino', 'Avenida Paulo Matarazzo, 726, Jardim Virgínia');
insert into candidato values (3,'02/02/1994','234567','ana de alencar', 'solteiro', 'feminino', 'Rua Davina da Silva Rosa Gurgel, 456, Jardim Campos do Conde II');
insert into candidato values (4,'02/02/1992','456789','jose de sousa', 'casado', 'masculino', 'Rua Galiléia, 803, Residencial Júlia Caparroz');

insert into experiencia (cargo,funcao,candidato_id) values ('Programador Front End Jr','construcao de aplicacoes web',1);
insert into experiencia (cargo,funcao,candidato_id) values ('Angular Web Developer','desenvolvimento de aplicacoes com angular',1);
insert into experiencia (cargo,funcao,candidato_id) values ('Cientista de Dados','Analise de big data e geracao de relatorios',2);
*/
