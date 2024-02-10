# Utilisez une image de base avec Java 17 et Alpine Linux
FROM eclipse-temurin:17-jdk-alpine

# Définissez le répertoire de travail
WORKDIR /app

# Copiez le fichier JAR dans le conteneur
COPY . /app

RUN ./gradlew build --no-daemon -x test

# Exposez le port sur lequel l'application Java s'exécute
EXPOSE 8080

# Commande d'entrée pour exécuter l'application au démarrage du conteneur
ENTRYPOINT ["java", "-jar", "/app/build/libs/csa-java-0.0.1-SNAPSHOT.jar"]