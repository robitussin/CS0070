import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NorthwindCrudExample {

    // Connection details for MS SQL Server
    private static final String url = "jdbc:mysql://localhost:3306/northwind";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to SQL Server Northwind Database successfully!\n");

            // Define sample customer data (CustomerID in Northwind Customers table is a
            // 5-char NCHAR primary key)
            String customerId = "500";

            // // 1. CREATE (Insert a new customer)
            createCustomer(conn, customerId, "Elizer Ponio Jr", "Rona Salazar", "123 Main St", "New York",
                    "10001", "USA");

            // 2. READ (Retrieve the inserted customer)
            readCustomer(conn, customerId);

            // 3. UPDATE (Modify customer contact details)
            updateCustomerContact(conn, customerId, "Jojit Alcalde");

            // Read again to verify update
            readCustomer(conn, customerId);

            // 4. DELETE (Remove the test customer)
            deleteCustomer(conn, customerId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --- CREATE ---
    public static void createCustomer(Connection conn, String id, String name, String contact, String address,
            String city, String postalCode, String country) throws SQLException {
        String sql = "INSERT INTO Customers (CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, contact);
            pstmt.setString(4, address);
            pstmt.setString(5, city);
            pstmt.setString(6, postalCode);
            pstmt.setString(7, country);

            int rowsInserted = pstmt.executeUpdate();
            System.out.println("[CREATE] Inserted " + rowsInserted + " customer record(s).");
        }
    }

    // --- READ ---
    public static void readCustomer(Connection conn, String id) throws SQLException {
        String sql = "SELECT CustomerID, CustomerName, ContactName, City, PostalCode, Country FROM Customers WHERE CustomerID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("[READ] Found Customer:");
                    System.out.println("  - ID: " + rs.getString("CustomerID"));
                    System.out.println("  - Company Name: " + rs.getString("CustomerName"));
                    System.out.println("  - Contact Name: " + rs.getString("ContactName"));
                    System.out.println("  - Location: " + rs.getString("City") + ", " + rs.getString("Country"));
                } else {
                    System.out.println("[READ] No customer found with ID: " + id);
                }
            }
        }
    }

    // --- UPDATE ---
    public static void updateCustomerContact(Connection conn, String id, String newContactName)
            throws SQLException {
        String sql = "UPDATE Customers SET ContactName = ? WHERE CustomerID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newContactName);
            pstmt.setString(2, id);

            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("[UPDATE] Updated " + rowsUpdated + " customer record(s).");
        }
    }

    // --- DELETE ---
    public static void deleteCustomer(Connection conn, String id) throws SQLException {
        String sql = "DELETE FROM Customers WHERE CustomerID = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            System.out.println("[DELETE] Deleted " + rowsDeleted + " customer record(s).");
        }
    }
}
