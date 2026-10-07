# =========================================================
# STAGE 1 - BUILD
# =========================================================
FROM maven:3.9.9-eclipse-temurin-23 AS build

WORKDIR /build

# Copia arquivo do projeto pai/módulo para cache de dependências
COPY stm-localizacao-rs/pom.xml .

RUN mvn -B dependency:go-offline

# Copia código-fonte
COPY stm-localizacao-rs/src ./src

# Build do pacote
RUN mvn -B clean package -DskipTests

# =========================================================
# STAGE 2 - RUNTIME
# =========================================================
FROM eclipse-temurin:23-jre-noble

LABEL org.opencontainers.image.title="stm-localizacao"
LABEL org.opencontainers.image.description="Localização base IBGE REST API"
LABEL org.opencontainers.image.version="1.0.0"

WORKDIR /opt/stm-localizacao

RUN apt-get update && \
    apt-get install -y --no-install-recommends tzdata curl && \
    rm -rf /var/lib/apt/lists/*

RUN groupadd -r spring && useradd -r -g spring spring

COPY --from=build /build/target/*.jar app.jar

RUN chown -R spring:spring /opt/stm-localizacao

USER spring

ENV JAVA_OPTS="\
-XX:+UseContainerSupport \
-XX:MaxRAMPercentage=75 \
-XX:+UseG1GC \
-XX:+UseStringDeduplication \
-Dfile.encoding=UTF-8 \
-Duser.timezone=America/Sao_Paulo \
"

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=10s --start-period=40s --retries=5 \
CMD curl --fail http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
