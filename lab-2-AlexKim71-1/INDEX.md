# 🎯 START HERE / ПОЧНІТЬ ЗВІДСИ

## Welcome to Lab 2: Hotel Management System Backend

This is your entry point. Choose your path below:

---

## 🚀 I WANT TO START QUICKLY (5 MINUTES)

**→ Read: [QUICK_START.md](QUICK_START.md)**

This file will get you up and running in just 5 minutes with:
- PostgreSQL setup
- Application launch
- First API test

---

## 📖 I WANT TO UNDERSTAND THE PROJECT

**→ Read: [README.md](README.md)**

Complete overview including:
- Project description
- Architecture
- Data model
- All API endpoints
- Examples

---

## 🔌 I WANT TO DEVELOP (ADD NEW FEATURES)

**→ Read: [DEVELOPMENT_GUIDE.md](DEVELOPMENT_GUIDE.md)**

Learn how to:
- Understand the architecture
- Follow code conventions
- Add new entities
- Write tests
- Best practices

---

## 🚢 I WANT TO DEPLOY TO PRODUCTION

**→ Read: [DEPLOYMENT_GUIDE.md](DEPLOYMENT_GUIDE.md)**

Complete guide for:
- Installation
- PostgreSQL setup
- Configuration
- Docker deployment
- Troubleshooting

---

## 🧪 I WANT TO TEST THE API

**Option 1: Postman**
- Import: `postman_collection.json`
- 50+ pre-built requests ready to use

**Option 2: VS Code**
- Install: "REST Client" extension
- Open: `test-requests.http`
- Click "Send Request"

**Option 3: cURL**
```bash
curl -X POST http://localhost:8080/hotels \
  -H "Content-Type: application/json" \
  -d '{"name":"Test","city":"Kyiv","address":"123 St","rating":5}'
```

---

## 📋 I NEED DETAILED API DOCUMENTATION

**→ Read: [API_SPECIFICATION.md](API_SPECIFICATION.md)**

Complete specification with:
- Every endpoint explained
- Request/response examples
- Error codes
- Data formats

---

## 📚 I WANT TO FIND A SPECIFIC TOPIC

**→ Read: [DOCUMENTATION_INDEX.md](DOCUMENTATION_INDEX.md)**

Navigation guide to all documentation organized by:
- Topic
- Audience (students, developers, DevOps)
- Component (Entity, Service, Controller, etc.)

---

## 📊 I WANT A PROJECT OVERVIEW

**→ Read: [SUMMARY.md](SUMMARY.md)**

Quick summary with:
- What was implemented
- Project statistics
- Technology stack
- Key features

---

## 📝 I WANT TO SEE WHAT'S INCLUDED

**→ Read: [CHANGELOG.md](CHANGELOG.md)**

Complete list of:
- All features
- All files created
- Database tables
- Endpoints

---

## 🚨 I HAVE A PROBLEM

Common issues and solutions:
1. **Port already in use** → See DEPLOYMENT_GUIDE.md
2. **Database connection error** → See QUICK_START.md
3. **Can't compile** → See DEVELOPMENT_GUIDE.md
4. **API not working** → See API_SPECIFICATION.md

---

## 📋 PROJECT STRUCTURE

```
lab-2-AlexKim71-1/
├── src/main/java/ua/opnu/labwork2/
│   ├── controller/     (8 REST Controllers)
│   ├── service/        (5 Service Classes)
│   ├── repository/     (5 Repository Interfaces)
│   ├── entity/         (5 JPA Entities + 1 Enum)
│   ├── dto/            (5 Data Transfer Objects)
│   └── Labwork2Application.java
├── src/main/resources/
│   └── application.properties
├── Documentation
│   ├── README.md
│   ├── QUICK_START.md
│   ├── API_SPECIFICATION.md
│   ├── DEVELOPMENT_GUIDE.md
│   ├── DEPLOYMENT_GUIDE.md
│   ├── DOCUMENTATION_INDEX.md
│   ├── SUMMARY.md
│   ├── CHANGELOG.md
│   ├── FINAL_INSTRUCTIONS.md
│   └── INDEX.md (this file)
├── Testing
│   ├── postman_collection.json
│   ├── test-requests.http
│   └── init-data.sql
└── Configuration
    ├── pom.xml
    ├── application.properties
    └── mvnw/mvnw.cmd
```

