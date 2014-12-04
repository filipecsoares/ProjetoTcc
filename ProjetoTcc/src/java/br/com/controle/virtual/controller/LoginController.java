/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.virtual.controller;

import br.com.controle.virtual.entity.Usuario;
import br.com.controle.virtual.enumerador.TipoUsuario;
import br.com.controle.virtual.managedBean.UsuarioMB;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private Usuario usuario;
    private static Usuario usuarioLogado;
    private UsuarioMB mb;

    public LoginController() {
        usuario = new Usuario();
        mb = new UsuarioMB();
    }

    public String verificaLoginSenha() {
        usuario = mb.getFindLoginSenha(usuario.getLogin(), usuario.getSenha());
        usuarioLogado = usuario;
        if (usuario == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha\n inválido", ""));
            return "login.xhtml";
        } else {
            return "telaPrincipal.xhtml";
        }
    }

    public Boolean getTemPermissao() {
        if (usuario != null && usuario.getTipo() != null) {
            if (usuario.getTipo() == TipoUsuario.ADMINISTRADOR) {
                return true;
            }
        }
        return false;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        usuarioLogado = usuario;
    }

    public static Usuario usuarioLogado() {
        return usuarioLogado;
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
