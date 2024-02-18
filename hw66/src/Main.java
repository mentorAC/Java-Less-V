/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter number: ");
        int N = cs.nextInt();
        double remainder = (Math.sqrt(N));
        if (remainder == (int)remainder) {
            System.out.println(" Yes ");
        } else {
            System.out.println(" No ");

        }
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        int sum = 0;
        int number;
        do {
            number = cs.nextInt();
            sum += number;
        } while (number != 0);

        System.out.println("Sum of the numbers: " + sum);


    }
}