import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventDetailPage extends JFrame {
    private JLabel eventNameLabel;
    private JLabel usernameLabel;
    private JLabel timeLabel;
    private JTextArea descriptionTextArea;
    private JTextField additionalDescriptionTextField;

    public String eventName = "Yoomin's Birthday";
    public String userName = "Yoomin";
    public String timedata = "2023-01-04";
    public String discripiton = "00th birthday at fdfjdsfjdkslfjkslfjfkdfjdksjffjsdjff fdkfjdfjdkfjdkfjd";



    public EventDetailPage() {
        setTitle("Event Detail Page");
        setPreferredSize(new Dimension(840, 450)); // Set preferred size of content pane        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        
        // Add top margin to main panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        // Event Name
        eventNameLabel = new JLabel(eventName);
        eventNameLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        mainPanel.add(eventNameLabel);

        // Username
        usernameLabel = new JLabel("Username: "+userName);
        usernameLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Left-align username label
        mainPanel.add(usernameLabel);

        // Time
        timeLabel = new JLabel("Time: "+timedata);
        timeLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Left-align time label
        mainPanel.add(timeLabel);

        // Description
        descriptionTextArea = new JTextArea("Description of the event", 10, 20);
        descriptionTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
        mainPanel.add(scrollPane);
        // JLabel discripitonLable = new JLabel(discripiton);
        // discripitonLable.setBounds(100,120,170,100);
        // mainPanel.add(discripitonLable);


        // Additional Description TextField
        additionalDescriptionTextField = new JTextField(7);
        mainPanel.add(additionalDescriptionTextField);

        // Add Description Button
        JButton addDescriptionButton = new JButton("Add Description");
        addDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String additionalDescription = additionalDescriptionTextField.getText();
                descriptionTextArea.append("\n" + additionalDescription);
                additionalDescriptionTextField.setText("");
            }
        });
        mainPanel.add(addDescriptionButton);

        // Go to Monthly Page Button and Go to Daily Page Button
        JPanel buttonPanel = new JPanel();
        JButton monthlyPageButton = new JButton("Go to Monthly Page");
        JButton dailyPageButton = new JButton("Go to Daily Page");

        buttonPanel.add(monthlyPageButton);
        buttonPanel.add(dailyPageButton);

        monthlyPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(EventDetailPage.this, "Redirecting to Monthly Page...");
            }
        });

        dailyPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(EventDetailPage.this, "Redirecting to Daily Page...");
            }
        });

        mainPanel.add(buttonPanel);
        add(mainPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EventDetailPage eventDetailPage = new EventDetailPage();
        });
    }
}
