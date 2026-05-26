package gradecalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages all students in the system.
 * Demonstrates: ArrayList, search by ID, display report
 */
public class GradeCalculator {

    private List<Student> students; // ArrayList to store all students

    public GradeCalculator() {
        this.students = new ArrayList<>();
    }

    // Add a new student (no duplicate IDs)
    public boolean addStudent(Student student) {
        if (findById(student.getStudentId()) != null) {
            System.out.println("  [!] Student ID " + student.getStudentId() + " already exists.");
            return false;
        }
        students.add(student);
        return true;
    }

    // Find student by ID (linear search)
    public Student findById(String id) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    // Print full report for one student
    public void printReport(Student s) {
        System.out.println("\n  ┌─────────────────────────────────────┐");
        System.out.printf("  │  Student : %-26s│%n", s.getName());
        System.out.printf("  │  ID      : %-26s│%n", s.getStudentId());
        System.out.println("  ├──────────────────────┬──────────────┤");
        System.out.println("  │  Subject             │  Marks       │");
        System.out.println("  ├──────────────────────┼──────────────┤");
        for (var entry : s.getSubjectMarks().entrySet()) {
            System.out.printf("  │  %-20s│  %-12d│%n", entry.getKey(), entry.getValue());
        }
        System.out.println("  ├──────────────────────┴──────────────┤");
        System.out.printf("  │  Total   : %-26d│%n", s.getTotal());
        System.out.printf("  │  Average : %-26.2f│%n", s.getAverage());
        System.out.printf("  │  Grade   : %-26s│%n", s.getGrade());
        System.out.println("  └─────────────────────────────────────┘");
    }

    // Print summary of all students
    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("  No students added yet.");
            return;
        }
        System.out.println("\n  ┌──────────┬──────────────────────┬──────────┬──────────┬───────────────────┐");
        System.out.println("  │  ID      │  Name                │  Total   │  Avg     │  Grade            │");
        System.out.println("  ├──────────┼──────────────────────┼──────────┼──────────┼───────────────────┤");
        for (Student s : students) {
            System.out.printf("  │ %-8s │ %-20s │ %-8d │ %-8.2f │ %-17s │%n",
                s.getStudentId(), s.getName(), s.getTotal(), s.getAverage(), s.getGrade());
        }
        System.out.println("  └──────────┴──────────────────────┴──────────┴──────────┴───────────────────┘");
    }

    public List<Student> getStudents() { return students; }
}
