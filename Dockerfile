# Image de base
FROM eclipse-temurin:17-jdk-alpine

# répertoire de travail
WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY build/libs/*.jar app.jar

# Exposez le port sur lequel l'application Java s'exécute
EXPOSE 8080

# Commande d'entrée pour exécuter l'application au démarrage du conteneur
ENTRYPOINT ["java", "-jar", "app.jar"]