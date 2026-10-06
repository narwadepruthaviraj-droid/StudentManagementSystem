# Student Management System

## 1. Problem Statement

Managing student records manually can be time-consuming and may result in errors while storing, searching, updating, and calculating student information.

The Student Management System provides a simple command-line solution for managing student records efficiently using Java.

---

## 2. Scope of the Project

The project focuses on managing student information through a command-line interface.

The system supports:

- Adding students
- Viewing students
- Searching students
- Updating student information
- Deleting students
- Calculating student statistics
- Assigning grades
- Sorting student records
- Saving and loading student data
- Input validation
- Error handling

---

## 3. Target Users

The system can be useful for:

- Students
- Teachers
- Academic staff
- Small educational institutions

---

## 4. High-Level Features

1. Student record management
2. CRUD operations
3. Student grade calculation
4. Student performance statistics
5. Sorting student records
6. File-based data storage
7. Input validation
8. Exception handling

---

## 5. Functional Requirements

### FR1 - Add Student

The system shall allow the user to add a student using:

- Student ID
- Student name
- Course
- Marks

### FR2 - View Students

The system shall display all stored student records.

### FR3 - Search Student

The system shall allow the user to search for a student using the student ID.

### FR4 - Update Student

The system shall allow the user to update student name, course, and marks.

### FR5 - Delete Student

The system shall allow the user to delete a student record using the student ID.

### FR6 - Student Statistics

The system shall calculate:

- Total students
- Average marks
- Highest marks
- Lowest marks
- Top student
- Lowest-performing student

### FR7 - Sorting

The system shall allow students to be sorted by:

- Marks
- Name

### FR8 - Data Persistence

The system shall save student records to a file and load them when the application starts.

---

## 6. Non-Functional Requirements

### NFR1 - Performance

The system should provide quick responses for normal student management operations.

### NFR2 - Reliability

The system should handle invalid input and file errors without unnecessary application failure.

### NFR3 - Usability

The command-line interface should be simple and easy to understand.

### NFR4 - Maintainability

The application should use separate classes for different responsibilities.

### NFR5 - Portability

The application should run on systems that support Java 17 or later.

### NFR6 - Data Integrity

Duplicate student IDs should not be accepted and marks should remain within the valid range of 0 to 100.

---

## 7. Technology

- Java 17
- Object-Oriented Programming
- ArrayList
- Java I/O
- Exception Handling
- Comparator
- Git
- GitHub
- Visual Studio Code

---

## 8. Project Architecture

The application follows a modular architecture:

```text
             User
               |
               v
        +--------------+
        |    Main      |
        | CLI / Menu   |
        +--------------+
               |
               v
      +------------------+
      | StudentManager   |
      +------------------+
        /      |       \
       /       |        \
      v        v         v
 Student   StudentReport  InputValidator
   |             |
   |             |
   +-------------+
         |
         v
   +-------------+
   | FileManager |
   +-------------+
         |
         v
    students.txt