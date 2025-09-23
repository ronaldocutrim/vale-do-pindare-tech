CONTAINER_NAME ?= postgres-local
DB_USER ?= postgres
DB_NAME ?= event_manager

run:
	DB_HOST=localhost DB_PORT=5432 DB_NAME=event_manager DB_USER=postgres DB_PASS=docker ./mvnw spring-boot:run
deps:
	./mvnw dependency:resolve
db:
	docker exec -it $(CONTAINER_NAME) psql -U $(DB_USER) -d $(DB_NAME)