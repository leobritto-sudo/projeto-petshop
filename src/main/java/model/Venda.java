/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mathe
 */
import java.sql.Date;

public class Venda {
    
    private String  id_venda, cpf_cli, fk_Cliente_cpf_cli;
    private String valor_tot;
    private String data_venda;

    
    public Venda(String id_venda, String cpf_cli, String fk_Cliente_cpf_cli, String valor_tot, String data_venda) {
        this.id_venda = id_venda;
        this.cpf_cli = cpf_cli;
        this.fk_Cliente_cpf_cli = fk_Cliente_cpf_cli;
        this.valor_tot = valor_tot;
        this.data_venda = data_venda;
    }
    public String getId_venda() {
        return id_venda;
    }
    public void setId_venda(String id_venda) {
        this.id_venda = id_venda;
    }
    public String getCpf_cli() {
        return cpf_cli;
    }
    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli = cpf_cli;
    }
    public String getFk_Cliente_cpf_cli() {
        return fk_Cliente_cpf_cli;
    }
    public void setFk_Cliente_cpf_cli(String fk_Cliente_cpf_cli) {
        this.fk_Cliente_cpf_cli = fk_Cliente_cpf_cli;
    }
    public String getValor_tot() {
        return valor_tot;
    }
    public void setValor_tot(String valor_tot) {
        this.valor_tot = valor_tot;
    }
    public String getData_venda() {
        return data_venda;
    }
    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }  
    
    
}
