## 📚 Indice (Index)
- [Project Description (En)](#rest-api-test-automation-project-wip)
- [Descrição do Projeto (PtBR)](#projeto-de-automação-de-testes-de-api-rest-em-construção)

# REST API Test Automation Project (WIP)

This project aims to automate tests for public REST APIs using **Java 17**, **Rest Assured**, **Cucumber**, **JUnit**, and **Allure Reports**.

### 🚧 Status: Work in Progress

The project is still under construction and new features are being added.

### 🔧 Technologies Used

- Java 17
- Maven
- Cucumber 7 (BDD)
- Rest Assured 5 (API testing)
- JUnit 5
- Allure (test reporting)

### 📌 Target APIs

- [PokéAPI](https://pokeapi.co) - for testing Pokémon-related endpoints (GET).
- [Reqres.in](https://reqres.in) - for simulating full CRUD operations (POST, PUT, PATCH, DELETE).

### ✅ Current Features

- GET requests to retrieve Pokémon information.
- CRUD tests for user management using Reqres.
- Status code validation (200, 201, 204, etc.).
- Allure reporting integration with Cucumber steps.

### 📂 Project Structure

```txt
src/
└── main/
   ├── java/com.linkedin.eversoncordeiro_da_silva/
   │   ├── app.runners/
   │   │   ├── Cucumber_Test.java
   │   │   └── Run_Test.java
   │   ├── logics/
   │   │   ├── commons/
   │   │   │   ├── Generic_Logic.java
   │   │   │   ├── Helloworld_PtBr_Logic.java
   │   │   │   └── Helloworld_En_Logic.java
   │   ├── steps/
   │   │   ├── app/
   │   │   │   └── Hooks.java
   │   │   └── commons/
   │   │       ├── Generic_Steps.java
   │   │       ├── Helloworld_En_Steps.java
   │   │       └── Helloworld_PtBr_Steps.java
   │   └── utils/
   │       ├── BaseUri.java
   │       ├── Constants.java
   │       ├── Context.java
   │       └── Utils.java
   └── resources/
       ├── features/
       │   ├── helloworld_en.feature
       │   └── helloworld_pt-br.feature
       ├── payloads/
       │   └── request/
       │       ├── trainer_register.json
       │       └── trainer_update.json
       └── response/
           └── response.properties

```
---

### 🇧🇷 **Português (Descrição do Projeto)**


# Projeto de Automação de Testes de API REST (Em Construção)

Este projeto tem como objetivo automatizar testes em APIs públicas REST utilizando **Java 17**, **Rest Assured**, **Cucumber**, **JUnit** e geração de relatórios com **Allure**.

### 🚧 Status: Em Construção

O projeto ainda está em desenvolvimento e novas funcionalidades estão sendo adicionadas.

### 🔧 Tecnologias Utilizadas

- Java 17
- Maven
- Cucumber 7 (BDD)
- Rest Assured 5 (testes de API)
- JUnit 5
- Allure (relatórios de testes)

### 📌 APIs Utilizadas

- [PokéAPI](https://pokeapi.co) - para testes de endpoints de Pokémon (GET).
- [Reqres.in](https://reqres.in) - para simulação de operações CRUD completas (POST, PUT, PATCH, DELETE).

### ✅ Funcionalidades Implementadas

- Requisições GET para consultar informações de Pokémon.
- Testes CRUD de usuários com a API Reqres.
- Validação de códigos de status HTTP (200, 201, 204 etc).
- Integração com Allure para relatórios dos testes.

### 📂 Estrutura do Projeto

```txt
src/
└── main/
   ├── java/com.linkedin.eversoncordeiro_da_silva/
   │   ├── app.runners/
   │   │   ├── Cucumber_Test.java
   │   │   └── Run_Test.java
   │   ├── logics/
   │   │   ├── commons/
   │   │   │   ├── Generic_Logic.java
   │   │   │   ├── Helloworld_PtBr_Logic.java
   │   │   │   └── Helloworld_En_Logic.java
   │   ├── steps/
   │   │   ├── app/
   │   │   │   └── Hooks.java
   │   │   └── commons/
   │   │       ├── Generic_Steps.java
   │   │       ├── Helloworld_En_Steps.java
   │   │       └── Helloworld_PtBr_Steps.java
   │   └── utils/
   │       ├── BaseUri.java
   │       ├── Constants.java
   │       ├── Context.java
   │       └── Utils.java
   └── resources/
       ├── features/
       │   ├── helloworld_en.feature
       │   └── helloworld_pt-br.feature
       ├── payloads/
       │   └── request/
       │       ├── trainer_register.json
       │       └── trainer_update.json
       └── response/
           └── response.properties

```