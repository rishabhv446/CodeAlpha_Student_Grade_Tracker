import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Calculate Statistics");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter grade: ");
                    double grade = sc.nextDouble();

                    if (grade < 0 || grade > 100) {
                        System.out.println("Grade must be between 0 and 100.");
                    } else {
                        students.add(new Student(name, grade));
                        System.out.println("Student added successfully!");
                    }
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        System.out.println("\n----- STUDENT REPORT -----");

                        for (int i = 0; i < students.size(); i++) {
                            Student s = students.get(i);

                            System.out.println(
                                (i + 1) + ". " + s.name +
                                " - Grade: " + s.grade
                            );
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No grades available.");
                        break;
                    }

                    double sum = 0;
                    double highest = students.get(0).grade;
                    double lowest = students.get(0).grade;

                    for (Student s : students) {

                        sum += s.grade;

                        if (s.grade > highest) {
                            highest = s.grade;
                        }

                        if (s.grade < lowest) {
                            lowest = s.grade;
                        }
                    }

                    double average = sum / students.size();

                    System.out.println("\n----- GRADE STATISTICS -----");
                    System.out.printf("Average Grade : %.2f%n", average);
                    System.out.printf("Highest Grade : %.2f%n", highest);
                    System.out.printf("Lowest Grade  : %.2f%n", lowest);

                    break;

                case 4:
                    System.out.println("Thank you for using Student Grade Tracker!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
