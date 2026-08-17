# Étape 1 : Image de base Java
FROM openjdk:17-jdk-slim

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copie du fichier JAR compilé
COPY target/*.jar app.jar

# Port d'exposition de l'application
EXPOSE 8080

# Commande de lancement
ENTRYPOINT ["java", "-jar", "app.jar"]
