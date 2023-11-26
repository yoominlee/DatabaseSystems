import javax.swing.*;
import java.awt.*;

public class EventReminderPage extends JFrame {

    public EventReminderPage() {
        setTitle("Event Reminder Page");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Grid layout with 2 columns and gaps

        // Add title at the top
        JLabel titleLabel = new JLabel("Event Reminders", SwingConstants.CENTER);
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

            JButton checkButton;
            if (i % 2 == 0) {
                checkButton = new JButton("30min left check");
            } else {
                checkButton = new JButton("15min left check");
            }
            
            checkButton.addActionListener(e -> {
                   // Add your action code here
               });
               
           String descriptionText = "<html>Description for Event " + i + "</html>";
           JLabel descriptionLabel = new JLabel(descriptionText);
           descriptionLabel.setFont(new Font("Arial", Font.PLAIN ,12));
           descriptionLabel.setBorder(BorderFactory.createEmptyBorder(5 ,5 ,5 ,5 )); 

           JPanel southPanel= new JPanel();
           southPanel.setLayout(new BoxLayout(southPanel ,BoxLayout.Y_AXIS));
           
           southPanel.setOpaque(false);   // make it transparent

           southPanel.add(descriptionLabel); 
           southPanel.add(checkButton); 

           
           eventPanel.add(southPanel,BorderLayout.SOUTH); 
             
          mainPanel.add(eventPanel); 
          }

          getContentPane().add(titleLabel, BorderLayout.NORTH); 
          getContentPane().add(mainPanel, BorderLayout.CENTER);

          setVisible(true);
      }

      public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> new EventReminderPage());
      }
}
