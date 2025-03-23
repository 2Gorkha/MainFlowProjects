package task3;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Login extends JFrame {
    public Login() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        // Left panel with image
        JPanel panel = new JPanel();
        panel.setBackground(new Color(131, 193, 233));
        panel.setBounds(0, 0, 400, 400);
        panel.setLayout(null);
        add(panel);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image image2 = image1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel label = new JLabel(image3);
        label.setBounds(100, 120, 200, 200);
        panel.add(label);

        // Right panel for login form
        JPanel panel_1 = new JPanel();

        panel_1.setBounds(400, 30, 450, 300);
        panel_1.setLayout(null); // Important for manual positioning
        add(panel_1);

        // Username Label
        JLabel label_1 = new JLabel("Username");
        label_1.setBounds(60, 20, 100, 25);
        label_1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        panel_1.add(label_1);

        // Username TextField
        JTextField textField = new JTextField();
        textField.setBounds(60, 60, 300, 30); // Corrected position & size
        textField.setBorder(BorderFactory.createEmptyBorder());
        panel_1.add(textField);

        JLabel label_2 = new JLabel("Password");
        label_2.setBounds(60, 100, 100, 25);
        label_2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        panel_1.add(label_2);

        // Password Field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(60, 140, 300, 30);
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        panel_1.add(passwordField);

        JButton button = new JButton("Login");
        button.setBounds(60,200,130,30);
        button.setBackground(new Color(131, 193, 233));
        button.setForeground(Color.WHITE);
        button.setBorder(new LineBorder(new Color(131, 193, 233)));
        panel_1.add(button);

        JButton button_1 = new JButton("Sign-Up");
        button_1.setBounds(200,200,130,30);
        button_1.setBackground(new Color(131, 193, 233));
        button_1.setForeground(Color.WHITE);
        button_1.setBorder(new LineBorder(new Color(131, 193, 233)));
        panel_1.add(button_1);


        setVisible(true);
    }

    public static void main(String[] args) {
        new Login(); // Anonymous object to run the frame
    }
}
