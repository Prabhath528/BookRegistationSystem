import java.awt.*;
import javax.swing.*;

public class Help extends JFrame {
    public Help() {
        setTitle("Help & QA");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        JTextArea helpText = new JTextArea();
        helpText.setEditable(false);
        helpText.setLineWrap(true);
        helpText.setWrapStyleWord(true);
        helpText.setMargin(new Insets(10, 10, 10, 10));
        helpText.setText(
            "1. Add New Book:\n" +
            "   - Click 'Add New Book' to register a new book in the system\n" +
            "   - Fill in Title, Author, and ISBN fields\n" +
            "   - Click 'Save Book' to add it to the library\n\n" +
            "2. Show Books:\n" +
            "   - View all registered books in the library\n" +
            "   - See details including Title, Author, and ISBN\n\n" +
            "3. Borrowed Books:\n" +
            "   - Enter the ISBN of a book you want to borrow\n" +
            "   - Click 'Confirm Borrow' to record the transaction\n\n" +
            "4. Return Books:\n" +
            "   - View your borrowed books\n" +
            "   - Select a book and click 'Return Selected Book'\n\n" +
            "5. Logout:\n" +
            "   - Click 'Logout' to return to the login screen\n\n" +
            "For additional support, contact your system administrator."
        );

        JScrollPane scrollPane = new JScrollPane(helpText);
        add(scrollPane, BorderLayout.CENTER);

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeBtn);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}