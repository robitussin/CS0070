import java.io.IOException;

public class App {

    // 'throws' declares that this method might throw an IOException
    public static void checkAge(int age) throws IOException {
        if (age < 18) {
            // 'throw' explicitly creates and throws the exception instance
            throw new IOException("Access denied - You must be at least 18 years old.");
        } else {
            System.out.println("Access granted - You are old enough!");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15); // Calling the method with an invalid age
        } catch (IOException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}