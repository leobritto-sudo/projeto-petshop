/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoPetShop.Test;


import dao.UserDAO;
import java.sql.SQLException;

/**
 *
 * @author noahr
 */
public class UserDAOTest {
    
    UserDAO dao;
    
    public UserDAOTest() throws SQLException {
        
        dao = new UserDAO();
        
    }
    public void testCheckAdm() throws SQLException{
        System.out.println(dao.checkAdm("11111111111"));
    }
    
    public static void main(String[] args) throws SQLException {
        UserDAOTest sas = new UserDAOTest();
        sas.testCheckAdm();
    }
}
