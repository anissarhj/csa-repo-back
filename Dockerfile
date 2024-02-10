# Image de base
FROM eclipse-temurin:17-jdk-alpine

# répertoire de travail
WORKDIR /app

# Copiez le fichier JAR dans le conteneur
COPY . /app

# Build l'app
RUN ./gradlew build --no-daemon -x test

# test l'app
RUN ./gradlew test

# Exposez le port sur lequel l'application Java s'exécute
EXPOSE 8080

# Commande d'entrée pour exécuter l'application au démarrage du conteneur
ENTRYPOINT ["java", "-jar", "/app/build/libs/csa-java-0.0.1-SNAPSHOT.jar"]