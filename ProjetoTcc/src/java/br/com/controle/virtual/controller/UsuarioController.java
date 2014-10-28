package br.com.controle.virtual.controller;

import br.com.controle.virtual.entity.Usuario;
import br.com.controle.virtual.managedBean.UsuarioMB;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "usuarioController")
@SessionScoped
@ViewScoped
public class UsuarioController implements Serializable {

    private UsuarioMB mb;
    private Usuario usuarioSearch;
    private Usuario usuarioSelecionado;
    private List<Usuario> listUsuario;

    public UsuarioController() {
        mb = new UsuarioMB();
        usuarioSearch = new Usuario();
        listUsuario = mb.getListFind();
    }

    public Usuario getUsuarioSearch() {
        return usuarioSearch;
    }

    public void setUsuarioSearch(Usuario usuarioSearch) {
        this.usuarioSearch = usuarioSearch;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public String pesquisaUsuarioPorNome() {
        if (usuarioSearch.getNome() != null && !usuarioSearch.getNome().equals("")) {
            listUsuario = mb.getFind(usuarioSearch.getNome());
        }
        return "";
    }
    
    public void delete(){
        
    }
    
    public void save(){
        
    }
}
