/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Login;


import AdminDB.DashboardPage;
import java.sql.Connection;
import cafemanagement.BuiltSystem;
import cafemanagement.CafeManagement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import staff.Dashboard;


public class LoginPage extends javax.swing.JFrame {
    Connection connection;
 
    public LoginPage() {
        CreateConnection();
        initComponents();
        this.setVisible(true);
        this.setLocation(50,50);
        this.setSize(681,420);
        this.setResizable(false);
        
    }
    
    void CreateConnection(){
        String url ="jdbc:mysql://localhost:3306/journey";
        String username ="root";
        String password="4321";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(BuiltSystem.getCurrentTime() + " Connection Success"); 
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CafeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameCafeLabel = new javax.swing.JLabel();
        latarPanel1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        loginLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        LoginButton1 = new javax.swing.JButton();
        invalidLoginLabel = new javax.swing.JLabel();
        iconLogin = new javax.swing.JLabel();
        logoLogin = new javax.swing.JLabel();

        NameCafeLabel.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        NameCafeLabel.setText("Journey Cafe");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        latarPanel1.setBackground(new java.awt.Color(209, 201, 192));
        latarPanel1.setForeground(new java.awt.Color(102, 0, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        loginLabel.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("Journey Cafe");

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(102, 102, 102));
        usernameLabel.setText("Username");

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("OCR A Extended", 0, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(102, 102, 102));
        passwordLabel.setText("Password ");

        LoginButton.setBackground(new java.awt.Color(167, 143, 125));
        LoginButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        LoginButton.setText("Login");
        LoginButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtonMouseClicked(evt);
            }
        });

        LoginButton1.setBackground(new java.awt.Color(204, 204, 204));
        LoginButton1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        LoginButton1.setText("Exit");
        LoginButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        LoginButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButton1MouseClicked(evt);
            }
        });

        invalidLoginLabel.setForeground(new java.awt.Color(204, 0, 0));
        invalidLoginLabel.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(LoginButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(usernameLabel)
                            .addGap(170, 170, 170)))
                    .addComponent(passwordLabel))
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invalidLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(loginLabel)
                .addGap(27, 27, 27)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalidLoginLabel)
                .addGap(22, 22, 22)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        iconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/journey-cafe.png"))); // NOI18N
        iconLogin.setText("jLabel1");

        logoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/journey-logo-ic-removebg.png"))); // NOI18N
        logoLogin.setText("jLabel1");
        logoLogin.setMaximumSize(new java.awt.Dimension(50, 50));
        logoLogin.setMinimumSize(new java.awt.Dimension(50, 50));
        logoLogin.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout latarPanel1Layout = new javax.swing.GroupLayout(latarPanel1);
        latarPanel1.setLayout(latarPanel1Layout);
        latarPanel1Layout.setHorizontalGroup(
            latarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(latarPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(351, 351, 351))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, latarPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(logoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        latarPanel1Layout.setVerticalGroup(
            latarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, latarPanel1Layout.createSequentialGroup()
                .addGroup(latarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(latarPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(logoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconLogin, 0, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(435, 435, 435))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(latarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(latarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void LoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseClicked
        // TODO add your handling code here:
        String username=usernameField.getText();
        String password=passwordField.getText();
        String role = CheckPasswordByDB(username, password);
        if(role.equals("admin")){
            System.out.println("IN role admin");
            new DashboardPage();
//            AdminDashboard.Start();

            this.dispose();
        }
        else if(role.equals("staff")){
            new Dashboard();
            this.dispose();
        }
        else{
            invalidLoginLabel.setText("invalid username or password!!");
        }
    }//GEN-LAST:event_LoginButtonMouseClicked

    private void LoginButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButton1MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_LoginButton1MouseClicked


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }
    
    public String CheckPasswordByDB(String username, String password){
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM administrator");
            while(result.next()) {
                String dbName = result.getString("username");
                String dbPass = result.getString("password");
                String dbRole = result.getString("role");
                if(username.equals(dbName) && password.equals(dbPass)) {
                    return dbRole;
                }
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "0";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton LoginButton1;
    private javax.swing.JLabel NameCafeLabel;
    private javax.swing.JLabel iconLogin;
    private javax.swing.JLabel invalidLoginLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel latarPanel1;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel logoLogin;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
