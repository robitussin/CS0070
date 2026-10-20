import java.util.Arrays;
import java.util.List;

public class App {

    // A custom static method that matches the Consumer signature (takes one int)
    public static void printDouble(int number) {
        System.out.println(number * 2);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 1. Using a lambda expression
        numbers.forEach(n -> printDouble(n));

        // 2. Using a method reference
        numbers.forEach(App::printDouble);
    }
}