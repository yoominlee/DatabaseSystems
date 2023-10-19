import javax.swing.*;
// import java.awt.*;


public class Login extends JFrame {
    public Login(){
        setTitle("Login Page");
        setSize(840,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(300,100,200,25);
        usernameField.setBorder(BorderFactory.createLineBorder(null));
        panel.add(usernameField);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(300,150,200,25);
        usernameField.setBorder(BorderFactory.createLineBorder(null));
        panel.add(passwordField);


        JLabel usernameLable = new JLabel("Username:");
        usernameLable.setBounds(200,100,100,25);
        panel.add(usernameLable);

        JLabel passwordLable = new JLabel("Password:");
        passwordLable.setBounds(200,150,100,25);
        panel.add(passwordLable);
        
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(250, 200, 100, 30);
        panel.add(loginButton);

        JButton joinButton = new JButton("Join");
        joinButton.setBounds(400, 200, 100, 30);
        panel.add(joinButton);

    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(()->{
            Login frame = new Login();
            frame.setVisible(true);
        });
    }
}
        