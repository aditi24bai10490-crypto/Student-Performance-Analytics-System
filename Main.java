import java.util.*;

class Student {
    int rollNo;
    String name;
    int[] marks = new int[5]; // 5 subjects
    double average;
    String grade;
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Sort by Performance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                System.out.print("Enter Roll No: ");
                int roll = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                // ✅ CREATE OBJECT FIRST
                Student s = new Student();
                s.rollNo = roll;
                s.name = name;

                // ✅ THEN USE s
                System.out.println("Enter marks for 5 subjects:");
                for (int i = 0; i < 5; i++) {
                    System.out.print("Subject " + (i + 1) + ": ");
                    s.marks[i] = sc.nextInt();
                }

                // ✅ CALCULATE
                int sum = 0;
                for (int m : s.marks) {
                    sum += m;
                }
                s.average = sum / 5.0;

                // ✅ GRADE
                if (s.average >= 90) s.grade = "A";
                else if (s.average >= 75) s.grade = "B";
                else if (s.average >= 50) s.grade = "C";
                else s.grade = "Fail";

                // ✅ ADD TO LIST
                students.add(s);

                System.out.println("Student added successfully!");
                break;
                case 2:
                    for (Student st : students) {
                        System.out.println("Roll No: " + st.rollNo);
                        System.out.println("Name: " + st.name);
                        System.out.println("Average: " + st.average);
                        System.out.println("Grade: " + st.grade);

                        // Find weakest subject
                        int min = st.marks[0];
                        int index = 0;

                        for (int i = 1; i < 5; i++) {
                            if (st.marks[i] < min) {
                                min = st.marks[i];
                                index = i;
                            }
                        }

                        System.out.println("Weakest Subject: Subject " + (index + 1));

                        // Suggestion
                        if (st.average < 50) {
                            System.out.println("Suggestion: High risk - needs serious improvement");
                        } 
                        else if (st.average < 70) {
                            System.out.println("Suggestion: Needs improvement");
                        } 
                        else if (st.average < 85) {
                            System.out.println("Suggestion: Good performance");
                        } 
                        else {
                            System.out.println("Suggestion: Excellent performance");
                        }

                        System.out.println("------------------");
                    }
                    break;
                case 3:
                    students.sort((a, b) -> Double.compare(b.average, a.average));
                    System.out.println("Students sorted by performance!");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}