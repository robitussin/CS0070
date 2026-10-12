package module5.exceptionhandling.multiplecatchblocks;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // Multiple catch blocks are used to handle different types of exceptions that may be thrown in a try block.
        // Each catch block is designed to handle a specific type of exception, allowing for more precise error handling.

        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Divide two numbers!");

            System.out.print("Enter dividend: ");
            int firstNumber = scan.nextInt();

            System.out.print("Enter divisor: ");
            int secondNumber = scan.nextInt();

            int quotient = firstNumber / secondNumber;

            System.out.print("The quotient is: " + quotient);
        } catch (ArithmeticException e) {
            System.out.print("You cannot divide by zero");
        } catch (NumberFormatException e) {
            System.out.print("Invalid number format");
        }

        scan.close();
    }
}
