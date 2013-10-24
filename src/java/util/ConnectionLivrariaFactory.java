/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.LivrariaDAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author richardsonandrade
 */
public class ConnectionLivrariaFactory {
    
    
    public static Connection getConnection()throws LivrariaDAOException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/livraria","root","mysql");
        }catch(Exception e){
            throw new LivrariaDAOException(e.getMessage());
        }
    }
     public static void closeConnection(Connection conn, Statement stmt, ResultSet set) throws LivrariaDAOException{
        close(conn,stmt,set);
    }
    
    
    public static void closeConnection(Connection conn, Statement stmt) throws LivrariaDAOException{
        close(conn,stmt,null);
    }
    
    public static void closeConnection(Connection conn) throws LivrariaDAOException{
        close(conn,null,null);
    }
    
    private static void close(Connection conn, Statement stmt, ResultSet rs)throws LivrariaDAOException{
        try{
            if(rs!= null) rs.close();
            if(stmt!= null) stmt.close();
            if(conn!= null) conn.close();
        }catch(Exception e){
              throw new LivrariaDAOException(e.getMessage());
        }
    }
    
}
