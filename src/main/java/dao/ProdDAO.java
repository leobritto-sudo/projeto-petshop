/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author mathe
 */
import bd.ConexãoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Prod;
import model.User;

/**
 *
 * @author mathe
 */
public class ProdDAO {
    
    Connection connection;
    
    
    public ProdDAO() throws SQLException{
        
        connection = ConexãoDB.getConnection();
        
    }
    
    public boolean inserirPROD(Prod produto) throws SQLException{
        
        String sql = "INSERT INTO produto (qtd, nome, valor) VALUES(?,?,?)";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        

        statement.setString(1, produto.getQtd());
        statement.setString(2, produto.getNome());
        statement.setDouble(3, produto.getValor());
        
        int rowsInserted = statement.executeUpdate();
        
        return (rowsInserted > 0);
        
    }

    
    public void deletarPROD(Prod produto) throws SQLException{
        
       PreparedStatement statement = connection.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
       
       statement.setString(1, produto.getId_produto());
        
       statement.executeUpdate();
        
    }
    
    public boolean atualizarPROD(Prod produto) throws SQLException{
        
       String sql = "UPDATE produto SET qtd = ?, valor = ?, nome = ? WHERE id_produto = ?";
        
       PreparedStatement statement = connection.prepareStatement(sql);
        
       statement.setString(1, produto.getQtd());
       statement.setDouble(2, produto.getValor());
       statement.setString(3, produto.getNome());
       statement.setString(4, produto.getId_produto());
        
       int rowsInserted = statement.executeUpdate();
        
       return (rowsInserted > 0);
           
    }
    
    public List<Prod> consultarPROD() throws SQLException{
        
        String sql = "SELECT id_produto , nome, qtd, valor FROM produto";

        
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        
        List<Prod> produtos = new ArrayList<>();
        
        while(result.next()){
                        
            Prod produto = new Prod(result.getString(1), result.getString(2), result.getString(3), result.getDouble(4));
           
            produtos.add(produto);
            
        }
       
        
        return produtos;
    
    }
    
    public List<Prod> pesquisarPROD(Prod produto) throws SQLException{
        
        PreparedStatement statement = connection.prepareStatement("SELECT id_produto , nome, qtd, valor FROM produto WHERE id_produto = ?");
        
        statement.setString(1, produto.getId_produto()); 
        
        ResultSet result = statement.executeQuery();
        
        List<Prod> produtos = new ArrayList<>();
        
        if(result.next()){
            
            Prod produtoLista = new Prod(result.getString(1), result.getString(2), result.getString(3), result.getDouble(4));
           
            produtos.add(produtoLista);
        }
        
        return produtos;
    }
    public List<Prod> mostrarNomeProdutos() throws SQLException{
        
        String sql = "SELECT nome, valor FROM produto";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        
        List<Prod> produtosVenda = new ArrayList<>();
        
        while(result.next()){
            
            Prod nomeProdutos = new Prod(null, null, result.getString(1), result.getDouble(2));
            
            produtosVenda.add(nomeProdutos);
            
        }
       
        
        return produtosVenda;
        
        
    }
    
    public List<Prod> pesquisarValorPROD(Prod produto) throws SQLException{
        
        String sql = "SELECT valor FROM produto WHERE nome = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, produto.getNome()); 
        
        ResultSet result = statement.executeQuery();
        
        List<Prod> produtos = new ArrayList<>();
        
        while(result.next()){
                        
            Prod valorProduto = new Prod(null, null, null, result.getDouble(1));
           
            produtos.add(valorProduto);
        
        }
        return produtos;
    }
    
    
    public boolean atualizarQTD(Prod produto) throws SQLException{
        
       String sql = "UPDATE produto SET qtd = ? WHERE id_produto = ?";
        
       PreparedStatement statement = connection.prepareStatement(sql);
        
       statement.setString(1, produto.getQtd());    
        
       int rowsInserted = statement.executeUpdate();
        
       return (rowsInserted > 0);
           
    }
     
    public boolean consultarQTD(Prod produto) throws SQLException{
        
        String sql = "SELECT qtd FROM produto WHERE id_produto = ?";

        
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        
        Prod produtos = new Prod(null, result.getString(1), null, null);
        
        
        return true;
    
    }
     
     
    
    
    public void close() throws SQLException{
        
        connection.close();
    }

    //public Object consultarPROD(int i) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
    
}


