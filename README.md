# Back-End Pousada

Projeto back-end em Java Spring Boot para o gerenciamento de uma pousada. Segue o padrão de arqutetura MVC. Os testes foram feitos utilizando HTTP requests com o Insomnia para os End-points da aplicação. 

## Pré-requisitos

- Intellij
- Java (build 17.0.9+11-LTS-201)
- Spring Boot (3.1.5) + dependências (vide pom.xml)
- Docker

## Configuração do Ambiente de Desenvolvimento

- Depois de feito o download das dependências com o Maven, siga os seguintes passos:

    - Se for preciso, altere o valor do parâmetro ports no docker-compose.yml de 3308:3306 para alguma porta ainda não utilizada XXXX:3306
    - O mesmo valor modificado anteriormente em docker-compose.yml, deve ser especificado em application.properties em :
    ```spring.datasource.url=jdbc:mysql://localhost:XXXX/```

- Executar na raiz do projeto (\pousada>) os seguintes comandos para configuração e criação do banco de dados:

    ```docker-compose build```

    ```docker-compose up```

- Iniciar a aplicação

## Modelo entidade relacionamento

Modelo da estrutura e relacionamentos das entidades do banco de dados construído para a aplicação:

![Modelo entidade relacionamento](/src/main/resources/static/mer.png)

## Próximos passos

- Dockerizar completamente a aplicação.
- Testar endpoints com o Swagger
- Testes unitários.

## Versão da aplicação

Back-End Pousada v1.0.0

## Contato

E-mail: giovanni.tnini@gmail.com

LinkedIn: https://www.linkedin.com/in/giovannitamanini/

