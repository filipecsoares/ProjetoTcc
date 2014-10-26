package br.com.controle.virtual.controller;

import br.com.controle.virtual.entity.Usuario;
import br.com.controle.virtual.managedBean.UsuarioMB;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    private UsuarioMB mb;
    private Usuario usuarioSearch;

    public UsuarioController() {
        mb = new UsuarioMB();
        usuarioSearch = new Usuario();
    }

    public List<Usuario> getListUsuario() {
        return mb.getListFind();
    }

    public Usuario getUsuarioSearch() {
        return usuarioSearch;
    }

    public void setUsuarioSearch(Usuario usuarioSearch) {
        this.usuarioSearch = usuarioSearch;
    }
    
}
