import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class LoginAppNoDB extends JFrame implements ActionListener {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private JLabel statusLabel;

    // Hardcoded users list
    private HashMap<String, String> users;

    public LoginAppNoDB() {
        setTitle("Login Page");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Username:"));
        userField = new JTextField();
        add(userField);

        add(new JLabel("Password:"));
        passField = new JPasswordField();
        add(passField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        add(loginButton);

        statusLabel = new JLabel();
        add(statusLabel);

        loadUsers();  // Load hardcoded users
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    // Hardcoded users
    private void loadUsers() {
        users = new HashMap<>();
        users.put("admin", "admin123");
        users.put("user", "pass123");
        users.put("test", "test123");
    }

    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passField.getPassword());

        if (users.containsKey(username) && users.get(username).equals(password)) {
            statusLabel.setText("Login successful");
            JOptionPane.showMessageDialog(this, "Welcome, " + username + "!");
        } else {
            statusLabel.setText("Login failed");
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }

    public static void main(String[] args) {
        new LoginAppNoDB();
    }
}
