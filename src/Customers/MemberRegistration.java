/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Customers;

public class MemberRegistration extends javax.swing.JFrame {

    private String isMember;


    public MemberRegistration() {
        initComponents();
        this.setVisible(true);
        this.setLocation(320,150);
        this.setSize(385, 475);
        this.setResizable(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PhoneField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        maleRadio = new javax.swing.JRadioButton();
        femaleRadio = new javax.swing.JRadioButton();
        confirmBtn = new javax.swing.JButton();
        confirmBtn2 = new javax.swing.JButton();
        finalConfirm = new javax.swing.JCheckBox();
        phoneWarning = new javax.swing.JLabel();
        checkWarning = new javax.swing.JLabel();
        genderWarning = new javax.swing.JLabel();
        nameWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 240, 234));

        jPanel2.setBackground(new java.awt.Color(228, 212, 197));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("Cafe Member Registration");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(73, 73, 73))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );

        NameField.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("Member name");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel3.setText("Member phone");

        PhoneField.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        PhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel4.setText("Gender");

        maleRadio.setBackground(new java.awt.Color(248, 240, 234));
        buttonGroup1.add(maleRadio);
        maleRadio.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        maleRadio.setText("Male");
        maleRadio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        maleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioActionPerformed(evt);
            }
        });

        femaleRadio.setBackground(new java.awt.Color(248, 240, 234));
        buttonGroup1.add(femaleRadio);
        femaleRadio.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        femaleRadio.setText("Female");
        femaleRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioActionPerformed(evt);
            }
        });

        confirmBtn.setBackground(new java.awt.Color(195, 180, 165));
        confirmBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        confirmBtn.setText("Confirm");
        confirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmBtnMouseClicked(evt);
            }
        });

        confirmBtn2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        confirmBtn2.setText("Cancel");
        confirmBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmBtn2MouseClicked(evt);
            }
        });

        finalConfirm.setBackground(new java.awt.Color(248, 240, 234));
        finalConfirm.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        finalConfirm.setText("I am sure the data is correct");

        phoneWarning.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        phoneWarning.setForeground(new java.awt.Color(153, 0, 0));
        phoneWarning.setText(" ");

        checkWarning.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        checkWarning.setForeground(new java.awt.Color(153, 0, 0));
        checkWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        checkWarning.setText(" ");

        genderWarning.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        genderWarning.setForeground(new java.awt.Color(153, 0, 0));
        genderWarning.setText(" ");

        nameWarning.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nameWarning.setForeground(new java.awt.Color(153, 0, 0));
        nameWarning.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(confirmBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(phoneWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(checkWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(genderWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(maleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(femaleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(nameWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(finalConfirm)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(nameWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(phoneWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maleRadio)
                    .addComponent(femaleRadio))
                .addGap(2, 2, 2)
                .addComponent(genderWarning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalConfirm)
                .addGap(2, 2, 2)
                .addComponent(checkWarning)
                .addGap(18, 18, 18)
                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmBtn2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void PhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneFieldActionPerformed

    private void maleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleRadioActionPerformed

    private void femaleRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleRadioActionPerformed

    private void confirmBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtn2MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_confirmBtn2MouseClicked

    private void confirmBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnMouseClicked
        // TODO add your handling code here:
        String name = NameField.getText();
        String phone = PhoneField.getText();
        
        if(name.isEmpty()){
            nameWarning.setText("Please fill member name");
        }
        else{
            nameWarning.setText("");
        }
        if(phone.isEmpty()){
            phoneWarning.setText("Plese fill member phone");
        }
        else{
            phoneWarning.setText("");
        }
        if(!maleRadio.isSelected() && !femaleRadio.isSelected()){
            genderWarning.setText("Please fill in gender");
        }
        else{
            genderWarning.setText("");
        }
        
        try {
            Integer.parseInt(phone.strip());
        } catch (Exception e) {
            phoneWarning.setText("Phone number Invalid !");
            return;
        }
        
        Customers customers = new Customers();
        for(int i = 0; i < customers.ids.size(); i++) {
            if(customers.phone_numbers.get(i).equalsIgnoreCase(phone)) {
                phoneWarning.setText("Phone number already exist!");
                return;
            }
        }
        
        String gender = "female";
        if(maleRadio.isSelected()) {
            gender = "male";
        }
        
        
        isMember="1";

        boolean confirmation = finalConfirm.isSelected();
        
        if(confirmation) {
            customers.InsertData(name, gender, phone, isMember);
            this.dispose();
        }
        else{
            checkWarning.setText("check the checkbox if the data is correct!");
        }
    }//GEN-LAST:event_confirmBtnMouseClicked


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
            java.util.logging.Logger.getLogger(MemberRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NameField;
    private javax.swing.JTextField PhoneField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel checkWarning;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JButton confirmBtn2;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.JCheckBox finalConfirm;
    private javax.swing.JLabel genderWarning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton maleRadio;
    private javax.swing.JLabel nameWarning;
    private javax.swing.JLabel phoneWarning;
    // End of variables declaration//GEN-END:variables
}
