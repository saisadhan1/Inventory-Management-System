# 📦 Inventory Management System (Spring Boot REST API)

A lightweight backend service for managing products and stock levels in a warehouse.

This project provides clean REST APIs with validation, error handling, and built-in API documentation powered by Swagger / Springdoc OpenAPI.

---

## 🎥 Video Demonstration

[Watch Demo Video (Google Drive)](https://drive.google.com/file/d/1nWK3Q5d2Njn0F4EWNc7Pbh9l1XUTZ79B/view)

---

## 🚀 Features

### 🛒 Product Operations

- Complete CRUD for products with fields:
    - `id`
    - `name`
    - `description`
    - `stockQuantity`
    - `lowStockThreshold`

### ✅ Input Validation

- Product name cannot be blank
- Negative values for stock are rejected
- Meaningful error responses for invalid/missing data

---

## 📦 Stock Handling

Endpoints to adjust stock levels:

- **POST** `/products/{id}/stock/increase`
- **POST** `/products/{id}/stock/decrease`

Prevents decreasing stock below available quantity  
→ returns **400 Bad Request**

---

## ⚠️ Low Stock Alerts

- `lowStockThreshold` can be configured per product

Dedicated endpoint:

- **GET** `/products/low-stock`  
  → fetches all products falling below threshold

---

## 📄 API Docs

- Swagger UI available at:  
  `http://localhost:8080/swagger-ui.html`

- Try out endpoints directly in the browser without external tools

---

## 🛠 Tech Stack

- Java 17
- Spring Boot (Web, Data JPA)
- MySQL / H2 Database
- Lombok
- Springdoc OpenAPI (Swagger)
- JUnit 5 & Spring Boot Test
- Maven

---

## 🔎 API Endpoints

### 📦 Products

- **POST** `/products` → create new product
- **GET** `/products` → list all products
- **GET** `/products/{id}` → fetch product by ID
- **PUT** `/products/{id}` → update product
- **DELETE** `/products/{id}` → delete product

### 📊 Stock Management



- POST `/products/{id}/stock/increase`
- POST `/products/{id}/stock/decrease`
- Returns 400 Bad Request if reducing more than available stock

### ⚠️ Low Stock

- **GET** `/products/low-stock
- view products below threshold

---

Clean REST APIs with validation, proper error handling, and interactive API documentation.