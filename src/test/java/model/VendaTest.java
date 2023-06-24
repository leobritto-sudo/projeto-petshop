
package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class VendaTest {
    
    @Test
    public void testVendaModel() {
        Venda venda = new Venda();
        venda.setCpf_cli("12345678910");
        venda.setId_venda("1");
        venda.setFk_Cliente_cpf_cli("12345678910");
        venda.setValor_tot("123.90");
        venda.setData_venda("03/09/2021");
        
        assertEquals("12345678910", venda.getCpf_cli());
        assertEquals("1", venda.getId_venda());
        assertEquals("12345678910", venda.getFk_Cliente_cpf_cli());
        assertEquals("123.90", venda.getValor_tot());
        assertEquals("03/09/2021", venda.getData_venda());
    }
    
}
