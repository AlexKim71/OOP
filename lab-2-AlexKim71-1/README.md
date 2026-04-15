# Лабораторна робота 2: Backend-сервіс управління бронюванням готелів
# Laboratory Work 2: Hotel Booking Management Backend Service

## Огляд проекту / Project Overview

Це повнофункціональний REST API backend-сервіс для управління системою бронювання номерів у готелях. Система дозволяє керувати готелями, номерами, гостями, бронюваннями та зручностями номерів.

This is a full-featured REST API backend service for managing a hotel room booking system. The system allows management of hotels, rooms, guests, bookings, and room amenities.

## Технологічний стек / Technology Stack

- **Java 17** - мова програмування / programming language
- **Spring Boot 4.0.5** - фреймворк для розробки / development framework
- **Spring Data JPA** - робота з базою даних / database operations
- **PostgreSQL** - система управління базами даних / database management system
- **Hibernate** - ORM framework для роботи з БД / ORM for database interaction
- **Lombok** - зменшення boilerplate коду / reducing boilerplate code
- **Maven** - управління проектом та залежностями / project management
- **Spring Boot Actuator** - моніторинг та метрики / monitoring and metrics

## Архітектура проекту / Project Architecture

```
src/
├── main/
│   ├── java/ua/opnu/labwork2/
│   │   ├── entity/              # JPA сутності / JPA entities
│   │   │   ├── Hotel.java
│   │   │   ├── Room.java
│   │   │   ├── Guest.java
│   │   │   ├── Booking.java
│   │   │   ├── Amenity.java
│   │   │   └── BookingStatus.java
│   │   ├── dto/                 # Data Transfer Objects
│   │   │   ├── HotelDTO.java
│   │   │   ├── RoomDTO.java
│   │   │   ├── GuestDTO.java
│   │   │   ├── BookingDTO.java
│   │   │   └── AmenityDTO.java
│   │   ├── repository/          # Data Access Layer / Шар доступу до данних
│   │   │   ├── HotelRepository.java
│   │   │   ├── RoomRepository.java
│   │   │   ├── GuestRepository.java
│   │   │   ├── BookingRepository.java
│   │   │   └── AmenityRepository.java
│   │   ├── service/             # Business Logic Layer / Шар бізнес-логіки
│   │   │   ├── HotelService.java
│   │   │   ├── RoomService.java
│   │   │   ├── GuestService.java
│   │   │   ├── BookingService.java
│   │   │   └── AmenityService.java
│   │   ├── controller/          # REST Controllers / REST контролери
│   │   │   ├── HotelController.java
│   │   │   ├── RoomController.java
│   │   │   ├── GuestController.java
│   │   │   ├── BookingController.java
│   │   │   ├── AmenityController.java
│   │   │   ├── SearchController.java
│   │   │   ├── AnalyticsController.java
│   │   │   └── HealthController.java
│   │   └── Labwork2Application.java  # Main Application / Основний клас
│   └── resources/
│       └── application.properties    # Конфігурація / Configuration
└── test/
    └── java/...                      # Unit тести / Unit tests
```

## Модель даних / Data Model

### Сутності / Entities

#### 1. Hotel (Готель)
- `id` (Long) - унікальний識ентифікатор / unique identifier
- `name` (String) - назва готелю / hotel name
- `city` (String) - місто / city
- `address` (String) - адреса / address
- `rating` (Integer) - рейтинг (1-5) / rating (1-5)

#### 2. Room (Номер)
- `id` (Long) - унікальний識ентифікатор / unique identifier
- `number` (String) - номер кімнати / room number
- `type` (String) - тип номера (Deluxe, Standard, Suite) / room type
- `pricePerNight` (Double) - ціна за ніч / price per night
- `capacity` (Integer) - кількість місць / room capacity
- `hotelId` (FK) - посилання на готель / reference to hotel

#### 3. Guest (Гість)
- `id` (Long) - унікальний識ентифікатор / unique identifier
- `firstName` (String) - ім'я / first name
- `lastName` (String) - прізвище / last name
- `email` (String) - email (унікальний) / email (unique)
- `phone` (String) - телефон / phone number

#### 4. Booking (Бронювання)
- `id` (Long) - унікальний識ентифікатор / unique identifier
- `checkInDate` (LocalDate) - дата заселення / check-in date
- `checkOutDate` (LocalDate) - дата виселення / check-out date
- `status` (BookingStatus) - статус (ACTIVE, COMPLETED, CANCELLED) / booking status
- `roomId` (FK) - посилання на номер / reference to room
- `guestId` (FK) - посилання на гостя / reference to guest

#### 5. Amenity (Зручність)
- `id` (Long) - унікальний識ентифікатор / unique identifier
- `name` (String) - назва зручності / amenity name
- `description` (String) - опис / description
- `hotelId` (FK) - посилання на готель / reference to hotel

