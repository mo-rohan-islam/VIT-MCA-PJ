/*
 * Write a Java program to find complex addition using method overloading:
 * a. Create a class Complex.
 * b. Create a parameterized constructor to get the real and imaginary parts of the number.
 * c. Create a parameterized constructor that initializes the real and imaginary parts of the complex number.
 * d. Create an add method to pass the parameters as the real and imaginary parts of the number, perform the addition, and return a complex number.
 * e. Create another add method to pass an object of the Complex class, perform the addition, and return a complex number.
 * f. Display the output.
 *
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Complex {
    int real;
    int imag;

    Complex() {
        this.real = 0;
        this.imag = 0;
    }

    Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    Complex add (int real, int imag) {
        Complex sum = new Complex();
        sum.real = this.real + real;
        sum.imag = this.imag + imag;
        return sum;
    }

    Complex add (Complex num) {
        Complex sum = new Complex();
        sum.real = this.real + num.real;
        sum.imag = this.imag + num.imag;
        return sum;
    }

    @Override
    public String toString() {
        // return "Complex [real=" + real + ", imag=" + imag + "]";
        return real + " + " + imag + "i";
    }

    public static void main(String[] args) {
        Complex c1 = null, c2 = null;

        try (Scanner scan = new Scanner(System.in)) {
            c1 = Complex.createComplexNumber(scan);
            c2 = Complex.createComplexNumber(scan);
        } catch (InputMismatchException e) {
            System.err.println("Input does not match required type (int)");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(String.format("\nAddition with parameters real (%d) and imag (%d): %s", c2.real, c2.imag, c1.add(c2.real, c2.imag)));
        System.out.println(String.format("Addition with another complex number (%s): %s", c2, c1.add(c2)));
    }

    private static Complex createComplexNumber(Scanner scan) {

        System.out.println("\nEnter the complex number");
        System.out.print("Enter real part: ");
        int real = scan.nextInt();
        System.out.print("Enter imaginary part: ");
        int imag = scan.nextInt();

        return new Complex(real, imag);
    }
}

