# API SPECIFICATION / СПЕЦИФІКАЦІЯ API
# Hotel Management System - Backend Service

## 1. HOTELS API / API ГОТЕЛІВ

### 1.1 Create Hotel / Створити готель
**Endpoint:** `POST /hotels`
**Description:** Creates a new hotel in the system / Створює новий готель у системі

**Request Body:**
```json
{
  "name": "string (required, max 255)",
  "city": "string (required, max 255)",
  "address": "string (required, max 500)",
  "rating": "integer (required, 1-5)"
}
```

**Response (201 Created):**
```json
{
  "id": "long",
  "name": "string",
  "city": "string",
  "address": "string",
  "rating": "integer"
}
```

**Example cURL:**
```bash
curl -X POST http://localhost:8080/hotels \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Grand Hotel Kyiv",
    "city": "Kyiv",
    "address": "123 Main Street, Kyiv",
    "rating": 5
  }'
```

---

### 1.2 Get All Hotels / Отримати всі готелі
**Endpoint:** `GET /hotels`
**Description:** Retrieves list of all hotels / Отримує список всіх готелів

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "Grand Hotel Kyiv",
    "city": "Kyiv",
    "address": "123 Main Street, Kyiv",
    "rating": 5
  },
  {
    "id": 2,
    "name": "Palace Hotel Lviv",
    "city": "Lviv",
    "address": "456 Liberty Avenue, Lviv",
    "rating": 4
  }
]
```

**Example cURL:**
```bash
curl http://localhost:8080/hotels
```

---

### 1.3 Get Hotel by ID / Отримати готель за ID
**Endpoint:** `GET /hotels/{id}`
**Description:** Retrieves hotel information by ID / Отримує інформацію про готель за ID

**Path Parameters:**
- `id` (long, required) - Hotel identifier / ID готелю

**Response (200 OK):**
```json
{
  "id": 1,
  "name": "Grand Hotel Kyiv",
  "city": "Kyiv",
  "address": "123 Main Street, Kyiv",
  "rating": 5
}
```

**Response (404 Not Found):**
```json
{
  "error": "Hotel not found with id: 999"
}
```

**Example cURL:**
```bash
curl http://localhost:8080/hotels/1
```

---

### 1.4 Update Hotel / Оновити готель
**Endpoint:** `PUT /hotels/{id}`
**Description:** Updates hotel information / Оновлює інформацію про готель

**Path Parameters:**
- `id` (long, required) - Hotel identifier / ID готелю

**Request Body:**
```json
{
  "name": "string",
  "city": "string",
  "address": "string",
  "rating": "integer"
}
```

**Response (200 OK):**
```json
{
  "id": 1,
  "name": "Grand Hotel Kyiv Updated",
  "city": "Kyiv",
  "address": "123 Main Street, Kyiv",
  "rating": 4
}
```

**Example cURL:**
```bash
curl -X PUT http://localhost:8080/hotels/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Grand Hotel Kyiv Updated",
    "city": "Kyiv",
    "address": "123 Main Street, Kyiv",
    "rating": 4
  }'
```

---

### 1.5 Delete Hotel / Видалити готель
**Endpoint:** `DELETE /hotels/{id}`
**Description:** Deletes hotel from system / Видаляє готель з системи

**Path Parameters:**
- `id` (long, required) - Hotel identifier / ID готелю

**Response (204 No Content):** (No body)

**Response (404 Not Found):**
```json
{
  "error": "Hotel not found with id: 999"
}
```

**Example cURL:**
```bash
curl -X DELETE http://localhost:8080/hotels/1
```

---

## 2. ROOMS API / API НОМЕРІВ

### 2.1 Create Room / Створити номер
**Endpoint:** `POST /rooms`
**Description:** Creates a new room in a hotel / Створює новий номер у готелі

**Request Body:**
```json
{
  "number": "string (required, max 50)",
  "type": "string (required, max 100, e.g., 'Standard', 'Deluxe', 'Suite')",
  "pricePerNight": "double (required, > 0)",
  "capacity": "integer (required, > 0)",
  "hotelId": "long (required)"
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "number": "101",
  "type": "Deluxe",
  "pricePerNight": 150.00,
  "capacity": 2,
  "hotelId": 1
}
```

**Example cURL:**
```bash
curl -X POST http://localhost:8080/rooms \
  -H "Content-Type: application/json" \
  -d '{
    "number": "101",
    "type": "Deluxe",
    "pricePerNight": 150.00,
    "capacity": 2,
    "hotelId": 1
  }'