### Зв'язки між сутностями / Entity Relationships

- **Hotel ↔ Room**: 1:N (один готель - багато номерів)
- **Hotel ↔ Amenity**: 1:N (один готель - багато зручностей)
- **Room ↔ Booking**: 1:N (один номер - багато бронювань)
- **Guest ↔ Booking**: 1:N (один гість - багато бронювань)
- **Room ↔ Amenity**: M:N (номер має багато зручностей)

## REST API Endpoints

### Hotels / Готелі

| Метод / Method | Endpoint | Опис / Description |
|---|---|---|
| POST | `/hotels` | Створити новий готель / Create new hotel |
| GET | `/hotels` | Отримати всі готелі / Get all hotels |
| GET | `/hotels/{id}` | Отримати готель за ID / Get hotel by ID |
| PUT | `/hotels/{id}` | Оновити готель / Update hotel |
| DELETE | `/hotels/{id}` | Видалити готель / Delete hotel |
| GET | `/hotels/{id}/rooms` | Отримати номери готелю / Get hotel rooms |

### Rooms / Номери

| Метод / Method | Endpoint | Опис / Description |
|---|---|---|
| POST | `/rooms` | Створити новий номер / Create new room |
| GET | `/rooms` | Отримати всі номери / Get all rooms |
| GET | `/rooms/{id}` | Отримати номер за ID / Get room by ID |
| PUT | `/rooms/{id}` | Оновити номер / Update room |
| DELETE | `/rooms/{id}` | Видалити номер / Delete room |
| GET | `/rooms/hotel/{hotelId}` | Отримати номери готелю / Get rooms by hotel |

### Guests / Гості

| Метод / Method | Endpoint | Опис / Description |
|---|---|---|
| POST | `/guests` | Зареєструвати нового гостя / Register new guest |
| GET | `/guests` | Отримати всіх гостей / Get all guests |
| GET | `/guests/{id}` | Отримати гостя за ID / Get guest by ID |
| PUT | `/guests/{id}` | Оновити дані гостя / Update guest |
| DELETE | `/guests/{id}` | Видалити гостя / Delete guest |
| GET | `/guests/{id}/bookings` | Отримати бронювання гостя / Get guest bookings |

### Bookings / Бронювання

| Метод / Method | Endpoint | Опис / Description |
|---|---|---|
| POST | `/bookings` | Створити нове бронювання / Create new booking |
| GET | `/bookings` | Отримати всі бронювання / Get all bookings |
| GET | `/bookings/{id}` | Отримати бронювання за ID / Get booking by ID |
| PUT | `/bookings/{id}` | Оновити бронювання / Update booking |
| DELETE | `/bookings/{id}` | Скасувати бронювання / Cancel booking |
| GET | `/bookings/active` | Отримати активні бронювання / Get active bookings |

### Amenities / Зручності

| Метод / Method | Endpoint | Опис / Description |
|---|---|---|
| POST | `/amenities` | Створити нову зручність / Create new amenity |
| GET | `/amenities` | Отримати всі зручності / Get all amenities |
| GET | `/amenities/{id}` | Отримати зручність за ID / Get amenity by ID |
| DELETE | `/amenities/{id}` | Видалити зручність / Delete amenity |
| POST | `/amenities/rooms/{roomId}/amenities/{amenityId}` | Додати зручність до номера / Add amenity to room |
| DELETE | `/amenities/rooms/{roomId}/amenities/{amenityId}` | Видалити зручність з номера / Remove amenity from room |

### Search / Пошук

| Метод / Method | Endpoint | Опис / Description |
|---|---|---|
| GET | `/search/hotels?query=` | Пошук готелів / Search hotels |
| GET | `/search/rooms?query=` | Пошук номерів / Search rooms |
| GET | `/search/guests?query=` | Пошук гостей / Search guests |

### Analytics / Аналітика

| Метод / Method | Endpoint | Опис / Description |
|---|---|---|
| GET | `/analytics/hotels/count` | Загальна кількість готелів / Total hotels count |
| GET | `/analytics/rooms/count` | Загальна кількість номерів / Total rooms count |
| GET | `/analytics/bookings/active` | Кількість активних бронювань / Active bookings count |
| GET | `/analytics/bookings/completed` | Кількість завершених бронювань / Completed bookings count |
| GET | `/analytics/rooms/by-type` | Кількість номерів за типом / Rooms by type |
| GET | `/analytics/all` | Вся аналітика / All analytics |

### Health & Metrics / Здоров'я та метрики

| Метод / Method | Endpoint | Опис / Description |
|---|---|---|
| GET | `/actuator/health` | Перевірити стан сервісу / Check service health |
| GET | `/actuator/metrics` | Отримати метрики / Get metrics |
| GET | `/actuator/prometheus` | Prometheus метрики / Prometheus metrics |

## Встановлення та запуск / Installation and Running

