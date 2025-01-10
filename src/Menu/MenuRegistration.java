/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Menu;

import cafemanagement.BuiltSystem;
import cafemanagement.CafeManagement;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import java.sql.Connection;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class MenuRegistration extends javax.swing.JFrame {

    private String isMember;
    Connection connection;
    
    File f = null;
    String path = null;
    private ImageIcon format = null;
    String fname = null;
    int s =0;
    byte[] pimage = null;

    public MenuRegistration() {
        CreateConnection();
        initComponents();
        this.setVisible(true);
        this.setLocation(320,150);
        //655, 522
        
        this.setSize(660,522);
        this.setResizable(false);
    }

    
    PreparedStatement pst;
    ResultSet rs;
    void CreateConnection(){
        String url ="jdbc:mysql://localhost:3306/journey";
        String username ="root";
        String password="4321";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(BuiltSystem.getCurrentTime() + " Connection Success"); 
            
            // Menyiapkan statement SQL
            String query = "SELECT * FROM Menu";
            pst = connection.prepareStatement(query);

            // Mengeksekusi query
            rs = pst.executeQuery();
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CafeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    private void upImage(){
//
//    }
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
        jLabel4 = new javax.swing.JLabel();
        confirmBtn = new javax.swing.JButton();
        confirmBtn2 = new javax.swing.JButton();
        finalConfirm = new javax.swing.JCheckBox();
        phoneWarning = new javax.swing.JLabel();
        checkWarning = new javax.swing.JLabel();
        genderWarning = new javax.swing.JLabel();
        nameWarning = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        priceField = new javax.swing.JTextField();
        BrowseBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        containerImg = new javax.swing.JLabel();
        imagePath = new javax.swing.JLabel();
        stockSpinner = new javax.swing.JSpinner();
        warningMinusInsert = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 240, 234));

        jPanel2.setBackground(new java.awt.Color(228, 212, 197));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("Cafe Menu Registration");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel2.setText("Menu name");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel3.setText("Stock");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel4.setText("Image");

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
        finalConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalConfirmActionPerformed(evt);
            }
        });

        phoneWarning.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        phoneWarning.setForeground(new java.awt.Color(153, 0, 0));
        phoneWarning.setText(" ...");

        checkWarning.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        checkWarning.setForeground(new java.awt.Color(153, 0, 0));
        checkWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        checkWarning.setText(" ");

        genderWarning.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        genderWarning.setForeground(new java.awt.Color(153, 0, 0));
        genderWarning.setText(" ");

        nameWarning.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nameWarning.setForeground(new java.awt.Color(153, 0, 0));
        nameWarning.setText("...");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel5.setText("Category");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel6.setText("Price");

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Main Course", "Korean", "Dessert", "Drinks" }));

        priceField.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        priceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFieldActionPerformed(evt);
            }
        });

        BrowseBtn.setBackground(new java.awt.Color(153, 153, 153));
        BrowseBtn.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        BrowseBtn.setText("Add file");
        BrowseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrowseBtnMouseClicked(evt);
            }
        });
        BrowseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseBtnActionPerformed(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(153, 153, 153));
        saveBtn.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        saveBtn.setText("Save");
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnMouseClicked(evt);
            }
        });
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        containerImg.setText("img");
        containerImg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        imagePath.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        imagePath.setText("Image Path : ");

        warningMinusInsert.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        warningMinusInsert.setForeground(new java.awt.Color(153, 0, 0));
        warningMinusInsert.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(260, 260, 260)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(confirmBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(197, 197, 197)
                                    .addComponent(genderWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(14, 14, 14))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(211, 211, 211)
                                    .addComponent(checkWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6)
                                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stockSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(warningMinusInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(37, 37, 37)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(BrowseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(saveBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addComponent(containerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(169, 169, 169)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(finalConfirm)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(phoneWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(nameWarning)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BrowseBtn)
                                .addGap(18, 18, 18)
                                .addComponent(saveBtn)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(containerImg, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addComponent(imagePath)
                        .addGap(34, 34, 34)
                        .addComponent(phoneWarning)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(finalConfirm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(genderWarning)
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confirmBtn2)
                        .addGap(108, 108, 108)
                        .addComponent(checkWarning))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stockSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(warningMinusInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void confirmBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtn2MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_confirmBtn2MouseClicked

    private void confirmBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnMouseClicked
//         TODO add your handling code here:
        String name = NameField.getText();
        String category_name = (String) categoryComboBox.getSelectedItem();
        
        String stock = stockSpinner.getValue().toString();
        String price = priceField.getText();
        
        if(Integer.parseInt(stock) <= 0 || Integer.parseInt(price) <= 0) {
            return;
        }
        
        Menu menu = new Menu();
        if (menu.menu_ids.isEmpty() || menu.menu_names.isEmpty() || menu.menu_ids.size() != menu.menu_names.size()) {
            JOptionPane.showMessageDialog(null, "Menu data is inconsistent or empty.");
            return;
        }
        
        boolean confirmation = finalConfirm.isSelected();
        
        if(confirmation && !name.trim().isEmpty() && !category_name.trim().isEmpty() && !stock.trim().isEmpty() && !price.trim().isEmpty() && Integer.parseInt(stock)>=0 && Integer.parseInt(price) >= 0 && !path.isEmpty()) {
            
            for(int i = 0; i < menu.menu_ids.size(); i++){
                String nameM = menu.menu_names.get(i);
                if(nameM.equalsIgnoreCase(name)){
                    //Double data update confirmation
                    new MenuDuplicateUpdateConfirm(name, menu.menu_ids.get(i), stock, price, path);
                    this.dispose();
                }
            }
            menu.InsertData(name, category_name, stock, price, path);
            this.dispose();
        }
        else{
//            this.warning.setVisible(true);
        }

    }//GEN-LAST:event_confirmBtnMouseClicked

    private void finalConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalConfirmActionPerformed

    private void priceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFieldActionPerformed

    private void BrowseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrowseBtnMouseClicked
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fextension = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
        fileChooser.addChoosableFileFilter(fextension);

        int load = fileChooser.showOpenDialog(null);

        if (load == fileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            if (selectedFile != null) {
                String filePath = selectedFile.getAbsolutePath();
                this.path = filePath; // save path
                imagePath.setText("Image path : " + path);

                // Tampilkan gambar pada JLabel
                ImageIcon imageIcon = new ImageIcon(filePath);
                Image img = imageIcon.getImage().getScaledInstance(169, 180, Image.SCALE_SMOOTH);
                containerImg.setIcon(new ImageIcon(img));
            } else {
                JOptionPane.showMessageDialog(null, "No file selected!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operation canceled!");
        }
//                    //browse & upload image
//        JFileChooser fileChooser = new JFileChooser();
//        
//        FileNameExtensionFilter fextension = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
//        fileChooser.addChoosableFileFilter(fextension);
//        
//        int load = fileChooser.showOpenDialog(null);
//        
//        if(load==fileChooser.APPROVE_OPTION){
//            f = fileChooser.getSelectedFile();
//            
//            path = f.getAbsolutePath();
//            imagePath.setText("Image path : " + path);
//            ImageIcon imgi = new ImageIcon(path);
//            Image img = imgi.getImage().getScaledInstance(169, 180,Image.SCALE_SMOOTH);
//            
//            containerImg.setIcon(new ImageIcon(img));
//        }
//        
//        // Collect form data
//        String name = NameField.getText();
//        String category_name = categoryComboBox.getSelectedItem().toString();
//        String stock = stockSpinner.getValue().toString();;
//        String price = priceField.getText();
//        
//        
//        //save image
//        System.out.println("img path : "+path);
//        System.out.println("img name : "+ f.getName());
//        
//        File f = new File(path);
//        
//        try {
//            InputStream input = new FileInputStream(f);
//            
//            Menu menu = new Menu();
//            // Call InsertData function
////            menu.InsertData(name, category_name, stock, price, path);
//  
//            int inserted = pst.executeUpdate();
//            
//            if(inserted > 0 ){
//                JOptionPane.showMessageDialog(null, "Image successfully inserted");
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(MenuUpdatePage.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MenuUpdatePage.class.getName()).log(Level.SEVERE, null, ex);
//        }

        
    }//GEN-LAST:event_BrowseBtnMouseClicked

    private void BrowseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseBtnActionPerformed
        // TODO add your handling code here:
        
        //browse & upload image
        JFileChooser fileChooser = new JFileChooser();
        
        FileNameExtensionFilter fextension = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
        fileChooser.addChoosableFileFilter(fextension);
        
        int load = fileChooser.showOpenDialog(null);
        
        if(load==fileChooser.APPROVE_OPTION){
            f = fileChooser.getSelectedFile();
            
            path = f.getAbsolutePath();
            imagePath.setText("Image path : " + path);
            ImageIcon imgi = new ImageIcon(path);
            Image img = imgi.getImage().getScaledInstance(169, 180,Image.SCALE_SMOOTH);
            
            containerImg.setIcon(new ImageIcon(img));
        }
        
        // Collect form data
        String name = NameField.getText();
        String category_name = categoryComboBox.getSelectedItem().toString();
        String stock = stockSpinner.getValue().toString();;
        String price = priceField.getText();
        
        
        //save image
        System.out.println("img path : "+path);
        System.out.println("img name : "+ f.getName());
        
        File f = new File(path);
        
        try {
            InputStream input = new FileInputStream(f);
            
            Menu menu = new Menu();
            // Call InsertData function
            menu.InsertData(name, category_name, stock, price, path);
  
            int inserted = pst.executeUpdate();
            
            if(inserted > 0 ){
                JOptionPane.showMessageDialog(null, "Image successfully inserted");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuRegistration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MenuRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BrowseBtnActionPerformed

    private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnMouseClicked

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnActionPerformed


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
            java.util.logging.Logger.getLogger(MenuRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseBtn;
    private javax.swing.JTextField NameField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel checkWarning;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JButton confirmBtn2;
    private javax.swing.JLabel containerImg;
    private javax.swing.JCheckBox finalConfirm;
    private javax.swing.JLabel genderWarning;
    private javax.swing.JLabel imagePath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nameWarning;
    private javax.swing.JLabel phoneWarning;
    private javax.swing.JTextField priceField;
    private javax.swing.JButton saveBtn;
    private javax.swing.JSpinner stockSpinner;
    private javax.swing.JLabel warningMinusInsert;
    // End of variables declaration//GEN-END:variables
}
