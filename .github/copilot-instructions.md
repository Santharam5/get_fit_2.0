# GetFit Copilot Instructions

## Repository Summary

GetFit is a Full Stack Gym Management System developed as a learning project following enterprise architecture.

The project consists of:

Backend
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL

Frontend
- React
- Vite
- TailwindCss

The project follows a strict layered architecture.

---

## Repository Layout

Backend

src/main/java/com/santharam/get_fit/

Each module contains:

- controller
- dto
- entity
- repository
- service
- serviceImpl
- transform

Frontend

/frontend

React
Vite
TailwindCss

---

## Architecture Rules

Always follow

Controller
↓
DTO
↓
Service
↓
Transform Service
↓
Repository
↓
Entity
↓
Database

Never bypass layers.

Never access Repository from Controller.

Never expose Entity through API.

---

## Coding Standards

Always

- Use constructor injection
- Use DTOs
- Use Transform Service
- Use ResponseEntity
- Use Lombok
- Follow SOLID
- Keep methods small
- Use validation annotations

Never

- Return Entity directly
- Put business logic in Controller
- Duplicate code
- Change package structure

---

## Naming Convention

Entity

Users

Gym

Equipment

Membership

Exercise

Routine

RoutineExercise

DTO

UsersRequestDto

UsersResponseDto

Repository

UsersRepository

Service

UsersService

Implementation

UsersServiceImpl

Transform

UsersTransformService

Controller

UsersController

---

## Build Instructions

Backend

Always execute

mvn clean install

before submitting changes.

Run

mvn test

before creating pull requests.

If dependency changes occur

run

mvn clean

followed by

mvn install

---

## Development Rules

When generating code

- Follow existing architecture.
- Reuse existing code style.
- Do not introduce new libraries unless requested.
- Keep code production ready.
- Respect package naming.
- Generate imports automatically.
- Prefer constructor injection.

---

## Future Roadmap

Future versions include

- JWT Authentication
- Trainer Module
- Attendance
- Billing
- AI Workout Recommendation
- Nutrition Recommendation

Design code to allow future expansion.

---

## AI Behaviour

Before generating code

Inspect existing module implementation.

Reuse existing patterns.

Only search repository if the information inside this file is insufficient.

Trust these instructions as the primary project guideline.