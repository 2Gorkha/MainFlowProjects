package task3;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {
    JButton btnSignUp,btnBack;
    JTextField txtUsername,txtPassword,txtName,txtAns;
    Choice SecurityQuestion;


    SignUp(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(133,193,233));
        panel.setBounds(0,0,500,400);
        panel.setLayout(null);
        add(panel);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(50,20,125,25);
        panel.add(lblNewLabel);

        txtUsername = new JTextField();
        txtUsername.setBounds(190,20,180,20);
        txtUsername.setBorder(BorderFactory.createEmptyBorder());
        panel.add(txtUsername);

        JLabel lblNewLabel1 = new JLabel("Name");
        lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel1.setForeground(Color.WHITE);
        lblNewLabel1.setBounds(50,60,125,25);
        panel.add(lblNewLabel1);

        txtName = new JTextField();
        txtName.setBounds(190,60,180,20);
        txtName.setBorder(BorderFactory.createEmptyBorder());
        panel.add(txtName);

        JLabel lblNewLabel2 = new JLabel("Password");
        lblNewLabel2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel2.setForeground(Color.WHITE);
        lblNewLabel2.setBounds(50,100,125,25);
        panel.add( lblNewLabel2);

        txtPassword = new JTextField();
        txtPassword.setBounds(190,100,180,20);
        txtPassword.setBorder(BorderFactory.createEmptyBorder());
        panel.add( txtPassword);

        JLabel lblSecurity2 = new JLabel("Security Question");
        lblSecurity2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblSecurity2.setForeground(Color.WHITE);
        lblSecurity2.setBounds(50,140,125,25);
        panel.add( lblSecurity2);

        SecurityQuestion = new Choice();
        SecurityQuestion.add("Select");
        SecurityQuestion.add("Which School did you Attend");
        SecurityQuestion.add("What is your Nickname");
        SecurityQuestion.add("What is Percentage in 10th");
        SecurityQuestion.setBounds(190,140,180,25);
        panel.add(SecurityQuestion);

        JLabel AnsSecurity = new JLabel("Answer");
        AnsSecurity.setFont(new Font("Times New Roman", Font.BOLD, 14));
        AnsSecurity.setForeground(Color.WHITE);
        AnsSecurity.setBounds(50,180,125,25);
        panel.add( AnsSecurity);

        txtAns = new JTextField();
        txtAns.setBounds(190,180,180,20);
        txtAns.setBorder(BorderFactory.createEmptyBorder());
        panel.add(txtAns);

        btnSignUp = new JButton("Register");
        btnSignUp.setBackground(Color.WHITE);
        btnSignUp.setForeground(new Color(133,193,233));
        btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnSignUp.setBounds(80,250,100,30);
        btnSignUp.addActionListener(this);
        panel.add(btnSignUp);

        btnBack = new JButton("Back");
        btnBack.setBackground(Color.WHITE);
        btnBack.setForeground(new Color(133,193,233));
        btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnBack.setBounds(250,250,100,30);
        btnBack.addActionListener(this);
        panel.add(btnBack);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image image2 = image.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel lblNewLabel3 = new JLabel(image3);
        lblNewLabel3.setBounds(580,50,250,250);
        add(lblNewLabel3);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSignUp) {
            String username = txtUsername.getText();
            String name = txtName.getText();
            String password = txtPassword.getText();
            String securityQuestion = SecurityQuestion.getSelectedItem();
            String ans = txtAns.getText();
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+securityQuestion+"','"+ans+"')";
            try{
                Connection1 con = new Connection1();
                con.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Registered Successfully");
                setVisible(false);
                new Login();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == btnBack){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}