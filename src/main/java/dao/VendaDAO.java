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
import model.Venda;

/**
 *
 * @author mathe
 */
public class VendaDAO{
    
    Connection connection;
    
    
    public VendaDAO() throws SQLException{
        
        connection = ConexãoDB.getConnection();
        
    }
    
    public boolean inserirVenda(Venda venda) throws SQLException{
        
        String sql = "INSERT INTO venda (id_venda, cpf_cli, valor_tot, data_venda) VALUES(?,?,?,?)";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, venda.getId_venda());
        statement.setString(2, venda.getCpf_cli());
        statement.setString(3, venda.getValor_tot());
        statement.setString(4, venda.getData_venda());
        
        int rowsInserted = statement.executeUpdate();
        
        return (rowsInserted > 0);
        
    }

    
    public boolean deletarPROD(Venda venda) throws SQLException{
        
       String sql = "DELETE FROM venda WHERE id_venda = ? ";
        
       PreparedStatement statement = connection.prepareStatement(sql);
       
       statement.setString(1, venda.getId_venda());
        
       statement.executeUpdate(sql);
        
       int rowsInserted = statement.executeUpdate();
        
       return (rowsInserted > 0);
        
    }
    
    public boolean atualizarVenda(Venda venda) throws SQLException{
        
       String sql = "UPDATE produto SET valor_tot = ?";
        
       PreparedStatement statement = connection.prepareStatement(sql);
        
       //statement.setDouble(1, venda.getValor_tot());
       //statement.setDouble(2, venda.getValor());
       //statement.setString(3, venda.getNome());
       //statement.setDate(4, venda.getId_produto());
        
       int rowsInserted = statement.executeUpdate();
        
       return (rowsInserted > 0);
           
    }
    
    public List<Venda> consultarVenda() throws SQLException{
        
        String sql = "SELECT * FROM venda";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        
        List<Venda> produtos = new ArrayList<>();
        
        while(result.next()){
            
            
            Venda venda = new Venda(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
            
            produtos.add(venda);
            
        }
       
        
        return produtos;
    
    }
    
    public List<Venda> mostrarNomeProdutos() throws SQLException{
        
        String sql = "SELECT * FROM produto";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        
        List<Venda> produtosVenda = new ArrayList<>();
        
        while(result.next()){
            
            Venda venda = new Venda(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
            
            produtosVenda.add(venda);
            
        }
       
        return produtosVenda;
        
        
    }  
    
    public void close() throws SQLException{
        
        connection.close();
    }
}
