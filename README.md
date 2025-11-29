A lightweight, extendable Spring Boot Weather Data API that provides a clean foundation for building weather-based services.
You can integrate external weather providers, add caching, schedule updates, or link it with an Angular UI.

🚀 Features

RESTful API with Spring Boot

Modular and scalable project structure

Easy integration with OpenWeather, Open-Meteo, etc.

Ideal starting point for personal or production weather services

Maven-based setup

📁 Project Structure
weather-data-api/
 ├── src/main/java       # Application source code
 ├── src/test/java       # Test cases
 ├── pom.xml             # Maven dependencies
 └── README.md           # Documentation

⚙️ Tech Stack

Java 17

Spring Boot 3+

Maven

REST API

▶️ Getting Started
1️⃣ Prerequisites

Install the following:

Java 17+

Maven 3.8+

Any IDE (IntelliJ / VS Code / Eclipse)

2️⃣ Clone the Repository
git clone https://github.com/GokulakrishnanMuthan/weather-data-api.git
cd weather-data-api

3️⃣ Build the Project
mvn clean install

4️⃣ Run the Application
mvn spring-boot:run


Your API will be available at:
http://localhost:8080

🌐 Sample API Endpoints (You can update after adding controllers)
Method	Endpoint	Description
GET	/api/weather/{city}	Fetch weather for a specific city
GET	/api/health	Service health check
POST	/api/weather/save	Save a weather record
🛠️ How to Extend

You can easily enhance this project by adding:

External API integration (OpenWeather, Open-Meteo, AccuWeather)

Database layer (MySQL, PostgreSQL, MongoDB)

Weather caching with Redis

Scheduled updates using Spring Scheduler

Swagger / OpenAPI documentation

JWT-based authentication

📌 Future Enhancements

Add full weather provider integration

Improve data models and error handling

Add Angular UI dashboard

Add unit + integration tests

Add Docker support

🤝 Contributing

Contributions are welcome!

Steps:

Fork this repository

Create your feature branch

Commit your changes

Push the branch

Open a Pull Request

📜 License

This project is licensed under the MIT License.
