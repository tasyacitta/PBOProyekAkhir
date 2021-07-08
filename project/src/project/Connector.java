package project;

import java.sql.*;

public class Connector {
    String url = "jdbc:mysql://localhost/player";
    String username = "root";
    String password = "";
    Connection connection;
    Statement statement;
    public Connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url,username,password);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
