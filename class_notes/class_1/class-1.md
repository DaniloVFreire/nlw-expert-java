# Anotações da aula 1

- [instalando requisitos](requirements-instalation.md)
- Inicializando projeto com: [spring initializr](https://start.spring.io/) projeto mantido pelos desenvolvedores do spring
  - Configurações utilizadas:
  - ![Configurações do spring initializer](spring-initializr-config.png)
    - Maven como gerenciador de pacotes
    - Java como linguagem
    - Versão 3.2.2 lts do spring boot
    - Metadados do projeto:
      - Grupo: Geralmente se coloca o domínio da empresa de trás pra frente; EX: site da empresa: rocketseat.com.br, Group: br.com.rocketseat
      - Artifact: Nome do projeto/palavras chaves
      - Name: Mesma coisa do artifact, ao menos que se queira mudar
      - Descrição: a descrição do projeto
      - Package name: Nome final do pacote java que vai ser gerado; EX: no projeto atual temos: com.rocketseat.certification_nlw mas poderiamos omitir o nome sobrando apenas: com.rocketseat o que pode gerar problemas se tivermos vários códigos da mesma organização, geralmente é bom manter o nome completo do pacote
      - Packaging: O tipo de empacotamento; o Jar é um empacotamento padrão que não precisa por padrão de um servidor web para rodar a aplicação, pode ser rodado pela comand line, já o War precisa obrigatoriamente de um servidor para o rodar
        - Antes do spring boot o War sempre era usado para aplicações web, hoje em dia com spring boot da pra se rodar o Jar tanto no serividor quanto pela linha de comando, pois o spring boot cria o jar com um serivdor embedded(java tomcat)
      - Dependencias spring utilizadas:
        - Spring web: Para construir apis restful, mvc e web
        - Spring boot devtools: Para monitorar as alterações no projeto dar live reload
        - Lombok: gera getters e setters automaticamente reduzindo boilerplate
    - Baixar o .zip e descompactar seu conteúdo na pasta do projeto

## Entendendo arquivos do projeto:

- pom.xml: arquivo de configuração do projeto e versões do pacotes
  - Atualizamos a versão`<version>0.0.1-SNAPSHOT</version>` para `<version>1.0.0</version>` pois vamos trabalhar já com um release desse toy project
- mvnw.cmd(windows) e mvnw(unix): Arquivos do mavem que servem para permitir rodar a aplicação sem ter o maven instalado globalmente na nossa máquina
  - Recomendável usar no servidor
  - Não recomendável utilizar no ambiente de desenvolvimento a menos que tenhamos pouca memória e recursos disponíveis
- Help: Documentações padrão e guias
- Gitgnore: documentos que devem ser ignorados pelo git
- Pasta target: arquivo gerado pelo maven após rodar a aplicação como jar e objetos compilados
- pasta src/test: arquivos de teste
- src/main/java/...: arquivos principais do código da aplicação, onde fica o main
- src/resources/application.properties: arquivo de configurações extra do projeto

## Rodando o projeto:

- indo no arquivo que contém a main, no caso: CertificationNlwApplication.java e clicando no icone superior direito de rodar no VSCode![icone no canto superior direito](run-with-vscode-run-java.png) recomendado para debug
  OU
- na aba maven ![abrindo e utilizando a aba maven](install-and-deploy-with-maven.png)
  OU
- Pelo terminal: `mvn spring-boot:run` recomendado para run padrão

## Seguindo o fluxo da aula:

- mudando porta do pojeto de 8080 para 8085 adicionando: server.port=8085 ao application.properties
  - acessando localhost:8085 temos:![Erro ao tentar acessar o recurso não criado "/"](acessing-api-for-the-first-time-error.png)

### MVC(Model View Controller)

- ![alt text](nlw-java-mvc-excalidraw.png)