```

---

### 2.2 Get All Rooms / Отримати всі номери
**Endpoint:** `GET /rooms`
**Description:** Retrieves list of all rooms / Отримує список всіх номерів

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "number": "101",
    "type": "Deluxe",
    "pricePerNight": 150.00,
    "capacity": 2,
    "hotelId": 1
  }
]
```

---

### 2.3 Get Room by ID / Отримати номер за ID
**Endpoint:** `GET /rooms/{id}`
**Description:** Retrieves room information by ID / Отримує інформацію про номер за ID

**Path Parameters:**
- `id` (long, required) - Room identifier / ID номера

**Response (200 OK):** Same as 2.1

---

### 2.4 Get Rooms by Hotel / Отримати номери готелю
**Endpoint:** `GET /rooms/hotel/{hotelId}`
**Description:** Retrieves all rooms in a specific hotel / Отримує всі номери в конкретному готелі

**Path Parameters:**
- `hotelId` (long, required) - Hotel identifier / ID готелю

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "number": "101",
    "type": "Deluxe",
    "pricePerNight": 150.00,
    "capacity": 2,
    "hotelId": 1
  }
]
```

---

### 2.5 Update Room / Оновити номер
**Endpoint:** `PUT /rooms/{id}`
**Description:** Updates room information / Оновлює інформацію про номер

**Response (200 OK):** Same as 2.1

---

### 2.6 Delete Room / Видалити номер
**Endpoint:** `DELETE /rooms/{id}`
**Description:** Deletes room from system / Видаляє номер з системи

**Response (204 No Content)**

---

## 3. GUESTS API / API ГОСТЕЙ

### 3.1 Register Guest / Зареєструвати гостя
**Endpoint:** `POST /guests`
**Description:** Registers a new guest in the system / Реєструє нового гостя в системі

**Request Body:**
```json
{
  "firstName": "string (required, max 100)",
  "lastName": "string (required, max 100)",
  "email": "string (required, unique, max 255, valid email)",
  "phone": "string (required, max 20)"
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "firstName": "Ivan",
  "lastName": "Ivanov",
  "email": "ivan@example.com",
  "phone": "+380501234567"
}
```

**Example cURL:**
```bash
curl -X POST http://localhost:8080/guests \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Ivan",
    "lastName": "Ivanov",
    "email": "ivan@example.com",
    "phone": "+380501234567"
  }'
```

---

### 3.2 Get All Guests / Отримати всіх гостей
**Endpoint:** `GET /guests`
**Description:** Retrieves list of all guests / Отримує список всіх гостей

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "firstName": "Ivan",
    "lastName": "Ivanov",
    "email": "ivan@example.com",
    "phone": "+380501234567"
  }
]
```

---

### 3.3 Get Guest by ID / Отримати гостя за ID
**Endpoint:** `GET /guests/{id}`
**Description:** Retrieves guest information by ID / Отримує інформацію про гостя за ID

**Response (200 OK):** Same as 3.1

---

### 3.4 Update Guest / Оновити гостя
**Endpoint:** `PUT /guests/{id}`
**Description:** Updates guest information / Оновлює інформацію про гостя

**Response (200 OK):** Same as 3.1

---

### 3.5 Delete Guest / Видалити гостя
**Endpoint:** `DELETE /guests/{id}`
**Description:** Deletes guest from system / Видаляє гостя з системи

**Response (204 No Content)**

---

### 3.6 Get Guest Bookings / Отримати бронювання гостя
**Endpoint:** `GET /guests/{id}/bookings`
**Description:** Retrieves all bookings for a guest / Отримує всі бронювання гостя

**Response (200 OK):** Message with guest bookings

---

## 4. BOOKINGS API / API БРОНЮВАНЬ

### 4.1 Create Booking / Створити бронювання
**Endpoint:** `POST /bookings`
**Description:** Creates a new booking / Створює нове бронювання

**Request Body:**
```json
{
  "checkInDate": "date (required, YYYY-MM-DD format)",
  "checkOutDate": "date (required, YYYY-MM-DD format, after checkInDate)",
  "status": "string (optional, default: 'ACTIVE', values: 'ACTIVE', 'COMPLETED', 'CANCELLED')",
  "roomId": "long (required)",
  "guestId": "long (required)"
}
```

**Response (201 Created):**
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

**Example cURL:**
```bash
curl -X POST http://localhost:8080/bookings \
  -H "Content-Type: application/json" \
  -d '{
    "checkInDate": "2024-05-01",
    "checkOutDate": "2024-05-05",
    "status": "ACTIVE",
    "roomId": 1,
    "guestId": 1
  }'
```

