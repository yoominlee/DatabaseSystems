import javax.swing.*;
// import java.awt.*;


public class Login extends JFrame {
    public Login(){
        setTitle("Login Page");
        setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(450,200,200,25);
        usernameField.setBorder(BorderFactory.createLineBorder(null));
        panel.add(usernameField);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(450,250,200,25);
        usernameField.setBorder(BorderFactory.createLineBorder(null));
        panel.add(passwordField);


        JLabel usernameLable = new JLabel("Username:");
        usernameLable.setBounds(350,200,100,25);
        panel.add(usernameLable);

        JLabel passwordLable = new JLabel("Password:");
        passwordLable.setBounds(350,250,100,25);
        panel.add(passwordLable);
        
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(400, 300, 100, 30);
        panel.add(loginButton);

        JButton joinButton = new JButton("Join");
        joinButton.setBounds(550, 300, 100, 30);
        panel.add(joinButton);

    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(()->{
            Login frame = new Login();
            frame.setVisible(true);
        });
    }
}
        