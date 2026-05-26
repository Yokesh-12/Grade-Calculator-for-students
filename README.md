# Student Grade Calculator — Java Console Application

## Project Overview
A console-based Java application to manage student records, enter subject marks,
and automatically calculate total marks, average, and letter grade.

## Resources / Technologies Used
| Resource           | Purpose                                      |
|--------------------|----------------------------------------------|
| Core Java (JDK 17) | Main programming language                    |
| OOP (4 Pillars)    | Encapsulation, Inheritance, Polymorphism, Abstraction |
| ArrayList          | Stores list of all Student objects           |
| HashMap            | Stores subject → marks mapping per student   |
| Exception Handling | try-catch for invalid marks & number input   |
| Scanner            | Reads user input from console                |
| VS Code / IntelliJ | IDE for development                          |

## Project Structure
```
grade-calculator/
└── src/
    └── gradecalculator/
        ├── Main.java            ← Entry point, menu loop
        ├── Student.java         ← Student entity (OOP model)
        └── GradeCalculator.java ← Service: manages all students
```

## How to Compile and Run

### Using Terminal
```bash
# Step 1 – Compile
javac -d out src/gradecalculator/*.java

# Step 2 – Run
java -cp out gradecalculator.Main
```

### Using VS Code
1. Open the `grade-calculator` folder
2. Open `Main.java`
3. Click the ▶ Run button (top-right)

## Grade Scale
| Average    | Grade              |
|------------|--------------------|
| 90 – 100   | O  (Outstanding)   |
| 80 – 89    | A+ (Excellent)     |
| 70 – 79    | A  (Very Good)     |
| 60 – 69    | B+ (Good)          |
| 50 – 59    | B  (Average)       |
| 40 – 49    | C  (Pass)          |
| Below 40   | F  (Fail)          |

## Key Concepts Demonstrated
- **Encapsulation** — private fields with public getters/setters in `Student.java`
- **Collections** — `ArrayList<Student>` for storage, `HashMap<String, Integer>` for marks
- **Exception Handling** — `IllegalArgumentException` for invalid marks, `NumberFormatException` for bad input
- **Modular Design** — separate classes for model (Student) and logic (GradeCalculator)
