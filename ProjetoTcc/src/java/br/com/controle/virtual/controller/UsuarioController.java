package br.com.controle.virtual.controller;

import br.com.controle.virtual.entity.Usuario;
import br.com.controle.virtual.managedBean.UsuarioMB;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "usuarioController")
@SessionScoped
@ViewScoped
public class UsuarioController implements Serializable {

    private UsuarioMB mb;
    private Usuario usuarioSearch;
    private String nome;
    private Usuario usuarioSelecionado;
    private List<Usuario> listUsuario;

    public UsuarioController() {
        mb = new UsuarioMB();
        usuarioSearch = new Usuario();
        listUsuario = mb.getListFind();
    }

    public Date getMaxDate() {
        return new Date();
    }

    public Usuario getNovo() {
        return new Usuario();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void atualizaListaUsuario() {
        listUsuario = mb.getListFind();
    }

    public void delete() {
        if (usuarioSelecionado != null && usuarioSelecionado.getId() != null) {
            mb.delete(usuarioSelecionado);
            atualizaListaUsuario();
        }
    }

    private void save() {
        if (mb.save(usuarioSelecionado) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", "Usuário salvo"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro o salvar", "Erro ao salvar o usuário"));
        }
    }

    private void update() {
        if (mb.update(usuarioSelecionado) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", "Usuário salvo"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro o salvar", "Erro ao salvar o usuário"));
        }
    }

    public void saveOrUpdate() {
        if (usuarioSelecionado.getId() == null || usuarioSelecionado.getId().equals(0)) {
            save();
        } else {
            update();
        }
        atualizaListaUsuario();
    }
}