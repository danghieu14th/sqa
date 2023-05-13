FROM openjdk:17-oracle as builder

WORKDIR /app

COPY mvnw .
RUN chmod +x mvnw
COPY .mvn .mvn
COPY pom.xml .

RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw package -DskipTests

FROM openjdk:17-oracle
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]