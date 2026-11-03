import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatementExample {

    private static final String url = "jdbc:mysql://localhost:3306/northwind";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {

        // User input (Imagine this came from a form)
        String customerId = "1";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement()) {

            // Danger: String concatenation builds raw SQL
            String sql = "SELECT * FROM customers WHERE CustomerID = '"
                    + customerId + "'";

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Customer found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
