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

***

## CRUD - REST 

### methods -  uris

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
---

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
