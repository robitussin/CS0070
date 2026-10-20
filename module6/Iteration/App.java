import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasicIteratorExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Obtaining the iterator
        Iterator<String> iterator = fruits.iterator();

        // Traversing elements
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Fruit: " + fruit);
        }
    }
}