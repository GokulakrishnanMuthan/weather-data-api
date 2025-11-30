# 🌦️ Weather API Service

A simple and efficient **Weather API** built using **Spring Boot (Java 17)** that fetches real-time weather details using external weather providers (like OpenWeatherMap API).  
This service exposes clean REST endpoints to get current weather, temperature, humidity, and condition details for any city.

---

## 🚀 Features

- Fetch real-time weather for any city
- REST API endpoints (GET)
- JSON-based response
- Supports CORS for frontend integrations (Angular, React, etc.)
- Easy to integrate with mobile/web apps
- Clean and modular structure
- Custom exception handling
- Environment-based API key configuration

---

## 📡 API Endpoints

### 🔹 Get Weather by Latitude and Longitude
GET [http://localhost:8080/api/weather/chennai](http://localhost:8080/weather?lat=13.08784&lon=80.27847)


#### 📌 Example Response
```json
{
  "city": "Chennai",
  "temperature": "31°C",
  "humidity": "74%",
  "description": "Partly cloudy",
  "windSpeed": "4.2 m/s"
}