---

## 🎯 QUICK NAVIGATION

| I Want To... | Read This | Time |
|---|---|---|
| Get started | QUICK_START.md | 5 min |
| Understand project | README.md | 15 min |
| Develop features | DEVELOPMENT_GUIDE.md | 20 min |
| Deploy to production | DEPLOYMENT_GUIDE.md | 15 min |
| Use API | API_SPECIFICATION.md | 30 min |
| Find something | DOCUMENTATION_INDEX.md | 5 min |
| See overview | SUMMARY.md | 10 min |
| Check included items | CHANGELOG.md | 10 min |

---

## 📌 KEY INFORMATION

### Tech Stack
- **Language:** Java 17
- **Framework:** Spring Boot 4.0.5
- **Database:** PostgreSQL
- **ORM:** Hibernate with Spring Data JPA
- **Build:** Maven

### What's Included
- ✅ 26 Java source files (fully organized)
- ✅ 40+ REST API endpoints
- ✅ 6 database tables (properly related)
- ✅ 9 comprehensive documentation files
- ✅ 3 testing resources
- ✅ Complete configuration

### Functionality
- ✅ Hotel management
- ✅ Room management
- ✅ Guest registration
- ✅ Booking system
- ✅ Amenities management
- ✅ Search functionality
- ✅ Analytics & statistics
- ✅ Health monitoring

---

## 🚀 THREE SIMPLE STEPS TO RUN

```bash
# Step 1: Create database
psql -U postgres
CREATE DATABASE hotel_management_db;
CREATE USER user_db WITH PASSWORD 'useruser';
GRANT ALL PRIVILEGES ON DATABASE hotel_management_db TO user_db;
\q

# Step 2: Start application
cd D:\Projects\lab-2-AlexKim71-1
.\mvnw.cmd spring-boot:run

# Step 3: Test
curl http://localhost:8080/actuator/health
# Should return: {"status":"UP"}
```

---

## ✅ VERIFICATION

After setup, verify that:
- [ ] Application started successfully
- [ ] Health endpoint returns "UP"
- [ ] Can create a hotel
- [ ] Can list all hotels
- [ ] Search works
- [ ] Analytics shows data

---

## 💡 TIPS

1. **Start Small:** Run QUICK_START.md first
2. **Read in Order:** README → API_SPECIFICATION → DEVELOPMENT_GUIDE
3. **Test Everything:** Use Postman or cURL
4. **Check Documentation:** Most answers are there
5. **Follow Conventions:** Maintain code style

---

## 🎓 FOR STUDENTS

This project teaches:
- Spring Boot development
- REST API design
- Database design
- 3-layer architecture
- Professional code practices
- Technical documentation

Best way to learn:
1. Run the application
2. Test the API
3. Read the code
4. Understand the architecture
5. Write your own features

---

## 🏆 PROJECT STATUS

| Item | Status |
|------|--------|
| Code | ✅ Complete |
| Documentation | ✅ Complete |
| Testing Resources | ✅ Complete |
| Database | ✅ Complete |
| API | ✅ Complete |
| Configuration | ✅ Complete |
| Production Ready | ✅ Yes |

---

## 📞 NEED HELP?

| Question | Answer In |
|----------|-----------|
| How do I start? | QUICK_START.md |
| What is this project? | README.md |
| How do I use the API? | API_SPECIFICATION.md |
| How do I add features? | DEVELOPMENT_GUIDE.md |
| How do I deploy? | DEPLOYMENT_GUIDE.md |
| I'm lost | DOCUMENTATION_INDEX.md |
| What's wrong? | DEPLOYMENT_GUIDE.md (Troubleshooting) |

---

## 🎉 YOU'RE ALL SET!

Choose a documentation file from above and start exploring.

**Recommended path:**
1. Read QUICK_START.md (5 minutes)
2. Start the application
3. Test with Postman
4. Read more documentation as needed

---

**Developer:** Гаврилов Олександр В'ячеславович  
**Group:** AI-243  
**Version:** 1.0  
**Status:** ✅ Production Ready  
**Date:** 2024-04-15  
**University:** OPNU

---

**Happy coding! / Приємного кодування!** 🚀

