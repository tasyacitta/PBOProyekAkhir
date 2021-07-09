package model;

import project.Connector;
import controller.ControlGame;
import javax.swing.*;
import java.sql.*;
import java.util.Date;



public class ModelRegis {
    private Connection connection;
    private Statement statement;
    
    public ModelRegis(){
        Connector connector = new Connector();
        connection = connector.getConnection();
        }
 
    public void inputRegis(String[] data){
        try{
            Timestamp date = new Timestamp(new Date().getTime()+7*60*60*1000); //+7jam konversi ke millisecond
            String query = " insert into pemain ( tanggal, nama, pw, skor) values ( ?, ?, ?,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setTimestamp (1, date);
            ps.setString (2, data[0]);
            ps.setString (3, data[1]);
            ps.setInt (4, 0);
            ps.executeUpdate();
            
            connection.close();
            JOptionPane.showMessageDialog(null, "Input Berhasil");
            
            ControlGame cg = new ControlGame();
            cg.login();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}