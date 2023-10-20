// import javax.swing.*;
// // import java.awt.*;

// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.geom.Ellipse2D;

// public class EventDetail extends JFrame {
//     public String eventName = "Yoomin's Birthday";
//     public String userName = "Yoomin";
//     public String timedata = "2023-01-04";
//     public String discripiton = "00th birthday at fdfjdsfjdkslfjkslfjfkdfjdksjffjsdjff fdkfjdfjdkfjdkfjd";

//     public EventDetail(){
//         setTitle("EventDetail Page");
//         setSize(840,450);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         JPanel panel = new JPanel();
//         panel.setLayout(null);
//         add(panel);

//         // CircularButton circularButton = new CircularButton(userName);
//         // add(circularButton);



//         JButton event = new JButton(eventName);
//         event.setBounds(100, 40, 400, 30);
//         panel.add(event);


//         JLabel usernameLable = new JLabel("Username: "+userName);
//         usernameLable.setBounds(100,80,200,25);
//         panel.add(usernameLable);

//         JLabel timeLable = new JLabel("Time: "+timedata);
//         timeLable.setBounds(100,100,200,25);
//         panel.add(timeLable);


//         JLabel discripitonLable = new JLabel(discripiton);
//         discripitonLable.setBounds(100,120,170,100);
//         panel.add(discripitonLable);


//         JTextField additionalDiscription = new JTextField();
//         additionalDiscription.setBounds(100,210,300,50);
//         additionalDiscription.setBorder(BorderFactory.createLineBorder(null));
//         panel.add(additionalDiscription);

//         JButton addDiscription = new JButton("Add discription");
//         addDiscription.setBounds(200, 300, 100, 30);
//         panel.add(addDiscription);




























//     }

//     // static class CircularButton extends JButton{
//     //     public CircularButton(String label) {
//     //         super(label);
//     //         setContentAreaFilled(false); // Make the button transparent
//     //         // setFocusPainted(false); // Remove focus indicator
//     //         setBorderPainted(false); // Remove border
    
//     //         // Set a custom shape for the button
//     //         Dimension size = getPreferredSize();
//     //         size.width = size.height = 20;//Math.max(size.width, size.height);
//     //         setPreferredSize(size);
    
//     //         // Add an action listener for the button
//     //         addActionListener(new ActionListener() {
//     //             @Override
//     //             public void actionPerformed(ActionEvent e) {
//     //                 // Button action here
//     //                 System.out.println("Button clicked!");
//     //             }
//     //         });
//     //     }
    
//     //     @Override
//     //     protected void paintComponent(Graphics g) {
//     //         if (getModel().isArmed()) {
//     //             g.setColor(getBackground());
//     //         } else {
//     //             g.setColor(Color.lightGray);
//     //         }
    
//     //         // Draw a circular shape
//     //         Graphics2D g2 = (Graphics2D) g;
//     //         g2.fill(new Ellipse2D.Double(0, 0, getSize().width - 1, getSize().height - 1));
    
//     //         super.paintComponent(g);
//     //     }
//     // }
//     public static void main(String[] args) {
//         javax.swing.SwingUtilities.invokeLater(()->{
//             EventDetail frame = new EventDetail();
//             frame.setVisible(true);
//         });
//     }
// }
        