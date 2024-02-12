# Anotações Aula 2

- Dependencia de integração com banco de dados:

  - [Spring data jpa(java persistence apis)](https://spring.io/projects/spring-data-jpa)
    - Utiliza o Hibernate por debaixo dos panos
      - Hibernate é um ORM(Object Relation Mapper) pois ele mapeia objetos em tabelas de um banco de dados relacional
  - Instalando as dependências do "spring data jpa" e do postgres

    - Abrindo o arquivo `pom.xml` podemos adicionar de 2 formas:
      - Copiando do site o xml para o arquivo pom EX:

    ```xml
    <!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
    <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.1</version>
    </dependency>
    ```

    - ou com control + shift + p
      - ![rodando comando de buscar dependencias no maven](add-maven-repository-vscode.png)
      - ![buscando organização vscode](add-maven-search-org-vscode.png)
      - ![adicionando postgres](add-maven-pkg-postgres-vscode.png)

## Criando docker compose para postgres:
