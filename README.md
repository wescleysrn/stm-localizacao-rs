# Micro Serviço Localização

Conjunto de microsserviços para gestão e consulta de dados geográficos e territoriais baseados na estrutura oficial do IBGE:

- Região
- Unidade da Federação (UF)
- Meso Região
- Micro Região
- Município
- Distrito
- Subdistrito

---

## Composição do Projeto

1. **`stm-localizacao-rs`**: Resource Server contendo as APIs REST, regras de negócio, persistência e integrações.

---

## Execução e Build Local (Maven)

### 1. Instalação dos Módulos Dependentes

Execute a compilação e instalação local dos módulos base:

```bash
cd stm-localizacao-rs
mvn clean install -DskipTests
```

### 2. Execução da API em Modo Desenvolvimento

Para testar diretamente via JVM local:

```bash
cd stm-localizacao-rs
mvn spring-boot:run
```

Ou gerando e executando o .jar:

```bash
mvn clean package -DskipTests
java -jar target/stm-localizacao-rs-1.0.0.jar
```

A API estará acessível em:

Swagger UI: http://localhost:8080/swagger-ui/index.html

Actuator Health: http://localhost:8080/actuator/health

## Build e Publicação no Docker Hub

### 1. Autenticação no Docker Hub

Faça login na sua conta do Docker Hub:

A. Gerando um Personal Access Token (PAT)
Acesse sua conta no Docker Hub.

Vá em Account Settings -> Security -> Personal Access Tokens.

Clique em Generate new token, defina uma descrição (ex: cli-access) e defina as permissões (Read, Write, Delete).

Copie e guarde o token gerado com segurança.

B. Autenticação via CLI
Execute o comando abaixo e insira o seu PAT gerado como senha:

```bash
docker login -u seu-usuario
```

### 2. Build da Imagem Docker

Na raiz do repositório, execute o build multi-stage informando a tag do seu usuário no Docker Hub (ex: stm-localizacao-rs:1.0.0):
Nota: Nas instruções abaixo, substitua seu-usuario pelo seu nome de usuário no Docker Hub.

```bash
docker build -f stm-localizacao-rs/Dockerfile -t seu-usuario/stm-localizacao-rs:1.0.0 .
```

### 3. Publicação (Push) para o Docker Hub

Envie a imagem construída para o Docker Hub:

```bash
docker push seu-usuario/stm-localizacao-rs:1.0.0
```

## Execução via Docker Cli

### Opção 1: Passando o arquivo .env direto no docker run (Recomendada e mais limpa)

O Docker CLI permite passar o próprio arquivo .env através do argumento --env-file, mantendo o comando enxuto:

```bash
docker run -d \
  --name stm-localizacao-rs \
  --restart unless-stopped \
  -p 8080:8080 \
  --env-file .env \
  wescleymacedosousa/stm-localizacao-rs:1.0.0
```

> Nota: Certifique-se de executar o comando no mesmo diretório em que o arquivo .env está localizado.

### Opção 2: Passando todas as variáveis explicitamente (-e)

Caso queira rodar em um servidor sem a presença do arquivo .env local, passe todas as variáveis diretamente via terminal com o parâmetro -e:

```bash
docker run -d \
  --name stm-localizacao-rs \
  --restart unless-stopped \
  -p 8080:8080 \
  -e RESOURCE-SERVER-PORT=8080 \
  -e SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.h2.Driver \
  -e SPRING_DATASOURCE_URL="jdbc:h2:mem:db-localizacao;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=PostgreSQL" \
  -e SPRING_DATASOURCE_USERNAME=sa \
  -e SPRING_DATASOURCE_PASSWORD=sa \
  -e SPRING_H2_CONSOLE_ENABLED=true \
  -e SPRING_H2_CONSOLE_WEB_ALLOW_OTHERS=true \
  -e SPRING_JPA_HIBERNATE_DIALECT=org.hibernate.dialect.H2Dialect \
  -e SPRING_JPA_SHOW_SQL=false \
  -e SPRING_JPA_HIBERNATE_DDL_AUTO=none \
  -e SPRING_SQL_INIT_MODE=always \
  -e SWAGGER_ENABLED=true \
  -e MONITORING_ENDPOINTS=health,metrics,info,prometheus \
  -e MONITORING_PROMETHEUS=true \
  wescleymacedosousa/stm-localizacao-rs:1.0.0
```

Comando em Linha Única (Copy & Paste)

```bash
docker run -d --name stm-localizacao-rs --restart unless-stopped -p 8080:8080 --env-file .env wescleymacedosousa/stm-localizacao-rs:1.0.0
```

```bash
docker run -d --name stm-localizacao-rs --restart unless-stopped -p 8080:8080 -e RESOURCE-SERVER-PORT=8080 -e SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.h2.Driver -e SPRING_DATASOURCE_URL="jdbc:h2:mem:db-localizacao;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=PostgreSQL" -e SPRING_DATASOURCE_USERNAME=sa -e SPRING_DATASOURCE_PASSWORD=sa -e SPRING_H2_CONSOLE_ENABLED=true -e SPRING_H2_CONSOLE_WEB_ALLOW_OTHERS=true -e SPRING_JPA_HIBERNATE_DIALECT=org.hibernate.dialect.H2Dialect -e SPRING_JPA_SHOW_SQL=false -e SPRING_JPA_HIBERNATE_DDL_AUTO=none -e SPRING_SQL_INIT_MODE=always -e SWAGGER_ENABLED=true -e MONITORING_ENDPOINTS=health,metrics,info,prometheus -e MONITORING_PROMETHEUS=true wescleymacedosousa/stm-localizacao-rs:1.0.0
```

## Execução via Docker Compose

O projeto conta com integração nativa via docker-compose.yml e arquivo .env para controle total dos parâmetros de execução.

### 1. Ajuste das Variáveis de Ambiente (.env)

Crie ou edite o arquivo .env na raiz do projeto conforme a sua necessidade de ambiente:

```text
DOCKER_IMAGE_NAME=stm-localizacao-rs
DOCKER_IMAGE_TAG=1.0.0
HOST_PORT=8080
CONTAINER_PORT=8080

# Fonte de Dados (H2 In-Memory)
SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.h2.Driver
SPRING_DATASOURCE_URL=jdbc:h2:mem:db-localizacao;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=PostgreSQL
SPRING_DATASOURCE_USERNAME=sa
SPRING_DATASOURCE_PASSWORD=sa
```

### 2. Subindo a Aplicação

Para subir o container em background:

```bash
cd stm-localizacao-rs
docker compose up -d
```

### 3. Verificação e Logs

Para acompanhar os logs do serviço em tempo real:

```bash
docker compose logs -f stm-localizacao-rs
```

Para verificar o status da aplicação e a checagem de saúde (Healthcheck):

```bash
docker compose ps
```

Endereços disponíveis após a execução:

Swagger UI: http://localhost:8080/swagger-ui/index.html

H2 Console: http://localhost:8080/h2-console

Métricas Prometheus: http://localhost:8080/actuator/prometheus

### 4. Parando o Serviço

Para encerrar e remover o container:

```bash
docker compose down
```
