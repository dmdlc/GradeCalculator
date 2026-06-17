package ph.edu.dlsu.lbycpob;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] resignation) {
        Student[] students = new Student[20];
        int activeCount = 0;

        GradeCalculator calculator = new GradeCalculator();
        GradeReporter reporter = new GradeReporter();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n=====Grades Tracker=====");
            System.out.println("Enter your choice (1-4)");
            System.out.println("1. Enter Student Data");
            System.out.println("2. View Grades Report");
            System.out.println("3. View Class Statistics");
            System.out.println("4. Exit\n");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    if (activeCount >= 20) {
                        System.out.println("Error. Max students reached");
                        break;
                    }

                    System.out.println("\nEnter student details");
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Lab Performance score: ");
                    double lab = scanner.nextDouble();
                    System.out.print("Enter Class Participation score: ");
                    double part = scanner.nextDouble();
                    System.out.print("Enter Teacher's Evaluation score: ");
                    double eval = scanner.nextDouble();
                    System.out.print("Enter Practical Exam score: ");
                    double exam = scanner.nextDouble();
                    System.out.print("Enter Project score: ");
                    double proj = scanner.nextDouble();

                    students[activeCount] = new Student(name, lab, part, eval, exam, proj);
                    activeCount++;

                    System.out.println("Student added successfully");
                }

                case 2 -> {
                    String reportTable = reporter.generateReport(students, activeCount, calculator);
                    System.out.println("\n" + reportTable);
                }

                case 3 -> {
                    if (activeCount == 0) {
                        System.out.println("No student records found");
                    }
                    else {
                        System.out.println("\n====Class Statistics====");
                        System.out.printf("Highest Raw Grade: %.2f\n", + calculator.computeHighest(students, activeCount));
                        System.out.printf("Lowest Raw Grade: %.2f\n", + calculator.computeLowest(students, activeCount));
                        System.out.printf("Class mean average: %.2f\n", + calculator.computeClassMean(students, activeCount));
                    }
                }

                case 4 -> System.out.println("\nExiting program...");
                default -> System.out.printf("Invalid option. Choose between (1-4)");
            }
        } while (choice != 4);

        scanner.close();

    }
}
