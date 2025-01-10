
package Orders;

import Menu.*;
import AdminDB.*;
import Customers.CustomerPage;
import Login.LoginPage;
import java.sql.Connection;
import cafemanagement.BuiltSystem;
import cafemanagement.CafeManagement;
import java.awt.Color;
import java.awt.Window;
import static java.lang.Integer.parseInt;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;


public class OrderPage extends javax.swing.JFrame {
    Connection connection;
    
    int id_order;    
    int total_recap;
    
    public OrderPage() {
        initComponents();
        CreateConnection();
        
        this.setVisible(true);
        this.setLocation(10,5);
        this.setSize(1230, 600);
        System.out.println("masuk dashboard page");
        
        JTableHeader header = OrderTable.getTableHeader();
        header.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
//        Font verdanaFont = new Font("Verdana", Font.PLAIN, 14); // Font, style, size
//        header.setFont(verdanaFont);
        header.setBackground(new Color(195,180,165));
        header.setForeground(Color.BLACK);   
        
        Order order = new Order();
        OrderTotLabel.setText("Total Order : " + order.o_ids.size());
        
        RefreshData();
        
    }
    
    private void RefreshData() {
        BuiltSystem.debugLog("Running RefreshData()");
        
        DefaultTableModel tableModel = (DefaultTableModel)OrderTable.getModel();
        
        
        Order order = new Order();
        String o_id, cust_id, order_total, order_date;
        int size = order.o_ids.size();
        int total_row = tableModel.getRowCount();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        for (int i = 0; i < size;  i++) {
            o_id = String.valueOf(order.o_ids.get(i));
            cust_id = String.valueOf(order.cust_ids.get(i));
            
            order_total = order.order_totals.get(i);
            order_date = order.order_dates.get(i);
            
            String rowData[] = {o_id, cust_id, order_total, order_date};
            tableModel.addRow(rowData);
        }   
        
        BuiltSystem.debugLog("RefreshData() Completed");
    }
    
    private void SearchData(){
        BuiltSystem.debugLog("Running SearchData()");
        
        //repetition
        DefaultTableModel tableModel = (DefaultTableModel)OrderTable.getModel();
        
        Order order = new Order();
        
        String o_id, cust_id, order_total, order_date;
        OrderTotLabel.setText("Total Order : " + order.o_ids.size());
        
        int size = order.o_ids.size();
        int total_row = tableModel.getRowCount();
        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
        
        //diff
        for (int i = 0; i < size;  i++) {
            String input = searchOrderField.getText().toLowerCase();
            
            o_id = String.valueOf(order.o_ids.get(i));
            cust_id = String.valueOf(order.cust_ids.get(i));
            
            order_total = order.order_totals.get(i);
            order_date = order.order_dates.get(i);

            if (o_id.equals(input) || cust_id.equals(input) || order_total.contains(input) || order_date.contains(input)) {
                String rowData[] = {o_id, cust_id, order_total, order_date};
                tableModel.addRow(rowData);
            }         
        }   
        BuiltSystem.debugLog("SearchData() in menu Completed");
    }    
    
//    private void CreateColumns(){
//        //get table model
//        dm = (DefaultTableModel) OrderTable.getModel();
//        
//        dm.addColumn("name");
//        dm.addColumn("name");
//        dm.addColumn("name");
//        dm.addColumn("name");
//        
//    }
    //filter by year order
    private void filter(String query){
        DefaultTableModel dm = (DefaultTableModel) OrderTable.getModel();
        
        
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
       

        OrderTable.setRowSorter(tr);
        
        //check filter query
        if(!query.equals("All")){
            tr.setRowFilter(RowFilter.regexFilter(query));
        }
        else{
            OrderTable.setRowSorter(tr);
        }
        
    }
    
    //delete by select row
    private void DeleteDataByTable() {
        BuiltSystem.debugLog("Running DeleteDataByTable order()");

        new OrderDeleteConfirm(String.valueOf(id_order));

        
        DeleteByOrderID(String.valueOf(id_order));
//        RefreshData();
        
        BuiltSystem.debugLog("Delete from d.menu success");
        BuiltSystem.debugLog("DeleteData() Completed");
    }
    
    private void DeleteByOrderID(String input_id){
        Order order = new Order();
        
        //return menu stock
        ReturnStockMenu(input_id);
        
        //remove data from orderDetail

        for (int i = 0; i < order.Dorder_ids.size(); i++) {
            System.out.println("size order_ids" +order.Dorder_ids.size()); 
            if(order.Dorder_ids.get(i).equals(input_id)){
                order.Dorder_ids.remove(i);
                order.Dm_ids.remove(i);
                order.Dquantities.remove(i);
                order.Dsub_totals.remove(i);
            }            
        }
        System.out.println("delete by orderID done");
    }
    
