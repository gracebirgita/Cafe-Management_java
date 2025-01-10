/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import Customers.Customers;
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

public class Menu {
    Connection connection;
    
    //insert
    ArrayList<String> m_ids = new ArrayList<>();
    ArrayList<String> c_ids = new ArrayList<>();
    ArrayList<String> m_names = new ArrayList<>();            
    ArrayList<String> stocks = new ArrayList<>();
    ArrayList<String> m_statusL = new ArrayList<>();
    ArrayList<String> m_prices = new ArrayList<>();
    ArrayList<String> m_last_updates = new ArrayList<>();
    ArrayList<String> m_images = new ArrayList<>();
    
    
    //menu insert category
    public ArrayList<String> menu_ids = new ArrayList<>();
    public ArrayList<String> category_ids = new ArrayList<>();
    public ArrayList<String> category_names = new ArrayList<>();
    public ArrayList<String> menu_names = new ArrayList<>();            
    public ArrayList<String> menu_stocks = new ArrayList<>();
    public ArrayList<String> menu_last_updates = new ArrayList<>();
    public ArrayList<String> menu_prices = new ArrayList<>();

    
    
    //category table
    ArrayList<String> category_list_ids = new ArrayList<>();
    ArrayList<String> category_list_names = new ArrayList<>();
    
