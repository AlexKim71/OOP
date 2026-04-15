# 📚 PROJECT DOCUMENTATION INDEX / ІНДЕКС ДОКУМЕНТАЦІЇ ПРОЕКТУ

## Welcome! / Ласкаво просимо!

Це **Лабораторна робота 2: Backend-сервіс управління бронюванням готелів** на базі **Spring Boot 4.0.5** та **PostgreSQL**.

This is **Laboratory Work 2: Hotel Booking Management Backend Service** based on **Spring Boot 4.0.5** and **PostgreSQL**.

---

## 📖 Документація / Documentation Files

### 🚀 **QUICK_START.md** - Швидкий старт (5 хвилин)
**Для:** Розробників які хочуть швидко запустити проект  
**Містить:**
- Установка PostgreSQL
- Створення бази даних
- Запуск сервісу
- Перші запити до API
- Вирішення проблем

👉 **Почніть звідси!** / **Start here!**

---

### 📋 **README.md** - Повний опис проекту
**Для:** Загального розуміння проекту  
**Містить:**
- Огляд проекту та технологічний стек
- Архітектура системи
- Модель даних та сутності
- REST API endpoints (таблиці методів)
- Приклади запитів
- Конфігурація
- Встановлення та запуск

👉 **Прочитайте для розуміння!** / **Read for understanding!**

---

### 🔌 **API_SPECIFICATION.md** - Детальна специфікація API
**Для:** Розробників backend та frontend  
**Містить:**
- Детальний опис кожного endpoint
- Формати запитів та відповідей
- Приклади cURL для кожного методу
- Коди помилок
- Формати даних (дата, час, телефон, email)

👉 **Використовуйте для розробки!** / **Use for development!**

---

### 🛠️ **DEVELOPMENT_GUIDE.md** - Посібник розробника
**Для:** Backend розробників що розробляють систему  
**Містить:**
- Архітектура проекту (3-шарова структура)
- Структура папок та файлів
- Діаграми зв'язків сутностей
- Конвенції найменування коду
- Workflow розробки
- Тестування
- Розгортання

👉 **Дотримуйтеся для узгодженості!** / **Follow for consistency!**

---

### 🚢 **DEPLOYMENT_GUIDE.md** - Посібник розгортання
**Для:** DevOps інженерів та системних адміністраторів  
**Містить:**
- Попередні вимоги (Java, PostgreSQL, Maven)
- Кроки встановлення
- Конфігурація PostgreSQL
- Тестування API
- Вирішення проблем
- Docker розгортання

👉 **Використовуйте для розгортання!** / **Use for deployment!**

---

## 🧪 Тестові файли / Test Files

### 📮 **postman_collection.json** - Postman колекція
Готова колекція з всіма API запитами для Postman  
Ready collection with all API requests for Postman

**Як використовувати:**
1. Відкрийте Postman
2. File → Import → Select File
3. Виберіть `postman_collection.json`
4. Запустіть запити

---

### 📄 **test-requests.http** - HTTP тестові запити
Файл тестових запитів для VS Code REST Client extension  
Test requests file for VS Code REST Client extension

**Як використовувати:**
1. Встановіть extension: REST Client
2. Відкрийте `test-requests.http`
3. Натисніть "Send Request" над кожним запитом

---

### 🗄️ **init-data.sql** - Ініціальні дані
SQL скрипт з тестовими даними для бази даних  
SQL script with test data for the database

**Дані включають:**
- 4 готелі (Kyiv, Lviv, Odesa, Kharkiv)
- 16 номерів
- 8 гостей
- 8 бронювань
- 10 зручностей (WiFi, Pool, Spa, тощо)

---

## 📁 Структура проекту / Project Structure

```
lab-2-AlexKim71-1/
├── src/main/java/ua/opnu/labwork2/
│   ├── controller/          # REST Controllers (8 файлів)
│   ├── service/             # Business Logic (5 файлів)
│   ├── repository/          # Data Access (5 файлів)
│   ├── entity/              # JPA Entities (6 файлів)
│   ├── dto/                 # DTOs (5 файлів)
│   └── Labwork2Application.java
├── src/main/resources/
│   └── application.properties
├── pom.xml                  # Maven конфігурація
├── README.md
├── QUICK_START.md
├── API_SPECIFICATION.md
├── DEVELOPMENT_GUIDE.md
├── DEPLOYMENT_GUIDE.md
├── DOCUMENTATION_INDEX.md   # ЦЕЙ ФАЙЛ
├── postman_collection.json
├── test-requests.http
└── init-data.sql
```

---

## 🎯 Швидка навігація / Quick Navigation

### 🔰 Я новачок / I'm new
1. Прочитайте **QUICK_START.md** (5 хвилин)
2. Запустіть **DEPLOYMENT_GUIDE.md** 
3. Використовуйте **postman_collection.json** для тестування

### 👨‍💻 Я розробник / I'm a developer
1. Прочитайте **README.md**
2. Вивчіть **DEVELOPMENT_GUIDE.md**
3. Використовуйте **API_SPECIFICATION.md** для розробки
4. Тестуйте за допомогою **test-requests.http**

