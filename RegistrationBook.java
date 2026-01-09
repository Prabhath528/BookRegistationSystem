import java.awt.*;
import javax.swing.*;

public class RegistrationBook extends JFrame {
    private JTextField txtTitle = new JTextField();
    private JTextField txtAuthor = new JTextField();
    private JTextField txtIsbn = new JTextField();

    public RegistrationBook() {
        setTitle("Register New Book");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2, 10, 10));
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        add(new JLabel("Book Title:"));
        add(txtTitle);
        add(new JLabel("Author:"));
        add(txtAuthor);
        add(new JLabel("ISBN:"));
        add(txtIsbn);

        JButton saveBtn = new JButton("Save Book");
        saveBtn.addActionListener(e -> {
            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();
            String isbn = txtIsbn.getText().trim();

            if (!title.isEmpty() && !author.isEmpty() && !isbn.isEmpty()) {
                Book newBook = new Book(title, author, isbn);
                DataStore.allBooks.add(newBook);
                JOptionPane.showMessageDialog(this, "Book saved successfully!");
                txtTitle.setText("");
                txtAuthor.setText("");
                txtIsbn.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
            }
        });

        add(new JLabel("")); // Placeholder
        add(saveBtn);
    }
}