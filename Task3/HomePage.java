import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class HomePage extends javax.swing.JFrame {

    public HomePage() {
        initComponents();
    }

    private void initComponents() {

        JLabel jLabel1 = new JLabel();
        JButton viewProfileButton = new JButton();
        JButton settingsButton = new JButton();
        JButton logoutButton = new JButton();
        JLabel jLabel2 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new Font("Arial", Font.BOLD, 20));
        jLabel1.setText("Welcome to Home Page");

        // Adjust button sizes
        Dimension buttonSize = new Dimension(120, 30);
        viewProfileButton.setPreferredSize(buttonSize);
        settingsButton.setPreferredSize(buttonSize);
        logoutButton.setPreferredSize(buttonSize);

        viewProfileButton.setBackground(new Color(102, 255, 255));
        viewProfileButton.setForeground(Color.BLACK);
        viewProfileButton.setText("View Profile");
        viewProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewProfileButtonActionPerformed(evt);
            }
        });

        settingsButton.setBackground(new Color(102, 255, 255));
        settingsButton.setForeground(Color.BLACK);
        settingsButton.setText("Settings");
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new Color(102, 255, 255));
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Hello User !!!");

        // Layout Configuration
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true); // Adds gaps between components
        layout.setAutoCreateContainerGaps(true); // Adds gaps between components and window edges

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(viewProfileButton)
                                .addGap(20) // Space between buttons
                                .addComponent(settingsButton)
                                .addGap(20) // Space between buttons
                                .addComponent(logoutButton)
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(20)
                        .addComponent(jLabel2)
                        .addGap(50)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(viewProfileButton)
                                .addComponent(settingsButton)
                                .addComponent(logoutButton)
                        )
        );

        pack();
        setLocationRelativeTo(null); // Centers the window
    }

    private void viewProfileButtonActionPerformed(ActionEvent evt) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mainflow", "root", "Rahul@130");
            String sql = "SELECT name, email, phone FROM users WHERE user_id IN (?,?)";


            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, 1);
            pst.setInt(2, 2);// Fetch user with ID 1


            ResultSet rs = pst.executeQuery();

            StringBuilder userInfo = new StringBuilder("User Profile(s):\n\n");
            boolean hasData = false; // To check if data exists

            while (rs.next()) {
                hasData = true; // At least one record exists
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                userInfo.append("Name: ").append(name)
                        .append("\nEmail: ").append(email)
                        .append("\nPhone: ").append(phone)
                        .append("\n-----------------\n");
            }

            if (hasData) {
                JOptionPane.showMessageDialog(this, userInfo.toString(), "Profile Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No records found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching profile!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void logoutButtonActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Logging out...");
        System.exit(0);
    }
    private void settingsButtonActionPerformed(ActionEvent evt) {
        String userIdInput = JOptionPane.showInputDialog(this, "Enter your User ID:", "Settings", JOptionPane.QUESTION_MESSAGE);

        if (userIdInput == null || userIdInput.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "User ID is required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int userId;
        try {
            userId = Integer.parseInt(userIdInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid User ID!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String newEmail = JOptionPane.showInputDialog(this, "Enter new email:", "Update Email", JOptionPane.QUESTION_MESSAGE);
        String newPhone = JOptionPane.showInputDialog(this, "Enter new phone number:", "Update Phone", JOptionPane.QUESTION_MESSAGE);

        if ((newEmail == null || newEmail.trim().isEmpty()) && (newPhone == null || newPhone.trim().isEmpty())) {
            JOptionPane.showMessageDialog(this, "No changes made!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mainflow", "root", "Rahul@130");

            String sql = "UPDATE users SET email = COALESCE(?, email), phone = COALESCE(?, phone) WHERE user_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            if (newEmail == null || newEmail.trim().isEmpty()) {
                pst.setNull(1, java.sql.Types.VARCHAR);
            } else {
                pst.setString(1, newEmail);
            }

            if (newPhone == null || newPhone.trim().isEmpty()) {
                pst.setNull(2, java.sql.Types.VARCHAR);
            } else {
                pst.setString(2, newPhone);
            }

            pst.setInt(3, userId);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "User ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating profile!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new HomePage().setVisible(true));
    }
}
