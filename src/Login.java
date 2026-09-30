import dbconnection.DBConnection;

import javax.swing.*;
import java.sql.*;

public class Login extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;

    public Login() {

        setTitle("Titan Company - Ratio Analysis");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("TITAN RATIO ANALYSIS");
        title.setBounds(100, 20, 220, 30);
        panel.add(title);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 70, 100, 25);
        panel.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 70, 180, 25);
        panel.add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 110, 100, 25);
        panel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 110, 180, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 155, 100, 30);
        panel.add(loginButton);

        loginButton.addActionListener(e -> login());

        add(panel);
        setVisible(true);
    }

private void login() {

    String username = usernameField.getText();
    String password = new String(passwordField.getPassword());

    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            JOptionPane.showMessageDialog(this,
                    "Login Successful!");

            new MainDashBoard().setVisible(true);
            dispose();

        } else {

            JOptionPane.showMessageDialog(this,
                    "Invalid Username or Password!");
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this,
                "Database Error: " + e.getMessage());

        e.printStackTrace();
    }
}
public static void main(String[]args){
    new Login();
}
}