---

### 4.2 Get All Bookings / Отримати всі бронювання
**Endpoint:** `GET /bookings`
**Description:** Retrieves list of all bookings / Отримує список всіх бронювань

**Response (200 OK):** Array of bookings

---

### 4.3 Get Booking by ID / Отримати бронювання за ID
**Endpoint:** `GET /bookings/{id}`
**Description:** Retrieves booking information by ID / Отримує інформацію про бронювання за ID

**Response (200 OK):** Same as 4.1

---

### 4.4 Update Booking / Оновити бронювання
**Endpoint:** `PUT /bookings/{id}`
**Description:** Updates booking information / Оновлює інформацію про бронювання

**Response (200 OK):** Same as 4.1

---

### 4.5 Cancel Booking / Скасувати бронювання
**Endpoint:** `DELETE /bookings/{id}`
**Description:** Cancels a booking (changes status to CANCELLED) / Скасовує бронювання (змінює статус на CANCELLED)

**Response (200 OK):**
```json
{
  "id": 1,
  "checkInDate": "2024-05-01",
  "checkOutDate": "2024-05-05",
  "status": "CANCELLED",
  "roomId": 1,
  "guestId": 1
}
```

---

### 4.6 Get Active Bookings / Отримати активні бронювання
**Endpoint:** `GET /bookings/active`
**Description:** Retrieves all active bookings / Отримує всі активні бронювання

**Response (200 OK):** Array of active bookings

---

## 5. AMENITIES API / API ЗРУЧНОСТЕЙ

### 5.1 Create Amenity / Створити зручність
**Endpoint:** `POST /amenities`
**Description:** Creates a new amenity / Створює нову зручність

**Request Body:**
```json
{
  "name": "string (required, max 100)",
  "description": "string (required, max 500)",
  "hotelId": "long (required)"
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "name": "WiFi",
  "description": "High-speed wireless internet",
  "hotelId": 1
}
```

---

### 5.2 Get All Amenities / Отримати всі зручності
**Endpoint:** `GET /amenities`
**Description:** Retrieves list of all amenities / Отримує список всіх зручностей

**Response (200 OK):** Array of amenities

---

### 5.3 Get Amenity by ID / Отримати зручність за ID
**Endpoint:** `GET /amenities/{id}`
**Description:** Retrieves amenity information by ID / Отримує інформацію про зручність за ID

**Response (200 OK):** Same as 5.1

---

### 5.4 Add Amenity to Room / Додати зручність до номера
**Endpoint:** `POST /amenities/rooms/{roomId}/amenities/{amenityId}`
**Description:** Adds an amenity to a room / Додає зручність до номера

**Path Parameters:**
- `roomId` (long, required) - Room identifier / ID номера
- `amenityId` (long, required) - Amenity identifier / ID зручності

**Response (201 Created):** No body

---

### 5.5 Remove Amenity from Room / Видалити зручність з номера
**Endpoint:** `DELETE /amenities/rooms/{roomId}/amenities/{amenityId}`
**Description:** Removes an amenity from a room / Видаляє зручність з номера

**Response (204 No Content)**

---

### 5.6 Delete Amenity / Видалити зручність
**Endpoint:** `DELETE /amenities/{id}`
**Description:** Deletes amenity from system / Видаляє зручність з системи

**Response (204 No Content)**

---

## 6. SEARCH API / API ПОШУКУ

### 6.1 Search Hotels / Пошук готелів
**Endpoint:** `GET /search/hotels?query={searchText}`
**Description:** Searches hotels by name or city / Шукає готелі за назвою або містом

**Query Parameters:**
- `query` (string, required) - Search text / Текст пошуку

**Response (200 OK):**
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

**Example cURL:**
```bash
curl "http://localhost:8080/search/hotels?query=kyiv"
```

---

### 6.2 Search Rooms / Пошук номерів
**Endpoint:** `GET /search/rooms?query={searchText}`
**Description:** Searches rooms by type / Шукає номери за типом

**Query Parameters:**
- `query` (string, required) - Search text / Текст пошуку

**Response (200 OK):** Array of rooms

---

### 6.3 Search Guests / Пошук гостей
**Endpoint:** `GET /search/guests?query={searchText}`
**Description:** Searches guests by name / Шукає гостей за ім'ям

**Query Parameters:**
- `query` (string, required) - Search text / Текст пошуку

