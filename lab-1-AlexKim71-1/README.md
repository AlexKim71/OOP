# Лабораторна робота 1 — REST API управління бронюванням готелів (Варіант 6)

## Опис проєкту

Spring Boot REST API для управління системою бронювання номерів у готелях. Сервіс реалізує заглушки для CRUD-операцій над основними сутностями предметної області та надає API для пошуку, аналітики та метрик.

### Основні можливості

- Управління готелями, номерами, клієнтами і бронюваннями
- Повнотекстовий пошук по готелях, номерах та клієнтах
- Аналітичні запити (кількість готелів, активні бронювання тощо)
- Метрики здоров'я та інформація про сервіс
- Всі відповіді через `ResponseEntity`

## Технічний стек

- **Java 17+**
- **Spring Boot 4.0.5**
- **Maven 3.9.14**
- **JUnit 5** для тестування

## Архітектура проєкту

### Сутності (5 класів)

| Сутність | Поля | 
|----------|------|
| `Hotel` | `id`, `name`, `city`, `address`, `rating` |
| `Room` | `id`, `number`, `type`, `pricePerNight`, `capacity` |
| `Guest` | `id`, `firstName`, `lastName`, `email`, `phone` |
| `Booking` | `id`, `checkInDate`, `checkOutDate`, `status` |
| `Amenity` | `id`, `name`, `description` |

**`BookingStatus`** — enum з можливими значеннями: `NEW`, `ACTIVE`, `COMPLETED`, `CANCELED`.

### Контролери (8 штук)

1. **`HotelController`** — управління готелями (6 endpoint-ів)
2. **`RoomController`** — управління номерами (6 endpoint-ів)
3. **`GuestController`** — управління клієнтами (6 endpoint-ів)
4. **`BookingController`** — управління бронюваннями (6 endpoint-ів)
5. **`AmenityController`** — управління зручностями (6 endpoint-ів)
6. **`SearchController`** — повнотекстовий пошук (3 endpoint-и)
7. **`AnalyticsController`** — аналітичні дані (5 endpoint-ів)
8. **`ActuatorController`** — метрики та статус сервісу (3 endpoint-и)

## REST API

### Hotels

```
POST   /hotels                 — Створити готель
GET    /hotels                 — Отримати список готелів
GET    /hotels/{id}            — Отримати готель за ID
PUT    /hotels/{id}            — Оновити готель
DELETE /hotels/{id}            — Видалити готель
GET    /hotels/{id}/rooms      — Отримати номери готелю
```

### Rooms

```
POST   /rooms                  — Створити номер
GET    /rooms                  — Отримати список номерів
GET    /rooms/{id}             — Отримати номер за ID
PUT    /rooms/{id}             — Оновити номер
DELETE /rooms/{id}             — Видалити номер
GET    /rooms/hotel/{hotelId}  — Отримати номери готелю
```

### Guests

```
POST   /guests                 — Створити клієнта
GET    /guests                 — Отримати список клієнтів
GET    /guests/{id}            — Отримати клієнта за ID
PUT    /guests/{id}            — Оновити клієнта
DELETE /guests/{id}            — Видалити клієнта
GET    /guests/{id}/bookings   — Отримати бронювання клієнта
```

### Bookings

```
POST   /bookings               — Створити бронювання
GET    /bookings               — Отримати список бронювань
GET    /bookings/{id}          — Отримати бронювання за ID
PUT    /bookings/{id}          — Оновити бронювання
DELETE /bookings/{id}          — Видалити бронювання
GET    /bookings/active        — Отримати активні бронювання
```

### Amenities

```
POST   /amenities              — Створити зручність
GET    /amenities              — Отримати список зручностей
GET    /amenities/{id}         — Отримати зручність за ID
DELETE /amenities/{id}         — Видалити зручність
POST   /rooms/{id}/amenities/{amenityId}    — Додати зручність до номера
DELETE /rooms/{id}/amenities/{amenityId}    — Видалити зручність у номера
```

### Search (Повнотекстовий пошук)

```
GET /search/hotels?query=<текст>   — Пошук готелів за назвою або містом
GET /search/rooms?query=<текст>    — Пошук номерів
GET /search/guests?query=<текст>   — Пошук клієнтів
```

### Analytics (Аналітика)

