# Back-End Pousada

Projeto back-end para o gerenciamento de uma pousada em Java Spring Boot que segue o padrão de arquitetura de três camadas. É utilizando o banco de dados MySQL. Durante o desenvolvimento os testes foram feitos utilizando HTTP requests com o Insomnia para os endpoints da aplicação. Posteriormente a aplicação foi portada para contêineres Docker para facilitar a implantação e a execução em diferentes ambientes. Em seguida, a API foi documentada utilizando o Swagger, proporcionando uma interface intuitiva para explorar e entender os endpoints, parâmetros e respostas da aplicação, facilitando o desenvolvimento de clientes front-end e integrações de serviços.   

## Pré-requisitos

- Intellij
- Docker

## Configuração do Ambiente de Desenvolvimento

- Executar na raiz do projeto (\pousada>) o seguinte comando para a compilação do projeto e criação da imagem do container com o servidor:

    ```docker build -t pousada-server .```

- Para a build do container com o MySQL e posterior início dos serviços definidos no docker-compose.yml, execute o seguinte comando:

    ```docker-compose up```

- (Opcional) Ver documentação e explorar os endpoints da aplicação com o Swagger. Abrir a Swagger-UI em:

  ```http://localhost:8080/swagger-ui/index.html```

## Modelo entidade relacionamento

Modelo da estrutura e relacionamentos das entidades do banco de dados construído para a aplicação:

![Modelo entidade relacionamento](/src/main/resources/static/mer.png)

## Próximos passos

- Fazer alguns testes unitários.

## Versão da aplicação

Back-End Pousada v1.0.0

## Contato

E-mail: giovanni.tnini@gmail.com

LinkedIn: https://www.linkedin.com/in/giovannitamanini/

