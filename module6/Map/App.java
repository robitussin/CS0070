import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();

        // Add key-value pairs
        inventory.put("Apples", 50);
        inventory.put("Bananas", 30);
        inventory.put("Oranges", 20);

        // Updating a value (overwriting existing key)
        inventory.put("Apples", 75);

        // Accessing values
        System.out.println("Apple count: " + inventory.get("Apples")); // Output: 75

        // Using getOrDefault to avoid NullPointerException
        System.out.println("Grapes count: " + inventory.getOrDefault("Grapes", 0)); // Output: 0

        // Checking existence
        if (inventory.containsKey("Bananas")) {
            System.out.println("Bananas are in stock!");
        }

        // Removing an entry
        inventory.remove("Oranges");
    }
}