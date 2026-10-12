import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        // Specifying a file path that does not exist
        File file = new File("sample.txt");
        
        try {
            // This constructor throws FileNotFoundException if the file is missing
            FileReader reader = new FileReader(file);
            
            System.out.println("File opened successfully.");

            reader.close(); // Close the reader after use
            
        } catch (FileNotFoundException e) {
            // Handle the specific case where the file is missing or inaccessible
            System.err.println("Error: The requested file could not be found!");
            System.err.println("Details: " + e.getMessage());  

            
        } 
    }
}
