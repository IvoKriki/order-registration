# Order Registration Application

This is a Spring Boot application that uses PostgreSQL as its database.

## Prerequisites

- Java 21
- Maven
- Docker and Docker Compose

## Database Setup with Docker Compose

The application uses PostgreSQL as its database. A Docker Compose configuration is provided to easily set up the database.

### Starting the Database

To start the PostgreSQL database, run the following command from the project root:

```bash
docker-compose up -d
```

This will start the following containers:

1. PostgreSQL 16 container with the following configuration:
   - Database name: order_registration
   - Username: postgres
   - Password: postgres
   - Port: 5432 (mapped to host)

2. pgAdmin 4 container for database management:
   - URL: http://localhost:5050
   - Default email: admin@admin.com
   - Default password: admin

### Using pgAdmin to Manage the Database

1. Access pgAdmin by navigating to http://localhost:5050 in your web browser
2. Log in using the credentials:
   - Email: admin@admin.com
   - Password: admin
3. To connect to the PostgreSQL database:
   - Right-click on "Servers" in the left panel and select "Create" > "Server..."
   - In the "General" tab, enter a name for the connection (e.g., "Order Registration DB")
   - In the "Connection" tab, enter the following details:
     - Host name/address: postgres (use the service name from docker-compose)
     - Port: 5432
     - Maintenance database: order_registration
     - Username: postgres
     - Password: postgres
   - Click "Save"
4. You should now be able to browse and manage your database

### Stopping the Services

To stop both the PostgreSQL database and pgAdmin, run:

```bash
docker-compose down
```

To stop all services and remove all data volumes, run:

```bash
docker-compose down -v
```

## Application Configuration

The application is configured to connect to the PostgreSQL database. The configuration can be found in `src/main/resources/application.properties`.

## Running the Application

To run the application, first ensure that the database is running, then use the following command:

```bash
./mvnw spring-boot:run
```

Or on Windows:

```bash
mvnw.cmd spring-boot:run
```

## Building the Application

To build the application, run:

```bash
./mvnw clean package
```

Or on Windows:

```bash
mvnw.cmd clean package
```

This will create a JAR file in the `target` directory.

## Running the JAR

To run the JAR file:

```bash
java -jar target/order-registration-0.0.1-SNAPSHOT.jar
```