### 🏭 Я DevOps / I'm DevOps
1. Прочитайте **DEPLOYMENT_GUIDE.md**
2. Налаштуйте PostgreSQL
3. Розгорніть за допомогою Docker (див. у guide)
4. Перевірте здоров'я сервісу: `curl http://localhost:8080/actuator/health`

### 🎓 Я студент / I'm a student
1. Прочитайте **QUICK_START.md** для налаштування
2. Вивчіть **README.md** для розуміння архітектури
3. Вивчіть **DEVELOPMENT_GUIDE.md** для кодування
4. Дотримуйтеся конвенцій при написанні коду

---

## 📊 Основні компоненти / Key Components

### Entities (Сутності)
| Entity | Таблиця | Поля |
|--------|---------|------|
| Hotel | hotels | id, name, city, address, rating |
| Room | rooms | id, number, type, pricePerNight, capacity, hotelId |
| Guest | guests | id, firstName, lastName, email, phone |
| Booking | bookings | id, checkInDate, checkOutDate, status, roomId, guestId |
| Amenity | amenities | id, name, description, hotelId |

### Services (Сервісні шари)
- HotelService - управління готелями
- RoomService - управління номерами
- GuestService - управління гостями
- BookingService - управління бронюваннями
- AmenityService - управління зручностями

### Controllers (REST контролери)
- HotelController - endpoints `/hotels`
- RoomController - endpoints `/rooms`
- GuestController - endpoints `/guests`
- BookingController - endpoints `/bookings`
- AmenityController - endpoints `/amenities`
- SearchController - endpoints `/search`
- AnalyticsController - endpoints `/analytics`
- HealthController - endpoints `/actuator`

---

## 🔗 REST API Summary

### Hotels (Готелі)
```
POST   /hotels           - Створити
GET    /hotels           - Отримати всі
GET    /hotels/{id}      - Отримати за ID
PUT    /hotels/{id}      - Оновити
DELETE /hotels/{id}      - Видалити
```

### Rooms (Номери)
```
POST   /rooms            - Створити
GET    /rooms            - Отримати всі
GET    /rooms/{id}       - Отримати за ID
GET    /rooms/hotel/{id} - За готелем
PUT    /rooms/{id}       - Оновити
DELETE /rooms/{id}       - Видалити
```

### Guests (Гості)
```
POST   /guests           - Зареєструвати
GET    /guests           - Отримати всіх
GET    /guests/{id}      - Отримати за ID
PUT    /guests/{id}      - Оновити
DELETE /guests/{id}      - Видалити
```

### Bookings (Бронювання)
```
POST   /bookings         - Створити
GET    /bookings         - Отримати всі
GET    /bookings/{id}    - Отримати за ID
GET    /bookings/active  - Активні
PUT    /bookings/{id}    - Оновити
DELETE /bookings/{id}    - Скасувати
```

### Amenities (Зручності)
```
POST   /amenities                              - Створити
GET    /amenities                              - Отримати всі
POST   /amenities/rooms/{roomId}/amenities/... - Додати
DELETE /amenities/rooms/{roomId}/amenities/... - Видалити
```

### Search (Пошук)
```
GET /search/hotels?query=...  - Пошук готелів
GET /search/rooms?query=...   - Пошук номерів
GET /search/guests?query=...  - Пошук гостей
```

### Analytics (Аналітика)
```
GET /analytics/hotels/count      - Готелі
GET /analytics/rooms/count       - Номери
GET /analytics/bookings/active   - Активні бронювання
GET /analytics/bookings/completed - Завершені
GET /analytics/rooms/by-type     - За типом
GET /analytics/all               - Все
```

### Health & Metrics
```
GET /actuator/health     - Здоров'я
GET /actuator/metrics    - Метрики
GET /actuator/prometheus - Prometheus
```

---

## 🔧 Технологічний стек / Tech Stack

| Component | Version | Purpose |
|-----------|---------|---------|
| Java | 17 | Programming Language / Мова програмування |
| Spring Boot | 4.0.5 | Web Framework / Веб-фреймворк |
| Spring Data JPA | 4.0.5 | ORM / Об'єктно-реляційне картування |
| Hibernate | 6.2 | ORM Framework / ORM фреймворк |
| PostgreSQL | 12+ | Database / База даних |
| Lombok | 1.18 | Code Generation / Генерація коду |
| Maven | 3.6+ | Build Tool / Інструмент збірки |

---

## ✅ Pre-Requisites / Вимоги

- ✅ Java 17 або вище
- ✅ PostgreSQL 12 або вище
- ✅ Maven 3.6+
- ✅ Git (для клонування)
- ✅ Postman (опціонально для тестування)

---

## 🚀 Перший запуск / First Run

### 3 простих кроки / 3 Simple Steps:

