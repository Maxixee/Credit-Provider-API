# Sistema de provedor de Credito

######  Portugues-Br

---
######  Criada com a versão 17 do Java, Springboot na versão 3.2.6

---

##### Resumo da aplicação
Aplicação criada durante meus estudos sobre comunicação entre microsserviços utilizando RabbitMQ, 
sendo essa feita com base no curso "Microsserviços com Spring e RabbitMQ + AWS" do professor Matheus Pieropan

##### Como executar a aplicação
É necessário ter o Docker instalado para executar a aplicação localmente.
- ```git clone https://github.com/Maxixee/Credit-Provider-API ``` Para clonar o repositório na sua IDE
  - ```docker run -d -p 80:80 --name proposta-web-front matheuspieropan/proposta-web``` Para rodar o front-end do projeto
  - ```docker run --name postgres-container -d -e POSTGRES PASSWORD-123 -e POSTGRES_DB-propostadb -p 5432:5432 postgres``` Para rodar a imagem do banco de dados postgres
  - ```docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management ``` Para rodar o RabbitMQ

- Também é necessário possuir uma conta AWS para poder utilizar o microsserviço notification-app, e inserir a AccessKey e SecretKey no application.properties
do mesmo 

- Realizados estes comandos, basta buildar e executar o backend na sua IDE.

# Documentação

- A API do microsserviço proposal-app foi documentada pelo swagger, a documentação pode ser acessada na URL: 
  - API Propostas: ```http://localhost:8080/swagger-ui/index.html#/```

---

---

# Credit provider system

###### English

---
###### Created with Java version 17, Springboot version 3.2.6

---

##### Application summary
Application created during my studies on communication between microservices using RabbitMQ,
this being based on the course "Microsserviços com Spring e RabbitMQ + AWS" by professor Matheus Pieropan

##### How to run the application
You must have Docker installed to run the application locally.
- ```git clone https://github.com/Maxixee/Credit-Provider-API ``` To clone the repository in your IDE
  - ```docker run -d -p 80:80 --name proposta-web-front matheuspieropan/proposta-web``` To run the project front-end
  - ```docker run --name postgres-container -d -e POSTGRES PASSWORD-123 -e POSTGRES_DB-propostadb -p 5432:5432 postgres``` To run the postgres database image
  - ```docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management ``` To run RabbitMQ

- It's also necessary to have an AWS account to be able to use the notification-app microservice, and insert the AccessKey and SecretKey in the application.properties

- Once these commands have been carried out, simply build and run the backend in your IDE.

# Documentation

- The proposal-app microservice API was documented by swagger, the documentation can be accessed at the URL:
  - API Proposals: ```http://localhost:8080/swagger-ui/index.html#/```






