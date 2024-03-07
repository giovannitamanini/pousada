# Back-End Pousada

Projeto back-end em Java Spring Boot para o gerenciamento de uma pousada. Segue o padrão de arqutetura MVC. Os testes foram feitos utilizando HTTP requests com o Insomnia para os End-points da aplicação. 

## Pré-requisitos

- Intellij
- Java (build 17.0.9+11-LTS-201)
- Spring Boot (3.1.5) + dependências (vide pom.xml)
- Docker

## Configuração do Ambiente de Desenvolvimento

- Depois de feito o download das dependências com o Maven siga os passos abaixo:  


- Para ambiente de desenvolvimento, utilizar em application.properties o seguinte:

  ```spring.sql.init.mode=always```

  Se for utilizar o perfil de testes manter:

  ```spring.sql.init.mode=never```

  Assim, os scripts para o banco de dados MySQL do ambiente de desenvolvimento não serão executados.  

    
- Se for preciso, altere o valor do parâmetro ports no docker-compose.yml de 3308:3306 para alguma porta ainda não utilizada XXXX:3306
    - O mesmo valor modificado anteriormente em docker-compose.yml, deve ser especificado em application.properties em :
    ```spring.datasource.url=jdbc:mysql://localhost:XXXX/```  


- Executar na raiz do projeto (\pousada>) os seguintes comandos para construção do container e inicialização do MySQL:

    ```docker-compose build```

    ```docker-compose up```


- Iniciar a aplicação Spring Boot


- (Opcional) Ver documentação e fazer testes com a aplicação utilizando o Swagger. Abrir a Swagger-UI em:

  ```http://localhost:8080/swagger-ui/index.html```

## Modelo entidade relacionamento

Modelo da estrutura e relacionamentos das entidades do banco de dados construído para a aplicação:

![Modelo entidade relacionamento](/src/main/resources/static/mer.png)

## Próximos passos

- Fazer alguns testes unitários.
- Dockerizar completamente a aplicação.

## Versão da aplicação

Back-End Pousada v1.0.0

## Contato

E-mail: giovanni.tnini@gmail.com

LinkedIn: https://www.linkedin.com/in/giovannitamanini/

