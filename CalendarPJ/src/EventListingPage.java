import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.table.TableCellEditor;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class EventListingPage extends JFrame {
    private JTable eventTable;

    public EventListingPage() {
        setTitle("Event Listing Page");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Column names
        Vector<String> columnNames = new Vector<>();
        columnNames.add("User Name");
        columnNames.add("Event Name");
        columnNames.add("Date");
        columnNames.add("Start Time");
        columnNames.add("End Time");

        // Add two columns for Modify and Cancel buttons
        columnNames.add("");
        columnNames.add("");

        // Sample data. Replace with your actual list of events.
        Vector<Vector<Object>> data = new Vector<>();
        for (int i = 1; i <= 5; i++) {
            Vector<Object> row = new Vector<>();
            row.add("User " + i);
            row.add("Event " + i);
            row.add(String.format("%d-%02d-%02d", 2023, i, i));
            row.add(String.format("%02d:00", i));
            row.add(String.format("%02d:30", i));

            // Add placeholders for Modify and Cancel buttons
            row.add("Modify");
            row.add("Cancel");

            data.add(row);
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return col >= 5; // Only the last two columns are editable (for the buttons)
            }
        };

        eventTable = new JTable(model);

        // Set custom renderer and editor for the last two columns
        ButtonColumn modifyButtonColumn = new ButtonColumn(eventTable, 5);
        ButtonColumn cancelButtonColumn = new ButtonColumn(eventTable, 6);

        JScrollPane scrollPane = new JScrollPane(eventTable);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EventListingPage());
    }
}

class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

    private JButton renderButton;
    private JButton editButton;
    private String text;

    public ButtonColumn(JTable table, int columnIndex) {
        super();
        this.renderButton = new JButton();
        this.editButton = new JButton();

        this.editButton.addActionListener((ActionEvent e) -> stopCellEditing());

        TableColumn tableColumn = table.getColumnModel().getColumn(columnIndex);
        tableColumn.setCellRenderer(this);
        tableColumn.setCellEditor(this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        if (hasFocus) {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        } else if (isSelected) {
            renderButton.setForeground(table.getSelectionForeground());
            renderButton.setBackground(table.getSelectionBackground());
        } else {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }

        renderButton.setText((value == null) ? "" : value.toString());

        return renderButton;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected,
            int row,
            int column) {

        text = (value == null) ? "" : value.toString();
        editButton.setText(text);

        return editButton;
    }

    @Override
    public Object getCellEditorValue() {
        JOptionPane.showMessageDialog(null, text + " button clicked");
        return text;
    }
}
