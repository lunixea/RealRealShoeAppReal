/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Robert
 */
public class DataAccessObject {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/sneaker_store";
    String username = "root";
    String password = "";
    
    public String newShoes (String name, double price, int stock) {
        String query = "insert into shoes (_name, _price, _stock) values (?,?,?)";
        try {
            Class.forName(driver);
            PreparedStatement conn = DriverManager.getConnection(url, username, password).prepareStatement(query);
            conn.setString(1, name);
            conn.setDouble(2, price);
            conn.setInt(3, stock);
            conn.execute();
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            
        }
        return "True";
        
    }
        public String updateShoes (double price, int stock, String name) {
        String query = "update shoes SET _price = ?, _stock = ? WHERE _name = ?";
        try {
            Class.forName(driver);
            PreparedStatement conn = DriverManager.getConnection(url, username, password).prepareStatement(query);
            conn.setDouble(1, price);
            conn.setInt(2, stock);
            conn.setString(3, name);
            conn.execute();
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            
        }
        return "True";
        
    }
    
    public String removeShoes (String name) {
        String query = "delete from shoes where _name=?";
        try {
            Class.forName(driver);
            PreparedStatement conn = DriverManager.getConnection(url, username, password).prepareStatement(query);
            conn.setString(1, name);
            conn.execute();
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            
        }
        return "True";
        
    }
    
    public ArrayList<Shoe> showShoes () {
        ArrayList <Shoe> Shoes = new ArrayList();
        String query = "select * from shoes";
        try {
            Class.forName(driver);
            PreparedStatement conn = DriverManager.getConnection(url, username, password).prepareStatement(query);
            ResultSet rs = conn.executeQuery();
            while (rs.next()) {
                Shoe shoe = new Shoe();
                shoe.setId(rs.getInt("_id"));
                shoe.setName(rs.getString("_name"));
                shoe.setStock(rs.getInt("_stock"));
                shoe.setPrice(rs.getInt("_price"));
                
                
                Shoes.add(shoe);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            
        }
        return Shoes;
        
    }
    
    
}
