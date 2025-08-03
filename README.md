
# Workforce Management API

Welcome to the Workforce Management API! This project simulates a real-world backend system used by logistics companies to assign, manage, and track tasks of field staff such as salespeople and operations employees.

## 🔧 Project Overview

This Spring Boot application allows managers to:
- Assign tasks to staff
- Modify or cancel tasks
- Track status and priority
- View historical task activity and comments

---

## 📁 Project Structure

```
src/main/java/com/example/workforcemgmt/
├── WorkforcemgmtApplication.java
├── controller/
│   └── TaskController.java
├── service/
│   └── TaskService.java
├── model/
│   ├── Task.java
│   └── Staff.java
├── dto/
│   ├── TaskDto.java
│   └── CreateTaskRequest.java
├── repository/
│   └── InMemoryTaskRepository.java
└── util/
    └── TaskMapper.java
```

## 🚀 Features Implemented

### ✅ Bug Fixes
- **Task Re-assignment Creates Duplicates**: Old task is now marked as CANCELLED when reassigned.
- **Cancelled Tasks Clutter View**: Cancelled tasks are excluded from the default date-based fetch.

### ✨ New Features
1. **Smart Daily Task View**: Fetches tasks starting today or earlier but still active.
2. **Task Priority**: Tasks have HIGH, MEDIUM, LOW priority. You can change and filter by priority.
3. **Task Comments & Activity History**: View chronological activity and user comments.

## 🐳 Run in Docker

### Step 1: Build JAR file

```bash
./gradlew clean build
```

### Step 2: Build Docker image

```bash
docker build -t workforcemgmt-api .
```

### Step 3: Run the container

```bash
docker run -p 8080:8080 workforcemgmt-api
```

API will now be accessible at: `http://localhost:8080`

---

## 🔌 API Endpoints (Sample)

### 📬 Create Task

```http
POST /tasks
Content-Type: application/json

{
  "title": "Visit Client",
  "staffId": "emp123",
  "startDate": "2025-08-01",
  "dueDate": "2025-08-02",
  "priority": "HIGH"
}
```

### 📥 Update Task Priority

```http
PUT /tasks/{taskId}/priority/HIGH
```

### 📖 Fetch All Tasks (excluding cancelled)

```http
GET /tasks?startDate=2025-08-01&endDate=2025-08-02
```

### 📌 Add Comment

```http
POST /tasks/{taskId}/comments
{
  "comment": "Please complete this before noon."
}
```

### 🧾 View Task Details (With Comments + Activity)

```http
GET /tasks/{taskId}
```

---

## 📽️ Demo Video Script (for 3-minute recording)

### Suggested Order:
1. **Start container**: `docker run -p 8081:8081 workforcemgmt-api`
2. **Show Postman**:
   - Create a task
   - Reassign task (see previous marked CANCELLED)
   - Add comment
   - Change priority
   - Fetch today's smart view
   - Fetch by priority (HIGH)
3. **Narrate**:
   - "This is a task management API used internally by field teams..."
   - "Built using Java 17, Spring Boot, no database—uses in-memory data..."
   - "Running in Docker at port 8080. All endpoints tested via Postman..."
   - "Each feature from the assignment is demonstrated here..."

---

## 📦 Tech Stack

- Java 17
- Spring Boot 3.0.4
- Gradle
- Docker
- Postman (for API testing)
- In-memory storage (List, Map)

---

## 📎 Submission

- GitHub: https://github.com/Naveen16-sketch/workforce-management-api-project
- Demo Video: 



