
package Menu;

import AdminDB.*;
import Customers.CustomerPage;
import Login.LoginPage;
import Orders.OrderPage;
import java.sql.Connection;
import cafemanagement.BuiltSystem;
import cafemanagement.CafeManagement;
import java.awt.Color;
import java.awt.Window;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;


public class MenuPage extends javax.swing.JFrame {
    Connection connection;
    

    public MenuPage() {
        initComponents();
        
        CreateConnection();
        
        this.setVisible(true);
        this.setLocation(10,5);
        this.setSize(1230, 600);
        System.out.println("masuk dashboard page");
        
        JTableHeader header = MenuTable.getTableHeader();
        header.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
//        Font verdanaFont = new Font("Verdana", Font.PLAIN, 14); // Font, style, size
//        header.setFont(verdanaFont);
        header.setBackground(new Color(195,180,165));
        header.setForeground(Color.BLACK);   
        
        Menu menu = new Menu();
        MenuTotLabel.setText("Total Menu : " + menu.m_ids.size());
        
        RefreshData();
    }
    

    
    private void RefreshData() {
        BuiltSystem.debugLog("Running RefreshData()");
        
        DefaultTableModel tableModel = (DefaultTableModel)MenuTable.getModel();
        
        System.out.println("Column Count: " + tableModel.getColumnCount());
        System.out.println("Row Count: " + tableModel.getRowCount());
        
        Menu menu = new Menu();
        String m_id, c_id, m_name, stock, m_status, m_price, m_last_update, m_image;
        int size = menu.m_ids.size();
        int total_row = tableModel.getRowCount();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        for (int i = 0; i < size;  i++) {
            m_id = String.valueOf(menu.m_ids.get(i));
            c_id = String.valueOf(menu.c_ids.get(i));
            m_name = menu.m_names.get(i);
            
            stock = menu.stocks.get(i);
            m_status = menu.m_statusL.get(i);
            m_price = menu.m_prices.get(i);
            m_last_update = menu.m_last_updates.get(i);
            m_image = menu.m_images.get(i);

            String rowData[] = {m_id, c_id, m_name, stock, m_status, m_price, m_last_update, m_image};
            tableModel.addRow(rowData);
        }   
        
        BuiltSystem.debugLog("RefreshData() Completed");
    }
    private void SearchData(){
        BuiltSystem.debugLog("Running SearchData()");
        
        //repetition
        DefaultTableModel tableModel = (DefaultTableModel)MenuTable.getModel();
        
        Menu menu = new Menu();
        
        String m_id, c_id, m_name, stock, m_status, m_price, m_last_update;
        MenuTotLabel.setText("Total Customer : " + menu.m_ids.size());
        
        int size = menu.m_ids.size();
        int total_row = tableModel.getRowCount();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        
        //diff
        for (int i = 0; i < size;  i++) {
            String input = searchMenuField.getText().toLowerCase();
            
            m_id = String.valueOf(menu.m_ids.get(i));
            c_id = String.valueOf(menu.c_ids.get(i));
            m_name = menu.m_names.get(i);
            
            stock = menu.stocks.get(i);
            m_status = menu.m_statusL.get(i);
            m_price = menu.m_prices.get(i);
            m_last_update = menu.m_last_updates.get(i);
            
//            if(input.startsWith("@")) {
//                if(id.equalsIgnoreCase(input.substring(1, input.length()))) {
//                    String rowData[] = {id, name, gender, registration_date, phone_number};
//                    tableModel.addRow(rowData);
//                    break;
//                }
//            }
            if (m_id.equals(input) || c_id.equals(input) || m_name.toLowerCase().contains(input) || m_status.contains(input) || stock.contains(input) || m_price.contains(input) || m_last_update.contains(input)) {
                String rowData[] = {m_id, c_id, m_name, stock, m_status, m_price, m_last_update};
                tableModel.addRow(rowData);
            }         
        }   
        BuiltSystem.debugLog("SearchData() in menu Completed");
    }    
    
    //filter by year order
    private void filter(String query){
        DefaultTableModel dm = (DefaultTableModel) MenuTable.getModel();
        
        
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
       

        MenuTable.setRowSorter(tr);
        
        //check filter query
        if(!query.equals("All")){
            tr.setRowFilter(RowFilter.regexFilter(query));
        }
        else{
            MenuTable.setRowSorter(tr);
        }
        
    }
    