```bash
# 1. Створіть БД
psql -U postgres
CREATE DATABASE hotel_management_db;
CREATE USER user_db WITH PASSWORD 'useruser';
GRANT ALL PRIVILEGES ON DATABASE hotel_management_db TO user_db;
\q

# 2. Запустіть сервіс
cd D:\Projects\lab-2-AlexKim71-1
.\mvnw.cmd spring-boot:run

# 3. Перевірте здоров'я
curl http://localhost:8080/actuator/health
```

---

## 📞 Support / Підтримка

### Документація
- 📖 README.md - Загальна інформація
- 🔌 API_SPECIFICATION.md - API деталі
- 🛠️ DEVELOPMENT_GUIDE.md - Розробка
- 🚢 DEPLOYMENT_GUIDE.md - Розгортання

### Тестування
- 📮 postman_collection.json - Postman
- 📄 test-requests.http - REST Client
- 🗄️ init-data.sql - Тестові дані

### Comunícation / Комунікація
- 💬 Issues - звітуйте про проблеми
- 📧 Email - технічна підтримка
- 📝 Wiki - додаткова інформація

---

## 📝 Файли розробки / Development Files

### Java Classes / Java класи (26 файлів)

**Entity Layer (6 файлів):**
- Hotel.java
- Room.java
- Guest.java
- Booking.java
- Amenity.java
- BookingStatus.java

**DTO Layer (5 файлів):**
- HotelDTO.java
- RoomDTO.java
- GuestDTO.java
- BookingDTO.java
- AmenityDTO.java

**Repository Layer (5 файлів):**
- HotelRepository.java
- RoomRepository.java
- GuestRepository.java
- BookingRepository.java
- AmenityRepository.java

**Service Layer (5 файлів):**
- HotelService.java
- RoomService.java
- GuestService.java
- BookingService.java
- AmenityService.java

**Controller Layer (8 файлів):**
- HotelController.java
- RoomController.java
- GuestController.java
- BookingController.java
- AmenityController.java
- SearchController.java
- AnalyticsController.java
- HealthController.java

**Application:**
- Labwork2Application.java

---

## 🎓 Learning Path / Шлях навчання

### Week 1 / Тиждень 1
- [ ] Встановіть PostgreSQL
- [ ] Запустіть сервіс
- [ ] Проведіть тестування з Postman
- [ ] Прочитайте README.md

### Week 2 / Тиждень 2
- [ ] Вивчіть DEVELOPMENT_GUIDE.md
- [ ] Зрозумійте архітектуру
- [ ] Вивчіть Entity-Relationship діаграму
- [ ] Дослідіть код Service層

### Week 3 / Тиждень 3
- [ ] Напишіть власну Feature
- [ ] Додайте новий endpoint
- [ ] Напишіть unit тести
- [ ] Протестуйте свої зміни

### Week 4 / Тиждень 4
- [ ] Розгорніть на сервері
- [ ] Налаштуйте моніторинг
- [ ] Оптимізуйте продуктивність
- [ ] Підготуйте звіт

---

## 🏆 Success Criteria / Критерії успіху

✅ Сервіс запускається без помилок  
✅ База даних створена та заповнена  
✅ Всі endpoints відповідають коректно  
✅ Пошук та аналітика працюють  
✅ Здоров'я сервісу: UP  
✅ Документація повна та зрозуміла  
✅ Код дотримується конвенцій  

---

## 📌 Важливі посилання / Important Links

- **Spring Boot**: https://spring.io/projects/spring-boot
- **PostgreSQL**: https://www.postgresql.org/
- **Maven**: https://maven.apache.org/
- **Postman**: https://www.postman.com/
- **REST Client (VS Code)**: https://marketplace.visualstudio.com/items?itemName=humao.rest-client

---

## ❓ FAQ / Часто задавані питання

**Q: Де знайти API documentation?**  
A: Див. файл **API_SPECIFICATION.md**

**Q: Як запустити тести?**  
A: `mvn test` або використовуйте **postman_collection.json**

**Q: Як розгорнути на продакшн?**  
A: Див. **DEPLOYMENT_GUIDE.md**

**Q: Як додати новий endpoint?**  
A: Див. **DEVELOPMENT_GUIDE.md** розділ "Adding a New Entity"

**Q: Як змінити порт?**  
A: Редагуйте `application.properties`: `server.port=8081`

**Q: Як переустановити БД?**  
A: `DROP DATABASE hotel_management_db;` та повторіть кроки встановлення

---

## 📄 Версія документації / Documentation Version

- **Version:** 1.0
- **Last Updated:** 2024-04-15
- **Project:** lab-2-AlexKim71-1
- **Status:** ✅ Complete and Production Ready

---

## 🎉 Готові почати? / Ready to Start?

1. 📖 Прочитайте **QUICK_START.md**
2. 🚀 Запустіть сервіс
3. 🧪 Протестуйте API
4. 💻 Почніть розробляти

**Приємного кодування! / Happy coding!** 🚀

---

**Lab 2 - Hotel Management System**  
Гаврилов Олександр В'ячеславович - Група AI-243  
OPNU - Open Polytechnic National University

