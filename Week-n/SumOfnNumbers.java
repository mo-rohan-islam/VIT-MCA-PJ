/*
 * Write a Java program to find sum of 1 to n numbers
 */

import java.util.Scanner;
import java.util.stream.IntStream;

public class SumOfnNumbers {
    public static void main(String[] args) {
        int n = 0;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter a positive integer n: ");
            n = scan.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(String.format("The sum of 1 to %d is %d.", n, SumOfnNumbers.sum(n)));
    }

    public static Integer sum(int n) {
        return IntStream.rangeClosed(1,n).sum();
    }
}
