

# BackEnd (API)

Para executar a API é necessário o Java 11, Gradle 7.0, e uma IDEA (recomendada IntelliJ  IDEA), software de teste de API e ter instalado o PostgreSQL.

- Faça download do projeto: `git clone https://github.com/PedroEmanuelLima/Agenda-de-Tarefas.git`
- Abra em sua IDEA a pasta api do projeto
- Configure o arquivo `application.properties` co caminho `.\API\src\main\resources` com informações de seu banco de dados
- Após a conclusão do build (Manualmente execute em `.\API`  o comando `gradle run`)
- Para testar a aplicação execute a classe _AgendaTarefasApplication_ no caminho `.\API\src\main\java\com\agenda\Agenda_Tarefas`
- Com o servidor executando agota é só testar com algum software de teste (Recomendado o POSTMAN)

## Divisão do projeto

- 1ª Rota: POST `/new_user`

  - Recebe um objeto no corpo no formato

    ```json
    {
        "title": "title",
        "description": "description",
        "remenber": "remenber",
        "completed": "completed",
        "owner": "owner"
    }
    ```

- 2º Rota: POST `login_token`

  - Recebe um objeto no corpo no formato

    ```json
    {
        "id": "id",
        "email": "email",
        "name": "name",
        "token": "token",
        "tasks": "tasks",
        "type": "type"
    }
    ```

- 3º Rota: POST `login`

  - Recebe um objeto no corpo no formato

    ```json
    {
        "email": "email",
        "password": "senha"
    }
    ```

- 4º Rota: POST `new_task`

  - Recebe um objeto no corpo no formato

    ```json
    {
        "title": "title",
        "description": "description",
        "remenber": "remenber",
        "completed": "completed",
        "owner": "owner"
    }
    ```

- 5º Rota: PUT`modifi/{id}`

  - Recebe um objeto no corpo no formato

    - id na url

    ```json
    {
        "title": "title",
        "description": "description",
        "remenber": "remenber"
    }
    ```

- 6º Rota: GET`check_task/{id}`

  - Recebe um objeto no corpo no formato
    - id na url

- 7º Rota: DELETE`delete/{id}`

  - Recebe um objeto no corpo no formato
    - id na url

# FrontEnd

## Como executar:

- Garanta de ter instalado o NodeJS e npm

- Após ter ter o projeto na maquina na pasta `frontend` execute os comandos:
> npm install <br />
> npm start

## Aplicação divida em 5 telas:
- Tela 1: Login `/login`
- Tela 2: Register `/cadastrar`
- Tela 3: Home `/`
- Tela 4: NewTask `/nova_tarefa`
- Tela 5: Detail `/detalhes/{id}`

### Observação:
A aplicação ainda não foi integrada com a API.
