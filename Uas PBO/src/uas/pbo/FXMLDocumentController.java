/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas.pbo;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import static uas.pbo.mysqlconnect.getDatauser;


/**
 *
 * @author ACER
 */

public class FXMLDocumentController implements Initializable {
    
   @FXML
    private TextField txt_Npwp;

    @FXML
    private TextField txt_Nama;

    @FXML
    private TextField txt_Alamat;

    @FXML
    private TextField txt_jenis_pajak;

    @FXML
    private TextField txt_Terbilang;

    @FXML
    private TableView<User> tabel_user;

    @FXML
    private TableColumn<User, Integer> col_Npwp;

    @FXML
    private TableColumn<User, String> col_Nama;

    @FXML
    private TableColumn<User, String> col_Alamat;

    @FXML
    private TableColumn<User, String > col_jenis_pajak;

    @FXML
    private TableColumn<User, String> col_Terbilang;
    
    

    ObservableList<User>listM;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public void add_data(){
        
        conn = mysqlconnect.ConnectDb();
        String sql = "insert into Data (Npwp,Nama,Alamat,jenis_pajak,terbilang)values(?,?,?,?,? )";
        try{
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_Npwp.getText());
            pst.setString(2, txt_Nama.getText());
            pst.setString(3, txt_Alamat.getText());
            pst.setString(4, txt_jenis_pajak.getText());
            pst.setString(5, txt_Terbilang.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
            Updatetabel();
            showdata();
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
    }

    }
    public void edit(){
        try{
            conn = mysqlconnect.ConnectDb();
            String value1 = txt_Npwp.getText();
            String value2 = txt_Nama.getText();
            String value3 = txt_Alamat.getText();
            String value4 = txt_jenis_pajak.getText();
            String value5 = txt_Terbilang.getText();
            
            String sql = "update Data set Npwp='" +value1+"',Npwp='" +value1+"',Nama='" +value2+"',Alamat='" +value3+"',jenis_pajak='" +value4+"',terbilang='" +value5+"' where Npwp ='"+value1+"' ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di update");
            Updatetabel();
            showdata();
            
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
       
    }
    
   @SuppressWarnings("empty-statement")
    public void Delete(){
        conn = mysqlconnect.ConnectDb();
        String sql = "delete from Data where Npwp = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_Npwp.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "data behasil di hapus");
            showdata();
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @FXML
    void getSelected(MouseEvent event){
        User klik = tabel_user.getSelectionModel().getSelectedItem();
        txt_Npwp.setText(klik.getNpwp());
        txt_Nama.setText(klik.getNama());
        txt_Alamat.setText(klik.getAlamat());
        txt_jenis_pajak.setText(klik.getJenis_pajak());
        txt_Terbilang.setText(klik.getTerbilang());
    }
  

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    showdata();
        
    }
    public void Updatetabel(){
        col_Npwp.setCellValueFactory(new PropertyValueFactory<User,Integer>("Npwp"));
         col_Nama.setCellValueFactory(new PropertyValueFactory<User,String>("Nama"));
         col_Alamat.setCellValueFactory(new PropertyValueFactory<User,String>("Alamat"));
         col_jenis_pajak.setCellValueFactory(new PropertyValueFactory<User,String>("jenis_pajak"));
         col_Terbilang.setCellValueFactory(new PropertyValueFactory<User,String>("terbilang")); 
    
            listM = mysqlconnect.getDatauser();
            tabel_user.setItems(listM);
            
    }
    
    public void showdata(){
         ObservableList<User> list = getDatauser();
         Updatetabel();
         
}

    
}