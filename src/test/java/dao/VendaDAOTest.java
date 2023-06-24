
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Venda;
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
public class VendaDAOTest {
    
    @Mock
    private Connection connection;
    
    @Mock 
    private PreparedStatement statement;
    
    @Mock
    private ResultSet resultSet;
    
    @InjectMocks
    private VendaDAO vendaDAO;
    
    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInserirVenda() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
        
        assertTrue(vendaDAO.inserirVenda(getVenda()));
    }
    
    @Test
    public void testDeletarVenda() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
        
        assertTrue(vendaDAO.deletarPROD(getVenda()));
    }
    
    @Test
    public void testConsultarVenda() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(Boolean.TRUE).thenReturn(Boolean.FALSE);
        when(resultSet.getString(Mockito.eq(1))).thenReturn(getVenda().getId_venda());
        when(resultSet.getString(Mockito.eq(1))).thenReturn(getVenda().getCpf_cli());
        when(resultSet.getString(Mockito.eq(2))).thenReturn(getVenda().getFk_Cliente_cpf_cli());
        when(resultSet.getString(Mockito.eq(3))).thenReturn(getVenda().getValor_tot());
        when(resultSet.getString(Mockito.eq(4))).thenReturn(getVenda().getData_venda());
        
        assertTrue(true == vendaDAO.consultarVenda() instanceof List);
    }
    
    @Test
    public void testMostrarNomeProdutos() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(Boolean.TRUE).thenReturn(Boolean.FALSE);
        when(resultSet.getString(Mockito.eq(1))).thenReturn(getVenda().getId_venda());
        when(resultSet.getString(Mockito.eq(1))).thenReturn(getVenda().getCpf_cli());
        when(resultSet.getString(Mockito.eq(2))).thenReturn(getVenda().getFk_Cliente_cpf_cli());
        when(resultSet.getString(Mockito.eq(3))).thenReturn(getVenda().getValor_tot());
        when(resultSet.getString(Mockito.eq(4))).thenReturn(getVenda().getData_venda());
        
        assertTrue(true == vendaDAO.mostrarNomeProdutos() instanceof List);
    }
    
    @Test
    public void testAtualizarVenda() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
        
        assertTrue(vendaDAO.atualizarVenda(getVenda()));
    }
    
    private Venda getVenda() {
        Venda venda = new Venda();
        venda.setCpf_cli("12345678910");
        venda.setId_venda("1");
        venda.setFk_Cliente_cpf_cli("12345678910");
        venda.setValor_tot("123.90");
        venda.setData_venda("03/09/2021");
        
        return venda;
    }
}
