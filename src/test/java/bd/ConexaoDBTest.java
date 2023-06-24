
package bd;

import java.sql.Connection;
import static org.junit.Assert.*;
import org.junit.Test;
public class ConexaoDBTest {

    @Test
    public void testGetConnectionSuccess() throws Exception {
        assertTrue(true == ConexaoDB.getConnection() instanceof Connection);
    }
}
