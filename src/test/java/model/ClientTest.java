
package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void testSClientModel() {
        Client cliente = new Client();
        cliente.setCpf_cli("12345678910");
        cliente.setEmail_cli("example@email.com.br");
        cliente.setNome_cli("Jorginho");
        cliente.setTel_cli("11123456789");
        
        assertEquals("12345678910", cliente.getCpf_cli());
        assertEquals("example@email.com.br", cliente.getEmail_cli());
        assertEquals("Jorginho", cliente.getNome_cli());
        assertEquals("11123456789", cliente.getTel_cli());
    }
    
}
