import javax.swing.*;
import java.awt.*;

public class UserEventPage extends JFrame {

    public UserEventPage() {
        setTitle("User's Event Page");
        setPreferredSize(new Dimension(1000, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main panel to hold events
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Example events
        for (int i = 0; i < 5; i++) {
            // Event panel
            JPanel eventPanel = new JPanel();
            eventPanel.setLayout(new BorderLayout());

            // Date and month on the left side of the event
            JLabel dateLabel = new JLabel("2023-01-0" + (i+1));
            eventPanel.add(dateLabel, BorderLayout.WEST);

            // Event details on the right side of the event
            JButton titleButton = new JButton("Event " + (i+1));

            String descriptionText;

            if(i % 2 == 0) { 
                descriptionText= "This is a private event";
            } else {
                descriptionText= "This is an open event";
            }

            JTextArea descriptionArea = new JTextArea(descriptionText);

            descriptionArea.setEditable(false); 

            JLabel timeLabel = new JLabel("Time: " + ((i+1)*2) + ":00 PM");

            JPanel titleAndTimePanel = new JPanel();
            titleAndTimePanel.setLayout(new FlowLayout());
            titleAndTimePanel.add(titleButton);
            titleAndTimePanel.add(timeLabel);

            JPanel detailsPanel = new JPanel();
            detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
            detailsPanel.add(titleAndTimePanel);
            detailsPanel.add(descriptionArea);

            eventPanel.add(detailsPanel, BorderLayout.CENTER);

            mainPanel.add(eventPanel);
        }
        add(mainPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserEventPage userEventPage = new UserEventPage();
        });
    }
}