### Вимоги / Requirements
- Java 17 або вище / Java 17 or higher
- PostgreSQL 12 або вище / PostgreSQL 12 or higher
- Maven 3.6+ / Maven 3.6+

### Крок 1: Створення бази даних / Step 1: Create Database

```sql
CREATE DATABASE hotel_management_db;
CREATE USER user_db WITH PASSWORD 'useruser';
ALTER ROLE user_db SET client_encoding TO 'utf8';
ALTER ROLE user_db SET default_transaction_isolation TO 'read committed';
ALTER ROLE user_db SET default_transaction_deferrable TO on;
ALTER ROLE user_db SET timezone TO 'UTC';
GRANT ALL PRIVILEGES ON DATABASE hotel_management_db TO user_db;
```

### Крок 2: Клонування проекту / Step 2: Clone Project

```bash
cd D:\Projects\lab-2-AlexKim71-1
```

### Крок 3: Встановлення залежностей / Step 3: Install Dependencies

```bash
mvn clean install
```

### Крок 4: Запуск проекту / Step 4: Run Project

```bash
mvn spring-boot:run
```

Сервіс буде доступний на: http://localhost:8080

The service will be available at: http://localhost:8080

## Приклади запитів / Request Examples

### 1. Створити готель / Create Hotel

**Request:**
```bash
POST http://localhost:8080/hotels
Content-Type: application/json

{
  "name": "Grand Hotel Kyiv",
  "city": "Kyiv",
  "address": "123 Main Street, Kyiv",
  "rating": 5
}
```

**Response:**
```json
{
  "id": 1,
  "name": "Grand Hotel Kyiv",
  "city": "Kyiv",
  "address": "123 Main Street, Kyiv",
  "rating": 5
}
```

### 2. Зареєструвати гостя / Register Guest

**Request:**
```bash
POST http://localhost:8080/guests
Content-Type: application/json

{
  "firstName": "Ivan",
  "lastName": "Ivanov",
  "email": "ivan@example.com",
  "phone": "+380501234567"
}
```

**Response:**
```json
{
  "id": 1,
  "firstName": "Ivan",
  "lastName": "Ivanov",
  "email": "ivan@example.com",
  "phone": "+380501234567"
}
```

### 3. Створити номер / Create Room

**Request:**
```bash
POST http://localhost:8080/rooms
Content-Type: application/json

{
  "number": "101",
  "type": "Deluxe",
  "pricePerNight": 150.0,
  "capacity": 2,
  "hotelId": 1
}
```

**Response:**
```json
{
  "id": 1,
  "number": "101",
  "type": "Deluxe",
  "pricePerNight": 150.0,
  "capacity": 2,
  "hotelId": 1
}
```

### 4. Створити бронювання / Create Booking

**Request:**
```bash
POST http://localhost:8080/bookings
Content-Type: application/json

{
  "checkInDate": "2024-05-01",
  "checkOutDate": "2024-05-05",
  "status": "ACTIVE",
  "roomId": 1,
  "guestId": 1
}
```

**Response:**
```json
{
  "id": 1,
  "checkInDate": "2024-05-01",
  "checkOutDate": "2024-05-05",
  "status": "ACTIVE",
  "roomId": 1,
  "guestId": 1
}
```

### 5. Пошук готелів / Search Hotels

**Request:**
```bash
GET http://localhost:8080/search/hotels?query=kyiv
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "Grand Hotel Kyiv",
    "city": "Kyiv",
    "address": "123 Main Street, Kyiv",
    "rating": 5
  }
]
```

## Тестування / Testing

### Використання Postman / Using Postman

1. Імпортуйте файл `postman_collection.json` у Postman
2. Import `postman_collection.json` file into Postman
3. Виберіть HTTP методи та запускайте запити
4. Select HTTP methods and run requests

### Запуск unit тестів / Running Unit Tests

```bash
mvn test
```

## Конфігурація / Configuration

### application.properties

```properties
# Database / База данних
spring.datasource.url=jdbc:postgresql://localhost:5432/hotel_management_db
spring.datasource.username=user_db
spring.datasource.password=useruser

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Actuator
management.endpoints.web.exposure.include=health,metrics,prometheus
```

## Обробка помилок / Error Handling

Сервіс повертає наступні HTTP статус-коди:

The service returns the following HTTP status codes:

- `200 OK` - успішне запит / Successful request
- `201 CREATED` - ресурс створено / Resource created
- `204 NO CONTENT` - успішне видалення / Successful deletion
- `400 BAD REQUEST` - помилка в запиті / Bad request
- `404 NOT FOUND` - ресурс не знайдено / Resource not found
- `500 INTERNAL SERVER ERROR` - помилка на сервері / Server error

## Ліцензія / License

MIT License

## Автор / Author

Laboratory Work 2 - Labwork2Application
Гаврилов Олександр В'ячеславович
Група AI-243 - 2024

