# REST API Test Automation Project (WIP)

This project automates tests for public REST APIs using Java, Rest Assured, Cucumber, JUnit and Allure.

Status: Work in Progress

Technologies
- Java 25+
- Maven 3+
- Cucumber 6 (deprecated — consider upgrading)
- Rest Assured 5
- JUnit 5
- Allure 2.15.2

Target API
- [Fake Store API](https://fakeapi.platzi.com/en/about/introduction/) - a sample store API for testing.

Current Features
- Login with valid and invalid users
- Status code validations (200, 201, 204, etc.)
- Validates presence of a Bearer token in responses
- Allure reporting integrated with Cucumber

Next Steps
- Test Bearer token across other endpoints
- CRUD tests
- Permissions tests
- Focus on user-critical features
- Other minor, non-user-facing improvements

Notes
- If you need wider compatibility, consider documenting a minimum supported Java version (for example: Java 17+).
- Update Cucumber to a maintained version when feasible.

### 📂 Project Structure

```txt
src/
└── test/
   ├── java/com.linkedin.eversoncordeiro_da_silva/
   │   ├── app.runners/
   │   │   ├── RunCucumberTest.java
   │   ├── logics/
   │   │   ├── requests/
   │   │   │   ├── login
   │   │   │   │    ├── LoginRequest.java
   │   │   │   │    └── Payload.java
   │   │   │   └── MyRequest.java
   │   │   └── Login_Logic.java
   │   ├── steps/
   │   │   ├── environment/
   │   │   │   └── Hooks.java
   │   │   └── Login_Steps.java
   │   └── utils/
   │       ├── Context.java
   │       └── Utils.java
   └── resources/
       ├── features/
       │   └── Login.feature
       ├── payloads/
       │   └── login.json
       ├── allure/
       │   └── categories.json
       └── allure.properties

```