# 🚀 OrderFlow - Full Stack Food Ordering System

## 📌 Project Overview

OrderFlow is a full-stack web application for managing food orders.
It allows users to view food items, place orders, and track order details.

---

## 🛠️ Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* MySQL

### Frontend

* React.js
* Axios

---

## 📂 Project Structure

```
OrderFlow (Backend)
orderflow-frontend (Frontend)
```

---

## ⚙️ Features

### 👤 User Features

* Create user
* View users

### 🍔 Food Features

* Add food items
* View food items
* Delete food items

### 🛒 Order Features

* Place order
* Add multiple items in order
* View all orders

### 💳 Payment Simulation

* Update payment status (PENDING / SUCCESS / FAILED)

---

## 🔗 API Endpoints

### User APIs

* POST `/users`
* GET `/users`

### Food APIs

* POST `/food`
* GET `/food`
* DELETE `/food/{id}`

### Order APIs

* POST `/orders`
* GET `/orders`

### Payment API

* PUT `/orders/{id}/payment?status=SUCCESS`

---

## ▶️ How to Run

### Backend

```bash
cd OrderFlow
mvn spring-boot:run
```

### Frontend

```bash
cd orderflow-frontend
npm install
npm start
```

---

## 🌐 URLs

* Backend: http://localhost:8080
* Frontend: http://localhost:3000

---

## 📸 Screenshots

(Add your screenshots here)

---

## 🎯 Future Enhancements

* JWT Authentication
* Cart System
* Payment Gateway Integration
* Admin Dashboard

---

## 👨‍💻 Author

Suraj Kushwaha
