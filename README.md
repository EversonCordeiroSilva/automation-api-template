# REST API Test Automation Project (WIP)

This project aims to automate tests for public REST APIs using **Java 17**, **Rest Assured**, **Cucumber**, **JUnit**, and **Allure Reports**.

### 🚧 Status: Work in Progress

The project is still under construction and new features are being added.

### 🔧 Technologies Used

- Java 17+
- Maven 3+
- Cucumber 6 (Deprecated)
- Rest Assured 5
- JUnit 5
- Allure 2.15.2

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
   │   │   │   └── Generic_Logic.java
   │   │   └── Helloworld_En_Logic.java
   │   ├── steps/
   │   │   ├── app/
   │   │   │   └── Hooks.java
   │   │   ├── commons/
   │   │   │   └── Generic_Steps.java
   │   │   └── Helloworld_En_Steps.java
   │   └── utils/
   │       ├── BaseUri.java
   │       ├── Constants.java
   │       ├── Context.java
   │       └── Utils.java
   └── resources/
       ├── features/
       │   └── helloworld_en.feature
       ├── payloads/
       │   └── request/
       │       ├── trainer_register.json
       │       └── trainer_update.json
       └── response/
           └── response.properties

```
---
![Quality Diagram.drawio.png](Quality%20Diagram.drawio.png)