    private void ReturnStockMenu(String input_id){

        Order order = new Order();
        CreateConnection();
        String menu_last_update = BuiltSystem.getCurrentDateFormattedDatabase();

        try{
          Statement stmt = connection.createStatement();
          
          List<String> updateMenuIDList= new ArrayList();
          for (int i = 0; i <order.Dorder_ids.size(); i++) {
            if(order.Dorder_ids.get(i).equals(input_id)){
                String menuID= order.Dm_ids.get(i);
                if(!updateMenuIDList.equals(menuID)){
                    updateMenuIDList.add(menuID);
                }
            }
          }
          
          for(String mID : updateMenuIDList){
                  //update stock yg transaksi dibatalkan/di delete
                String query = "UPDATE Menu m \n" +
                        "SET m.menu_stock = m.menu_stock + \n" +
                        "	(SELECT SUM(d.quantity)\n" +
                        "     	FROM order_details d \n" +
                        "     	WHERE d.order_id = '" + input_id +"' AND \n" +
                        "     	d.menu_id = m.menu_id),\n" +
                        "        \n" +
                        "       m.menu_last_update = '" + menu_last_update + "'\n" +
                        "WHERE m.menu_id = '" + mID + "';";

                stmt.execute(query);
                BuiltSystem.debugLog("Stock order ID " + input_id + " with menu_id "+ mID +" returned");
          }
        }catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("return stock done");
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
        OrderTable = new javax.swing.JTable();
        OrderTotLabel = new javax.swing.JLabel();
        ShowBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        searchOrderField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        filterBox = new javax.swing.JComboBox<>();

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
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(228, 228, 228));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setText("Order");

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

        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer ID", "Total", "Order Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(OrderTable);
        if (OrderTable.getColumnModel().getColumnCount() > 0) {
            OrderTable.getColumnModel().getColumn(0).setResizable(false);
            OrderTable.getColumnModel().getColumn(1).setResizable(false);
            OrderTable.getColumnModel().getColumn(2).setResizable(false);
            OrderTable.getColumnModel().getColumn(3).setResizable(false);
        }

        OrderTotLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        OrderTotLabel.setText("Total Order : ");

        ShowBtn.setBackground(new java.awt.Color(195, 180, 165));
        ShowBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        ShowBtn.setText("Show");
        ShowBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShowBtnMouseClicked(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(195, 180, 165));
        deleteBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        deleteBtn.setText("Delete");
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

        searchOrderField.setText("Search...");
        searchOrderField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchOrderFieldActionPerformed(evt);
            }
        });
        searchOrderField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchOrderFieldKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Filter :");

        filterBox.setBackground(new java.awt.Color(195, 181, 157));
        filterBox.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        filterBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "2022", "2023", "2024" }));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrderTotLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(searchOrderField, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(filterBox, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(42, 42, 42))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1)
                                        .addGap(40, 40, 40)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ShowBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(74, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrderTotLabel)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchOrderField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(ShowBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
        new MenuPage();
        
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

    private void searchOrderFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchOrderFieldActionPerformed
        SearchData();
    }//GEN-LAST:event_searchOrderFieldActionPerformed

    private void filterBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBoxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_filterBoxActionPerformed

    private void searchOrderFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchOrderFieldKeyTyped
        SearchData();
    }//GEN-LAST:event_searchOrderFieldKeyTyped

    private void ShowBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowBtnMouseClicked
        // TODO add your handling code here:
        new OrderShowDetailPage(id_order, total_recap);
        
    }//GEN-LAST:event_ShowBtnMouseClicked

    private void OrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTableMouseClicked
        // TODO add your handling code here:
        
        int selectedRow = OrderTable.getSelectedRow();
        if(selectedRow != -1){
            id_order = Integer.parseInt(OrderTable.getValueAt(selectedRow,0).toString());
            total_recap = Integer.parseInt(OrderTable.getValueAt(selectedRow, 2).toString());
                    
        }
        else{
            System.out.println("row not selected");
        }
        
        System.out.println("order ID selected : " + id_order);
        System.out.println("selected row : " + selectedRow);
        System.out.println("tot recap selected : " + total_recap);
               
//        Transactions trans=new Transactions();
//        for (int i = 0; i <trans.Dids_trans.size(); i++) {
//            if(trans.Dids_trans.get(i).equals(String.valueOf(trans_id))){
//                String productID= trans.Dids_products.get(i);
//                int quantity = Integer.parseInt(trans.Dquantities.get(i));
//                
//                System.out.println("product ID : "+ productID +" return quantity "+ quantity);
//            }
//        }
    }//GEN-LAST:event_OrderTableMouseClicked

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        // TODO add your handling code here:
        System.out.println("delete button clicked");
        int selectedRow = OrderTable.getSelectedRow();
        if(selectedRow != -1){
            DeleteDataByTable();
        }
        else{
            System.out.println("no selected row");
        }
        
    }//GEN-LAST:event_deleteBtnMouseClicked

    //combo selection
    private void filterBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterBoxItemStateChanged
        // TODO add your handling code here:
        String query = filterBox.getSelectedItem().toString();
        
        filter(query);
        
    }//GEN-LAST:event_filterBoxItemStateChanged

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
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminDashLabel;
    private javax.swing.JLabel CustomerDash;
    private javax.swing.JLabel ExitDash;
    private javax.swing.JLabel MenuDash;
    private javax.swing.JLabel OrderDash;
    private javax.swing.JTable OrderTable;
    private javax.swing.JLabel OrderTotLabel;
    private javax.swing.JButton ShowBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<String> filterBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchOrderField;
    private javax.swing.JLabel titleJourney;
    // End of variables declaration//GEN-END:variables
}
