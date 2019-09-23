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
#### 1 - entrar no console do MySQL.
> mysql -u 'angularjs' -D 'angularjs' -p 'angularjs'
```shell
```
#### 2 - criar database com o nome ```angularjs```
```sql
#mysql>
CREATE DATABASE angularjs;
```
### 3 - criar tabela candidato, com id, nome, endereço e cpf.
```sql
#mysql>
use angularjs;
CREATE TABLE `candidato` (`nome` varchar(255) NOT NULL, `cpf` varchar(14) NOT NULL, `endereco` varchar(255) NOT NULL,`id` int(11) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf-8;
ALTER TABLE `candidato` ADD PRIMARY KEY (`id`);
ALTER TABLE `candidato` MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT
```


criar as 3 tabelas candidato, vaga e empresa.

***
---

# CRUD - methods -  uris

POST - http://localhost:8080/rest-api/vagas
```json
#headers 
{ "Content-type": "application/json" } }

#body
{
"nome":"",
"endereco":"",
"cpf":""
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

>#### listar 
method -  uri

GET - http://localhost:8080/rest-api/vaga

>#### buscar por id 
method -  uri

GET - http://localhost:8080/rest-api/vagas/{id}

>#### deletar
method -  uri

DELETE - http://localhost:8080/rest-api/vagas/{id}


