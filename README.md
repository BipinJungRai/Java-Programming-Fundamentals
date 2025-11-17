# Java Programming Fundamentals

## [COM1027 - Object-Oriented Programming](https://catalogue.surrey.ac.uk/2022-3/module/COM1027) | 2022/3

[![Grade](https://img.shields.io/badge/Grade-85%25-brightgreen)](https://github.com/BipinJungRai/Java-Programming-Fundamentals)
[![Java](https://img.shields.io/badge/Java-8+-blue.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.0+-orange.svg)](https://maven.apache.org/)
[![University](https://img.shields.io/badge/University-Surrey-green.svg)](https://www.surrey.ac.uk/)

## 📋 Project Overview

This repository is an archive of my university coursework for **[COM1027 - Object-Oriented Programming](https://catalogue.surrey.ac.uk/2022-3/module/COM1027)** at the University of Surrey (2022/3). It focuses on object-oriented programming principles in Java and includes a multi-part car auction simulation coursework alongside a comprehensive series of lab exercises covering fundamental to advanced Java concepts, achieving a coursework grade of **85%**.

## Coursework: Car Auction Simulation

The main coursework project is a command-line simulation of a car auction system, developed incrementally across four questions to demonstrate progressive software design and implementation skills.

*   **Features:**
    *   **User Roles:** Distinction between regular users, auctioneers, traders, buyers, and sellers.
    *   **Vehicle Adverts:** Users can create and view advertisements for cars with different types, body styles, conditions, and sale types.
    *   **Bidding System:** Users can make offers on cars, and the system manages the auction and bidding process.
    *   **Dealership Management:** Support for dealerships to manage multiple traders and their car listings.
    *   **Data Persistence:** The system saves auction statistics and trade information to text files for analysis.

### Coursework Structure

The coursework is organized into four progressive questions, each building upon the previous one:

*   **Question 1:** Basic car auction system with users, cars, adverts, and offers
*   **Question 2:** Extended with trader functionality and sale types (auction vs. sale)
*   **Question 3:** Introduction of buyers, sellers, and dealership management
*   **Question 4:** Complete system with advanced dealership features and statistics tracking

## Lab Exercises

This repository contains a series of 11 labs, each designed to teach specific Java concepts and programming techniques:

*   **Lab01: Hello World** - A basic introduction to the Java language and development environment.
*   **Lab02: Object-Oriented Concepts** - Creating objects and modeling their interactions.
*   **Lab03: Object-Oriented Modelling** - Advanced modeling of real-world entities like employees and organizational positions.
*   **Lab04: Collections** - Introduction to Java's collection framework for managing groups of objects.
*   **Lab05: Arrays and Loops** - Using arrays and iteration for data processing and calculations.
*   **Lab06: Enums and Maps** - Working with enumerations for constant values and maps for key-value data structures.
*   **Lab07: Advanced Collections** - Complex use of collections to manage object relationships and hierarchies.
*   **Lab08: File I/O and Exception Handling** - Reading from and writing to files, along with creating and handling custom exceptions.
*   **Lab09: Abstract Classes and Interfaces** - Designing flexible and extensible code using abstraction and polymorphism.
*   **Lab10: Interfaces and Polymorphism** - Further practice with interfaces in a hotel management scenario.
*   **Lab11: Final Project** - A comprehensive design exercise modeling a factory system, integrating concepts from all previous labs.

## Getting Started

This repository contains multiple, separate Maven projects. Please ensure you have JDK 8 (or newer) and Maven installed on your system.

1.  Clone the repository:
    ```bash
    git clone https://github.com/BipinJungRai/Java-Programming-Fundamentals.git
    ```
2.  Navigate to the directory of the project you want to work with (e.g., `cd Coursework` or `cd Lab02`).

3.  To compile the project, use:
    ```bash
    mvn compile
    ```

4.  To run the JUnit tests for the project:
    ```bash
    mvn test
    ```
    This was the primary method used to verify the code for both the coursework and the lab exercises.

## Project Structure

Each lab and the coursework are organized as independent Maven projects with the following structure:

```
Project/
├── pom.xml                 # Maven configuration file
├── src/
│   ├── main/
│   │   └── java/          # Source code
│   └── test/
│       └── java/          # JUnit test files
└── target/                # Compiled classes and test results
```

## Technologies Used

This project is built using industry-standard Java development tools and practices.

- ### Core Language & Build Tool:
    - **Java SE 8** - Core language for all projects, featuring object-oriented programming principles.
    - **Maven** - Build automation and dependency management tool.

- ### Development Practices:
    - **JUnit** - Unit testing framework for test-driven development.
    - **Checkstyle** - Code quality and style enforcement based on Google Java Style Guide.

## Module Information

**Module Code:** COM1027  
**Module Title:** Object-Oriented Programming  
**Institution:** University of Surrey  
**Academic Year:** 2022-23

This module covers fundamental concepts in object-oriented programming including:
- Classes, objects, and encapsulation
- Inheritance and polymorphism
- Abstract classes and interfaces
- Collections and data structures
- File I/O and exception handling
- Software design principles and UML modeling

## License

This repository is for educational purposes and contains coursework completed as part of university studies.
