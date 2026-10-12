import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_database";
        String user = "root";
        String password = "password";
        String query = "SELECT id, username FROM users WHERE status = ?";

        // Try-with-resources automatically closes connections and statements
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, "active");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("User ID: " + rs.getInt("id"));
                }
            }
            
        } catch (SQLException e) {
            // Log and debug the database exception
            System.err.println("Database Error Message: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Vendor Error Code: " + e.getErrorCode());
            e.printStackTrace();
        }
    }
}
