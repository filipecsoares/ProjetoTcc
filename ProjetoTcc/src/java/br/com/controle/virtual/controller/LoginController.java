/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.virtual.controller;

import br.com.controle.virtual.entity.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private Usuario usuario;

    public LoginController() {
        usuario = new Usuario();
    }

    public void getEntrar() {
        System.out.println("Valida login!");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getLogin() {
        return usuario.getLogin();
    }

    public void setLogin(String login) {
        this.usuario.setLogin(login);
    }

    public String getSenha() {
        return usuario.getSenha();
    }

    public void setSenha(String senha) {
        this.usuario.setSenha(senha);
    }
}
