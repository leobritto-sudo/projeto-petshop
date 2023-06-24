
package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProdTest {

    @Test
    public void testProdModel() {
        Prod produto = new Prod();
        produto.setId_produto("12345");
        produto.setNome("Ração cachorro");
        produto.setQtd("24");
        produto.setValor(109.90);
        
        assertEquals("12345", produto.getId_produto());
        assertEquals("Ração cachorro", produto.getNome());
        assertEquals("24", produto.getQtd());
        assertEquals(109.90, produto.getValor(), 0);
    }
    
}
