import javax.swing.*;
import java.awt.*;

public class ReturnBooks extends JFrame {
    public ReturnBooks() {
        setTitle("Return a Book");
        setSize(400, 300);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // List of borrowed books
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String record : DataStore.borrowedRecords) {
            listModel.addElement(record);
        }

        JList<String> borrowedList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(borrowedList);

        JButton btnReturn = new JButton("Return Selected Book");
        btnReturn.addActionListener(e -> {
            int selectedIndex = borrowedList.getSelectedIndex();
            if (selectedIndex != -1) {
                String removed = DataStore.borrowedRecords.remove(selectedIndex);
                listModel.remove(selectedIndex);
                JOptionPane.showMessageDialog(this, "Book returned: " + removed);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a book to return!");
            }
        });

        mainPanel.add(new JLabel("Borrowed Books:"), BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(btnReturn, BorderLayout.SOUTH);

        add(mainPanel);
    }
}