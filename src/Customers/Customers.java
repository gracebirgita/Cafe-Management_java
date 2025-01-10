
package Customers;

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

public class Customers {
    Connection connection;
    
    ArrayList<String> ids = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();            
    ArrayList<String> genders = new ArrayList<>();
    ArrayList<String> join_dates = new ArrayList<>();
    ArrayList<String> phone_numbers = new ArrayList<>();
    ArrayList<String> isMembers = new ArrayList<>();
    
    Customers() {
        CreateConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Customers");
            while(result.next()) {
                String id = String.valueOf(result.getInt("customer_id"));
                String name = result.getString("customer_name").strip();
                String gender = result.getString("customer_gender").strip();
                String phone_number = result.getString("customer_phone");
                if (phone_number != null) {
                    phone_number = phone_number.strip();
                } else {
                    phone_number = " ";  // Fallback
                }
                String join_date = result.getString("customer_join_date");
                if (join_date != null) {
                    join_date = join_date.strip();
                } else {
                    join_date = " ";  // Fallback
                }
                String isMember = result.getString("is_member").strip();
                
                ids.add(id);
                names.add(name);
                genders.add(gender);
                join_dates.add(join_date);
                phone_numbers.add(phone_number);
                isMembers.add(isMember);
                
                
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
    }   
    
    
    void InsertData(String name, String gender, String phone_number, String isMember) {
        try {
            
            
            for(int i = 0; i < ids.size(); i++) { }
            
            int id = Integer.parseInt(ids.get(ids.size()- 1));
            id++;
            
            String join_date = BuiltSystem.getCurrentDateFormattedDatabase();
            
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO customers VALUES(" + id + ",'" + name + "','" + gender + "','" + phone_number + "','" 
                            + join_date + "','" + isMember +"');";
            stmt.execute(query);
  

            ids.add("" + id);
            names.add(name);
            genders.add(gender);
            join_dates.add(join_date);
            phone_numbers.add(phone_number); 
            isMembers.add(isMember);
            stmt.close();
            
            BuiltSystem.debugLog("Running InsertData()");
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //is_member ="0"
//    void InsertDataGuest(String name, String gender, String phone_number, String isMember) {
//        try {
//            
//            
//            for(int i = 0; i < ids.size(); i++) { }
//            
//            int id = Integer.parseInt(ids.get(ids.size()- 1));
//            id++;
//            
//            String join_date = BuiltSystem.getCurrentDateFormattedDatabase();
//            
//            Statement stmt = connection.createStatement();
//            String query = "INSERT INTO customers VALUES(" + id + ",'" + name + "','" + gender + "','" + phone_number + "','" 
//                            + join_date + "','" + isMember +"');";
//            stmt.execute(query);
//  
//
//            ids.add("" + id);
//            names.add(name);
//            genders.add(gender);
//            join_dates.add(join_date);
//            phone_numbers.add(phone_number); 
//            isMembers.add(isMember);
//            stmt.close();
//            
//            BuiltSystem.debugLog("Running InsertData()");
//        } catch (SQLException ex) {
//            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    void DeleteData(String id) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM Customers WHERE customer_id = '" + id + "';");
            System.out.println(BuiltSystem.getCurrentTime() + " Deleted customer with id " + id);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        for(int i = 0; i < ids.size(); i++) {
            if(ids.get(i).equals(id)) {
                ids.remove(i);
                names.remove(i);
                genders.remove(i);
                join_dates.remove(i);
                phone_numbers.remove(i);   
                isMembers.remove(i);
               
                break;
            }
        }
        BuiltSystem.debugLog("DeletedData() CUSTOMER Completed");
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
