package Lab_day3.StudentManager;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void printWelcomeMessage() {
        System.out.println("+++++Welcome to Student Manager Application+++++");
        System.out.println("Please choose an option:");
    }

    public static void printMenu() {
        System.out.println("1. Add New Student");
        System.out.println("2. Add Course to Student");
        System.out.println("3. Display Students");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        printWelcomeMessage();
        printMenu();
        Boolean running = true;
        Scanner scan = new java.util.Scanner(System.in);
        Regesteration action = (student, course, grade) -> student.registerCourse(course, grade);

        while (running) {
            while (true) {
                try {

                    int choice = scan.nextInt();
                    if (choice == 1) {
                        System.out.println("Enter Student Name:");
                        String name = scan.next();
                        System.out.println("Enter Student Age:");
                        int age = scan.nextInt();
                        if (age < 0) {
                            throw new IllegalArgumentException("Age is not possible please try again");
                        }
                        System.out.println("Enter Student ID:");
                        String studentId = scan.next();
                        if (manager.findStudent(studentId)) {
                            throw new IllegalArgumentException("Student ID already exists please try again");
                        }
                        Student student = new Student(name, age, studentId);

                        manager.addStudent(student);
                        System.out.println("Student Added Successfully!");
                    } else if (choice == 2) {
                        System.out.println("Enter Student Index:");
                        int index = scan.nextInt();
                        Student student = manager.getStudent(index - 1);
                        if (student != null) {
                            System.out.println("Enter Course ID:");
                            Integer courseId = scan.nextInt();
                            if (courseId < 0) {
                                throw new IllegalArgumentException("Course ID cannot be negative please try again");
                            } else if (manager.findCourse(courseId)) {
                                throw new IllegalArgumentException("Course ID already exists please try again");
                            }
                            System.out.println("Enter Course Name:");
                            String courseName = scan.next();
                            System.out.println("Enter CreditHours Code:");
                            Integer courseCreditHourse = scan.nextInt();
                            Course course = new Course(courseId, courseName, courseCreditHourse);
                            System.out.println("Enter Grade (or -1 if not available):");
                            Double gradeInput = scan.nextDouble();
                            Double grade = (gradeInput == -1) ? null : gradeInput;
                            action.registerCourse(student, course, grade);
                            System.out.println("Course Added Successfully!");
                        } else {
                            System.out.println("Invalid Student Index");
                        }
                    } else if (choice == 3) {
                        manager.displayStudents();
                    } else if (choice == 4) {
                        System.out.println("Exiting Application. Goodbye!");
                        running = false;
                        scan.close();
                        break;
                    } else {
                        System.out.println("Invalid Choice. Please Try Again.");
                    }
                    printMenu();
                } catch (InputMismatchException e) {
                    System.out.println("+++++++INVALID INPUT PLEASE TRY AGAIN+++++++");
                    scan.next();
                    printMenu();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    printMenu();

                }
            }

        }

    }
}
