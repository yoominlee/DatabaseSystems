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

// import javax.swing.*;
// import java.awt.*;

// public class UserEventPage extends JFrame {

//     public UserEventPage() {
//         setTitle("User's Event Page");
//         setPreferredSize(new Dimension(840, 450));
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         // Main panel to hold events
//         JPanel mainPanel = new JPanel();
//         mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

//         // Example events
//         for (int i = 0; i < 5; i++) {
//             // Event panel
//             JPanel eventPanel = new JPanel();
//             eventPanel.setLayout(new BorderLayout());
//             eventPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

//             // Date and month on the left side of the event
//             JLabel dateLabel = new JLabel("2023-01-0" + (i + 1));

//             // Add some margin next to date label
//             dateLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

//             eventPanel.add(dateLabel, BorderLayout.WEST);

//             // Event details on the right side of the event
//             JButton titleButton = new JButton("Event " + (i + 1));

//             JLabel timeLabel = new JLabel("Time: " + ((i + 1) * 2) + ":00 PM");

//             JPanel titleAndTimePanel = new JPanel();
//             titleAndTimePanel.setLayout(new FlowLayout());
//             titleAndTimePanel.add(titleButton);
//             titleAndTimePanel.add(timeLabel);

//             // JTextArea descriptionArea = new JTextArea("This is an open event");
//             JTextArea descriptionArea = new JTextArea("descriptionText");

//             descriptionArea.setEditable(false);

//             JButton privateMarkButton;

//             if (i % 2 == 0) {
//                 privateMarkButton = new JButton("Private");
//                 privateMarkButton.setPreferredSize(new Dimension(70, 20)); // Set preferred size for button
//                 privateMarkButton.setEnabled(false); // Disable button interaction
//             } else {
//                 privateMarkButton = null;
//             }

//             JPanel detailsWithPrivateMarkPane = new JPanel();
//             detailsWithPrivateMarkPane.setLayout(new BorderLayout());
//             if (privateMarkButton != null) {
//                 detailsWithPrivateMarkPane.add(privateMarkButton, BorderLayout.NORTH); // Place button at top part of
//                                                                                        // pane
//             }

//             detailsWithPrivateMarkPane.add(descriptionArea, BorderLayout.CENTER);

//             descriptionArea.setEditable(false);

//             JPanel detailsPanel = new JPanel();
//             detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
//             detailsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Add margin to the panel
//             detailsPanel.add(titleAndTimePanel);
//             detailsPanel.add(detailsWithPrivateMarkPane);

//             detailsPanel.add(detailsPanel, BorderLayout.CENTER);

//             mainPanel.add(eventPanel);
//         }

//         add(mainPanel, BorderLayout.CENTER);

//         pack();
//         setVisible(true);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             UserEventPage userEventPage = new UserEventPage();
//         });
//     }
// }