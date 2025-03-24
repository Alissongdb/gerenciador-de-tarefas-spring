FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/gerenciador-de-tarefas-0.0.1-SNAPSHOT.jar /app/gerenciador-de-tarefas.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/gerenciador-de-tarefas.jar"]
