
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Client;
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
public class ClientDAOTest {
    
    @Mock
    private Connection connection;
    
    @Mock 
    private PreparedStatement statement;
    
    @Mock
    private ResultSet resultSet;
    
    @InjectMocks
    private ClientDAO clientDAO;
    
    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInserirCLI() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
        
        assertTrue(clientDAO.inserirCLI(getClient()));
    }
    
    @Test
    public void testDeletarCLI() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
        
        assertTrue(clientDAO.deletarCLI(getClient()));
    }
    
    @Test
    public void testConsultarCLI() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(Boolean.TRUE).thenReturn(Boolean.FALSE);
        when(resultSet.getString(Mockito.eq(1))).thenReturn(getClient().getCpf_cli());
        when(resultSet.getString(Mockito.eq(2))).thenReturn(getClient().getNome_cli());
        when(resultSet.getString(Mockito.eq(3))).thenReturn(getClient().getEmail_cli());
        when(resultSet.getString(Mockito.eq(4))).thenReturn(getClient().getTel_cli());
        
        assertTrue(true == clientDAO.consultarCLI() instanceof List);
    }
    
    @Test
    public void testAtualizarCLI() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
        
        assertTrue(clientDAO.atualizarCLI(getClient()));
    }
    
    private Client getClient() {
        Client cliente = new Client();
        cliente.setCpf_cli("12345678910");
        cliente.setEmail_cli("example@email.com.br");
        cliente.setNome_cli("Jorginho");
        cliente.setTel_cli("11123456789");
        
        return cliente;
    }
    
}
