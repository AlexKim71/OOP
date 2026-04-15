# DEPLOYMENT_GUIDE.md - Посібник розгортання / Deployment Guide

## Українська версія / Ukrainian Version

### Попередні вимоги / Prerequisites

1. **Установка PostgreSQL**
   - Завантажте PostgreSQL з https://www.postgresql.org/download/
   - Встановіть з паролем користувача `user_db` як `useruser`
   - Переконайтеся, що PostgreSQL запущен на порту 5432

2. **Установка Java 17**
   - Завантажте Java 17 з https://www.oracle.com/java/technologies/downloads/#java17
   - Встановіть та встановіть змінну середовища JAVA_HOME

3. **Установка Maven**
   - Завантажте Maven з https://maven.apache.org/download.cgi
   - Встановіть та додайте до PATH

### Кроки встановлення / Installation Steps

#### 1. Створення бази даних PostgreSQL

```sql
-- Підключіться до PostgreSQL як адміністратор
-- Connect to PostgreSQL as administrator

-- Створіть базу даних
CREATE DATABASE hotel_management_db;

-- Створіть користувача
CREATE USER user_db WITH PASSWORD 'useruser';

-- Встановіть кодування UTF-8
ALTER ROLE user_db SET client_encoding TO 'utf8';
ALTER ROLE user_db SET default_transaction_isolation TO 'read committed';
ALTER ROLE user_db SET default_transaction_deferrable TO on;
ALTER ROLE user_db SET timezone TO 'UTC';

-- Надайте права користувачу
GRANT ALL PRIVILEGES ON DATABASE hotel_management_db TO user_db;
```

#### 2. Перевірка конфігурації

Переконайтеся, що `application.properties` містить:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hotel_management_db
spring.datasource.username=user_db
spring.datasource.password=useruser
spring.datasource.driver-class-name=org.postgresql.Driver
```

#### 3. Збірка проекту / Build Project

```bash
cd D:\Projects\lab-2-AlexKim71-1
mvn clean install
```

#### 4. Запуск сервісу / Run Service

```bash
mvn spring-boot:run
```

Або / Or:

```bash
mvn clean package
java -jar target/labwork-2-0.0.1-SNAPSHOT.jar
```

#### 5. Перевірка здоров'я сервісу / Check Service Health

```bash
curl http://localhost:8080/actuator/health
```

Очікуваний відповідь / Expected response:
```json
{
  "status": "UP",
  "timestamp": "2024-04-15T10:00:00",
  "message": "Hotel Management Service is running"
}
```

### Тестування API / Testing API

#### За допомогою cURL / Using cURL

```bash
# Створити готель
curl -X POST http://localhost:8080/hotels \
  -H "Content-Type: application/json" \
  -d '{"name":"Test Hotel","city":"Kyiv","address":"123 St","rating":5}'

# Отримати всі готелі
curl http://localhost:8080/hotels

# Пошук готелів
curl "http://localhost:8080/search/hotels?query=kyiv"

# Отримати аналітику
curl http://localhost:8080/analytics/all
```

#### За допомогою Postman / Using Postman

1. Відкрийте Postman
2. Імпортуйте `postman_collection.json`
3. Встановіть змінну `base_url = http://localhost:8080`
4. Запустіть запити з колекції

### Вирішення проблем / Troubleshooting

#### Проблема: Connection refused на порті 5432
**Рішення:** Переконайтеся, що PostgreSQL запущен

```bash
# Windows
net start PostgreSQL13

# Linux
sudo service postgresql start
```

#### Проблема: "Error creating bean with name 'hotelRepository'"
**Рішення:** Перевірте підключення до БД в `application.properties`

#### Проблема: "Port 8080 already in use"
**Рішення:** Зміните порт в `application.properties`:

```properties
server.port=8081
```

---

## English Version / Англійська версія

### Prerequisites

1. **Install PostgreSQL**
   - Download PostgreSQL from https://www.postgresql.org/download/
   - Install with user password `user_db` as `useruser`
   - Ensure PostgreSQL is running on port 5432

2. **Install Java 17**
   - Download Java 17 from https://www.oracle.com/java/technologies/downloads/#java17
   - Install and set JAVA_HOME environment variable

