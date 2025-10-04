# User App - Sistema de Cadastro de Usuários

Uma aplicação Spring Boot para gerenciamento de usuários com autenticação e documentação automática via Swagger/OpenAPI.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **SQLite** (banco de dados)
- **Maven** (gerenciamento de dependências)
- **Docker & Docker Compose**
- **Swagger/OpenAPI** (documentação da API)

## 📋 Pré-requisitos

- Docker e Docker Compose instalados
- Java 17+ (para desenvolvimento local)
- Maven 3.6+ (para desenvolvimento local)

## 📥 Clonando o Repositório

```bash
git clone <url-do-repositorio>
cd UserCadastro
```

## 🐳 Executando com Docker (Recomendado)

### 1. Execute com Docker Compose
```bash
# Construir e executar a aplicação
docker compose up --build

# Executar sem buildar (se já foi construído antes)
docker compose up

# Executar em background
docker compose up -d --build
```

### 2. Parar a aplicação
```bash
# Parar containers
docker compose down

# Parar e remover volumes
docker compose down -v

# Parar e remover tudo (containers, volumes, imagens)
docker compose down --volumes --remove-orphans
```

## 💻 Executando Localmente (Desenvolvimento)

### 1. Instale as dependências
```bash
mvn clean install
```

### 2. Execute a aplicação
```bash
mvn spring-boot:run
```

## 🌐 Acessando a Aplicação

Após executar a aplicação (com Docker ou localmente), acesse:

- **API**: http://localhost:8080
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **Documentação da API**: http://localhost:8080/api-docs

## 📊 Banco de Dados

A aplicação utiliza **SQLite** como banco de dados:
- **Docker**: O banco é persistido no diretório `./data/userapp.db`
- **Local**: O banco é criado automaticamente no diretório `data/userapp.db`

## 🔧 Endpoints da API

### Usuários
- `GET /api/users` - Listar todos os usuários
- `GET /api/users/{id}` - Buscar usuário por ID
- `POST /api/users` - Criar novo usuário
- `PUT /api/users/{id}` - Atualizar usuário
- `DELETE /api/users/{id}` - Deletar usuário

### Exemplo de criação de usuário:
```json
POST /api/users
{
  "name": "João Silva",
  "email": "joao@email.com",
  "password": "senha123"
}
```

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/arquitetura_de_software/userapp/
│   │   ├── config/          # Configurações (OpenAPI)
│   │   ├── controller/      # Controladores REST
│   │   ├── dto/            # Data Transfer Objects
│   │   ├── model/          # Entidades JPA
│   │   ├── repository/     # Repositórios de dados
│   │   ├── service/        # Lógica de negócio
│   │   └── util/           # Utilitários
│   └── resources/
│       └── application.properties
└── test/                   # Testes unitários
```

## 👥 Equipe

- [ALEX KAUAN DE OLIVEIRA LIMA](https://github.com/AlexKauan)
- [DAYVISON ERYC DE MOURA SILVA](https://github.com/dayvisonmsilva)
- [LIDIANA COSTA DE SOUZA](https://github.com/Lidianacosta)
- [LUCAS MAIRON OLIVEIRA CAMILO](https://github.com/LucasMairon)
- [MURILO LACERDA DE SOUZA FONTES](https://github.com/murilofontes1)

## 🔐 Segurança

- Senhas são criptografadas usando **BCrypt**
- Validação de dados de entrada

