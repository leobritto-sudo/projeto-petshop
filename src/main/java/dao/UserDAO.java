/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bd.ConexãoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author mathe
 */
public class UserDAO {
    
    Connection connection;
    
    
    public UserDAO() throws SQLException{
        
        connection = ConexãoDB.getConnection();
        
    }
    
    public boolean inserirUSR(User usuario) throws SQLException{
        
        String sql = "INSERT INTO usuario (cpf_usu, nome_usu, senha_usu, email_usu, tel_usu) VALUES(?,?,?,?,?)";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getCpf_usu());
        statement.setString(2, usuario.getNome_usu());
        statement.setString(3, usuario.getSenha_usu());
        statement.setString(4, usuario.getEmail_usu());
        statement.setString(5, usuario.getTel_usu());
        
        int rowsInserted = statement.executeUpdate();
        
        return (rowsInserted > 0);
        
    }
    
    public String checkLogin(String nome_usu, String senha_usu) throws SQLException{
        String check = "";
        
        String sql = "SELECT cpf_usu FROM usuario WHERE nome_usu = ? AND senha_usu = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, nome_usu);
        statement.setString(2, senha_usu);
        
        ResultSet result = statement.executeQuery();
        
        if (result.next()){
            
            check = result.getString(1);
            
        }
    
        return check;
    
    }
    
    
    
    public boolean deletarUSR(User usuario) throws SQLException{
        
       String sql = "DELETE FROM usuario WHERE cpf_usu = ? ";
        
       PreparedStatement statement = connection.prepareStatement(sql);
       
       statement.setString(1, usuario.getCpf_usu());
        
       statement.executeUpdate(sql);
        
       int rowsInserted = statement.executeUpdate();
        
       return (rowsInserted > 0);
        
    }
    
    public boolean atualizarUSR(User usuario) throws SQLException{
        
       String sql = "UPDATE usuario SET Tel_usu = ?, Senha_usu = ?, Nome_usu = ?, Email_usu = ? WHERE cpf_usu = ?";
        
       PreparedStatement statement = connection.prepareStatement(sql);
        
       statement.setString(1, usuario.getTel_usu());
       statement.setString(2, usuario.getSenha_usu());
       statement.setString(3, usuario.getNome_usu());
       statement.setString(4, usuario.getEmail_usu());
       statement.setString(5, usuario.getCpf_usu());
        
       int rowsInserted = statement.executeUpdate();
        
       return (rowsInserted > 0);
           
    }
    
    public List<User> consultarUSR() throws SQLException{
        
        String sql = "SELECT * FROM usuario";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        
        List<User> users = new ArrayList<>();
        
        while(result.next()){
            
            User usuario = new User(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
            
            users.add(usuario);
            
        }
       
        
        return users;
    
    }
    
    public boolean checkAdm(String cpf) throws SQLException{
        
        boolean check = false;
        
        String sql = "SELECT is_adm FROM usuario WHERE cpf_usu = '?'";
        
        sql = sql.replace("?", cpf);
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet result = statement.executeQuery();
        
        if(result.next()){
            check = result.getBoolean(1);
        }
        
        return check;
        
    }
    
    public void close() throws SQLException{
        
        connection.close();
    }
    
}
