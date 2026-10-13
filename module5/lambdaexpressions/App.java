import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    // 1. A functional interface with a single abstract method
    @FunctionalInterface
    interface MathOperation {
        int calculate(int a, int b);
    }

    public static void main(String[] args) {
        // --- Example 1: Using a custom functional interface with a Lambda ---
        
        // Addition lambda
        MathOperation addition = (int a, int b) -> a + b;
        
        // Multiplication lambda (type inference: Java knows a and b are ints)
        MathOperation multiplication = (a, b) -> a * b;

        System.out.println("--- Custom Functional Interface ---");
        System.out.println("10 + 5 = " + operate(10, 5, addition));
        System.out.println("10 * 5 = " + operate(10, 5, multiplication));

        // --- Example 2: Working with Collections (Sorting) ---
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");

        System.out.println("\n--- Collections & Sorting ---");
        System.out.println("Before sorting: " + fruits);

        // Sorting using a lambda expression instead of an anonymous inner class
        Collections.sort(fruits, (s1, s2) -> s1.compareTo(s2));

        System.out.println("After sorting (Alphabetical): " + fruits);

        // --- Example 3: Using the built-in Consumer interface with forEach ---
        System.out.println("\n--- Using forEach with a Lambda ---");
        fruits.forEach(fruit -> System.out.println("Fruit item: " + fruit));
    }