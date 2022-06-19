package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
        
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String HOST = "localhost";
    public static final String  BASE = "sys_estoque";
    public static final String  USER = "root";
    public static final String  PASS = "";
      Connection conexao;

public Connection conectar() throws SQLException{ 
     try { 
      Class.forName(DRIVER);
      Connection con = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BASE
              + "?user=" + USER + "&password=" + PASS + "");
      this.conexao = con;
    //  JOptionPane.showConfirmDialog(null, "Conectado");
     } catch (ClassNotFoundException ex) { 
         Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        // JOptionPane.showConfirmDialog(null, "Desconectado");
     }
     return conexao;
}   

}
