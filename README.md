# Project Overview

This project demonstrates various design patterns written in Java.

## Design Patterns Demonstrated

- **Architectural Patterns**
    - Event Sourcing

## Used Technologies

- **Java 21** - The primary programming language.
- **Spring Boot 3.3.5** - For dependency management, configuration, and application setup.
- **Maven** - For project build and dependency management.
- **Data Jpa** - for DB interaction.
- **Postgres** - as relational database management system.
- **JUnit 5** - For testing design pattern implementations.
- **Lombok** - For reducing boilerplate code.

## Getting Started

You need to follow up some steps before you can run the tests`

1. Clone the repository:`
   git clone git@github.com:TigranMelkonyan/java-design-patterns.git

2. Set up JDK 21

3. Change application.properties with your own db credentials
   [spring.datasource.url=jdbc:your_database_url
   spring.datasource.username=your_database_username
   spring.datasource.password=your_database_password]

4. Build the project using maven
   [./mvnw clean install]

5. Run tests
   [./mvnw test]



