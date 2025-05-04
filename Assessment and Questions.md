# 🎓 Java OOP Assessment: Peer Tutor Booking Platform

<div align="center">
  <img src="https://img.shields.io/badge/Java-OOP-orange" alt="Java OOP"/>
  <img src="https://img.shields.io/badge/Difficulty-Intermediate-yellow" alt="Difficulty: Intermediate"/>
  <img src="https://img.shields.io/badge/Est. Time-5~6 hours-blue" alt="Time: 5-6 hours"/>
</div>

## 📋 Overview
Build a terminal-based Peer Tutor Booking Platform from scratch! This project will help you master core Object-Oriented Programming concepts in Java, including:

- 🧬 **Inheritance**
- 🔄 **Polymorphism**
- 🔒 **Encapsulation**
- 🧩 **Abstraction** (with abstract classes and interfaces)
- ⚡ **Static keyword usage**
- 📊 **Collections** (List and Map)
- ⚠️ **Exception handling**

The entire assessment is organized as a step-by-step guide with both coding tasks and conceptual questions to deepen your understanding.

## 🏫 Scenario Overview
Imagine a peer tutoring system at a university where students can book sessions with experienced student mentors. The system includes:

### 🔑 Key Features:
- **👥 User roles**: Both **Students** and **Mentors** share common attributes but have role-specific details
- **📚 Session types**: Choose between **Subject 1-to-1 tutoring** and **Career Coaching**
- **📅 Booking workflow**: Schedule, view, and cancel sessions with your chosen mentor
- **💾 Memory-based storage**: Data stored in collections (no database required)
- **💻 Terminal interaction**: Text-based menu system driven by user input

Throughout this project, you'll build the application incrementally while exploring important OOP principles at each stage.

## 🗺️ Step 1: Plan the Application Structure

Before writing any code, let's map out our classes and their relationships.

### 👤 User Hierarchy
We'll create an abstract `User` base class with common attributes and behaviors, then derive `Student` and `Mentor` subclasses with role-specific features. This demonstrates **inheritance** - a Student *is-a* User, and a Mentor *is-a* User.

### 📝 Session Hierarchy
Similarly, we'll design an abstract `Session` class for common session attributes, with concrete subclasses `SubjectSession` and `CareerSession`. This showcases **abstraction** - defining a general template and hiding implementation details.

### 🔄 Relationships
A session connects a student with a mentor - this is **composition** (a "has-a" relationship). Each Session object contains references to a Student and a Mentor.

### 🔢 Unique Identifiers
We'll use **static** counters for auto-generating unique IDs as new objects are created. This demonstrates how static variables belong to the class rather than individual instances.

### 📦 Collections for Storage
We'll implement various Java collections:
- `List<Student>` and `List<Mentor>` to store users by role
- `List<Session>` for all tutoring sessions
- `Map<Integer, User>` for quick user lookup by ID

### 🖥️ Console Interface
We'll build a `BookingPlatform` class with the main method to handle menu-driven interaction, using **exception handling** to manage invalid inputs gracefully.

### 📊 Class Diagram
```
User (abstract)
├── Student (extends User)
└── Mentor  (extends User)

Session (abstract)
├── SubjectSession (extends Session)
└── CareerSession  (extends Session)

BookingException (custom exception extends Exception)

BookingPlatform (contains main method and manages collections)
```

## 👤 Step 2: Implement the User Class Hierarchy

Let's start by creating our user classes to demonstrate **inheritance** and **encapsulation**.

### 🔒 Encapsulation
We'll keep data (fields) private and provide controlled access through methods. This protects data integrity and hides implementation details.

### ✅ Task 2.1: Define an abstract User class

Create `User.java` with:

- **📝 Fields**: Private `id` (int) and `name` (String)
- **🔢 Static ID Counter**: `private static int nextId = 1;` to generate unique IDs
- **🏗️ Constructor**: Accept common fields and assign ID using counter
- **🔍 Getters/Setters**: Public getter methods for all fields, but no setter for ID (read-only)
- **🧩 Abstract Method**: `abstract String getRole();` to be implemented by subclasses
- **📄 toString()**: Override to return formatted user info

#### ❓ Question 2.1
Why mark User as abstract? What would happen if it were concrete and allowed to be instantiated directly?

#### ❓ Question 2.2
How does making User fields private achieve encapsulation? What problems might occur if these fields were public?

### ✅ Task 2.2: Implement the Student class

Create `Student.java`:

- **🧬 Inheritance**: `extends User` to inherit common user attributes
- **📝 Unique Field**: Add a field like `private String major;`
- **🏗️ Constructor**: Call `super(name)` and set student-specific fields
- **🔄 Override**: Implement `getRole()` to return "Student"
- **📄 toString()**: Optionally override to include student details

