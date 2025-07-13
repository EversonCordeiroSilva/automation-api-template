#language: pt
  @api @helloworld_pt-br
Funcionalidade: Operações CRUD
  @consulta_pokemon
  Esquema do Cenario: Consultar Pokémon
    Dado eu capturei "<POKEMON>"
    Quando eu envio para a "POKE_API" no endpoint "<METHOD>" "<ENDPOINT>"
    Então espero o <STATUS CODE>
    E valido se o pokémon possui habilidade "overgrow" e se este se encontra na "abilities.ability.name"
    E valido se o pokémon possui habilidade "chlorophyll" e se este se encontra na "abilities.ability.name"
    E valido se o pokémon possui movimento "solar-beam" e se este se encontra na "moves.move.name"
    Exemplos:
      | POKEMON   | METHOD | ENDPOINT                | STATUS CODE |
      | BULBASAUR | GET    | /pokemon/{nome_pokemon} | 200         |

  Esquema do Cenario: Criar usuário
    Dado possuo o "<PAYLOAD>"
    E eu sou cadastrado no "<PAYLOAD>" como "<TRABALHADOR>" no campo "PROFISSÃO"
    Quando eu envio para a "REQRES_API" no endpoint "<METHOD>" "<ENDPOINT>"
    Então espero o <STATUS CODE>
    Exemplos:
      | TRABALHADOR | PAYLOAD          | METHOD | ENDPOINT | STATUS CODE |
      | CLT         | trainer_register | POST   | /users   | 201         |


  Esquema do Cenario: Atualizar usuário com PUT
    Dado possuo o "<PAYLOAD>"
    E eu sou "<USUÁRIO>" com identificador <ID>
    E eu sou cadastrado no "<PAYLOAD>" como "<TRABALHADOR>" no campo "PROFISSÃO"
    Quando eu envio para a "REQRES_API" no endpoint "<METHOD>" "<ENDPOINT>"
    Então espero o <STATUS CODE>
    Exemplos:
      | USUÁRIO | ID | PAYLOAD          | METHOD | ENDPOINT    | STATUS CODE |
      | EVERSON | 2  | trainer_register | PUT    | /users/{id} | 200         |

  Esquema do Cenario: Atualizar usuário com PATCH
    Dado possuo o "<PAYLOAD>"
    E eu sou "<USUÁRIO>" com identificador <ID>
    Quando eu envio para a "REQRES_API" no endpoint "<METHOD>" "<ENDPOINT>"
    Então espero o <STATUS CODE>
    Exemplos:
      | USUÁRIO | ID | PAYLOAD          | METHOD | ENDPOINT    | STATUS CODE |
      | EVERSON | 2  | trainer_register | PUT    | /users/{id} | 200         |

  Esquema do Cenario: Deletar usuário
    Dado eu sou "<USUÁRIO>" com identificador <ID>
    Quando eu envio para a "REQRES_API" no endpoint "<METHOD>" "<ENDPOINT>"
    Então espero o <STATUS CODE>
    Exemplos:
      | USUÁRIO | ID | METHOD | ENDPOINT    | STATUS CODE |
      | EVERSON | 2  | DELETE | /users/{id} | 204         |
