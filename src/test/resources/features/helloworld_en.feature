#language: en
@allure.label.epic:Api
@allure.label.parentSuite:Cucumber
@allure.label.subSuite:Helloworld
@api @helloworld_en
Feature: CRUD Operations
  Example feature for API automation development in JAVA

  @consultation
  @SEVERITY:critical
  Scenario Outline: Consult Pokémon
    Given I captured "<POKEMON>"
    When I send to the "POKE_API" on the endpoint "<METHOD>" "<ENDPOINT>"
    Then I expect the <STATUS CODE>
    And I validate if the Pokémon has the ability "overgrow" and if it is found in "abilities.ability.name"
    And I validate if the Pokémon has the ability "chlorophyll" and if it is found in "abilities.ability.name"
    And I validate if the Pokémon has the move "solar-beam" and if it is found in "moves.move.name"
    Examples:
      | POKEMON   | METHOD | ENDPOINT                | STATUS CODE |
      | BULBASAUR | GET    | /pokemon/{pokemon_name} | 200         |

  @create
  @SEVERITY:critical
  Scenario Outline: Create user
    Given I have the "<PAYLOAD>"
    And I am registered in "<PAYLOAD>" as "<WORKER>" in the field "PROFESSION"
    When I send to the "REQRES_API" on the endpoint "<METHOD>" "<ENDPOINT>"
    Then I expect the <STATUS CODE>
    Examples:
      | WORKER    | PAYLOAD          | METHOD | ENDPOINT | STATUS CODE |
      | CLT       | trainer_register | POST   | /users   | 201         |

  @update
  @SEVERITY:high
  Scenario Outline: Update user with PUT
    Given I have the "<PAYLOAD>"
    And I am "<USER>" with identifier <ID>
    And I am registered in "<PAYLOAD>" as "<WORKER>" in the field "PROFESSION"
    When I send to the "REQRES_API" on the endpoint "<METHOD>" "<ENDPOINT>"
    Then I expect the <STATUS CODE>
    Examples:
      | USER    | ID | PAYLOAD          | METHOD | ENDPOINT    | STATUS CODE |
      | EVERSON | 2  | trainer_register | PUT    | /users/{id} | 200         |

  @update
  @SEVERITY:high
  Scenario Outline: Update user with PATCH
    Given I have the "<PAYLOAD>"
    And I am "<USER>" with identifier <ID>
    When I send to the "REQRES_API" on the endpoint "<METHOD>" "<ENDPOINT>"
    Then I expect the <STATUS CODE>
    Examples:
      | USER    | ID | PAYLOAD        | METHOD | ENDPOINT    | STATUS CODE |
      | EVERSON | 2  | trainer_update | PATCH  | /users/{id} | 200         |

  @delete
  @SEVERITY:normal
  Scenario Outline: Delete user
    Given I am "<USER>" with identifier <ID>
    When I send to the "REQRES_API" on the endpoint "<METHOD>" "<ENDPOINT>"
    Then I expect the <STATUS CODE>
    Examples:
      | USER    | ID | METHOD | ENDPOINT    | STATUS CODE |
      | EVERSON | 2  | DELETE | /users/{id} | 204         |
