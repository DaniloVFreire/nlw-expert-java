# Instalação de requisitos windows

## Java 17:

- Fazer o download do Java no link abaixo: https://download.oracle.com/java/17/archive/jdk-17.0.6_windows-x64_bin.msi
- Acessar o diretório C:\Arquivo de Programas\Java\jdk-17 e verificar se a pasta está instalada corretamente
- Adicionar uma nova variável de ambiente:
  - Nome da variável: JAVA_HOME
  - Valor da variável: C:\Arquivo De Programas\jdk-17
- Adicionar variável de ambiente path:
  - %JAVA_HOME%\bin
- Testar no terminal:

```bash
java -version
```

## Maven:

- Baixar o bin zipado em:
  - [Downloading Apache Maven](https://maven.apache.org/download.cgi)
- Descompactar o zip numa pasta nova maven em C:\maven\
- Adicionar a variável de ambiente PATH: C:\maven\bin
- Testar no terminal:

```bash
mvn -version
```

## instalar extensões vscode:

- vscjava.vscode-java-pack
- vscjava.vscode-java-debug
- vscjava.vscode-java-test
- vscjava.vscode-java-dependency
- vscjava.vscode-maven
- redhat.java
- vscjava.vscode-spring-initializr
- vmware.vscode-spring-boot
- vscjava.vscode-spring-boot-dashboard

## Usar um Rest Client:

- Utilizado: [Httpie](https://httpie.io/desktop)
  - [Httpie web app](https://httpie.io/app)
- Opções alternativas:
  - [API Dog](https://apidog.com/download/)
  - [Insomnia](https://insomnia.rest/download)
  - [Postman](https://www.postman.com/downloads/)

## Docker:

Seguir o [Install Docker Desktop on Windows](https://docs.docker.com/docker-for-windows/install/)