    private void DeleteDataByTable() {
        BuiltSystem.debugLog("Running DeleteMenuByTable()");
        BuiltSystem.debugLog("Delete from customer success");
        Menu menu = new Menu();
        int selectedRow=MenuTable.getSelectedRow();
        new MenuDeleteConfirm(menu.m_names.get(selectedRow), String.valueOf(selectedRow));
        RefreshData();
        
        BuiltSystem.debugLog("DeleteData() Completed");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        titleJourney = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        AdminDashLabel = new javax.swing.JLabel();
        CustomerDash = new javax.swing.JLabel();
        MenuDash = new javax.swing.JLabel();
        OrderDash = new javax.swing.JLabel();
        ExitDash = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MenuTable = new javax.swing.JTable();
        MenuTotLabel = new javax.swing.JLabel();
        insertBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        filterBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        searchMenuField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 184, 151));

        titleJourney.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        titleJourney.setText("Journey Cafe");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titleJourney)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(titleJourney)
                .addGap(27, 27, 27))
        );

        jPanel3.setBackground(new java.awt.Color(236, 226, 213));

        AdminDashLabel.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        AdminDashLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AdminDashLabel.setText("      Dashboard");
        AdminDashLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminDashLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdminDashLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdminDashLabelMouseExited(evt);
            }
        });

        CustomerDash.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        CustomerDash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CustomerDash.setText("      Customer");
        CustomerDash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerDashMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CustomerDashMouseEntered(evt);
            }
        });

        MenuDash.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        MenuDash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MenuDash.setText("      Menu");
        MenuDash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuDashMouseClicked(evt);
            }
        });

        OrderDash.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        OrderDash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OrderDash.setText("      Order");
        OrderDash.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        OrderDash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderDashMouseClicked(evt);
            }
        });

        ExitDash.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        ExitDash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ExitDash.setText("      Exit");
        ExitDash.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        ExitDash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitDashMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AdminDashLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(CustomerDash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MenuDash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OrderDash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ExitDash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(AdminDashLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(CustomerDash, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(MenuDash, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(OrderDash, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(ExitDash, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(228, 228, 228));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setText("Menu");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        MenuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Menu ID", "Category ID", "Menu", "Stock", "Status", "Price", "Last Update", "Image"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(MenuTable);
        if (MenuTable.getColumnModel().getColumnCount() > 0) {
            MenuTable.getColumnModel().getColumn(0).setResizable(false);
            MenuTable.getColumnModel().getColumn(1).setResizable(false);
            MenuTable.getColumnModel().getColumn(2).setResizable(false);
            MenuTable.getColumnModel().getColumn(3).setResizable(false);
            MenuTable.getColumnModel().getColumn(4).setResizable(false);
            MenuTable.getColumnModel().getColumn(5).setResizable(false);
            MenuTable.getColumnModel().getColumn(6).setResizable(false);
            MenuTable.getColumnModel().getColumn(7).setResizable(false);
        }

        MenuTotLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        MenuTotLabel.setText("Total Menu : ");

        insertBtn.setBackground(new java.awt.Color(195, 180, 165));
        insertBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        insertBtn.setText("Insert Menu");
        insertBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertBtnMouseClicked(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(195, 180, 165));
        updateBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        updateBtn.setText("Update Stock");
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBtnMouseClicked(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(195, 180, 165));
        deleteBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        deleteBtn.setText("Delete Menu");
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        filterBox.setBackground(new java.awt.Color(195, 181, 157));
        filterBox.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        filterBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "available", "sold out" }));
        filterBox.setBorder(null);
        filterBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterBoxItemStateChanged(evt);
            }
        });
        filterBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Filter :");

        searchMenuField.setText("Search...");
        searchMenuField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMenuFieldActionPerformed(evt);
            }
        });
        searchMenuField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchMenuFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MenuTotLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(searchMenuField, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(filterBox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(42, 42, 42)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MenuTotLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filterBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchMenuField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdminDashLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminDashLabelMouseClicked
        System.out.println("Dashboard button clicked");
        new DashboardPage();
        
        String specificWindowName = new DashboardPage().getName();

        for (Window window : Window.getWindows()) {
            if (window.isVisible() && !specificWindowName.equals(window.getName())) {
                window.dispose(); 
            }
        }
    }//GEN-LAST:event_AdminDashLabelMouseClicked

    private void AdminDashLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminDashLabelMouseEntered
        // TODO add your handling code here:
        AdminDashLabel.setBackground(new Color(230,230,230));
        System.out.println("mouse enter");
    }//GEN-LAST:event_AdminDashLabelMouseEntered

    private void AdminDashLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminDashLabelMouseExited
        // TODO add your handling code here:
        AdminDashLabel.setBackground(new Color(230,230,230));
        System.out.println("mouse exited");
    }//GEN-LAST:event_AdminDashLabelMouseExited

    private void CustomerDashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerDashMouseEntered
        // TODO add your handling code here:
        System.out.println("customer menu entered");
    }//GEN-LAST:event_CustomerDashMouseEntered

    private void MenuDashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuDashMouseClicked
        System.out.println("menu page clicked");
        
        String specificWindowName = new MenuPage().getName();

        for (Window window : Window.getWindows()) {
            if (window.isVisible() && !specificWindowName.equals(window.getName())) {
                window.dispose(); 
            }
        }
    }//GEN-LAST:event_MenuDashMouseClicked

    private void ExitDashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitDashMouseClicked
        // TODO add your handling code here:
        new LoginPage();
        this.dispose();
    }//GEN-LAST:event_ExitDashMouseClicked

    private void CustomerDashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerDashMouseClicked
        // TODO add your handling code here:
        System.out.println("customer page clicked");
        new CustomerPage();
        String specificWindowName = new CustomerPage().getName();

        for (Window window : Window.getWindows()) {
            if (window.isVisible() && !specificWindowName.equals(window.getName())) {
                window.dispose(); 
            }
        }
    }//GEN-LAST:event_CustomerDashMouseClicked

    private void OrderDashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderDashMouseClicked
        // TODO add your handling code here:
        System.out.println("order page clicked");
        new OrderPage();
        
        String specificWindowName = new OrderPage().getName();

        for (Window window : Window.getWindows()) {
            if (window.isVisible() && !specificWindowName.equals(window.getName())) {
                window.dispose(); 
            }
        }
    }//GEN-LAST:event_OrderDashMouseClicked

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void searchMenuFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMenuFieldActionPerformed
        // TODO add your handling code here:
        SearchData();
    }//GEN-LAST:event_searchMenuFieldActionPerformed

    private void filterBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterBoxActionPerformed

    private void searchMenuFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchMenuFieldKeyTyped
        // TODO add your handling code here:
        SearchData();
    }//GEN-LAST:event_searchMenuFieldKeyTyped

    private void insertBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertBtnMouseClicked
        // TODO add your handling code here:
        new MenuRegistration();
        String specificWindowName = new MenuRegistration().getName();

        for (Window window : Window.getWindows()) {
            if (window.isVisible() && !specificWindowName.equals(window.getName())) {
                window.dispose(); 
            }
        }
        
    }//GEN-LAST:event_insertBtnMouseClicked

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        // TODO add your handling code here:
        BuiltSystem.debugLog("Delete button clicked");
        int selectedRow=MenuTable.getSelectedRow();
        if(selectedRow != -1) {
            DeleteDataByTable();
        }
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void filterBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterBoxItemStateChanged
        // TODO add your handling code here:
        String query = filterBox.getSelectedItem().toString();
        
        filter(query);
    }//GEN-LAST:event_filterBoxItemStateChanged

    private void updateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseClicked
        // TODO add your handling code here:
        new MenuUpdatePage();
        
        String specificWindowName = new MenuUpdatePage().getName();

        for (Window window : Window.getWindows()) {
            if (window.isVisible() && !specificWindowName.equals(window.getName())) {
                window.dispose(); 
            }
        }
    }//GEN-LAST:event_updateBtnMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminDashLabel;
    private javax.swing.JLabel CustomerDash;
    private javax.swing.JLabel ExitDash;
    private javax.swing.JLabel MenuDash;
    private javax.swing.JTable MenuTable;
    private javax.swing.JLabel MenuTotLabel;
    private javax.swing.JLabel OrderDash;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<String> filterBox;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchMenuField;
    private javax.swing.JLabel titleJourney;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
