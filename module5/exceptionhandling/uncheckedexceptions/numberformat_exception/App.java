package module5.exceptionhandling.numberformat_exception;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // NumberFormatException is thrown to indicate that the application has attempted to convert a string to one of the numeric types,

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your age: ");
        String age = scan.nextLine(); 

        try {
            int result = Integer.parseInt(age); 
            System.out.println("The number is: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        }

        scan.close();
    }
    
}
