/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Customers;

import java.awt.Window;

public class CustomerDeleteConfirm extends javax.swing.JFrame {

    String deletedItem;
    
    public CustomerDeleteConfirm(String deletedName, String deletedID, String isMember) {
        initComponents();
        this.setVisible(true);
        this.setLocation(420,200);
        this.setSize(430,210);
        this.setResizable(false);
        
        this.deletedItem = deletedID;
        
        if(isMember.strip().equalsIgnoreCase("0")) {
            System.out.println("Attempting delete non member");
            deleteLabel.setText("You`re not allowed to delete non member!");
            yesBtn.setVisible(false);
        } else {
            deleteLabel.setText("Are you sure want to delete \"" + deletedName +"  \" ?");
        }
    }
    
    public CustomerDeleteConfirm(){
         initComponents();
        this.setVisible(true);
        this.setLocation(420,210);
        this.setSize(430,200);
        this.setResizable(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        deleteLabel = new javax.swing.JLabel();
        yesBtn = new javax.swing.JButton();
        NoBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 240, 234));

        deleteLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        deleteLabel.setText("Are you sure want to delete \"\" ?");

        yesBtn.setBackground(new java.awt.Color(0, 0, 0));
        yesBtn.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        yesBtn.setForeground(new java.awt.Color(255, 255, 255));
        yesBtn.setText("Yes");
        yesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yesBtnMouseClicked(evt);
            }
        });

        NoBtn.setBackground(new java.awt.Color(0, 0, 0));
        NoBtn.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        NoBtn.setForeground(new java.awt.Color(255, 255, 255));
        NoBtn.setText("No");
        NoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(yesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(NoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(deleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(deleteLabel)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoBtnMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_NoBtnMouseClicked

    private void yesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yesBtnMouseClicked
        // TODO add your handling code here:
        Customers customers = new Customers();
        customers.DeleteData(deletedItem);
        this.dispose();
        
        new CustomerPage();
        String specificWindowName = new CustomerPage().getName();

        for (Window window : Window.getWindows()) {
            if (window.isVisible() && !specificWindowName.equals(window.getName())) {
                window.dispose(); 
            }
        }
        
    }//GEN-LAST:event_yesBtnMouseClicked


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerDeleteConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerDeleteConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerDeleteConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerDeleteConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerDeleteConfirm();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NoBtn;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton yesBtn;
    // End of variables declaration//GEN-END:variables
}
