
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Prod;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProdDAOTest {
    
    @Mock
    private Connection connection;
    
    @Mock 
    private PreparedStatement statement;
    
    @Mock
    private ResultSet resultSet;
    
    @InjectMocks
    private ProdDAO prodDAO;
    
    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInserirProd() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
        
        assertTrue(prodDAO.inserirPROD(getProd()));
    }
    
    @Test
    public void testDeletarProd() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
        
        prodDAO.deletarPROD(getProd());
        
        assertTrue(Boolean.TRUE);
    }
    
    @Test
    public void testConsultarProd() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(Boolean.TRUE).thenReturn(Boolean.FALSE);
        when(resultSet.getString(Mockito.eq(1))).thenReturn(getProd().getId_produto());
        when(resultSet.getString(Mockito.eq(2))).thenReturn(getProd().getQtd());
        when(resultSet.getString(Mockito.eq(3))).thenReturn(getProd().getNome());
        when(resultSet.getDouble(Mockito.eq(4))).thenReturn(getProd().getValor());
        
        assertTrue(true == prodDAO.consultarPROD() instanceof List);
    }
    
    @Test
    public void testAtualizarProd() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
        
        assertTrue(prodDAO.atualizarPROD(getProd()));
    }
    
    private Prod getProd() {
        Prod produto = new Prod();
        produto.setId_produto("12345");
        produto.setNome("Ração cachorro");
        produto.setQtd("24");
        produto.setValor(109.90);
        
        return produto;
    }
    
}
