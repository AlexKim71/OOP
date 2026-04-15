# QUICK START GUIDE / ПОСІБНИК ШВИДКОГО СТАРТУ

## 🚀 5-Хвилинний Старт / 5-Minute Quick Start

### Крок 1: Встановіть PostgreSQL / Step 1: Install PostgreSQL

```bash
# Windows: Download and install from https://www.postgresql.org/download/
# Запам'ятайте пароль: useruser

# Linux (Ubuntu):
sudo apt-get install postgresql postgresql-contrib

# macOS:
brew install postgresql
```

### Крок 2: Створіть базу даних / Step 2: Create Database

```bash
# Запустіть psql (PostgreSQL terminal)
psql -U postgres

# Скопіюйте та вставте:
CREATE DATABASE hotel_management_db;
CREATE USER user_db WITH PASSWORD 'useruser';
GRANT ALL PRIVILEGES ON DATABASE hotel_management_db TO user_db;
\q
```

### Крок 3: Запустіть проект / Step 3: Run Project

```bash
# Перейдіть до папки проекту
cd D:\Projects\lab-2-AI-243

# Запустіть через Maven
.\mvnw.cmd spring-boot:run
```

### Крок 4: Перевірте / Step 4: Test

```bash
# В іншому терміналі:
curl http://localhost:8080/actuator/health
```

**Результат / Result:**
```json
{
  "status": "UP",
  "message": "Hotel Management Service is running"
}
```

---

## 📝 Приклади запитів / Example Requests

### Створити готель / Create Hotel

```bash
curl -X POST http://localhost:8080/hotels \
  -H "Content-Type: application/json" \
  -d '{
    "name": "My Hotel",
    "city": "Kyiv",
    "address": "123 Street",
    "rating": 5
  }'
```

### Отримати всі готелі / Get All Hotels

```bash
curl http://localhost:8080/hotels
```

### Зареєструвати гостя / Register Guest

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

### Отримати аналітику / Get Analytics

```bash
curl http://localhost:8080/analytics/all
```

---

## 🔧 Конфігурація / Configuration

### Змінити порт / Change Port

Редагуйте `application.properties`:
```properties
server.port=8081
```

### Змінити БД / Change Database

Редагуйте `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/YOUR_DB
spring.datasource.username=YOUR_USER
spring.datasource.password=YOUR_PASSWORD
```

---

## 🧪 Тестування / Testing

### Використати Postman / Use Postman

1. Завантажте Postman: https://www.postman.com/
2. Import → Select file → `postman_collection.json`
3. Запустіть запити / Run requests

### Використати curl / Use curl

Див. приклади вище / See examples above

### Використати VS Code REST Client

1. Встановіть extension: `REST Client` від Huachao Mao
2. Відкрийте файл `test-requests.http`
3. Натисніть "Send Request" над кожним запитом

---

## 📊 API Endpoints

### Hotels
- `POST /hotels` - Створити
- `GET /hotels` - Отримати всі
- `GET /hotels/{id}` - Отримати за ID
- `PUT /hotels/{id}` - Оновити
- `DELETE /hotels/{id}` - Видалити

### Rooms
- `POST /rooms` - Створити
- `GET /rooms` - Отримати всі
- `GET /rooms/{id}` - Отримати за ID
- `GET /rooms/hotel/{hotelId}` - За готелем
- `PUT /rooms/{id}` - Оновити
- `DELETE /rooms/{id}` - Видалити

### Guests
- `POST /guests` - Зареєструвати
- `GET /guests` - Отримати всіх
- `GET /guests/{id}` - Отримати за ID
- `PUT /guests/{id}` - Оновити
- `DELETE /guests/{id}` - Видалити

### Bookings
- `POST /bookings` - Створити
- `GET /bookings` - Отримати всі
- `GET /bookings/{id}` - Отримати за ID
- `GET /bookings/active` - Активні
- `PUT /bookings/{id}` - Оновити
- `DELETE /bookings/{id}` - Скасувати

### Amenities
- `POST /amenities` - Створити
- `GET /amenities` - Отримати всі
- `DELETE /amenities/{id}` - Видалити
- `POST /amenities/rooms/{roomId}/amenities/{amenityId}` - Додати
- `DELETE /amenities/rooms/{roomId}/amenities/{amenityId}` - Видалити

### Search
- `GET /search/hotels?query=` - Пошук готелів
- `GET /search/rooms?query=` - Пошук номерів
- `GET /search/guests?query=` - Пошук гостей

### Analytics
- `GET /analytics/hotels/count` - Готелі
- `GET /analytics/rooms/count` - Номери
- `GET /analytics/bookings/active` - Активні
- `GET /analytics/bookings/completed` - Завершені
- `GET /analytics/rooms/by-type` - За типом
- `GET /analytics/all` - Все

### Health
- `GET /actuator/health` - Здоров'я
- `GET /actuator/metrics` - Метрики
- `GET /actuator/prometheus` - Prometheus

---

## 🐛 Вирішення проблем / Troubleshooting

### ❌ Port 8080 already in use
```bash
# Знайдіть процес
netstat -ano | findstr :8080

# Вбийте процес (замініть PID)
taskkill /PID 1234 /F

# Або змініть порт у application.properties
server.port=8081
```

### ❌ PostgreSQL connection refused
```bash
# Запустіть PostgreSQL
net start PostgreSQL13

# Або у Linux
sudo service postgresql start
```

### ❌ Database does not exist
```bash
# Переконайтеся, що створили БД
psql -U postgres
\l  # Список БД
```

### ❌ Cannot compile project
```bash
# Очистіть та переспробуйте
.\mvnw.cmd clean install
.\mvnw.cmd spring-boot:run
```

---

## 📚 Документація / Documentation

- **README.md** - Повний опис проекту
- **API_SPECIFICATION.md** - Детальна специфікація API
- **DEPLOYMENT_GUIDE.md** - Посібник розгортання
- **postman_collection.json** - Postman колекція
- **test-requests.http** - HTTP запити для тестування

---

## ✅ Перевірка встановлення / Verify Installation

```bash
# 1. Перевірте Java
java -version

# 2. Перевірте Maven
mvn --version

# 3. Перевірте PostgreSQL
psql --version

# 4. Запустіть сервіс
mvn spring-boot:run

# 5. У новому терміналі перевірте health
curl http://localhost:8080/actuator/health
```

---

## 🎯 Наступні кроки / Next Steps

1. ✅ Запустіть сервіс
2. 📖 Прочитайте README.md
3. 🧪 Протестуйте API запити
4. 📊 Перевірте аналітику
5. 🔄 Інтегруйте з вашим frontend

---

## 🆘 Потрібна допомога? / Need Help?

- 📖 Див. README.md для більш детальної інформації
- 📋 Див. API_SPECIFICATION.md для опису всіх endpoints
- 🚀 Див. DEPLOYMENT_GUIDE.md для детальної інсталяції

---

**Приємного використання! / Happy coding!** 🎉