3. **Install Maven**
   - Download Maven from https://maven.apache.org/download.cgi
   - Install and add to PATH

### Installation Steps

#### 1. Create PostgreSQL Database

```sql
-- Connect to PostgreSQL as administrator

-- Create database
CREATE DATABASE hotel_management_db;

-- Create user
CREATE USER user_db WITH PASSWORD 'useruser';

-- Set UTF-8 encoding
ALTER ROLE user_db SET client_encoding TO 'utf8';
ALTER ROLE user_db SET default_transaction_isolation TO 'read committed';
ALTER ROLE user_db SET default_transaction_deferrable TO on;
ALTER ROLE user_db SET timezone TO 'UTC';

-- Grant privileges
GRANT ALL PRIVILEGES ON DATABASE hotel_management_db TO user_db;
```

#### 2. Verify Configuration

Ensure `application.properties` contains:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hotel_management_db
spring.datasource.username=user_db
spring.datasource.password=useruser
spring.datasource.driver-class-name=org.postgresql.Driver
```

#### 3. Build Project

```bash
cd D:\Projects\lab-2-AlexKim71-1
mvn clean install
```

#### 4. Run Service

```bash
mvn spring-boot:run
```

Or:

```bash
mvn clean package
java -jar target/labwork-2-0.0.1-SNAPSHOT.jar
```

#### 5. Check Service Health

```bash
curl http://localhost:8080/actuator/health
```

Expected response:
```json
{
  "status": "UP",
  "timestamp": "2024-04-15T10:00:00",
  "message": "Hotel Management Service is running"
}
```

### Testing API

#### Using cURL

```bash
# Create hotel
curl -X POST http://localhost:8080/hotels \
  -H "Content-Type: application/json" \
  -d '{"name":"Test Hotel","city":"Kyiv","address":"123 St","rating":5}'

# Get all hotels
curl http://localhost:8080/hotels

# Search hotels
curl "http://localhost:8080/search/hotels?query=kyiv"

# Get analytics
curl http://localhost:8080/analytics/all
```

#### Using Postman

1. Open Postman
2. Import `postman_collection.json`
3. Set variable `base_url = http://localhost:8080`
4. Run requests from collection

### Troubleshooting

#### Issue: Connection refused on port 5432
**Solution:** Ensure PostgreSQL is running

```bash
# Windows
net start PostgreSQL13

# Linux
sudo service postgresql start
```

#### Issue: "Error creating bean with name 'hotelRepository'"
**Solution:** Check database connection in `application.properties`

#### Issue: "Port 8080 already in use"
**Solution:** Change port in `application.properties`:

```properties
server.port=8081
```

## Документація API / API Documentation

### Основні сутності / Main Entities

1. **Hotel** - Contains information about hotels
2. **Room** - Contains information about hotel rooms
3. **Guest** - Contains information about guests
4. **Booking** - Contains booking information
5. **Amenity** - Contains room amenities/facilities

### Структура проекту / Project Structure

```
src/main/java/ua/opnu/labwork2/
├── entity/          - JPA entities
├── dto/             - Data Transfer Objects
├── repository/      - Data Access Objects
├── service/         - Business Logic
├── controller/      - REST Controllers
└── Labwork2Application.java
```

### Відповіді сервера / Server Responses

Усі відповіді у форматі JSON:

All responses in JSON format:

```json
{
  "status": "success/error",
  "data": {},
  "timestamp": "2024-04-15T10:00:00"
}
```

## Посилання на документацію / Documentation Links

- Spring Boot: https://spring.io/projects/spring-boot
- Spring Data JPA: https://spring.io/projects/spring-data-jpa
- PostgreSQL: https://www.postgresql.org/
- Hibernate: https://hibernate.org/
- Lombok: https://projectlombok.org/

## Видалення та очищення / Cleaning Up

Для видалення та переспробування:

To remove and retry:

```bash
# Видаліть базу даних
DROP DATABASE hotel_management_db;

# Видаліть jar файли
rm -rf target/

# Переспробуйте встановлення
mvn clean install
```

## Контакт / Contact

Laboratory Work 2 - Hotel Management System
Гаврилов Олександр В'ячеславович
Група AI-243 - 2024

