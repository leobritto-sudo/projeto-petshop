/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mathe
 */
public class Client {
    
    private String nome_cli, email_cli, tel_cli, cpf_cli;
    
    
    public Client(String cpf_cli, String nome_cli, String email_cli, String tel_cli){
        
        this.cpf_cli = cpf_cli;
        this.email_cli = email_cli;
        this.nome_cli = nome_cli;
        this.tel_cli = tel_cli;
        
    }
    
    public String getTel_cli() {
        return tel_cli;
    }


    public void setTel_cli(String tel_cli) {
        this.tel_cli = tel_cli;
    }


    public String getCpf_cli() {
        return cpf_cli;
    }


    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli = cpf_cli;
    }


    public String getNome_cli() {
        return nome_cli;
    }


    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }


    public String getEmail_cli() {
        return email_cli;
    }


    public void setEmail_cli(String email_cli) {
        this.email_cli = email_cli;
    }
    
    
}
