
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.User;
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
public class UserDAOTest {
    
    @Mock
    private Connection connection;
    
    @Mock 
    private PreparedStatement statement;
    
    @Mock
    private ResultSet resultSet;
    
    @InjectMocks
    private UserDAO userDAO;
    
    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInserirUser() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
        
        assertTrue(userDAO.inserirUSR(getUser()));
    }
    
    @Test
    public void testDeletarUser() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
        
        assertTrue(userDAO.deletarUSR(getUser()));
    }
    
    @Test
    public void testConsultarUser() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(Boolean.TRUE).thenReturn(Boolean.FALSE);
        when(resultSet.getString(Mockito.eq(1))).thenReturn(getUser().getCpf_usu());
        when(resultSet.getString(Mockito.eq(2))).thenReturn(getUser().getTel_usu());
        when(resultSet.getString(Mockito.eq(3))).thenReturn(getUser().getNome_usu());
        when(resultSet.getString(Mockito.eq(4))).thenReturn(getUser().getSenha_usu());
        when(resultSet.getString(Mockito.eq(4))).thenReturn(getUser().getEmail_usu());
        
        assertTrue(true == userDAO.consultarUSR() instanceof List);
    }
    
    @Test
    public void testAtualizarUser() throws SQLException {
        when(connection.prepareStatement(Mockito.anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1);
        
        assertTrue(userDAO.atualizarUSR(getUser()));
    }
    
    private User getUser() {
        User user = new User();
        user.setCpf_usu("12345678910");
        user.setSenha_usu("123456");
        user.setEmail_usu("example@email.com.br");
        user.setNome_usu("Jorginho");
        user.setTel_usu("11123456789");
        
        return user;
    }
    
}
