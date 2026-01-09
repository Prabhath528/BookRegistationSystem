import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainContainer = new JPanel(cardLayout);

    public MainApp() {
        setTitle("Library Management System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 1. Loading Screen (Simple Splash)
        showLoadingScreen();

        // 2. Add Pages to Container
        mainContainer.add(new AuthPage(this), "Login");
        mainContainer.add(new Dashboard(this), "Dashboard");

        add(mainContainer);
    }

    private void showLoadingScreen() {
        JWindow splash = new JWindow();
        JPanel content = new JPanel(new BorderLayout());
        content.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        JLabel label = new JLabel("Loading System...", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        JProgressBar pb = new JProgressBar();
        pb.setIndeterminate(true);

        content.add(label, BorderLayout.CENTER);
        content.add(pb, BorderLayout.SOUTH);
        splash.add(content);
        splash.setSize(400, 200);
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);

        // Simulate loading for 3 seconds
        new Timer(3000, e -> {
            splash.dispose();
            this.setVisible(true);
        }).start();
    }

    public void showPage(String name) {
        cardLayout.show(mainContainer, name);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp());
    }
}