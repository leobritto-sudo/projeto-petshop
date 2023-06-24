/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author mathe
 */
public class ConexaoDB {
    
    static String urlBD = "jdbc:mysql://localhost:3306/petshop";
    static String username = "root";
    static String password = "123456"; // "123456"
    
    public static Connection getConnection() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = null;

            connection = DriverManager.getConnection(urlBD, username, password);

            return connection;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
}


