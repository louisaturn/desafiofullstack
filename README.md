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
- [Node.js 18.16](https://nodejs.org/en/download)
- [Angular](https://angular.io/guide/setup-local)
- [Maven](https://maven.apache.org/install.html)
### Execução
1. Ir para o diretório base e executar o comando: `mvn package`
2. Executar: `java -jar target/desafiofullstack-0.0.1.jar`
- A aplicação será executada, por padrão, em `http://localhost:8080/`. 
- Para acessar as empresas existentes cadastradas e todas as suas propriedades, acesse `http://localhost:8080/empresas`. 
- Para fornecedores, `http://localhost:8080/fornecedores`.
- Em `http://localhost:8080/h2-console`, temos uma interface de banco de dados.

3. Na pasta `/front/desafiofullstack`, executar `npm i`para instalar dependências.
4. Finalmente, em `/front/desafiofullstack`, executar `ng serve`. O front-end da aplicação, por padrão, será executado em `http://localhost:4200/`.
## Screenshots
### Página inicial, aba Empresas
![Screenshot from 2023-05-14 17-19-53](https://github.com/louisaturn/desafiofullstack/assets/48096245/65b824f5-2c00-4f46-85f9-0e7074fe1af2)

### Página inicial, aba Fornecedores
![Screenshot from 2023-05-14 16-53-14](https://github.com/louisaturn/desafiofullstack/assets/48096245/17ed745b-e466-4368-a200-1f3c4730f6ff)

### Adicionar Empresas
![Screenshot from 2023-05-14 16-38-01](https://github.com/louisaturn/desafiofullstack/assets/48096245/7de652f3-d57f-47b6-9520-34170bede86a)

### Sucesso
![Screenshot from 2023-05-14 16-41-36](https://github.com/louisaturn/desafiofullstack/assets/48096245/b315a281-d191-4dd3-a4a7-ecb7b7de45b2)

### Adicionar Fornecedores
![Screenshot from 2023-05-14 16-52-07](https://github.com/louisaturn/desafiofullstack/assets/48096245/ddb55735-5c21-44ed-8e16-37382305c06b)

### Editar Empresas
![Screenshot from 2023-05-14 16-58-32](https://github.com/louisaturn/desafiofullstack/assets/48096245/54f90e0b-2cd5-4b9a-acfc-6237b01311b7)

Além de editar os dados da empresa, é possível adicionar fornecedores para ela.

![Screenshot from 2023-05-14 16-58-51](https://github.com/louisaturn/desafiofullstack/assets/48096245/8ee8b5ad-882a-4aef-929b-f91ff2851c64)


| Observação: para adicionar um fornecedor para uma empresa, ele precisa ser cadastrado previamente.
### Editar Fornecedores
![Screenshot from 2023-05-14 16-55-34](https://github.com/louisaturn/desafiofullstack/assets/48096245/67884b7b-5d56-4420-b293-52b58e0e8a09)

### Sucesso ao deletar
![Screenshot from 2023-05-14 17-01-26](https://github.com/louisaturn/desafiofullstack/assets/48096245/20a50e6a-998c-417d-a739-a594ac854fab)
