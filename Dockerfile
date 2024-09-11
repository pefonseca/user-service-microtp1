# Use uma imagem base do OpenJDK
FROM openjdk:17-jdk-alpine

# Copie o JAR da aplicação para dentro do container
COPY target/user-service-0.0.1-SNAPSHOT.jar /app/user-service.jar

# Defina o diretório de trabalho
WORKDIR /app

# Exponha a porta na qual a aplicação estará rodando
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "user-service.jar"]
