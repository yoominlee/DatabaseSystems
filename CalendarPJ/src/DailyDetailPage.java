import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class DailyDetailPage extends JFrame {

    public DailyDetailPage() {
        setTitle("Daily Detail Page");
        setSize(840, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a panel to hold the daily details
        JPanel dailyDetailsPanel = new JPanel();
        dailyDetailsPanel.setLayout(new BoxLayout(dailyDetailsPanel, BoxLayout.Y_AXIS));
        add(dailyDetailsPanel);

        // Date at the top
        JLabel dateLabel = new JLabel("2023-10-19"); // Replace with the actual date
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dailyDetailsPanel.add(dateLabel);

        // Create a list of user-event details
        List<UserEventDetail> userEventDetails = new ArrayList<>();
        userEventDetails.add(new UserEventDetail("Y", "15:00~17:00", "Meeting 1"));
        userEventDetails.add(new UserEventDetail("B", "10:30~12:00", "Presentation"));
        userEventDetails.add(new UserEventDetail("H", "14:00~15:30", "Lunch"));

        // Add user-event details to the panel
        for (UserEventDetail detail : userEventDetails) {
            dailyDetailsPanel.add(detail);
        }
    }

    // Custom component for user-event detail
    private class UserEventDetail extends JPanel {
        public UserEventDetail(String userInitial, String eventTime, String eventTitle) {
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            setAlignmentX(Component.LEFT_ALIGNMENT);

            // User initial inside a circle
            // JLabel userLabel = new JLabel(userInitial);
            // userLabel.setPreferredSize(new Dimension(30, 30));
            // userLabel.setHorizontalAlignment(JLabel.CENTER);
            // userLabel.setVerticalAlignment(JLabel.CENTER);
            // userLabel.setOpaque(true);
            // userLabel.setBackground(Color.BLUE); // Change color as needed
            // userLabel.setForeground(Color.WHITE);
            // userLabel.setFont(new Font("Arial", Font.BOLD, 16));
            // add(userLabel);

            // CIRCLE TEST
            CircularButton circularButton = new CircularButton(userInitial);
            add(circularButton);



            // Time of the event
            JLabel timeLabel = new JLabel(eventTime);
            add(timeLabel);

            // Title of the event
            JLabel titleLabel = new JLabel(eventTitle);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Adjust font size
            add(titleLabel);



        }
    }

    static class CircularButton extends JButton{
        public CircularButton(String label) {
            super(label);
            setContentAreaFilled(false); // Make the button transparent
            // setFocusPainted(false); // Remove focus indicator
            setBorderPainted(false); // Remove border
    
            // Set a custom shape for the button
            Dimension size = getPreferredSize();
            size.width = size.height = 20;//Math.max(size.width, size.height);
            setPreferredSize(size);
    
            // Add an action listener for the button
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Button action here
                    System.out.println("Button clicked!");
                }
            });
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isArmed()) {
                g.setColor(getBackground());
            } else {
                g.setColor(Color.lightGray);
            }
    
            // Draw a circular shape
            Graphics2D g2 = (Graphics2D) g;
            g2.fill(new Ellipse2D.Double(0, 0, getSize().width - 1, getSize().height - 1));
    
            super.paintComponent(g);
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            DailyDetailPage frame = new DailyDetailPage();
            frame.setVisible(true);
        });
    }
}




