    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas.pbo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Arif
 */
public class mysqlconnect {
    Connection conn = null;
    
    public static Connection ConnectDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pajak");
            JOptionPane.showMessageDialog(null,"Connection Established");
            return conn;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
            
        }
    }
    public static ObservableList<User>getDatauser(){
        Connection conn = ConnectDb();
        ObservableList<User>list = FXCollections.observableArrayList();
       try{
          PreparedStatement ps = conn.prepareStatement("select * from Data");
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
              list.add(new User(rs.getString("Npwp"),rs.getString("Nama"),rs.getString("Alamat"),rs.getString("jenis_pajak"),rs.getString("terbilang")));
              
              
          }
        }catch (Exception e){
    }
        return list;
    }
    }
    
