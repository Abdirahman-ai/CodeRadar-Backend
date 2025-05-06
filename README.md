# 📊 CodeRadar Backend

CodeRadar is a backend service for tracking GitHub project contributions and visualizing team metrics like commits, lines of code, pull requests, and issue participation. It supports role-based user association with projects and offers detailed summaries per contributor.

---

## 🚀 Features

- Create and manage users, projects, and contributions
- Link contributions to users and projects
- Aggregate and summarize contributions by user
- Calculate percentage breakdowns of commits and lines of code per user
- RESTful API powered by Spring Boot, PostgreSQL, and MapStruct

---

## 🛠️ Tech Stack

- **Backend**: Java 21, Spring Boot 3
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA
- **Mapping**: MapStruct
- **Testing**: Postman (manual)
- **Build Tool**: Maven

---

## 🧱 Project Structure
- src/
- ├── controller/
- ├── dto/
- ├── entity/
- ├── exception/
- ├── mapper/
- ├── repository/
- ├── service/
- │└── impl/
