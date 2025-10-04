# Use uma imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml primeiro para aproveitar o cache do Docker
COPY pom.xml .

# Instala o Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Baixa as dependências (isso será cacheado se o pom.xml não mudar)
RUN mvn dependency:go-offline -B

# Copia o código fonte
COPY src ./src

# Compila a aplicação
RUN mvn clean package -DskipTests

# Expõe a porta 8080
EXPOSE 8080

# Comando para executar a aplicação
CMD ["java", "-jar", "target/userapp-1.0.0.jar"]
