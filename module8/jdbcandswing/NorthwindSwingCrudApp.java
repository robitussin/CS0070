import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NorthwindSwingCrudApp extends JFrame {

    // Database Connection Parameters
    private static final String URL = "jdbc:mysql://localhost:3306/northwind";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Form Input Fields
    private JTextField txtId = new JTextField(10);
    private JTextField txtName = new JTextField(15);
    private JTextField txtContact = new JTextField(15);
    private JTextField txtAddress = new JTextField(15);
    private JTextField txtCity = new JTextField(10);
    private JTextField txtPostalCode = new JTextField(10);
    private JTextField txtCountry = new JTextField(10);

    // Table Components
    private JTable customerTable;
    private DefaultTableModel tableModel;

    public NorthwindSwingCrudApp() {
        setTitle("Northwind Customer Management (JDBC Swing)");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- TOP: Form Panel ---
        JPanel formPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));

        formPanel.add(new JLabel("Customer ID:"));
        formPanel.add(txtId);
        formPanel.add(new JLabel("Customer Name:"));
        formPanel.add(txtName);
        formPanel.add(new JLabel("Contact Name:"));
        formPanel.add(txtContact);
        formPanel.add(new JLabel("Address:"));
        formPanel.add(txtAddress);
        formPanel.add(new JLabel("City:"));
        formPanel.add(txtCity);
        formPanel.add(new JLabel("Postal Code:"));
        formPanel.add(txtPostalCode);
        formPanel.add(new JLabel("Country:"));
        formPanel.add(txtCountry);

        add(formPanel, BorderLayout.NORTH);

        // --- CENTER: Table Panel ---
        String[] columnNames = { "ID", "Company Name", "Contact Name", "Address", "City", "Postal Code", "Country" };
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make cells non-editable in table direct view
            }
        };
        customerTable = new JTable(tableModel);
        add(new JScrollPane(customerTable), BorderLayout.CENTER);

        // Table Selection Listener: Fill text fields when clicking a table row
        customerTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = customerTable.getSelectedRow();
            if (selectedRow != -1) {
                txtId.setText(tableModel.getValueAt(selectedRow, 0).toString());
                txtName.setText(tableModel.getValueAt(selectedRow, 1).toString());
                txtContact.setText(tableModel.getValueAt(selectedRow, 2).toString());
                txtAddress.setText(tableModel.getValueAt(selectedRow, 3).toString());
                txtCity.setText(tableModel.getValueAt(selectedRow, 4).toString());
                txtPostalCode.setText(tableModel.getValueAt(selectedRow, 5).toString());
                txtCountry.setText(tableModel.getValueAt(selectedRow, 6).toString());
            }
        });

        // --- BOTTOM: Button Panel ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        JButton btnCreate = new JButton("Create");
        JButton btnRead = new JButton("Read / Refresh All");
        JButton btnUpdate = new JButton("Update Contact");
        JButton btnDelete = new JButton("Delete");
        JButton btnClear = new JButton("Clear Fields");

        buttonPanel.add(btnCreate);
        buttonPanel.add(btnRead);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);

        add(buttonPanel, BorderLayout.SOUTH);

        // --- Event Listeners ---

        // 1. CREATE
        btnCreate.addActionListener(e -> {
            try (Connection conn = getConnection()) {
                createCustomer(conn,
                        txtId.getText().trim(),
                        txtName.getText().trim(),
                        txtContact.getText().trim(),
                        txtAddress.getText().trim(),
                        txtCity.getText().trim(),
                        txtPostalCode.getText().trim(),
                        txtCountry.getText().trim());
                JOptionPane.showMessageDialog(this, "Customer created successfully!");
                loadAllCustomers();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error Creating Customer: " + ex.getMessage(), "Database Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // 2. READ (Refresh Table)
        btnRead.addActionListener(e -> loadAllCustomers());

        // 3. UPDATE
        btnUpdate.addActionListener(e -> {
            try (Connection conn = getConnection()) {
                updateCustomerContact(conn, txtId.getText().trim(), txtContact.getText().trim());
                JOptionPane.showMessageDialog(this, "Customer updated successfully!");
                loadAllCustomers();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error Updating Customer: " + ex.getMessage(), "Database Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // 4. DELETE
        btnDelete.addActionListener(e -> {
            String id = txtId.getText().trim();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter or select a Customer ID to delete.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete Customer ID: " + id + "?", "Confirm Delete",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try (Connection conn = getConnection()) {
                    deleteCustomer(conn, id);
                    JOptionPane.showMessageDialog(this, "Customer deleted successfully!");
                    clearInputFields();
                    loadAllCustomers();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Error Deleting Customer: " + ex.getMessage(), "Database Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Clear Form Fields
        btnClear.addActionListener(e -> clearInputFields());

        // Initial Data Load
        loadAllCustomers();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private void clearInputFields() {
        txtId.setText("");
        txtName.setText("");
        txtContact.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtPostalCode.setText("");
        txtCountry.setText("");
        customerTable.clearSelection();
    }

    // --- CRUD OPERATIONS (From original file) ---

    // 1. CREATE
    public void createCustomer(Connection conn, String id, String name, String contact, String address,
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
            pstmt.executeUpdate();
        }
    }

    // 2. READ ALL (Populates the JTable)
    public void loadAllCustomers() {
        tableModel.setRowCount(0); // Clear current rows
        String sql = "SELECT CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country FROM Customers";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                tableModel.addRow(new Object[] {
                        rs.getString("CustomerID"),
                        rs.getString("CustomerName"),
                        rs.getString("ContactName"),
                        rs.getString("Address"),
                        rs.getString("City"),
                        rs.getString("PostalCode"),
                        rs.getString("Country")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Loading Customers: " + ex.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // 3. UPDATE[cite: 1]
    public void updateCustomerContact(Connection conn, String id, String newContactName) throws SQLException {
        String sql = "UPDATE Customers SET ContactName = ? WHERE CustomerID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newContactName);
            pstmt.setString(2, id);
            pstmt.executeUpdate();
        }
    }

    // 4. DELETE[cite: 1]
    public void deleteCustomer(Connection conn, String id) throws SQLException {
        String sql = "DELETE FROM Customers WHERE CustomerID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        // Run GUI construction on Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new NorthwindSwingCrudApp().setVisible(true);
        });
    }
}