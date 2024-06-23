# Use uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo JAR da sua aplicação para o contêiner
COPY build/libs/ServicoPagamentos.jar /app/ServicoPagamentos.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app/ServicoPagamentos.jar"]
