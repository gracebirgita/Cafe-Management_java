package Orders;


import cafemanagement.BuiltSystem;
import cafemanagement.CafeManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class OrderDetail {
    
    Connection connection;
    
    
    ArrayList<String> order_ids = new ArrayList<>();
    ArrayList<String> m_ids= new ArrayList<>();
    ArrayList<String> c_ids= new ArrayList<>();
    ArrayList<String> m_names=new ArrayList<>();
    ArrayList<String> quantities=new ArrayList<>();
    ArrayList<String> m_prices=new ArrayList<>();
    ArrayList<String> sub_totals=new ArrayList<>();
    ArrayList<String> c_names= new ArrayList<>();
    
    OrderDetail(int id_order, int total_recap) {
        
        CreateConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT\n" +
                    "	o.order_id,\n" +
                    "    m.menu_id,\n" +
                    "    m.menu_name,\n" +
                    "    d.quantity,\n" +
                    "    m.menu_price,\n" +
                    "    d.sub_total,\n" +
                    "    c.customer_id,\n" +
                    "    c.customer_name\n" +
                    "FROM orders o\n" +
                    "JOIN\n" +
                    "	customers c  ON c.customer_id = o.customer_id\n" +
                    "JOIN \n" +
                    "	order_details d ON d.order_id = o.order_id\n" +
                    "JOIN\n" +
                    "	menu m ON m.menu_id= d.menu_id\n" +
                    "WHERE \n" +
                    "	m.menu_id = d.menu_id AND\n" +
                    "    c.customer_id = o.customer_id AND\n" +
                    "    d.order_id = '" + id_order + "';");
            
            while(result.next()) {
                
                String order_id = String.valueOf(result.getInt("order_id"));
                String m_id =  String.valueOf(result.getInt("menu_id"));
                String c_id = String.valueOf(result.getInt("customer_id"));
                String m_name = result.getString("menu_name").strip();
                String quantity = result.getString("quantity").strip();
                String m_price = result.getString("menu_price").strip();
                String sub_total = result.getString("sub_total").strip();
                String c_name = result.getString("customer_name").strip();

                
                order_ids.add(order_id);
                m_ids.add(m_id);
                c_ids.add(c_id); 
                m_names.add(m_name);
                quantities.add(quantity);
                m_prices.add(m_price);
                sub_totals.add(sub_total);
                c_names.add(c_name);
               
                
                System.out.println(c_name);
            
            }
            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }   
//        
    }   
    
    //update product stock
//    OrderDetail() {
//        
//        CreateConnection();
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet result = stmt.executeQuery("SELECT\n" +
//                    "        d.order_id,\n" +
//                    "    d.menu_id,\n" +
//                    "    d.quantity,\n" +
//                    "    m.menu_stock\n" +
//                    "FROM order_details d\n" +
//                    "JOIN\n" +
//                    "        orders o ON o.order_id= d.order_id\n" +
//                    "JOIN\n" +
//                    "        menu m ON m.menu_id= d.menu_id\n" +
//                    "WHERE\n" +
//                    "        o.order_id = d.order_id AND\n" +
//                    "    m.menu_id = d.menu_id;");
//                        
//            System.out.println(result);
//            while(result.next()) {
//                
//                String order_id = String.valueOf(result.getInt("order_id"));
//                String m_id = result.getString("menu_id").strip();
//                String quantity = result.getString("quantity").strip();
//                if(quantity ==null){
//                    System.out.println("quantity from db is null");
//                }
//                
//                String m_stock = result.getString("menu_stock").strip();
//                               
////                if(qty!=null){
////                    qty = result.getString("quantity").strip();
////                    System.out.println(qty);
////                }
////                else{
////                    System.out.println("quantity from db is null");
////                }
//                
//                order_ids.add(order_id);
//                m_ids.add(m_id);
//                quantitiesUp.add(quantity);
//                m_stocks.add(m_stock);
//
//            }
//            
//            stmt.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
//        }   
        
//    }   
    
    
    
    

//    private void RefreshData() {
//        BuiltSystem.debugLog("Running RefreshData()");
//        
//        DefaultTableModel tableModel = (DefaultTableModel)tableMembers.getModel();
//        Members members = new Members();
//        String id, name, gender, registration_date, phone_number;
//        int size = members.ids.size();
//        int total_row = tableModel.getRowCount();
//        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
//        for (int i = 0; i < size;  i++) {
//            id = members.ids.get(i);
//            name = members.names.get(i);
//            gender = members.genders.get(i);
//            registration_date = members.registration_dates.get(i);
//            phone_number = members.phone_numbers.get(i);
//            String rowData[] = {id, name, gender, registration_date, phone_number};
//            tableModel.addRow(rowData);
//        }   
//        
//        BuiltSystem.debugLog("RefreshData() Completed");
//    }
    
//    private void SearchData(){
//        BuiltSystem.debugLog("Running SearchData()");
//        DefaultTableModel tableModel = (DefaultTableModel)tableMembers.getModel();
//        Members members = new Members();
//        totalMember.setText("Total Member : " + members.ids.size());
//        String id, name, gender, registration_date, phone_number;
//        int size = members.ids.size();
//        int total_row = tableModel.getRowCount();
//        for (int i = 0; i < total_row; i++) tableModel.removeRow(0);
//        for (int i = 0; i < size;  i++) {
//            String input = memberInputField.getText().toLowerCase();
//            id = members.ids.get(i);
//            name = members.names.get(i).toLowerCase();
//            gender = members.genders.get(i).toLowerCase().strip();
//            registration_date = members.registration_dates.get(i);
//            phone_number = members.phone_numbers.get(i);
//            if(input.startsWith("@")) {
//                if(id.equalsIgnoreCase(input.substring(1, input.length()))) {
//                    String rowData[] = {id, name, gender, registration_date, phone_number};
//                    tableModel.addRow(rowData);
//                    break;
//                }
//            }
//            if (id.equals(input) || name.contains(input) || gender.contains(input) || registration_date.contains(input) || phone_number.equals(input)) {
//                String rowData[] = {id, name, gender, registration_date, phone_number};
//                tableModel.addRow(rowData);
//            }         
//        }   
//        BuiltSystem.debugLog("SearchData() Completed");
//    }
    
    
//    void DeleteData(String id) {
//        // DELETE FROM Member WHERE member_id = '5';
//        try {
//            Statement stmt = connection.createStatement();
//            stmt.execute("DELETE FROM Members WHERE member_id = '" + id + "';");
//            System.out.println(BuiltSystem.getCurrentTime() + " Deleted member with id " + id);
//            stmt.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(GardeniaStoreManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        
//        
//        for(int i = 0; i < ids.size(); i++) {
//            if(ids.get(i).equals(id)) {
//                ids.remove(i);
//                names.remove(i);
//                genders.remove(i);
//                registration_dates.remove(i);
//                phone_numbers.remove(i);   
//                break;
//            }
//        }
//        BuiltSystem.debugLog("DeletedData() Completed");
//    }
    
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