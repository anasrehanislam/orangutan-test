# FROM openjdk:11
# COPY ./build/libs/orangutan.jar /app/
# WORKDIR /app
# EXPOSE 5000
# ENTRYPOINT ["java","-jar","orangutan.jar"]


FROM gradle:jdk11 as gradleimage
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build

FROM openjdk:11-jre-slim
COPY --from=gradleimage /home/gradle/src/build/libs/orangutan.jar /app/orangutan.jar
EXPOSE 5000
WORKDIR /app
ENTRYPOINT ["java", "-jar", "orangutan.jar"]