**Response (200 OK):** Array of guests

---

## 7. ANALYTICS API / API АНАЛІТИКИ

### 7.1 Get Hotels Count / Отримати кількість готелів
**Endpoint:** `GET /analytics/hotels/count`
**Description:** Returns total count of hotels / Повертає загальну кількість готелів

**Response (200 OK):**
```json
{
  "totalHotels": 4
}
```

---

### 7.2 Get Rooms Count / Отримати кількість номерів
**Endpoint:** `GET /analytics/rooms/count`
**Description:** Returns total count of rooms / Повертає загальну кількість номерів

**Response (200 OK):**
```json
{
  "totalRooms": 16
}
```

---

### 7.3 Get Active Bookings Count / Отримати кількість активних бронювань
**Endpoint:** `GET /analytics/bookings/active`
**Description:** Returns count of active bookings / Повертає кількість активних бронювань

**Response (200 OK):**
```json
{
  "activeBookings": 5
}
```

---

### 7.4 Get Completed Bookings Count / Отримати кількість завершених бронювань
**Endpoint:** `GET /analytics/bookings/completed`
**Description:** Returns count of completed bookings / Повертає кількість завершених бронювань

**Response (200 OK):**
```json
{
  "completedBookings": 2
}
```

---

### 7.5 Get Rooms by Type / Отримати номери за типом
**Endpoint:** `GET /analytics/rooms/by-type`
**Description:** Returns count of rooms grouped by type / Повертає кількість номерів за типом

**Response (200 OK):**
```json
{
  "Standard": 5,
  "Deluxe": 7,
  "Suite": 4
}
```

---

### 7.6 Get All Analytics / Отримати всю аналітику
**Endpoint:** `GET /analytics/all`
**Description:** Returns all analytics information / Повертає всю аналітичну інформацію

**Response (200 OK):**
```json
{
  "totalHotels": 4,
  "totalRooms": 16,
  "totalGuests": 8,
  "totalBookings": 8,
  "activeBookings": 5,
  "completedBookings": 2
}
```

---

## 8. HEALTH & METRICS API / API ЗДОРОВ'Я ТА МЕТРИК

### 8.1 Check Service Health / Перевірити стан сервісу
**Endpoint:** `GET /actuator/health`
**Description:** Checks if service is running / Перевіряє чи працює сервіс

**Response (200 OK):**
```json
{
  "status": "UP",
  "timestamp": "2024-04-15T10:00:00",
  "message": "Hotel Management Service is running"
}
```

---

### 8.2 Get Metrics / Отримати метрики
**Endpoint:** `GET /actuator/metrics`
**Description:** Lists available metrics / Повертає список доступних метрик

**Response (200 OK):**
```json
{
  "availableMetrics": "Use /actuator/metrics/{metric.name}"
}
```

---

### 8.3 Get Prometheus Metrics / Отримати Prometheus метрики
**Endpoint:** `GET /actuator/prometheus`
**Description:** Returns Prometheus format metrics / Повертає метрики у форматі Prometheus

**Response (200 OK):** Prometheus metrics in text format

---

## Error Responses / Помилкові відповіді

### 400 Bad Request
```json
{
  "timestamp": "2024-04-15T10:00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Invalid request parameters"
}
```

### 404 Not Found
```json
{
  "timestamp": "2024-04-15T10:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Hotel not found with id: 999"
}
```

### 500 Internal Server Error
```json
{
  "timestamp": "2024-04-15T10:00:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "An error occurred processing your request"
}
```

---

## Common HTTP Status Codes / Загальні HTTP коди

| Code | Status | Description |
|------|--------|-------------|
| 200 | OK | Successful request / Успішний запит |
| 201 | Created | Resource created / Ресурс створено |
| 204 | No Content | Successful deletion / Успішне видалення |
| 400 | Bad Request | Invalid request / Невалідний запит |
| 404 | Not Found | Resource not found / Ресурс не знайдено |
| 500 | Server Error | Server error / Помилка сервера |

---

## Data Formats / Формати даних

### Date Format / Формат дати
```
YYYY-MM-DD (e.g., 2024-05-01)
```

### DateTime Format / Формат дати-часу
```
YYYY-MM-DDTHH:MM:SS (e.g., 2024-04-15T10:00:00)
```

### Phone Number Format / Формат телефону
```
Recommended: +[country_code][number]
Приклад: +380501234567
```

### Email Format / Формат email
```
Must be valid email format
Повинен бути валідний email
```

---

End of API Specification / Кінець специфікації API

