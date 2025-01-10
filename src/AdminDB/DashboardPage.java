
package AdminDB;

import Customers.CustomerPage;
import Login.LoginPage;
import Menu.MenuPage;
import Orders.OrderPage;
import java.sql.Connection;
import cafemanagement.BuiltSystem;
import cafemanagement.CafeManagement;
import java.awt.Color;
import java.awt.Window;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DashboardPage extends javax.swing.JFrame {
    Connection connection;

    public DashboardPage() {
        initComponents();
        CreateConnection();
        
        this.setVisible(true);
        this.setLocation(10,5);
        this.setSize(1230, 600);
        System.out.println("masuk dashboard page");
        
        //recap total menu & income
        foodLabel.setText("Total : " + GetAmountFood());
        IncomeLabel.setText("Rp. " + GetIncomeSummary());
        
        //Best seller
        topFood.setText(GetFavFood() + " : " + GetFavFood(0));
        topDrink.setText(GetFavDrink() + " : " + GetFavDrink(0));
        
        //highest & lowest income summary
        higestYear.setText(GetHighestIncome());
        higestAmount.setText("Rp. " + GetHighestIncome(0));
        
        lowestYear.setText(GetLowestIncome());
        lowestAmount.setText("Rp. " + GetLowestIncome(0));
    }
    
    //food
    int GetAmountFood(){
        int totalFood=0;
        try{
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT SUM(quantity) AS total_qty FROM Order_details;");
            while(result.next()) {
                String qty = result.getString("total_qty");
                totalFood += (int) Double.parseDouble(qty);
                
            }
            stmt.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(totalFood);
        return totalFood;
    }
    
    String GetFavFood(){
        String favFood = null;
        try{
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT\n" +
                "    m.menu_name,\n" +
                "    SUM(o.quantity) AS tot_qty_sold\n" +
                "FROM order_details o \n" +
                "JOIN\n" +
                "        menu m ON m.menu_id = o.menu_id\n" +
                "WHERE\n" +
                "        m.category_id = 1 \n" +
                "        OR m.category_id = 2 \n" +
                "    OR m.category_id = 3\n" +
                "GROUP BY\n" +
                "        m.menu_name\n" +
                "ORDER BY tot_qty_sold DESC\n" +
                "LIMIT 1;");
            while(result.next()) {
                String topFood = result.getString("m.menu_name");
                favFood = topFood;
                
            }
            stmt.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(favFood);
        return favFood;
    }
    
    int GetFavFood(int favFoodQty){
        int favFood = 0;
        try{
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT\n" +
                "    m.menu_name,\n" +
                "    SUM(o.quantity) AS tot_qty_sold\n" +
                "FROM order_details o \n" +
                "JOIN\n" +
                "        menu m ON m.menu_id = o.menu_id\n" +
                "WHERE\n" +
                "        m.category_id = 1 \n" +
                "        OR m.category_id = 2 \n" +
                "    OR m.category_id = 3\n" +
                "GROUP BY\n" +
                "        m.menu_name\n" +
                "ORDER BY tot_qty_sold DESC\n" +
                "LIMIT 1;");
            while(result.next()) {
                int topFood = result.getInt("tot_qty_sold");
                favFood += topFood;
                
            }
            stmt.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(favFood);
        return favFood;
    } 
    
    String GetFavDrink(){
        String favDrink = null;
        try{
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT\n" +
                "    m.menu_name,\n" +
                "    SUM(o.quantity) AS tot_qty_sold\n" +
                "FROM order_details o \n" +
                "JOIN\n" +
                "        menu m ON m.menu_id = o.menu_id\n" +
                "WHERE\n" +
                "        m.category_id = 4\n" +
                "GROUP BY\n" +
                "        m.menu_name\n" +
                "ORDER BY tot_qty_sold DESC\n" +
                "LIMIT 1;");
            while(result.next()) {
                String topDrink = result.getString("m.menu_name");
                favDrink = topDrink;
                
            }
            stmt.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(favDrink);
        return favDrink;
    }
    
    int GetFavDrink(int favd){
        int favDrink = 0;
        try{
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT\n" +
                "    m.menu_name,\n" +
                "    SUM(o.quantity) AS tot_qty_sold\n" +
                "FROM order_details o \n" +
                "JOIN\n" +
                "        menu m ON m.menu_id = o.menu_id\n" +
                "WHERE\n" +
                "        m.category_id = 4\n" +
                "GROUP BY\n" +
                "        m.menu_name\n" +
                "ORDER BY tot_qty_sold DESC\n" +
                "LIMIT 1;");
            while(result.next()) {
                int topDrink = result.getInt("tot_qty_sold");
                favDrink += topDrink;
                
            }
            stmt.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(favDrink);
        return favDrink;
    }
    
    //income per year
    String GetHighestIncome(){
        String highest = null;
        try{
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT \n" +
                "        SUM(order_total) AS tot_order_year,\n" +
                "    YEAR(order_date)\n" +
                "FROM\n" +
                "        orders\n" +
                "GROUP BY \n" +
                "        YEAR(order_date)\n" +
                "ORDER BY\n" +
                "        tot_order_year DESC\n" +
                "LIMIT 1;");
            while(result.next()) {
                String highIncome = result.getString("YEAR(order_date)");
                highest = highIncome;
                
            }
            stmt.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(highest);
        return highest;
    }
    
    int GetHighestIncome(int amountHighest){
        int highest=0;
        try{
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT \n" +
                "        SUM(order_total) AS tot_order_year,\n" +
                "    YEAR(order_date)\n" +
                "FROM\n" +
                "        orders\n" +
                "GROUP BY \n" +
                "        YEAR(order_date)\n" +
                "ORDER BY\n" +
                "        tot_order_year DESC\n" +
                "LIMIT 1;");
            while(result.next()) {
                String highIncome = result.getString("tot_order_year");
                highest += (int) Double.parseDouble(highIncome);
                
            }
            stmt.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(highest);
        return highest;
    }
    
    //lowest
    String GetLowestIncome(){
        String highest = null;
        try{
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT \n" +
                "        SUM(order_total) AS tot_order_year,\n" +
                "    YEAR(order_date)\n" +
                "FROM\n" +
                "        orders\n" +
                "GROUP BY \n" +
                "        YEAR(order_date)\n" +
                "ORDER BY\n" +
                "        tot_order_year ASC\n" +
                "LIMIT 1;");
            while(result.next()) {
                String highIncome = result.getString("YEAR(order_date)");
                highest = highIncome;
                
            }
            stmt.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(highest);
        return highest;
    }
    
    int GetLowestIncome(int amountHighest){
        int highest=0;
        try{
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT \n" +
                "        SUM(order_total) AS tot_order_year,\n" +
                "    YEAR(order_date)\n" +
                "FROM\n" +
                "        orders\n" +
                "GROUP BY \n" +
                "        YEAR(order_date)\n" +
                "ORDER BY\n" +
                "        tot_order_year ASC\n" +
                "LIMIT 1;");
            while(result.next()) {
                String highIncome = result.getString("tot_order_year");
                highest += (int) Double.parseDouble(highIncome);
                
            }
            stmt.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(highest);
        return highest;
    }
    
    //income
    int GetIncomeSummary(){
        int total=0;
        try{
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Orders;");
            while(result.next()) {
                String totIncome = result.getString("order_total");
                
                if(totIncome != null && !totIncome.isEmpty()){
                    total += (int) Double.parseDouble(totIncome);
                }

            }
            stmt.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
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
        foodsPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        amountFoodDesc = new javax.swing.JLabel();
        foodLabel = new javax.swing.JLabel();
        topDrinksLabel = new javax.swing.JLabel();
        topFoodLabel = new javax.swing.JLabel();
        topFood = new javax.swing.JLabel();
        topDrink = new javax.swing.JLabel();
        BestSellerLabel = new javax.swing.JLabel();
        incomePanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        incomeLabelDesc = new javax.swing.JLabel();
        IncomeLabel = new javax.swing.JLabel();
        minIncomeLabel = new javax.swing.JLabel();
        maxIncomeLabel1 = new javax.swing.JLabel();
        higestAmount = new javax.swing.JLabel();
        lowestAmount = new javax.swing.JLabel();
        higestYear = new javax.swing.JLabel();
        lowestYear = new javax.swing.JLabel();
        AmountIncomeLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1224, 520));

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
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(228, 228, 228));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setText("Dashboard");

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

        foodsPanel.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Menu");

        amountFoodDesc.setForeground(new java.awt.Color(255, 255, 255));
        amountFoodDesc.setText("Amount of menu sold ");

        foodLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        foodLabel.setForeground(new java.awt.Color(255, 255, 255));
        foodLabel.setText("...");

        topDrinksLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        topDrinksLabel.setForeground(new java.awt.Color(255, 255, 255));
        topDrinksLabel.setText("Drink");

        topFoodLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        topFoodLabel.setForeground(new java.awt.Color(255, 255, 255));
        topFoodLabel.setText("Food");

        topFood.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        topFood.setForeground(new java.awt.Color(255, 255, 255));
        topFood.setText("....");

        topDrink.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        topDrink.setForeground(new java.awt.Color(255, 255, 255));
        topDrink.setText("...");

        BestSellerLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BestSellerLabel.setForeground(new java.awt.Color(222, 212, 196));
        BestSellerLabel.setText("Best Seller");

        javax.swing.GroupLayout foodsPanelLayout = new javax.swing.GroupLayout(foodsPanel);
        foodsPanel.setLayout(foodsPanelLayout);
        foodsPanelLayout.setHorizontalGroup(
            foodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodsPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(foodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BestSellerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountFoodDesc)
                    .addComponent(jLabel3)
                    .addGroup(foodsPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(foodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(foodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(foodsPanelLayout.createSequentialGroup()
                                .addComponent(topFoodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(topDrinksLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodsPanelLayout.createSequentialGroup()
                                .addComponent(topFood, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(topDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        foodsPanelLayout.setVerticalGroup(
            foodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodsPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amountFoodDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(foodLabel)
                .addGap(30, 30, 30)
                .addComponent(BestSellerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(foodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(topFood)
                    .addComponent(topDrink))
                .addGap(7, 7, 7)
                .addGroup(foodsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(topFoodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(topDrinksLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        incomePanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Income Summary");

        incomeLabelDesc.setForeground(new java.awt.Color(255, 255, 255));
        incomeLabelDesc.setText("Income total this month");

        IncomeLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        IncomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        IncomeLabel.setText("Rp. ...");

        minIncomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        minIncomeLabel.setForeground(new java.awt.Color(222, 212, 196));
        minIncomeLabel.setText("Lowest");

        maxIncomeLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        maxIncomeLabel1.setForeground(new java.awt.Color(222, 212, 196));
        maxIncomeLabel1.setText("Highest ");

        higestAmount.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        higestAmount.setForeground(new java.awt.Color(255, 255, 255));
        higestAmount.setText("Rp.....");

        lowestAmount.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lowestAmount.setForeground(new java.awt.Color(255, 255, 255));
        lowestAmount.setText("Rp. ...");

        higestYear.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        higestYear.setForeground(new java.awt.Color(255, 255, 255));
        higestYear.setText("tahun");

        lowestYear.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        lowestYear.setForeground(new java.awt.Color(255, 255, 255));
        lowestYear.setText("tahun");

        javax.swing.GroupLayout incomePanel3Layout = new javax.swing.GroupLayout(incomePanel3);
        incomePanel3.setLayout(incomePanel3Layout);
        incomePanel3Layout.setHorizontalGroup(
            incomePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(incomePanel3Layout.createSequentialGroup()
                .addGroup(incomePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(incomePanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(IncomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(incomePanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(incomePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(incomePanel3Layout.createSequentialGroup()
                                .addGroup(incomePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(incomePanel3Layout.createSequentialGroup()
                                        .addComponent(maxIncomeLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, incomePanel3Layout.createSequentialGroup()
                                        .addGap(0, 7, Short.MAX_VALUE)
                                        .addGroup(incomePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(higestYear, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(higestAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)))
                                .addGroup(incomePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(minIncomeLabel)
                                    .addGroup(incomePanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(incomePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lowestYear, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lowestAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(42, 42, 42))
                            .addGroup(incomePanel3Layout.createSequentialGroup()
                                .addGroup(incomePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(incomeLabelDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        incomePanel3Layout.setVerticalGroup(
            incomePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(incomePanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(incomeLabelDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IncomeLabel)
                .addGap(32, 32, 32)
                .addGroup(incomePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxIncomeLabel1)
                    .addComponent(minIncomeLabel))
                .addGap(18, 18, 18)
                .addGroup(incomePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(higestAmount)
                    .addComponent(lowestAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(incomePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lowestYear)
                    .addComponent(higestYear))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        AmountIncomeLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        AmountIncomeLabel1.setForeground(new java.awt.Color(255, 255, 255));
        AmountIncomeLabel1.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(foodsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(incomePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(430, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(546, 546, 546)
                    .addComponent(AmountIncomeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(547, Short.MAX_VALUE)))
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
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(foodsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(incomePanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(243, 243, 243)
                    .addComponent(AmountIncomeLabel1)
                    .addContainerGap(244, Short.MAX_VALUE)))
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
        String specificWindowName = new DashboardPage().getName();

        for (Window window : Window.getWindows()) {
            if (window.isVisible() && !specificWindowName.equals(window.getName())) {
                window.dispose(); 
            }
        }   
    }//GEN-LAST:event_AdminDashLabelMouseClicked

    private void AdminDashLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminDashLabelMouseEntered
        // TODO add your handling code here:
        AdminDashLabel.setBackground(new Color(0,0,0));
        System.out.println("mouse enter");
    }//GEN-LAST:event_AdminDashLabelMouseEntered

    private void AdminDashLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminDashLabelMouseExited
        // TODO add your handling code here:
        AdminDashLabel.setBackground(new Color(230,230,230));
        System.out.println("mouse exit");
    }//GEN-LAST:event_AdminDashLabelMouseExited

    private void CustomerDashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerDashMouseEntered
        // TODO add your handling code here:
        System.out.println("customer menu enter");
    }//GEN-LAST:event_CustomerDashMouseEntered

    private void MenuDashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuDashMouseClicked
        MenuPage menuPage = new MenuPage();
//        this.dispose();
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
        System.out.println("customer page entered ");
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
        System.out.println("order page entered");
        new OrderPage();
        
        String specificWindowName = new OrderPage().getName();

        for (Window window : Window.getWindows()) {
            if (window.isVisible() && !specificWindowName.equals(window.getName())) {
                window.dispose(); 
            }
        }
    }//GEN-LAST:event_OrderDashMouseClicked

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
            java.util.logging.Logger.getLogger(DashboardPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminDashLabel;
    private javax.swing.JLabel AmountIncomeLabel1;
    private javax.swing.JLabel BestSellerLabel;
    private javax.swing.JLabel CustomerDash;
    private javax.swing.JLabel ExitDash;
    private javax.swing.JLabel IncomeLabel;
    private javax.swing.JLabel MenuDash;
    private javax.swing.JLabel OrderDash;
    private javax.swing.JLabel amountFoodDesc;
    private javax.swing.JLabel foodLabel;
    private javax.swing.JPanel foodsPanel;
    private javax.swing.JLabel higestAmount;
    private javax.swing.JLabel higestYear;
    private javax.swing.JLabel incomeLabelDesc;
    private javax.swing.JPanel incomePanel3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lowestAmount;
    private javax.swing.JLabel lowestYear;
    private javax.swing.JLabel maxIncomeLabel1;
    private javax.swing.JLabel minIncomeLabel;
    private javax.swing.JLabel titleJourney;
    private javax.swing.JLabel topDrink;
    private javax.swing.JLabel topDrinksLabel;
    private javax.swing.JLabel topFood;
    private javax.swing.JLabel topFoodLabel;
    // End of variables declaration//GEN-END:variables
}
