
package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testUserModel() {
        User user = new User();
        user.setCpf_usu("12345678910");
        user.setSenha_usu("123456");
        user.setEmail_usu("example@email.com.br");
        user.setNome_usu("Jorginho");
        user.setTel_usu("11123456789");
        
        assertEquals("12345678910", user.getCpf_usu());
        assertEquals("123456", user.getSenha_usu());
        assertEquals("example@email.com.br", user.getEmail_usu());
        assertEquals("Jorginho", user.getNome_usu());
        assertEquals("11123456789", user.getTel_usu());
    }
    
}
