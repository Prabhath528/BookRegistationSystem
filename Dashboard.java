import javax.swing.*;
import java.awt.*;

public class Dashboard extends JPanel {
    public Dashboard(MainApp app) {
        setLayout(new BorderLayout());
        
        JLabel header = new JLabel("Library Dashboard", SwingConstants.CENTER);
        header.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(header, BorderLayout.NORTH);

        // Grid for the Cards
        JPanel gridPanel = new JPanel(new GridLayout(2, 3, 20, 20));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        gridPanel.add(createMenuCard("Add New Book", Color.decode("#3498db"), () -> {
            new RegistrationBook().setVisible(true);
        }));
        gridPanel.add(createMenuCard("Show Books", Color.decode("#2ecc71"), () -> {
            new ViewBooks().setVisible(true);
        }));
        gridPanel.add(createMenuCard("Borrowed Books", Color.decode("#f1c40f"), () -> {
            new BorrowedBook().setVisible(true);
        }));
        gridPanel.add(createMenuCard("Return Books", Color.decode("#e67e22"), () -> {
            new ReturnBooks().setVisible(true);
        }));
        gridPanel.add(createMenuCard("Help & QA", Color.decode("#95a5a6"), () -> {
            new Help().setVisible(true);
        }));
        gridPanel.add(createMenuCard("Logout", Color.decode("#e74c3c"), () -> {
            app.showPage("Login");
        }));

        add(gridPanel, BorderLayout.CENTER);
    }

    private JButton createMenuCard(String title, Color color, Runnable action) {
        JButton button = new JButton(title);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.addActionListener(e -> action.run());
        return button;
    }
}