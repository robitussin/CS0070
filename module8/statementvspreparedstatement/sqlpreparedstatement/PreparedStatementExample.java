import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementExample {

    private static final String url = "jdbc:mysql://localhost:3306/northwind";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {

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
                System.out.println("Customer found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}