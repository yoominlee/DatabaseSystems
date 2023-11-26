import javax.swing.*;
import java.awt.*;

public class RsvpPage extends JFrame {

    public RsvpPage() {
        setTitle("RSVP Page");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Grid layout with 2 columns and gaps

        // Add title at the top
        JLabel titleLabel = new JLabel("Inviting Request", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

         // Sample data. Replace with your actual list of events.
         for (int i = 1; i <= 5; i++) {
             JPanel eventPanel = new JPanel(new BorderLayout());
             eventPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); // add margin

             if (i % 2 == 0) {
                eventPanel.setBackground(Color.LIGHT_GRAY); 
            } else {
                eventPanel.setBackground(Color.WHITE); 
            }

             JLabel userNameLabel = new JLabel("User " + i);
             eventPanel.add(userNameLabel,BorderLayout.WEST);

             String dateTimeEventNameText = "<html>2023-01-0" + i + " / 10:00<br/>Event " + i + "</html>";
             JLabel dateTimeEventNameLabel = new JLabel(dateTimeEventNameText);
             eventPanel.add(dateTimeEventNameLabel,BorderLayout.EAST);

            JSeparator separator = new JSeparator(JSeparator.HORIZONTAL); 

            JPanel buttonPanel = new JPanel();
             
              JButton acceptButton = new JButton("Accept");
              acceptButton.addActionListener(e -> {
                   // Add your action code here
               });
               buttonPanel.add(acceptButton);

               JButton declineButton = new JButton("Decline");
               declineButton.addActionListener(e -> {
                   // Add your action code here
               });
               buttonPanel.add(declineButton);

              eventPanel.add(buttonPanel,BorderLayout.SOUTH); 
              mainPanel.add(eventPanel); 
          }

          getContentPane().add(titleLabel,BorderLayout.NORTH); 
          getContentPane().add(mainPanel,BorderLayout.CENTER); 

          setVisible(true);
      }

      public static void main(String[] args) {
           SwingUtilities.invokeLater(() -> new RsvpPage());
      }
}
