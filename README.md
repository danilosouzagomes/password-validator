# Password Validator

Uma API Web Rest para validação de senhas baseada em múltiplas regras e contruída em Java e Springboot.

## Regras de Validação

Foram adotadas as seguintes regras para validação das senhas:

* Ter nove ou mais caracteres
* Conter pelo menos uma letra maiúscula
* Conter pelo menos uma letra minúscula
* Conter pelo menos um dígito
* Conter pelo menos um dos seguintes caracteres especiais: ! @ # $ % ^ & * ( ) - +
* Não conter caracteres repetidos dentro do mesma senha

Todas essas regras são aplicadas para determinar se uma senha é válida ou não. Caso seja válida, é retornado um boolean true. Caso contrário, se qualquer uma das regras falhe, será retornado false.

Para definição das regras foi adotado um padrão onde para facilitar testes e manutenção, cada regra possui sua classe isolada, o que torna mais simple a criação de novas regras caso seja necessário. 

## Tecnologias

* Java
* Spring boot
* JUnit 5
* Maven
* Docker

## Executando o Projeto

Existem duas maneiras de realizar a execução deste projeto:
1. Usando Maven localmente
2. Usando Docker (containerizado)

### 1. Executando com Maven (local)

#### Pré-requisitos

* Java 17 ou superior
* Maven 3.6 instalado (ou use o wrapper `./mvnw`)

#### Passos

1. Clone o repositório:
```shell
git clone https://github.com/danilosouzagomes/password-validator.git
cd password-validator
```

2. Compile o projeto:
```shell
mvn clean install
```

3. Execute a aplicação:
```shell
mvn spring-boot:run
```

Após isso, a aplicação estará disponível para ser acessada em:
``http://localhost:8080``

### 2. Executando com Docker

#### Pré-requisitos

* Docker instalado

#### Passos

1. Clone o repositório:
```shell
git clone https://github.com/danilosouzagomes/password-validator.git
cd password-validator
```

2. Construa a imagem Docker do projeto:
```shell
docker build -t password-validator .
```

3. Rode o container:
```shell
docker run -p 8080:8080 password-validator
```

Logo após isso, a aplicação estará disponível em: `http://localhost:8080`

### Exemplo de requisição
Requisição HTTP:
```
POST http://localhost:8080/api/v1/passwords/validate
Content-Type: text/plain
```

Corpo da Requisição:
```
Senha@123
```

Resultado Esperado:
```
true
```

## Testes

O projeto possui testes unitários e de integração onde é possível testar:
* Cada regra que será aplicada de maneira individual
* O serviço de validação que agrega as regras para serem executadas
* O controller que recebe as requisições e testa de forma integrada todas as camadas da aplicação

Para executar os testes é necessário executar o seguinte comando:
```shell
mvn test
```