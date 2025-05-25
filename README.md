# Port of Algiers Vehicle Management System

## School Assignment Information

- **Institution**: Nationale Higher School of Advanced Technologies (ENSTA)
- **Program**: CP-MI-2
- **Module**: Object-Oriented Programming (OOP)
- **Student**: FERKIOUI Akram
- **Group**: A1
- **Teacher**: Mr BADJARA Mohamed el Amine

## Overview

A Java application that manages vehicles transported on ships at the Port of Algiers.

## Project Description

This application allows port managers to:
- Create trips with destination information
- Add cars with their maximum speed
- Add trucks with trailer information
- Generate detailed reports of vehicles on each trip

## Features

- Object-oriented design with inheritance
- Console-based user interface
- Detailed text report generation
- Support for multiple vehicle types

## How to Run

To compile and run the application:

```bash
javac PortManagementSystem.java
java PortManagementSystem
```

## Project Structure

- `Vehicle.java` - Abstract base class for all vehicles
- `Car.java` - Class for cars with maximum speed
- `Truck.java` - Class for trucks with trailer information
- `Trip.java` - Class to manage trips and collections of vehicles
- `ReportGenerator.java` - Handles creation of detailed reports
- `PortManagementSystem.java` - Main application with user interface

## Sample Output

The application will generate detailed reports in text format that include:
- Trip details (ID, date, destination)
- Vehicle inventory statistics
- Detailed listing of all vehicles on the trip
