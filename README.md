# Vehicle Rental Management System

Author: Omar Shoubaki

Birzeit University

Department of Electrical and Computer Engineering

## Project Overview
This project is a Java-based console application that simulates a basic vehicle rental management system.  
It enables users to manage customers, vehicles, and rental transactions interactively.  

The project demonstrates the use of **Object-Oriented Programming (OOP)** principles including:
- Class design and encapsulation
- Object relationships (Customer ↔ Vehicle)
- Array-based data handling
- Input validation and console-based menus

## Classes and Responsibilities
- **Vehicle.java** – Represents vehicles with attributes such as type, registration number, brand, availability, and rental rate.  
- **Customer.java** – Represents customers who can rent multiple vehicles, calculate rent by type, and return rented vehicles.  
- **Driver.java** – Serves as the main class containing the program entry point and user interface logic. Handles:
  - Registering customers  
  - Renting and returning vehicles  
  - Displaying total rent  
  - Sorting and displaying available vehicles  

## Features
1. Add and manage customers  
2. Rent vehicles by registration number  
3. Return rented vehicles  
4. Calculate total rent for each customer  
5. Display available vehicles sorted by:
   - Rental price (ascending)
   - Type (alphabetically)
6. Prevent duplicate IDs or names for customers  
7. Validate input and available rentals

## How to Run
1. Compile all `.java` files
2. Run the Main program(driver)
   
## Tools Used
Eclipse IDE
