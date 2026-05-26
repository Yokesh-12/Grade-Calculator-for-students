package gradecalculator;

import java.util.Scanner;

/**
 * ============================================================
 *  STUDENT GRADE CALCULATOR
 *  A console-based Java application to manage student marks,
 *  compute totals, averages, and assign letter grades.
 *
 *  Technologies: Core Java, OOP, Collections, Exception Handling
 *  Author      : Yokesh E
 * ============================================================
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final GradeCalculator calculator = new GradeCalculator();

    public static void main(String[] args) {
        printBanner();

        // Pre-load sample data so the app works straight away
        loadSampleData();

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addStudent();
                case "2" -> addMarksToStudent();
                case "3" -> viewStudentReport();
                case "4" -> calculator.printAllStudents();
                case "5" -> { System.out.println("\n  Goodbye! All the best, Yokesh!\n"); running = false; }
                default  -> System.out.println("\n  [!] Invalid option. Please enter 1–5.");
            }
        }
        scanner.close();
    }

    // ─── ADD STUDENT ─────────────────────────────────────────
    private static void addStudent() {
        System.out.println("\n  ── Add New Student ──");
        System.out.print("  Enter Student ID  : ");
        String id = scanner.nextLine().trim();

        System.out.print("  Enter Student Name: ");
        String name = scanner.nextLine().trim();

        if (id.isEmpty() || name.isEmpty()) {
            System.out.println("  [!] ID and Name cannot be empty.");
            return;
        }

        Student student = new Student(id, name);

        System.out.print("  How many subjects? : ");
        try {
            int count = Integer.parseInt(scanner.nextLine().trim());
            if (count <= 0) throw new NumberFormatException();

            for (int i = 1; i <= count; i++) {
                System.out.print("  Subject " + i + " name    : ");
                String subject = scanner.nextLine().trim();
                System.out.print("  Marks (0–100)      : ");
                int marks = Integer.parseInt(scanner.nextLine().trim());
                try {
                    student.addMark(subject, marks);
                } catch (IllegalArgumentException e) {
                    System.out.println("  [!] " + e.getMessage() + " — subject skipped.");
                }
            }

            if (calculator.addStudent(student)) {
                System.out.println("  [✓] Student added successfully!");
                calculator.printReport(student);
            }

        } catch (NumberFormatException e) {
            System.out.println("  [!] Please enter a valid number.");
        }
    }

    // ─── ADD MARKS TO EXISTING STUDENT ───────────────────────
    private static void addMarksToStudent() {
        System.out.println("\n  ── Add Marks to Existing Student ──");
        System.out.print("  Enter Student ID: ");
        String id = scanner.nextLine().trim();

        Student student = calculator.findById(id);
        if (student == null) {
            System.out.println("  [!] No student found with ID: " + id);
            return;
        }

        System.out.print("  Subject name  : ");
        String subject = scanner.nextLine().trim();
        System.out.print("  Marks (0–100) : ");

        try {
            int marks = Integer.parseInt(scanner.nextLine().trim());
            student.addMark(subject, marks);
            System.out.println("  [✓] Marks added. Updated report:");
            calculator.printReport(student);
        } catch (NumberFormatException e) {
            System.out.println("  [!] Invalid marks. Please enter a number.");
        } catch (IllegalArgumentException e) {
            System.out.println("  [!] " + e.getMessage());
        }
    }

    // ─── VIEW ONE STUDENT ─────────────────────────────────────
    private static void viewStudentReport() {
        System.out.println("\n  ── View Student Report ──");
        System.out.print("  Enter Student ID: ");
        String id = scanner.nextLine().trim();

        Student student = calculator.findById(id);
        if (student == null) {
            System.out.println("  [!] No student found with ID: " + id);
        } else {
            calculator.printReport(student);
        }
    }

    // ─── SAMPLE DATA ──────────────────────────────────────────
    private static void loadSampleData() {
        Student s1 = new Student("S001", "Yokesh E");
        s1.addMark("Java Programming", 92);
        s1.addMark("Data Structures", 88);
        s1.addMark("Database Systems", 85);
        s1.addMark("Operating Systems", 78);
        s1.addMark("Computer Networks", 81);
        calculator.addStudent(s1);

        Student s2 = new Student("S002", "Arun Kumar");
        s2.addMark("Java Programming", 74);
        s2.addMark("Data Structures", 69);
        s2.addMark("Database Systems", 71);
        s2.addMark("Operating Systems", 66);
        s2.addMark("Computer Networks", 72);
        calculator.addStudent(s2);

        Student s3 = new Student("S003", "Priya S");
        s3.addMark("Java Programming", 55);
        s3.addMark("Data Structures", 48);
        s3.addMark("Database Systems", 52);
        s3.addMark("Operating Systems", 45);
        s3.addMark("Computer Networks", 50);
        calculator.addStudent(s3);

        System.out.println("  [✓] Sample data loaded (3 students).");
    }

    // ─── UI HELPERS ───────────────────────────────────────────
    private static void printBanner() {
        System.out.println("\n  ╔══════════════════════════════════════════╗");
        System.out.println("  ║     STUDENT GRADE CALCULATOR v1.0        ║");
        System.out.println("  ║     Built with Core Java | Yokesh E      ║");
        System.out.println("  ╚══════════════════════════════════════════╝");
    }

    private static void printMenu() {
        System.out.println("\n  ┌──────────────────────────────┐");
        System.out.println("  │         MAIN MENU            │");
        System.out.println("  ├──────────────────────────────┤");
        System.out.println("  │  1. Add New Student          │");
        System.out.println("  │  2. Add Marks to Student     │");
        System.out.println("  │  3. View Student Report      │");
        System.out.println("  │  4. View All Students        │");
        System.out.println("  │  5. Exit                     │");
        System.out.println("  └──────────────────────────────┘");
        System.out.print("  Your choice: ");
    }
}
