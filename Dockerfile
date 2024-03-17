# Usar una imagen base con JDK 11 y Gradle
FROM gradle:7.3.0-jdk11 AS build

# Establecer un directorio de trabajo
WORKDIR /app

# Copiar archivos de tu proyecto al directorio de trabajo
COPY src/main /app

# Ejecutar Gradle para construir el proyecto
RUN gradle clean build

# Crear una nueva imagen basada en OpenJDK 11
FROM adoptopenjdk/openjdk11:jdk-11.0.11_9-alpine AS runtime

# Exponer el puerto que utilizará la aplicación
EXPOSE 8090

# Establecer un directorio de trabajo para la aplicación
WORKDIR /app

# Copiar el archivo JAR construido desde la etapa anterior
COPY --from=build /app/build/libs/platzi-market-1.2.jar /app/platzi-market-1.2.jar

# Establecer el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/platzi-market-1.2.jar"]