import java.awt.*;
import javax.swing.*;

public class BorrowedBook extends JFrame {
    public BorrowedBook() {
        setTitle("Borrow a Book");
        setSize(300, 200);
        setLayout(new FlowLayout());

        JTextField txtIsbn = new JTextField(15);
        JButton btnBorrow = new JButton("Confirm Borrow");

        btnBorrow.addActionListener(e -> {
            DataStore.borrowedRecords.add("Borrowed ISBN: " + txtIsbn.getText());
            JOptionPane.showMessageDialog(this, "Book Borrowed Successfully!");
        });

        add(new JLabel("Enter ISBN to Borrow:"));
        add(txtIsbn);
        add(btnBorrow);
        setLocationRelativeTo(null);
    }
}