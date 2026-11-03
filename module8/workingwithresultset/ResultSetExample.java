import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultSetExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/northwind";
        String user = "root";
        String password = "password";

        // User input
        String inputCustomerID = "1";

        // Placeholders (?) represent values supplied later
        String sql = "SELECT * FROM customers WHERE CustomerID = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Bind values to placeholders (1-indexed)
            pstmt.setString(1, inputCustomerID);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("CustomerID");

                System.out.println("Customer found! ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}