```
GET /analytics/hotels/count         — Загальна кількість готелів
GET /analytics/rooms/count          — Кількість номерів
GET /analytics/bookings/active      — Кількість активних бронювань
GET /analytics/bookings/completed   — Кількість завершених бронювань
GET /analytics/rooms/by-type        — Кількість номерів за типом
```

### Actuator (Метрики та статус)

```
GET /actuator/health   — Здоров'я сервісу
GET /actuator/info     — Інформація про сервіс
GET /actuator/metrics  — Метрики
```

## Запуск проєкту

### Передумови

- JDK 17+
- Maven (вбудований Maven wrapper)
- IntelliJ IDEA або VS Code

### Команди

#### Запуск застосунку

```bash
cd D:\Projects\lab-1-AlexKim71-1
./mvnw.cmd spring-boot:run
```

Сервер буде доступний за адресою: `http://localhost:8080`

#### Запуск тестів

```bash
./mvnw.cmd test
```

#### Чистої пересборки

```bash
./mvnw.cmd clean test
```

## Тестування в Postman

1. **Імпорт коллекції:**
   - Відкрити Postman
   - Натиснути **Import**
   - Вибрати файл `lab1-variant6.postman_collection.json` з коренів проєкту

2. **Налаштування змінної:**
   - Переконатися, що змінна `baseUrl` встановлена в `http://localhost:8080`

3. **Запуск запитів:**
   - Можна вручну тестувати кожен endpoint
   - Або натиснути **Run collection** для автоматичного запуску всіх запитів

4. **Очікуваний результат:**
   - CRUD endpoint-и повертають об'єкти-заглушки (HTTP 200)
   - Search/Analytics/Actuator endpoint-и повертають строкові статуси
   - Немає помилок 404 чи 500

## Приклади запитів

### GET /hotels
```bash
curl http://localhost:8080/hotels
```

Відповідь:
```json
[
  {
    "id": 1,
    "name": "Grand Palace",
    "city": "Odesa",
    "address": "Shevchenka Ave, 1",
    "rating": 5
  },
  {
    "id": 2,
    "name": "Sea View",
    "city": "Lviv",
    "address": "Freedom Sq, 10",
    "rating": 4
  }
]
```

### GET /analytics/hotels/count
```bash
curl http://localhost:8080/analytics/hotels/count
```

Відповідь:
```
GET /analytics/hotels/count OK
```

## Структура проєкту

```
src/
├── main/
│   ├── java/ua/opnu/labwork21/
│   │   ├── Labwork21Application.java
│   │   ├── entity/
│   │   │   ├── Hotel.java
│   │   │   ├── Room.java
│   │   │   ├── Guest.java
│   │   │   ├── Booking.java
│   │   │   ├── Amenity.java
│   │   │   └── BookingStatus.java (enum)
│   │   └── controller/
│   │       ├── HotelController.java
│   │       ├── RoomController.java
│   │       ├── GuestController.java
│   │       ├── BookingController.java
│   │       ├── AmenityController.java
│   │       ├── SearchController.java
│   │       ├── AnalyticsController.java
│   │       └── ActuatorController.java
│   └── resources/
│       └── application.yaml
└── test/
    └── java/ua/opnu/labwork21/
        └── Labwork21ApplicationTests.java
```

## Чеклист виконання (за Lab1.md)

- [x] **5 сутностей** створено згідно варіанту 6
- [x] **Конструктори** без параметрів та з параметрами в кожній сутності
- [x] **Getter-и** для всіх полів
- [x] **Setter** тільки для поля `id`
- [x] **8 REST-контролерів** реалізовано
- [x] **ResponseEntity** у всіх методах контролерів
- [x] **Заглушки** для CRUD-методів (об'єкти створені прямо в контролері)
- [x] **Search/Analytics/Actuator** повертають рядки-статуси
- [x] **Postman-коллекція** експортована в JSON в корінь репозиторію
- [x] **README** з описом виконаної роботи

## Примітки

1. На цьому етапі реалізовані тільки **заглушки** — реальна база даних не використовується.
2. Зв'язки між сутностями (1:N, M:N) ігноруються на цьому етапі.
3. Клієнтський код отримує завжди статичні тестові об'єкти.
4. Проєкт готовий до розширення на наступних лабораторних роботах.

## Контакт та запитання

Для запитань щодо реалізації відкрити issue в репозиторії GitHub Classroom або зв'язатися з викладачем.

---

**Дата виконання:** 2026-04-01  
**Варіант:** 6  
**Статус:** ✅ Завершено

