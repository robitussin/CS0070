public class App {
    public static void main(String[] args) {

        // NullPointerException is thrown when an application attempts to use null in a case where an object is required.

        try {
            String myName = null;

            System.out.println(myName.length());
        } catch (NullPointerException e) {
            System.out.println("Cannot print a null value");
        }
    }
}