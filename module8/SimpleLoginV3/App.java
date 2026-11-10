import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App extends JFrame {

    // Attributes for the login form/GUI components
    JTextField usernameField;
    JPasswordField passwordField;
    JLabel messageLabel;

    // Constuctor to set up the GUI
    public App() {

        // 1. Set up the JFrame properties
        setTitle("Login System");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // 2. Create and add GUI components
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        messageLabel = new JLabel("");

        // 3. Add event listener for the login button
        // Run this code when the Login button is clicked
        loginButton.addActionListener(e -> login());

        // 4. Add components to the JFrame
        add(usernameLabel);
        add(usernameField);

        add(passwordLabel);
        add(passwordField);

        add(new JLabel("")); // Empty space
        add(loginButton);

        add(new JLabel("Status:"));
        add(messageLabel);

        setLocationRelativeTo(null); // Place window at the center of the screen
        setVisible(true);
    }

    class WelcomeFrame extends JFrame {

        public WelcomeFrame(String username) {
            setTitle("Welcome");
            setSize(350, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel welcomeLabel = new JLabel(
                    "Welcome, " + username + "!",
                    SwingConstants.CENTER);

            add(welcomeLabel);

            setLocationRelativeTo(null);
            setVisible(true);
        }
    }

    public void login() {
        // Extract the username and password from the input fields
        String usernameInput = usernameField.getText();
        String passwordInput = new String(passwordField.getPassword());

        User user = new User(usernameInput, passwordInput);

        // MySQL database connection details
        // Replace 'mydatabase', 'root', and 'your_password' with your actual database
        // name, user, and password
        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String dbUser = "root";
        String dbPassword = "password";

        String query = "SELECT password FROM users WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set the username parameter in the query safely to prevent SQL injection
            pstmt.setString(1, user.getUsername());

            try (ResultSet rs = pstmt.executeQuery()) {
                boolean loginSuccessful = false;

                if (rs.next()) {
                    String storedPassword = rs.getString("password");

                    // Verify the entered password matches the database record
                    if (storedPassword.equals(user.getPassword())) {
                        loginSuccessful = true;
                    }
                }

                if (loginSuccessful) {
                    messageLabel.setText("Login successful!");
                    new WelcomeFrame(user.getUsername());
                    dispose(); // Closes the login window
                } else {
                    messageLabel.setText("Incorrect username or password.");
                }
            }

        } catch (Exception error) {
            messageLabel.setText("Database error occurred.");
            error.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new App();
    }
}