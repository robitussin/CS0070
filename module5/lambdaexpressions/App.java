import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        /*
         * lambda expression = feature for Java 8 and above
         * also known as an anonymous method
         * a shorter way to write anonymous classes with only one method
         *
         * need to use a functional interface or use a pre-defined functional interface
         * they contain only one abstract method
         * ex. ActionListener, Runnable, (user-defined)
         *
         * A Lambda expression can be used in any place where a functional interface is
         * required
         * How to use a lambda expression:
         * (arguments) -> {statement/s}
         */

        // Example 1
        String name = "Bro";
        char symbol = '!';

        MyInterface myInterface = (x, y) -> {
            System.out.println("Heello World!");
            System.out.println("It is a nice day " + x + y);
        };

        MyInterface myInterface2 = (x, y) -> {
            System.out.println("Hello " + x + y);
        };

        myInterface.message(name, symbol);
        myInterface2.message(name, symbol);

        // Example 2
        // Addition lambda
        MathOperation addition = (int a, int b) -> a + b;

        // Multiplication lambda (type inference: Java knows a and b are ints)
        MathOperation multiplication = (a, b) -> a * b;

        System.out.println("--- Custom Functional Interface ---");
        System.out.println("10 + 5 = " + addition.calculate(10, 5));
        System.out.println("10 * 5 = " + multiplication.calculate(10, 5));
    }
}