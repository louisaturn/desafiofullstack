# Desafio Full-Stack
Meu primeiro projeto full-stack, uma oportunidade de aprender novas tecnologias.

### Back-end
Linguagem Java, utilizando o framework [Spring Boot](https://spring.io/). Dependências importadas:
- Spring Web
- Spring Data JPA (Java Persistence API)
- H2 Database (mecanismo de banco de dados SQL)

### Front-end
Linguagem Typescript, utilizando a tecnologia Angular. Foram utilizados componentes de interface da biblioteca [Material](https://material.angular.io/).

### Outras tecnologias
[Postman](https://www.postman.com/postman/workspace/postman-public-workspace/documentation/12959542-c8142d51-e97c-46b6-bd77-52bb66712c9a), para testes do CRUD. Foi utilizada a IDE [IntelliJ](https://www.jetbrains.com/pt-br/idea/download/) para programação e excução do código em Java, além do [VSCode](https://code.visualstudio.com/download) para desenvolvimento e execução do front-end.

## Como Executar
### Dependências (Links para instalá-las)
- [Java SE 20](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html)
- [Node.js](https://www.npmjs.com/package/npm)
- [Angular](https://angular.io/guide/setup-local)
### Execução
1. Ir para o diretório base e executar o comando:
`java -jar desafiofullstack.jar `. A aplicação será executada, por padrão, em `http://localhost:8080/`. 

- Para acessar as empresas existentes cadastradas e todas as suas propriedades, acesse `http://localhost:8080/empresas`. 

- Para fornecedores, `http://localhost:8080/fornecedores`.

- Em `http://localhost:8080/h2-console`, temos uma interface de banco de dados.

2. Na pasta `/front/desafiofullstack`, executar `ng serve`. O front-end da aplicação, por padrão, será executado em `http://localhost:4200/`.
## Screenshots
### Página inicial, aba Empresas
### Página inicial, aba Fornecedores
### Adicionar Empresas
### Sucesso
### Adicionar Fornecedores
### Editar Empresas
Além de editar os dados da empresa, é possível adicionar fornecedores para ela.

| Observação: para adicionar um fornecedor para uma empresa, ele precisa ser cadastrado previamente.
### Editar Fornecedores
### Sucesso ao deletar