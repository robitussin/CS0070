import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println(names.get(1));
    }
}