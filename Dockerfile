# Usar una imagen base con JDK 8 y Gradle
FROM gradle:8.5 AS build

# Establecer un directorio de trabajo
WORKDIR /app

# Copiar archivos de tu proyecto al directorio de trabajo
COPY . /app

# Ejecutar Gradle para construir el proyecto
RUN gradle clean build

# Crear una nueva imagen basada en OpenJDK 8
FROM openjdk:11-jre-slim-buster

# Exponer el puerto que utilizará la aplicación
EXPOSE 8090

# Copiar el archivo JAR construido desde la etapa anterior
COPY --from=build /app/build/libs/platzi-market-1.2.jar /app/platzi-market-1.2.jar

# Establecer el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/platzi-market-1.2.jar"]