### ✅ Task 2.3: Implement the Mentor class

Create `Mentor.java` similarly:

- **🧬 Inheritance**: `extends User` to inherit common user attributes
- **📝 Unique Field**: Add `private String expertise;` or similar
- **🏗️ Constructor**: Call `super(name)` and set mentor-specific fields
- **🔄 Override**: Implement `getRole()` to return "Mentor"
- **📄 toString()**: Optionally override to include mentor details

#### ❓ Question 2.3
Which OOP principle are we demonstrating with Student and Mentor inheriting from User? How does this reduce code duplication?

#### ❓ Question 2.4
Identify examples of both inheritance and composition in our design so far.

#### ❓ Question 2.5
Why make `nextId` static? What would happen if it were an instance variable instead?

## 📝 Step 3: Implement the Session Classes

Now let's build the session classes to demonstrate **abstraction** and **polymorphism**.

### ✅ Task 3.1: Define an abstract Session class

Create `Session.java`:

- **📝 Fields**: Private `sessionId` (int), `student` (Student), and `mentor` (Mentor)
- **🔢 Static ID Counter**: `private static int nextSessionId = 1;`
- **🏗️ Constructor**: Accept Student and Mentor and assign session ID
- **🔍 Getters**: Methods to access session fields
- **🧩 Abstract Methods**:
  - `public abstract String getType();` 
  - `public abstract String getDetails();`
- **📄 toString()**: Override to use abstract methods for polymorphic behavior

### ✅ Task 3.2: Implement the SubjectSession class

Create `SubjectSession.java`:

- **🧬 Inheritance**: `extends Session`
- **📝 Unique Field**: `private String subjectName;`
- **🏗️ Constructor**: Call `super(student, mentor)` and set subject name
- **🔄 Override**: Implement abstract methods:
  - `getType()` → "Subject 1-to-1"
  - `getDetails()` → "Subject: " + subjectName

### ✅ Task 3.3: Implement the CareerSession class

Create `CareerSession.java`:

- **🧬 Inheritance**: `extends Session`
- **📝 Unique Field**: `private String topic;`
- **🏗️ Constructor**: Call `super(student, mentor)` and set topic
- **🔄 Override**: Implement abstract methods:
  - `getType()` → "Career Coaching"
  - `getDetails()` → "Topic: " + topic

#### ❓ Question 3.1
How does method overriding in SubjectSession and CareerSession demonstrate polymorphism? Give an example of using a Session reference with a concrete subclass object.

#### ❓ Question 3.2
Explain the difference between abstract Session and concrete SubjectSession/CareerSession. Could we have used an interface instead of an abstract class?

#### ❓ Question 3.3
How would our design make it easy to add new session types in the future?

## 🔔 Step 4: Introduce a Notification Interface

Let's add an interface to demonstrate **multiple inheritance of type** and another form of **abstraction**.

### ✅ Task 4.1: Define a Notifiable interface

Create `Notifiable.java`:

- **🧩 Method Declaration**: `void notify(String message);`
- No implementation, just the contract that implementers must fulfill

### ✅ Task 4.2: Make Student and Mentor implement Notifiable

Update both classes:

- **➕ Interface Implementation**: `extends User implements Notifiable`
- **🔄 Method Implementation**: Define `notify()` to print a role-specific notification message

Now Student and Mentor can be treated as both User objects and Notifiable objects, demonstrating polymorphism through interfaces.

#### ❓ Question 4.1
Why use an interface for notifications instead of adding a notify method to User? How does this approach offer more flexibility?

#### ❓ Question 4.2
List key differences between interfaces and abstract classes. When would you choose one over the other?

## 📦 Step 5: Manage Collections of Users and Sessions

Let's set up our data structures to store application objects.

### ✅ Task 5.1: Define collections in the main class

In `BookingPlatform.java`:

```java
private static List<Student> students = new ArrayList<>();
private static List<Mentor> mentors = new ArrayList<>();
private static List<Session> sessions = new ArrayList<>();
private static Map<Integer, User> userMap = new HashMap<>();
```

We'll update these collections when creating users and booking sessions:
- Add new Students to both `students` and `userMap`
- Add new Mentors to both `mentors` and `userMap`
- Add new Sessions to `sessions`

## 🖥️ Step 6: Build the Interactive Console Application

Finally, let's create the main program with user interaction.

### 📋 Menu Options

```
1. Register a new Student
2. Register a new Mentor
3. List all Students
4. List all Mentors
5. Book a Session
6. List all Sessions
7. Cancel a Session
8. Exit
```

### ✅ Task 6.1: Implement the main method logic

Create the main method in `BookingPlatform.java` with a menu loop and option handling.

---

💪 **Good luck with your implementation!** This assessment will strengthen your understanding of Java OOP principles through practical application.
