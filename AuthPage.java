import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class AuthPage extends JPanel {
    private static HashMap<String, String> userDatabase = new HashMap<>(); // Stores Username -> Password
    private JTextField txtUser = new JTextField(15);
    private JPasswordField txtPass = new JPasswordField(15);
    private boolean isLoginMode = true;
    private JLabel lblTitle = new JLabel("Login to Library");
    private JButton btnAction = new JButton("Login");
    private JButton btnToggle = new JButton("Need an account? Sign Up");

    public AuthPage(MainApp app) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy = 0; add(lblTitle, gbc);
        
        gbc.gridy = 1; add(new JLabel("Username:"), gbc);
        gbc.gridy = 2; add(txtUser, gbc);
        
        gbc.gridy = 3; add(new JLabel("Password:"), gbc);
        gbc.gridy = 4; add(txtPass, gbc);

        gbc.gridy = 5; add(btnAction, gbc);
        gbc.gridy = 6; add(btnToggle, gbc);

        // Action Logic
        btnAction.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());

            if (isLoginMode) {
                if (userDatabase.containsKey(user) && userDatabase.get(user).equals(pass)) {
                    app.showPage("Dashboard");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Credentials!");
                }
            } else {
                userDatabase.put(user, pass);
                JOptionPane.showMessageDialog(this, "Account Created! Please Login.");
                toggleMode();
            }
        });

        btnToggle.addActionListener(e -> toggleMode());
    }

    private void toggleMode() {
        isLoginMode = !isLoginMode;
        lblTitle.setText(isLoginMode ? "Login to Library" : "Create Account");
        btnAction.setText(isLoginMode ? "Login" : "Register");
        btnToggle.setText(isLoginMode ? "Need an account? Sign Up" : "Back to Login");
    }
}