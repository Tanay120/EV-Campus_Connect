# ⚡ EV Campus Connect

**A Smart & Sustainable Mobility Platform for University Campuses.**

EV Campus Connect is a full-stack web application designed to solve the "last-mile" transportation problem on large university campuses. It enables students and faculty to easily book shared electric vehicles (scooters and bikes), track their carbon footprint, and manage ride credits in a secure environment.

## 🚀 Key Features

* **🔐 Secure Authentication:** Full user registration and login system using **Spring Security** and **JWT (JSON Web Tokens)**.
* **🛵 Vehicle Fleet Management:** Browse available electric scooters and bikes with details on range, speed, and pricing.
* **📅 Smart Booking System:**
    * Instant booking with validation (prevents duplicate bookings).
    * Real-time credit deduction (simulated payment system).
    * Ability to view and cancel active bookings.
* **🌿 Sustainability Dashboard:** Visualizes the user's positive environmental impact by calculating CO₂ saved per trip.
* **🏆 Gamification:** A "Top Eco-Riders" leaderboard to encourage sustainable commuting habits.
* **💳 Wallet System:** Integrated simulated credit balance displayed in the header.
* **📱 Responsive UI:** A clean, modern interface built with React and CSS3.

## 🛠️ Tech Stack

### Backend
* **Language:** Java 17
* **Framework:** Spring Boot 3 (Spring Web, Spring Data JPA)
* **Security:** Spring Security, JWT (jjwt)
* **Database:** H2 (In-Memory for Dev) / PostgreSQL (Production ready)
* **Build Tool:** Maven

### Frontend
* **Library:** React.js (Hooks, Functional Components)
* **HTTP Client:** Axios (with Interceptors for Token Management)
* **Styling:** CSS3 (Custom dark theme, Flexbox/Grid)
* **Utilities:** jwt-decode

## ⚙️ Installation & Setup

Follow these steps to run the project locally.

### Prerequisites
* Java JDK 17 or newer
* Node.js & npm
* Maven

### 1. Clone the Repository
```bash
git clone [https://github.com/your-username/ev-campus-connect.git](https://github.com/your-username/ev-campus-connect.git)
cd ev-campus-connect
