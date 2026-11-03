import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class App extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;
    JLabel messageLabel;

    public App() {
        setTitle("Login System");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        messageLabel = new JLabel("");

        // Run this code when the Login button is clicked
        loginButton.addActionListener(e -> login());

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
        String usernameInput = usernameField.getText();
        String passwordInput = new String(passwordField.getPassword());

        User user = new User(usernameInput, passwordInput);

        try {
            File accountsFile = new File("accounts.txt");

            // Create the file if it does not exist
            if (accountsFile.createNewFile()) {
                messageLabel.setText("accounts.txt was created.");
                return;
            }

            Scanner fileScanner = new Scanner(accountsFile);
            boolean loginSuccessful = false;

            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine();

                // Expected format: username,password
                String[] account = data.split(",");

                if (account.length == 2) {
                    String username = account[0];
                    String password = account[1];

                    if (username.equals(user.getUsername())
                            && password.equals(user.getPassword())) {

                        loginSuccessful = true;
                        break;
                    }
                }
            }

            fileScanner.close();

            if (loginSuccessful) {
                messageLabel.setText("Login successful!");

                new WelcomeFrame(user.getUsername());
                dispose(); // Closes the login window
            } else {
                messageLabel.setText("Incorrect username or password.");
            }

        } catch (Exception error) {
            messageLabel.setText("An error occurred.");
        }
    }

    public static void main(String[] args) {
        new App();
    }
}