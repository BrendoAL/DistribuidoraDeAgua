# 🐬API Distribuidora

Esta API foi desenvolvida para gerenciar o estoque de uma distribuidora de água, é possível realizar o cadastro de produtos, clientes e fornecedores, além de editar as informações e controlar as quantidades disponíveis no estoque, a aplicação oferece funcionalidades completas de CRUD (Create, Read, Update, Delete) para todos os registros.

📐## Arquitetura utilizada

Separação em camadas MVC (Controller, Service, Model, Repository e Exceptions)  
Injeção de dependências com Spring

📘## Padrões de projetos utilizados

Repository: utilizado para abstrair a camada de acesso ao banco de dados.
DTO: utilizado para transferir dados entre o frontend e o backend, evitando expor diretamente as entidades JPA.
Service layer: centraliza as regras de negócio e as chamadas ao repositório, separando a lógica de controle da lógica de domínio.

## ✔ Tecnologias e bibliotecas usadas

- Java 23
- Javascript
- Spring Boot 3  
- Spring Data JPA  
- PostgresSQL
- H2 Database  
- JUnit 5  
- Mockito
- Postman
- Docker
- HTML
- CSS

## 🔎Endpoints

`GET /localhost:9090/Menu.html`: endpoint para acessar o menu principal e realizar as outras operações da API.

## 🛠 Execução do projeto

Para executar o projeto, é necessário ter o Java 23,Docker e Docker Compose instalados.

## 🚀 Como usar

📁Clone o repositório:  

git clone https://github.com/BrendoAL/DistribuidoraDeAgua.git

  
Entre na pasta do projeto:  

cd Javagua

  
Execute o comando abaixo para compilar e empacotar o projeto:  

mvn clean package

🐳Execute o docker-compose:

docker-compose up --build

A API estará disponível em `http://localhost:9090/Menu.html`.  

## 📌 Observação

Para cadastrar um produto, é obrigatório ter pelo menos um fornecedor registrado, pois o produto precisa estar vinculado a um fornecedor.

## 🧪Testes unitários

Para rodar os testes unitários, execute o comando abaixo: 

mvn test
