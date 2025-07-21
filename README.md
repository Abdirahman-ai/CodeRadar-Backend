# 📊 CodeRadar Backend

CodeRadar is a backend service for tracking GitHub project contributions and visualizing team metrics like commits, lines of code, pull requests, and issue participation. It supports role-based user association with projects and offers detailed summaries per contributor.

---

## 🛠️ Tech Stack

- **Backend**: Java 21, Spring Boot 3
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA
- **Mapping**: MapStruct
- **Testing**: Postman (manual)
- **Build Tool**: Maven

---

## 📸 Demo

### 🏠 Homepage  
![Homepage](https://github.com/Abdirahman-ai/CodeRadar-Backend/blob/master/gifs/dashboard.png)

### 🔐 Login  
![Login](https://github.com/Abdirahman-ai/CodeRadar-Backend/blob/master/gifs/login.png)

### 📋 Dashboard  
![Dashboard](https://github.com/Abdirahman-ai/CodeRadar-Backend/blob/master/gifs/projects.png)

### ➕ Create Project  
![Create](https://yourdomain.com/assets/create-project.gif)

### 📈 Contribution Summary  
![Summary](https://github.com/Abdirahman-ai/CodeRadar-Backend/blob/master/gifs/contributionSummary.png)

### 👥 Team Member Table  
![Team](https://yourdomain.com/assets/team-table.gif)

---

## 🚀 Features

- Create and manage users, projects, and contributions
- Link contributions to users and projects
- Aggregate and summarize contributions by user
- Calculate percentage breakdowns of commits and lines of code per user
- RESTful API powered by Spring Boot, PostgreSQL, and MapStruct

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

---

## 🧪 API Endpoints

### 👤 Users
- `POST /api/users` – Create a user
- `GET /api/users` – List all users
- `GET /api/users/{id}` – Get user by ID

### 📁 Projects
- `POST /api/projects` – Create project (with optional contributions)
- `GET /api/projects` – List all projects
- `GET /api/projects/{id}` – Get project by ID

### 📈 Contributions
- `POST /api/contributions` – Create a contribution
- `GET /api/contributions/project/{projectId}` – List all contributions for a project
- `GET /api/contributions/summary/project/{projectId}` – Get aggregated contribution summary by user

---

## 🧾 Setup Instructions

1. **Clone the repo**
   ```bash
   git clone https://github.com/abdirahman-ai/CodeRadar.git
   cd CodeRadar
