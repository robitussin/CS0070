public class App {
    public static void main(String[] args) {

        // ArithmeticException is used when an exceptional arithmetic condition has occurred. 
        // For example, an integer "divide by zero" throws an instance of this class.

        try {
            int a = 5; 
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
           System.out.println("Cannot divide by zero");
        }
    }
}