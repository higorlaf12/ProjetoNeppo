
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionFactory {
    
    private static final String DRIVE = "com.mysql.jdbc.Driver";
    private static final String URL ="jdbc:mysql://127.0.0.1:3306/dbgerar";
    private static final String USER = "root";
    private static final String PASS = "asioduf03";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVE);
            return DriverManager.getConnection(URL,USER,PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
          throw new RuntimeException("Erro na conexão",ex);
        }
    }
    
    public static void closseconnection(Connection con){
             try {
                if(con != null){
                 con.close();
                }
                } 
             catch (SQLException ex) {
                 Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
     public static void closseconnection(Connection con, PreparedStatement stmt){
            
         closseconnection(con);
         
         try {
                if(stmt != null){
                    stmt.close();
                }
                } 
             catch (SQLException ex) {
                 Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
     
     public static void closseconnection(Connection con, PreparedStatement stmt,ResultSet rs){
            
         closseconnection(con,stmt);
         
         try {
                if(rs != null){
                    rs.close();
                }
                } 
             catch (SQLException ex) {
                 Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
    
}