    Menu() {
        CreateConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM Menu;");
            while(result.next()) {
                String m_id = String.valueOf(result.getInt("menu_id"));
                String c_id = String.valueOf(result.getInt("category_id"));
                String m_name = result.getString("menu_name").strip();
                String stock = result.getString("menu_stock").strip();
                String m_status = result.getString("menu_status").strip();
                String m_price = result.getString("menu_price").strip();
                String m_last_update = result.getString("menu_last_update").strip();
                String m_image = result.getString("menu_image").strip();
                
                m_ids.add(m_id);
                c_ids.add(c_id);
                m_names.add(m_name);
                stocks.add(stock);
                m_statusL.add(m_status);
                m_prices.add(m_price);
                m_last_updates.add(m_last_update);    
                m_images.add(m_image);
            }
            System.out.println("Menu Data: " + m_names);
            
            //insert query
            result = stmt.executeQuery(
                    "SELECT \n" +
                    "	m.menu_id,\n" +
                    "    m.category_id,\n" +
                    "    c.category_name,\n" +
                    "    m.menu_name,\n" +
                    "    m.menu_stock,\n" +
                    "    m.menu_last_update,\n" +
                    "    m.menu_price\n" +
                    "FROM menu m \n" +
                    "JOIN\n" +
                    "	categories c ON c.category_id=m.category_id\n" +
                    "ORDER BY m.menu_id ASC;");
            while(result.next()) { 
                String menu_id = result.getString("menu_id").strip();
                String category_id = result.getString("category_id").strip();
                String category_name = result.getString("category_name").strip();
                String menu_name = result.getString("menu_name").strip();
                String menu_stock = result.getString("menu_stock").strip();
                String menu_last_update = result.getString("menu_last_update").strip();
                String menu_price = result.getString("menu_price").strip();
                
                
                menu_ids.add(menu_id);
                category_ids.add(category_id);
                category_names.add(category_name);
                menu_names.add(menu_name);
                menu_stocks.add(menu_stock);
                menu_last_updates.add(menu_last_update);
                menu_prices.add(menu_price);
                
            }
            
            
            //category query
            result = stmt.executeQuery("SELECT c.category_id, c.category_name "
                    + "FROM categories c");
            while(result.next()){
                String category_id = result.getString("category_id").strip();
                String category_name = result.getString("category_name").strip();
                
                category_list_ids.add(category_id);
                category_list_names.add(category_name);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
    }
    

    void InsertData(String name, String category_name, String stock, String price, String image) {
        
        try {
            int j = 0;
            String category_id=null, category_temp;
            
            for(int i = 0; i < category_list_ids.size(); i++) { 
                category_temp = category_list_names.get(i);
                if(category_temp.equals(category_name)){
                    category_id = category_list_ids.get(i);
                }
            
            }
            String menu_last_update = BuiltSystem.getCurrentDateFormattedDatabase();
            Statement stmt = connection.createStatement();
            
            
            //check menu already on table
            boolean duplicateData = false;
            for(int i = 0; i < menu_ids.size(); i++) { 
                String nameM = menu_names.get(i);
                if(nameM.equals(name)){
                    duplicateData = true;
                    break;
                }
            }
            
            if(!duplicateData){
                int id = Integer.parseInt(menu_ids.get(j-1));
                System.out.println("Nama Produk : " + menu_names.get(j-1));
                id++;
                System.out.println("id : " + id);
                
                //insert query
                String query = "INSERT INTO products VALUES('"+ id + "','" + category_id + "'," + name + "','" + stock + "','" + menu_last_update + "','" + price + "','" + image + "');";
                stmt.execute(query);
                menu_ids.add("" + id);
                category_ids.add(category_id);
                menu_names.add(name);
                menu_stocks.add(stock);
                menu_last_updates.add(menu_last_update);
                menu_prices.add(price); 
                m_images.add(image);
            } 
            else{
//                UpdateData(name, category_id, stock, price);
            }
            
            BuiltSystem.debugLog("Running InsertData()");
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdateData(String name, String menu_id, String stock, String price, String image){
        try {
            int i;
            String menu_last_update = BuiltSystem.getCurrentDateFormattedDatabase();
            Statement stmt = connection.createStatement();
            for(i = 0; i < menu_ids.size(); i++) { 
                String nameM = menu_names.get(i);
                if(nameM.equalsIgnoreCase(name)){
                    break;
                }
            }
            
            System.out.println(stock);
            int new_stock = Integer.parseInt(menu_stocks.get(i));
            new_stock += Integer.parseInt(stock);
            String stock_now = String.valueOf(new_stock);
            menu_stocks.set(i, stock_now);
            menu_prices.set(i, price);
            menu_last_updates.set(i, menu_last_update);
            m_images.set(i, image);

            String query = "update products SET menu_stock = '"+menu_stocks.get(i)+"', menu_last_update = '"+menu_last_updates.get(i)+"', menu_price = '"+ menu_prices.get(i) +"', menu_image = '"+ m_images.get(i) +"' WHERE menu_id = '"+menu_ids.get(i)+"';";
            stmt.execute(query);
            
            stmt.close();
            BuiltSystem.debugLog("Running UpdateData()");
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    void DeleteData(String id) {

        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM Menu WHERE menu_id = '" + id + "';");
            System.out.println(BuiltSystem.getCurrentTime() + " Deleted customer with id " + id);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CafeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        for(int i = 0; i < m_ids.size(); i++) {
            if(m_ids.get(i).equals(id)) {
                m_ids.remove(i);
                m_names.remove(i);
                stocks.remove(i);
                m_statusL.remove(i);
                m_prices.remove(i);   
                m_last_updates.remove(i);
                m_images.remove(i);
                break;
            }
        }
        BuiltSystem.debugLog("DeletedData() Completed");
    }

    
//  public void InsertProduct(String name, String suppName, String category_name, String stock, String price) {
//        try {
//            Suppliers suppliers = new Suppliers();
//            String suppID = null, suppName_temp;
//            for (int i = 0; i < suppliers.supplier_ids.size(); i++) {
//                suppName_temp = suppliers.supplier_names.get(i);
//                if(suppName_temp.equals(suppName)){
//                    suppID = suppliers.supplier_ids.get(i);
//                }
//                
//            }
//            int i;
//            String category_id = null, category_name_temp;
//            for(int j = 0; j<category_list_ids.size(); j++){
//                category_name_temp = category_list_names.get(j);
//                if(category_name_temp.equals(category_name)){
//                    category_id = category_list_ids.get(j);
//                }
//            }
//            String product_last_update = BuiltSystem.getCurrentDateFormattedProduct();
//            Statement stmt = connection.createStatement();
//            //Memeriksa apakah product sudah ada di tabel apa belum
//            boolean doubleData = false;
//            for(i = 0; i < product_ids.size(); i++) { 
//                String namex = product_names.get(i);
//                if(namex.equals(name)){
//                    doubleData = true;
//                    break;
//                }
//            }
//            
//            if(!doubleData){
//                System.out.println("i : " + (i-1));
//                int id = Integer.parseInt(product_ids.get(i-1));
//                System.out.println("Nama Produk : " + product_names.get(i-1));
//                id++;
//                System.out.println("id : " + id);
//                
//                String query = "INSERT INTO products VALUES('"+ id + "','" + category_id + "',"+ suppID +",'" + name + "','" + stock + "','" + product_last_update + "','" + price + "');";
//                stmt.execute(query);
//                product_ids.add("" + id);
//                category_ids.add(category_id);
//                product_names.add(name);
//                product_stocks.add(stock);
//                product_last_updates.add(product_last_update);
//                product_prices.add(price); 
//            } else{
//                UpdateData(name, category_id, stock, price);
//            }
//            stmt.close();
//            BuiltSystem.debugLog("Running InsertData()");
//        } catch (SQLException ex) {
//            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void UpdateData(String name, String product_id, String stock, String price){
//        try {
//            int i;
//            String product_last_update = BuiltSystem.getCurrentDateFormattedProduct();
//            Statement stmt = connection.createStatement();
//            for(i = 0; i < product_ids.size(); i++) { 
//                String namex = product_names.get(i);
//                if(namex.equalsIgnoreCase(name)){
//                    break;
//                }
//            }
//            
//            System.out.println(stock);
//            int new_stock = Integer.parseInt(product_stocks.get(i));
//            new_stock += Integer.parseInt(stock);
//            String stock_now = String.valueOf(new_stock);
//            product_stocks.set(i, stock_now);
//            product_prices.set(i, price);
//            product_last_updates.set(i, product_last_update);
//
//            String query = "update products SET product_stock = '"+product_stocks.get(i)+"', product_last_update = '"+product_last_updates.get(i)+"', product_price = '"+ product_prices.get(i) +"' WHERE product_id = '"+product_ids.get(i)+"';";
//            stmt.execute(query);
//            
//            stmt.close();
//            BuiltSystem.debugLog("Running UpdateData()");
//        } catch (SQLException ex) {
//            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    }
//    
//    public void DeleteData(String name, String product_id, String stock, String price){
//        try {
//            int i = product_ids.size() - 1;
//            String product_last_update = BuiltSystem.getCurrentDateFormattedProduct();
//            Statement stmt = connection.createStatement();
//            
//            int new_stock = Integer.parseInt(product_stocks.get(i));
//            new_stock -= Integer.parseInt(stock);
//            String stock_now = String.valueOf(new_stock);
//            product_stocks.set(i, stock_now);
//
//            product_prices.set(i, price);
//
//            product_last_updates.set(i, product_last_update);
//
//            String query = "update products SET product_stock = '"+product_stocks.get(i)+"', product_last_update = '"+product_last_updates.get(i)+"' WHERE product_id = '"+product_ids.get(i)+"';";
//            stmt.execute(query);
//            
//            stmt.close();
//            BuiltSystem.debugLog("Running UpdateData()");
//        } catch (SQLException ex) {
//            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    }
//    
//    public void RemoveStock(String product_id, String stock){
//        try {
//            int i = -1;
//            for(i = 0; i < product_ids.size(); i++) { 
//                String namex = product_names.get(i);
//                if(product_ids.get(i).equals(product_id)){
//                    break;
//                }
//            }
//            
//            String product_last_update = BuiltSystem.getCurrentDateFormattedProduct();
//            Statement stmt = connection.createStatement();
//            
//            // mengurangi stock jika produk sudah ada ditabel
//            int new_stock = Integer.parseInt(product_stocks.get(i));
//            new_stock -= Integer.parseInt(stock);
//            String stock_now = String.valueOf(new_stock);
//            product_stocks.set(i, stock_now);
//
//            // merubah last update product
//            product_last_updates.set(i, product_last_update);
//
//            String query = "update products SET product_stock = '"+product_stocks.get(i)+"', product_last_update = '"+product_last_updates.get(i)+"' WHERE product_id = '"+product_ids.get(i)+"';";
//            stmt.execute(query);
//            
//            stmt.close();
//            BuiltSystem.debugLog("Running UpdateData()");
//        } catch (SQLException ex) {
//            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
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
