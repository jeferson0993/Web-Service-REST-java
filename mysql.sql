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
    `rg` VARCHAR(45) NULL,
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

