
# 🏫 School Management – Java CLI App

## 📋 Project Overview

A **School** is an institution for learning, and you are going to create a **Java command-line application** that handles school management using **collections** to represent relationships between classes.
- You are also going to use collections to store all your created objects. (See the Structure requirement)
- It is also important that you Unit test methods as you write them to avoid bugs.

**The main focus is on:**
  - Class relationships using collections
  - Object storage using DAOs
  - Unit testing methods
  - Optional CLI interface

---

## 🧑‍🎓 Class: `Student`

### Attributes:
- `id`: `int`
- `name`: `String`
- `email`: `String`
- `address`: `String`

### Diagram:
```
+---------------------+
|      Student        |
+---------------------+
| - id: int           |
| - name: String      |
| - email: String     |
| - address: String   |
+---------------------+
```

---

## 📘 Class: `Course`

### Attributes:
- `id`: `int`
- `courseName`: `String`
- `startDate`: `LocalDate`
- `weekDuration`: `int`
- `students`: `List<Student>`

### Methods:
- `register(Student student)`
- `unregister(Student student)`

### Diagram:
```
+------------------------------+
|            Course           |
+------------------------------+
| - id: int                   |
| - courseName: String        |
| - startDate: LocalDate      |
| - weekDuration: int         |
| - students: List<Student>   |
+------------------------------+
| + register(Student)         |
| + unregister(Student)       |
+------------------------------+
```

### Class Diagram:
![model.jpeg](img%2Fmodel.jpeg)

> **Note**: Each course can have many students. This relationship is managed from the `Course` class.

---

## 📦 Structure Requirement
Course and Student objects should be stored in collections you decide. Its common that you separate
your data access in a separate package away from the business logic. Your Student and Course
collections should be stored inside Data Access Objects, so called DAO’s. The DAO classes only
concern should be to create, read, update and remove objects from the collections.

---

## 🧱 DAO Interfaces & Implementation

![dao.jpeg](img%2Fdao.jpeg)

> **Make your Dao classes implement** the methods from the interfaces above.

### Methods Explanation:
- Student save(Student student) and Course save(Course course) should add objects to the collection and return the same object back.
- The find methods should find and return object(s) matching the search criteria.  
- The delete methods should remove matching object from the collection.

---

## 🧪 Unit Testing
It is crucial to **unit test** your methods as you build them to avoid bugs and ensure application stability.

---

## 💻 Optional: CLI User Interface

Implement a simple command-line interface with the ability to:
- Create new courses and students
- Register and remove students from courses
- Search for students and courses
- Edit existing students and courses

---

> **Good luck and have fun building your school management app!**
