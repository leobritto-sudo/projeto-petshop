/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mathe
 */
public class User {
    
    private String nome_usu, senha_usu, email_cli, cpf_usu, tel_usu;

    public User(String cpf_usu, String tel_usu, String nome_usu, String senha_usu, String email_cli) {
        this.cpf_usu = cpf_usu;
        this.tel_usu = tel_usu;
        this.nome_usu = nome_usu;
        this.senha_usu = senha_usu;
        this.email_cli = email_cli;
    }
    
    public User() {
    }

    public String getCpf_usu() {
        return cpf_usu;
    }

    public void setCpf_usu(String cpf_usu) {
        this.cpf_usu = cpf_usu;
    }

    public String getTel_usu() {
        return tel_usu;
    }

    public void setTel_usu(String tel_usu) {
        this.tel_usu = tel_usu;
    }

    public String getNome_usu() {
        return nome_usu;
    }

    public void setNome_usu(String nome_usu) {
        this.nome_usu = nome_usu;
    }

    public String getSenha_usu() {
        return senha_usu;
    }

    public void setSenha_usu(String senha_usu) {
        this.senha_usu = senha_usu;
    }

    public String getEmail_usu() {
        return email_cli;
    }

    public void setEmail_usu(String email_cli) {
        this.email_cli = email_cli;
    }    
    
}
