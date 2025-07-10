# 🎯 QuizBuzz - Java Spring Boot Quiz App

**QuizBuzz** is a web-based quiz application built with **Spring Boot** and **Thymeleaf**, designed to test your knowledge of Java data structures like ArrayList, HashMap, Stack, and more. It features a clean UI, a countdown timer, and instant result display at the end of the quiz.

---

## 📌 Features

- ✅ Topic selection from multiple Java concepts  
- ✅ Timer-based quiz questions (auto-submits after 30 seconds)  
- ✅ Navigation support (Back button to review/change previous answers)  
- ✅ Instant result summary with correct/incorrect feedback  
- ✅ Clean, responsive UI using TailwindCSS  
- ✅ Stateless session handling using `HttpSession`  

---

## 🚀 Tech Stack

| Layer        | Technology            |
|--------------|------------------------|
| Backend      | Java 17, Spring Boot 3.1.5 |
| Frontend     | Thymeleaf, HTML5, Tailwind CSS |
| Build Tool   | Maven                  |
| Templates    | Thymeleaf              |
| Session      | `HttpSession` for user quiz state |

---

## 📂 Project Structure

QuizBuzz/
│

├── pom.xml

└── src/

└── main/

├── java/

│ └── com/example/quiz/

│ ├── QuizApplication.java

│ ├── QuizController.java

│ └── QuizSystem.java

└── resources/

├── templates/

│ ├── categories.html

│ ├── question.html

│ └── results.html

└── application.properties

---
🧠 Java Data Structures & Concepts Used

This project was built with core Java programming principles and data structure knowledge, applied to real-world quiz logic. Here are the key components used:

🔹 1. Map<String, Collection<Question>>

• Used to store and categorize quiz questions topic-wise.

• Each topic (e.g., "HashMap", "Stack") maps to a list of Question objects.

🔹 2. ArrayList<Question>

• Used to store the active quiz session questions in order.

• Supports random access, iteration, and dynamic resizing during quiz navigation.

🔹 3. Custom Question Class (Encapsulation)

• Each quiz question is represented by a Question object containing:

 The question text

Options (as a list of strings)

Correct answer index

User-selected answer index

• Demonstrates use of constructors, getters/setters, and encapsulation.

🔹 4. HttpSession (State Management)

• Stores the QuizSystem object in session so the user's progress and score persist across multiple HTTP requests.

• Maintains session state during quiz navigation.

🔹 5. OOP Concepts

•Classes and Objects: Structured QuizSystem, Question, and controller logic.

• Encapsulation: Data hiding and access via getters/setters.

• Modularity: Clean separation of logic in controller and system class.

🔹 6. Control Flow & Logic

• if-else and loops to manage quiz navigation (nextQuestion, previousQuestion).

• Conditional rendering in Thymeleaf based on quiz state (hasPreviousQuestion, quiz.getCurrentQuestion()).

---

🔍 Screenshots






---

✨ Future Improvements

• Add login/signup with Spring Security

• Leaderboard and score tracking with a database

• Shuffle questions and randomize options

• Add difficulty levels (Easy, Medium, Hard)

• REST API support for frontend frameworks like React

---

🙌 Author

Shresth Veer Singh

Java Developer | Learner | Tech Enthusiast

📧 Email: shresthveer0408@gmail.com

🔗 https://www.linkedin.com/in/shresth-veer-singh-598830291/

---

📜 License

This project is licensed under the MIT License.

---


