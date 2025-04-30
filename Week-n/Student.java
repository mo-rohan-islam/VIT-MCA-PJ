/*
 * Write a Java program to create a class called `Student` with three overloaded constructors:
 *  a. The default constructor initializes the `registerNumber` and `name` fields.
 *  b. The parameterized constructor initializes the `registerNumber`, `name`, and `mark` fields.
 *  c. The copy constructor takes an object of type `Student` and copies its values into the new object.
 * 
 */

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Student {
    String registerNumber;
    String name;
    List<Integer> marks;

    Student() {
        this.registerNumber = "";
        this.name = "";
    }

    Student(String registerNumber, String name, List<Integer> marks) {
        this.registerNumber = registerNumber;
        this.name = name;
        this.marks = new ArrayList<>(marks);
    }

    Student(Student s) {
        this.registerNumber = s.registerNumber;
        this.name = s.name;
        this.marks = new ArrayList<>(s.marks);
    }

    @Override
    public String toString() {
        return "Student [registerNumber=" + registerNumber + ", name=" + name + ", marks=" + marks + "]";
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Create default student
            Student defaultStudent = new Student();
            System.out.println("Default student created: " + defaultStudent);

            // Create student with user input
            System.out.println("\nEnter details for a new student:");
            System.out.print("Registration Number: ");
            String regNo = scanner.nextLine();
            
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            // System.out.print("Enter marks: ");
            // List<Integer> marks = Arrays.stream(scanner.nextLine().split(" "))
            //                             .filter(num -> !num.trim().isEmpty())
            //                             .map(Integer::parseInt)
            //                             .toList();


            AtomicInteger counter = new AtomicInteger(0);
            List<Integer> marks = Stream.generate(() -> {
                    System.out.print("Enter mark " + counter.incrementAndGet() + ": ");
                    return scanner.nextLine();
                })
                .takeWhile(line -> !line.isEmpty() /* && line != null */ )
                .map(Integer::parseInt)
                .toList();

            // System.out.print("Enter number of marks: ");
            // int numMarks = scanner.nextInt();
            
            // List<Integer> marks = new ArrayList<>();
            // for (int i = 0; i < numMarks; i++) {
            //     System.out.print("Enter mark " + (i + 1) + ": ");
            //     marks.add(scanner.nextInt());
            // }
            // scanner.nextLine(); // Consume newline
            
            Student userStudent = new Student(regNo, name, marks);
            System.out.println("\nStudent created from user input: " + userStudent);

            // Create student using copy constructor
            Student copiedStudent = new Student(userStudent);
            System.out.println("\nCopied student: " + copiedStudent);

            // Demonstrate independence of copied student
            System.out.print("\nEnter an additional mark for the copied student: ");
            copiedStudent.marks.add(scanner.nextInt());
            scanner.nextLine(); // Consume newline
            
            System.out.println("\nOriginal student: " + userStudent);
            System.out.println("Modified copied student: " + copiedStudent);

        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input type entered");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
