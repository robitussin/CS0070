import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Set<String> uniqueNames = new HashSet<>();

        // Adding elements
        uniqueNames.add("Alice");
        uniqueNames.add("Bob");
        uniqueNames.add("Charlie");

        // Attempting to add a duplicate
        boolean isAdded = uniqueNames.add("Alice");
        System.out.println("Was second 'Alice' added? " + isAdded); // Output: false

        // Checking existence
        System.out.println("Contains Bob? " + uniqueNames.contains("Bob")); // Output: true

        // Size of the set
        System.out.println("Total elements: " + uniqueNames.size()); // Output: 3
    }
}