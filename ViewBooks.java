import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewBooks extends JFrame {
    public ViewBooks() {
        setTitle("All Registered Books");
        setSize(500, 300);
        DefaultTableModel model = new DefaultTableModel(new String[]{"Title", "Author", "ISBN"}, 0);
        
        for (Book b : DataStore.allBooks) {
            model.addRow(new Object[]{b.getTitle(), b.getAuthor(), b.getIsbn()});
        }

        add(new JScrollPane(new JTable(model)));
        setLocationRelativeTo(null);
    }
}