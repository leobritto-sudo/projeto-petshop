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
import model.Client;

/**
 *
 * @author mathe
 */
public class ClientDAO {
    
    Connection connection;
    
    public ClientDAO() throws SQLException{
        
        connection = ConexãoDB.getConnection();
    }
    
     public boolean inserirCLI(Client cliente) throws SQLException{
        
        String sql = "INSERT INTO cliente (cpf_cli, nome_cli, email_cli, tel_cli) VALUES(?,?,?,?)";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, cliente.getCpf_cli());
        statement.setString(2, cliente.getNome_cli());
        statement.setString(3, cliente.getEmail_cli());
        statement.setString(4, cliente.getTel_cli());
        
        int rowsInserted = statement.executeUpdate();
        
        return (rowsInserted > 0);
        
    }
     
    public boolean deletarCLI(Client cliente) throws SQLException{
        
       String sql = "DELETE FROM usuario WHERE cpf_cli = ? ";
        
       PreparedStatement statement = connection.prepareStatement(sql);
       
       statement.setString(1, cliente.getCpf_cli());
        
       statement.executeUpdate(sql);
        
       int rowsInserted = statement.executeUpdate();
        
       return (rowsInserted > 0);
        
    }
    
    public boolean atualizarCLI(Client cliente) throws SQLException{
        
       String sql = "UPDATE usuario SET Nome_usu = ?, Email_usu = ?, Tel_usu = ? WHERE cpf_usu = ?";
        
       PreparedStatement statement = connection.prepareStatement(sql);
        
       statement.setString(1, cliente.getNome_cli());      
       statement.setString(3, cliente.getEmail_cli());
       statement.setString(4, cliente.getTel_cli());
       statement.setString(5, cliente.getCpf_cli());
        
       int rowsInserted = statement.executeUpdate();
        
       return (rowsInserted > 0);
           
    }
    
    public List<Client> consultarCLI() throws SQLException{
        
        String sql = "SELECT cpf_cli, nome_cli, email_cli, tel_cli FROM cliente";

        
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        
        List<Client> clientes = new ArrayList<>();
        
        while(result.next()){
                        
            Client cliente = new Client(result.getString(1), result.getString(2), result.getString(3), result.getString(4));
           
            clientes.add(cliente);
            
        }
       
        
        return clientes;
    
    }
    
    public void close() throws SQLException{
        
        connection.close();
    }
    
    
}
