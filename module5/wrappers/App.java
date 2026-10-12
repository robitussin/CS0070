import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        // 1. Autoboxing & Unboxing
        Integer wrappedAge = 25; // Primitive int 25 is automatically wrapped in an Integer object
        int normalAge = wrappedAge; // Integer object is automatically unboxed to a primitive int

        System.out.println("Wrapped Age: " + wrappedAge);
        System.out.println("Normal Age: " + normalAge);

        // 2. Using Wrapper Classes with Collections (ArrayList cannot hold primitive
        // 'int')
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(95); // Autoboxing: primitive 95 becomes an Integer object

        // This will throw a compilation error:
        // ArrayList<int> list = new ArrayList<>();

        // 3. Using Built-in Utility Methods (converting strings to numbers)
        String priceString = "150";
        int price = Integer.parseInt(priceString);
        System.out.println("Calculated total with tax: " + (price + 10));

        // 4. Handling null values (primitives cannot be null)
        Integer optionalScore = null;
        if (optionalScore == null) {
            System.out.println("No score recorded yet!");
        }
    }

}