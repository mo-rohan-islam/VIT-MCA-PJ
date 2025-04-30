/*
 * Write a Java program to get the name, age, designation and salary of the person from the user and display the output in standard output device.
 */

import java.util.Scanner;

public class PersonalDetails {
    public static void main(String[] args) {
        String name = null, designation = null;
        int age = 0;
        double salary = 0;

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter the details of the person");
            System.out.println("================================");
            System.out.print("Enter the name: ");
            name = scan.nextLine();
            System.out.print("Enter the age: ");
            age = scan.nextInt();
            scan.nextLine();    // clear the buffer after nextInt();
            System.out.print("Enter the designation: ");
            designation = scan.nextLine();
            System.out.print("Enter the salary: ");
            salary = scan.nextDouble();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(PersonalDetails.printPersonDetails(name, age, designation, salary));
    }

    private static String printPersonDetails(String name, Integer age, String designation, Double salary) {
        return "\nPerson Details \n" +
        "===============\n" +
        "name: " + name + "\n" +
        "age: " + age + "\n" +
        "designation: " + designation + "\n" +
        "salary: " + salary + "\n";
    }
}