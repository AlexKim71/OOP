# DEVELOPMENT GUIDE / ПОСІБНИК РОЗРОБНИКА

## 📋 Індекс / Table of Contents

1. [Project Structure](#project-structure)
2. [Architecture](#architecture)
3. [Database Schema](#database-schema)
4. [Entity Relationships](#entity-relationships)
5. [Code Conventions](#code-conventions)
6. [Development Workflow](#development-workflow)
7. [Testing](#testing)
8. [Deployment](#deployment)

---

## Project Structure

```
lab-2-AlexKim71-1/
├── .mvn/                          # Maven wrapper files
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ua/opnu/labwork2/
│   │   │       ├── controller/    # REST Controllers
│   │   │       │   ├── HotelController.java
│   │   │       │   ├── RoomController.java
│   │   │       │   ├── GuestController.java
│   │   │       │   ├── BookingController.java
│   │   │       │   ├── AmenityController.java
│   │   │       │   ├── SearchController.java
│   │   │       │   ├── AnalyticsController.java
│   │   │       │   └── HealthController.java
│   │   │       ├── service/       # Business Logic
│   │   │       │   ├── HotelService.java
│   │   │       │   ├── RoomService.java
│   │   │       │   ├── GuestService.java
│   │   │       │   ├── BookingService.java
│   │   │       │   └── AmenityService.java
│   │   │       ├── repository/    # Data Access
│   │   │       │   ├── HotelRepository.java
│   │   │       │   ├── RoomRepository.java
│   │   │       │   ├── GuestRepository.java
│   │   │       │   ├── BookingRepository.java
│   │   │       │   └── AmenityRepository.java
│   │   │       ├── entity/        # JPA Entities
│   │   │       │   ├── Hotel.java
│   │   │       │   ├── Room.java
│   │   │       │   ├── Guest.java
│   │   │       │   ├── Booking.java
│   │   │       │   ├── Amenity.java
│   │   │       │   └── BookingStatus.java
│   │   │       ├── dto/           # DTOs
│   │   │       │   ├── HotelDTO.java
│   │   │       │   ├── RoomDTO.java
│   │   │       │   ├── GuestDTO.java
│   │   │       │   ├── BookingDTO.java
│   │   │       │   └── AmenityDTO.java
│   │   │       └── Labwork2Application.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── ua/opnu/labwork2/
│               └── Labwork2ApplicationTests.java
├── pom.xml
├── mvnw / mvnw.cmd
├── README.md
├── QUICK_START.md
├── DEPLOYMENT_GUIDE.md
├── DEVELOPMENT_GUIDE.md (THIS FILE)
├── API_SPECIFICATION.md
├── postman_collection.json
├── test-requests.http
└── init-data.sql
```

---

## Architecture

### Layered Architecture / Архітектура залежностей

```
┌─────────────────────────────────┐
│   REST Controllers              │  (Presentation Layer)
│   (HotelController, etc.)       │  (Шар представлення)
└────────────────┬────────────────┘
                 │
┌─────────────────▼────────────────┐
│   Service Layer                 │  (Business Logic Layer)
│   (HotelService, etc.)          │  (Шар бізнес-логіки)
└────────────────┬────────────────┘
                 │
┌─────────────────▼────────────────┐
│   Repository Layer              │  (Data Access Layer)
│   (HotelRepository, etc.)       │  (Шар доступу до даних)
└────────────────┬────────────────┘
                 │
┌─────────────────▼────────────────┐
│   Database (PostgreSQL)         │  (Persistence Layer)
│                                 │  (Шар збереження)
└─────────────────────────────────┘
```

### Request Flow / Потік запиту

1. **HTTP Request** → REST Controller
2. **Controller** → Service Layer
3. **Service** → Repository
4. **Repository** → Database
5. **Database** → Repository
6. **Repository** → Service
7. **Service** → Controller
8. **Controller** → HTTP Response

---

## Database Schema

### Entity Relationship Diagram / Діаграма зв'язків сутностей

```
┌──────────────┐         ┌──────────────┐
│    Hotel     │────1:N──│     Room     │
└──────────────┘         └──────────────┘
     │                         │
     │                         │
     │ 1:N                     │ 1:N
     │                         │
┌────▼─────────┐         ┌─────▼─────────┐
│   Amenity    │         │   Booking     │
└─────────────┤         └─────────┬─────┘
              │                    │
              └─────M:N────┐  1:N  │
                        │          │
                   ┌────▼──────────▼─┐
                   │     Guest       │
                   └─────────────────┘
```

### Tables / Таблиці

#### Hotels Table
```sql
CREATE TABLE hotels (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    address VARCHAR(500) NOT NULL,
    rating INTEGER NOT NULL
);
```

#### Rooms Table
```sql
CREATE TABLE rooms (
    id SERIAL PRIMARY KEY,
    number VARCHAR(50) NOT NULL,
    type VARCHAR(100) NOT NULL,
    price_per_night DOUBLE PRECISION NOT NULL,
    capacity INTEGER NOT NULL,
    hotel_id BIGINT NOT NULL,
    FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);
```

#### Guests Table
```sql
CREATE TABLE guests (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL
);
```

#### Bookings Table
```sql
CREATE TABLE bookings (
    id SERIAL PRIMARY KEY,
    check_in_date DATE NOT NULL,
    check_out_date DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    room_id BIGINT NOT NULL,
    guest_id BIGINT NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms(id),
    FOREIGN KEY (guest_id) REFERENCES guests(id)
);
```

#### Amenities Table
```sql
CREATE TABLE amenities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL,
    hotel_id BIGINT NOT NULL,
    FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);
```

#### Room Amenities Junction Table
```sql
CREATE TABLE room_amenities (
    room_id BIGINT NOT NULL,
    amenity_id BIGINT NOT NULL,
    PRIMARY KEY (room_id, amenity_id),
    FOREIGN KEY (room_id) REFERENCES rooms(id),
    FOREIGN KEY (amenity_id) REFERENCES amenities(id)
);
```

---

## Entity Relationships

### One-to-Many (1:N) / Один до багатьох

#### Hotel ↔ Room
```java
@Entity
public class Hotel {
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Room> rooms = new HashSet<>();
}

@Entity
public class Room {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
```

#### Hotel ↔ Amenity
```java
@Entity
public class Hotel {
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Amenity> amenities = new HashSet<>();
}

@Entity
public class Amenity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
```

#### Room ↔ Booking
```java
@Entity
public class Room {
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Booking> bookings = new HashSet<>();
}

@Entity
public class Booking {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
}
```

#### Guest ↔ Booking
```java
@Entity
public class Guest {
    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
    private Set<Booking> bookings = new HashSet<>();
}

@Entity
public class Booking {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")
    private Guest guest;
}
```

### Many-to-Many (M:N) / Багато до багатьох

#### Room ↔ Amenity
```java
@Entity
public class Room {
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "room_amenities",
        joinColumns = @JoinColumn(name = "room_id"),
        inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private Set<Amenity> amenities = new HashSet<>();
}

@Entity
public class Amenity {
    @ManyToMany(mappedBy = "amenities")
    private Set<Room> rooms = new HashSet<>();
}
```

---

## Code Conventions

### Naming Conventions / Конвенції найменування

#### Classes / Класи
```java
// Entity Classes - использовать единственное число
public class Hotel { }
public class Room { }
public class Guest { }

// Service Classes - с суффиксом Service
public class HotelService { }
public class RoomService { }

// Repository Classes - с суффиксом Repository
public class HotelRepository { }
public class RoomRepository { }

// Controller Classes - с суффиксом Controller
public class HotelController { }
public class RoomController { }

// DTO Classes - с суффиксом DTO
public class HotelDTO { }
public class RoomDTO { }
```

#### Methods / Методи

```java
// CRUD Operations
public T create(T entity)
public List<T> getAll()
public T getById(Long id)
public T update(Long id, T entity)
public void delete(Long id)

// Custom Queries
public List<T> findByProperty(String property)
public T findByUniqueProperty(String property)
```

#### Variables / Змінні

```java
private Long id;                    // ID
private String name;                // Name
private String description;         // Description
private Double pricePerNight;       // Price (camelCase)
private Integer capacity;           // Capacity
private LocalDate checkInDate;      // Date (camelCase)
```

### Code Style / Стиль коду

#### Annotations
```java
@Entity
@Table(name = "hotels")
@Data                               // Lombok
@NoArgsConstructor                 // Lombok
@AllArgsConstructor                // Lombok
@Builder                           // Lombok
public class Hotel {
    // ...
}
```

#### Service Class Template
```java
@Service
@RequiredArgsConstructor
@Transactional
public class HotelService {
    
    private final HotelRepository hotelRepository;
    
    public HotelDTO createHotel(HotelDTO hotelDTO) {
        // Implementation
    }
    
    public List<HotelDTO> getAllHotels() {
        // Implementation
    }
    
    public HotelDTO getHotelById(Long id) {
        // Implementation
    }
    
    public HotelDTO updateHotel(Long id, HotelDTO hotelDTO) {
        // Implementation
    }
    
    public void deleteHotel(Long id) {
        // Implementation
    }
    
    private HotelDTO convertToDTO(Hotel hotel) {
        // Implementation
    }
}
```

#### Controller Class Template
```java
@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {
    
    private final HotelService hotelService;
    
    @PostMapping
    public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(hotelService.createHotel(hotelDTO));
    }
    
    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }
    
    // Other methods...
}
```

---

## Development Workflow

### Setting Up Development Environment

```bash
# 1. Clone the repository
git clone <repository_url>
cd lab-2-AI-243

# 2. Install dependencies
mvn clean install

# 3. Setup database
# Run init-data.sql in PostgreSQL

# 4. Start development server
mvn spring-boot:run

# 5. Verify server is running
curl http://localhost:8080/actuator/health
```

### Making Changes

```bash
# 1. Create a new branch
git checkout -b feature/your-feature-name

# 2. Make your changes

# 3. Test your changes
mvn test

# 4. Commit your changes
git add .
git commit -m "Add your feature description"

# 5. Push to repository
git push origin feature/your-feature-name
```

### Adding a New Entity

1. Create Entity class in `entity/` package
2. Create DTO class in `dto/` package
3. Create Repository interface in `repository/` package
4. Create Service class in `service/` package
5. Create Controller class in `controller/` package

### Example: Adding User Entity

```java
// 1. Entity
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String email;
}

// 2. DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String email;
}

// 3. Repository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

// 4. Service
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    // Implementation
}

// 5. Controller
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    // Implementation
}
```

---

## Testing

### Running Tests / Запуск тестів

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=HotelServiceTest

# Run with coverage
mvn test jacoco:report
```

### Test Structure / Структура тестів

```java
@SpringBootTest
@AutoConfigureMockMvc
public class HotelServiceTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private HotelRepository hotelRepository;
    
    @Test
    public void testCreateHotel() {
        // Given
        HotelDTO hotelDTO = HotelDTO.builder()
            .name("Test Hotel")
            .city("Kyiv")
            .address("123 St")
            .rating(5)
            .build();
        
        // When
        // Then
    }
}
```

---

## Deployment

### Building for Production / Збірка для продакшену

```bash
# Build JAR file
mvn clean package

# Run JAR file
java -jar target/labwork-2-0.0.1-SNAPSHOT.jar
```

### Environment Variables / Змінні середовища

```bash
# Database
SPRING_DATASOURCE_URL=jdbc:postgresql://host:5432/db_name
SPRING_DATASOURCE_USERNAME=username
SPRING_DATASOURCE_PASSWORD=password

# Server
SERVER_PORT=8080

# JPA
SPRING_JPA_HIBERNATE_DDL_AUTO=validate
```

### Docker Deployment / Розгортання в Docker

```dockerfile
FROM eclipse-temurin:17-jre-focal

WORKDIR /app

COPY target/labwork-2-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
```

```bash
# Build and run
docker build -t hotel-api .
docker run -p 8080:8080 hotel-api
```

---

## Additional Resources / Додаткові ресурси

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [Hibernate ORM](https://hibernate.org/)
- [Project Lombok](https://projectlombok.org/)

---

**Happy coding! / Приємного кодування!** 🎉

