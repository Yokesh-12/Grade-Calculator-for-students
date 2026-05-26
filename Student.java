package gradecalculator;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Student with an ID, name, and subject marks.
 * Demonstrates: Encapsulation, Collections (HashMap)
 */
public class Student {

    private String studentId;
    private String name;
    private Map<String, Integer> subjectMarks; // subject -> marks

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.subjectMarks = new HashMap<>();
    }

    // Add a subject mark (validates 0–100)
    public void addMark(String subject, int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException(
                "Marks must be between 0 and 100. Got: " + marks
            );
        }
        subjectMarks.put(subject, marks);
    }

    public double getAverage() {
        if (subjectMarks.isEmpty()) return 0.0;
        int total = 0;
        for (int mark : subjectMarks.values()) {
            total += mark;
        }
        return (double) total / subjectMarks.size();
    }

    public int getTotal() {
        int total = 0;
        for (int mark : subjectMarks.values()) {
            total += mark;
        }
        return total;
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "O  (Outstanding)";
        else if (avg >= 80) return "A+ (Excellent)";
        else if (avg >= 70) return "A  (Very Good)";
        else if (avg >= 60) return "B+ (Good)";
        else if (avg >= 50) return "B  (Average)";
        else if (avg >= 40) return "C  (Pass)";
        else return "F  (Fail)";
    }

    // Getters
    public String getStudentId()  { return studentId; }
    public String getName()       { return name; }
    public Map<String, Integer> getSubjectMarks() { return subjectMarks; }
}
