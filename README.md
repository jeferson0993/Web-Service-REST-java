# Web Service REST em java

>O projeto consiste em um web service desenvolvido com java e com persistencia de dados em MySql. Este web service recebe e envia dados em formato json.

#### Tecnologias utilizadas:
* Java
* Jersey
* JSON
* XML
* Maven
* MySql
* SQL
* GlassFish
* GIT

# setup do projeto
## banco de dados
```shell
sudo mysql -e "CREATE USER 'angularjs'@'localhost' IDENTIFIED BY 'angularjs'; \
GRANT ALL PRIVILEGES ON *.angularjs TO 'angularjs'@'localhost'; \
FLUSH PRIVILEGES; \
select Host,User,authentication_string from mysql.user;"
```

#### - MySQL.
```shell
mysql -u angularjs -p
```

#### - criar database com o nome ```angularjs```
```sql
#mysql>
CREATE DATABASE angularjs;
```
### - criar tabela candidato, empresa e vaga.
```sql
#mysql>
use angularjs;
CREATE TABLE `candidato` (`nome` varchar(255) NOT NULL, `cpf` varchar(14) NOT NULL, `dataNascimento` varchar(255) NOT NULL,`id` int(11) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `candidato` ADD PRIMARY KEY (`id`);
ALTER TABLE `candidato` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT;

CREATE TABLE `empresa` (`razaoSocial` varchar(255) NOT NULL, `cnpj` varchar(21) NOT NULL, `endereco` varchar(255) NOT NULL,`id` int(11) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `empresa` ADD PRIMARY KEY (`id`);
ALTER TABLE `empresa` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT;

CREATE TABLE `vaga` (`nome` varchar(255) NOT NULL,`id` int(11) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE `vaga` ADD PRIMARY KEY (`id`);
ALTER TABLE `vaga` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT;
```

***

# CRUD - methods -  uris

POST - http://localhost:8080/rest-api/candidatos
```json
#headers 
{ "Content-type": "application/json" } }

#body
{
"nome":"joao da silva",
"dataNascimento":"21-01-1949",
"cpf":"9876543"
}
```
>#### atualizar 
method -  uri


PUT -  http://localhost:8080/rest-api/vagas/{id}
```json
#headers 
{ "Content-type": "application/json" }

#body
{
"nome":"",
"endereco":"",
"cpf":""
}
```

***
***

>#### listar 
method -  uri

GET - http://localhost:8080/rest-api/vagas

>#### buscar por id 
method -  uri

GET - http://localhost:8080/rest-api/vagas/{id}

>#### adicionar
method -  uri

POST -  http://localhost:8080/rest-api/vagas

>#### deletar
method -  uri

DELETE - http://localhost:8080/rest-api/vagas/{id}

>#### update
method -  uri

PUT - http://localhost:8080/rest-api/vagas/{id}