package Orders;

import cafemanagement.BuiltSystem;
import cafemanagement.CafeManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Order {
    Connection connection;
    
    ArrayList<String> o_ids = new ArrayList<>();
    ArrayList<String> cust_ids = new ArrayList<>();
    ArrayList<String> order_totals = new ArrayList<>();            
    ArrayList<String> order_dates = new ArrayList<>();    
    
    //update stocks
    ArrayList<String> order_ids = new ArrayList<>();
    ArrayList<String> m_ids= new ArrayList<>();
    ArrayList<String> quantities=new ArrayList<>();
    ArrayList<String> m_stocks= new ArrayList<>();
    
    //remove order detail
    public ArrayList<String> Dorder_ids = new ArrayList<>();
    public ArrayList<String> Dm_ids = new ArrayList<>();
    public ArrayList<String> Dquantities = new ArrayList<>();
    public ArrayList<String> Dsub_totals = new ArrayList<>();
    
    
    Order() {
        CreateConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Orders;");
            while(result.next()) {
                String o_id = String.valueOf(result.getInt("order_id"));
                String cust_id = String.valueOf(result.getInt("customer_id"));
                String order_total = result.getString("order_total").strip();
                String order_date = result.getString("order_date").strip();

                o_ids.add(o_id);
                cust_ids.add(cust_id);
                order_totals.add(order_total);
                order_dates.add(order_date);
                
                
            }
            System.out.println("order Data: " + o_ids);
            
            
            //update product stock
            result = stmt.executeQuery("SELECT\n" +
                    "        d.order_id,\n" +
                    "    d.menu_id,\n" +
                    "    d.quantity,\n" +
                    "    m.menu_stock\n" +
                    "FROM order_details d\n" +
                    "JOIN\n" +
                    "        orders o ON o.order_id= d.order_id\n" +
                    "JOIN\n" +
                    "        menu m ON m.menu_id= d.menu_id\n" +
                    "WHERE\n" +
                    "        o.order_id = d.order_id AND\n" +
                    "    m.menu_id = d.menu_id;");
                        
            while(result.next()) {
                
                String order_id = String.valueOf(result.getInt("order_id"));
                String m_id = String.valueOf(result.getInt("menu_id"));
                String m_stock = result.getString("menu_stock").strip();
                String quantity = result.getString("quantity").strip();             
                
                order_ids.add(order_id);
                m_ids.add(m_id);
                m_stocks.add(m_stock);
                quantities.add(quantity);
            }
            
            //order detail
            result = stmt.executeQuery("SELECT * FROM order_details;");
                        
            while(result.next()) {
                
                String Dorder_id = String.valueOf(result.getInt("order_id"));
                String Dm_id = String.valueOf(result.getInt("menu_id"));
                String Dquantity = result.getString("quantity").strip();
                String Dsub_total = result.getString("sub_total").strip();             
                
                Dorder_ids.add(Dorder_id);
                Dm_ids.add(Dm_id);
                Dquantities.add(Dquantity);
                Dsub_totals.add(Dsub_total);
            }
            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
    }
    
    void DeleteData(String id_order){
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM order_details WHERE order_id = '" + id_order + "';");
            System.out.println(BuiltSystem.getCurrentTime() + " Deleted detailtransaction with id " + id_order);
            
            stmt.execute("DELETE FROM Orders WHERE order_id = '" + id_order + "';");
            System.out.println(BuiltSystem.getCurrentTime() + " Deleted transaction with id " + id_order);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        for(int i = 0; i < o_ids.size(); i++) {
            if(o_ids.get(i).equals(id_order)) {
                o_ids.remove(i);
                cust_ids.remove(i);
                order_totals.remove(i);
                order_dates.remove(i); 
                break;
            }
        }
        BuiltSystem.debugLog("DeletedData QUERY() Completed");

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
}
