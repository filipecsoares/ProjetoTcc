package br.com.controle.virtual.controller;

import br.com.controle.virtual.entity.Execucao;
import br.com.controle.virtual.entity.Ficha;
import br.com.controle.virtual.entity.Usuario;
import br.com.controle.virtual.enumerador.TipoUsuario;
import br.com.controle.virtual.managedBean.ExecucaoMB;
import br.com.controle.virtual.managedBean.FichaMB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "fichaController")
@ViewScoped
public class FichaController implements Serializable {

    private FichaMB mb;
    private Ficha fichaSearch;
    private String nome;
    private Ficha fichaSelecionada;
    private List<Ficha> listFicha;
    private List<Usuario> listUsuario;
    private List<Execucao> listExecucao;
    private Usuario usuarioLogado;

    public FichaController() {
        mb = new FichaMB();
        fichaSearch = new Ficha();
        fichaSearch.setUsuario(new Usuario());
        fichaSelecionada = new Ficha();
        fichaSelecionada.setUsuario(new Usuario());
        usuarioLogado = LoginController.usuarioLogado();
        if (usuarioLogado != null && usuarioLogado.getTipo() != null && usuarioLogado.getTipo().equals(TipoUsuario.USUARIO)) {
            listFicha = mb.getFind(usuarioLogado.getId());
        } else {
            listFicha = mb.getListFind();
        }
        UsuarioController usuario = new UsuarioController();
        listUsuario = usuario.getListUsuarioCombo();
    }

    public Date getMaxDate() {
        return new Date();
    }

    public Ficha getNovo() {
        return new Ficha();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Ficha getFichaSearch() {
        return fichaSearch;
    }

    public void setFichaSearch(Ficha fichaSearch) {
        this.fichaSearch = fichaSearch;
    }

    public List<Ficha> getListFicha() {
        return listFicha;
    }

    public void setListFicha(List<Ficha> listFicha) {
        this.listFicha = listFicha;
    }

    public Ficha getFichaSelecionada() {
        return fichaSelecionada;
    }

    public void setFichaSelecionada(Ficha fichaSelecionada) {
        this.fichaSelecionada = fichaSelecionada;
        if (fichaSelecionada != null && fichaSelecionada.getId() != null) {
            ExecucaoMB emb = new ExecucaoMB();
            listExecucao = emb.getFindByFicha(fichaSelecionada.getId());
        } else {
            listExecucao = new ArrayList<>();
        }
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public FichaMB getMb() {
        return mb;
    }

    public void setMb(FichaMB mb) {
        this.mb = mb;
    }

    public List<Execucao> getListExecucao() {
        return listExecucao;
    }

    public void setListExecucao(List<Execucao> listExecucao) {
        this.listExecucao = listExecucao;
    }

    public String pesquisaFichaPorUsuario() {
        if (fichaSearch.getUsuario() != null && fichaSearch.getUsuario().getNome() != null) {
            listFicha = mb.getFind(fichaSearch.getUsuario().getNome());
        }
        return "";
    }

    public String abrir() {
        return "execucaoListar.xhtml";
    }

    public void atualizaListaFicha() {
        listFicha = mb.getListFind();
    }

    public void delete() {
        if (fichaSelecionada != null && fichaSelecionada.getId() != null) {
            mb.delete(fichaSelecionada);
            atualizaListaFicha();
        }
    }

    private void save() {
        fichaSelecionada.setDtCadastro(new Date());
        if (mb.save(fichaSelecionada) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", "Usuário salvo"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro o salvar", "Erro ao salvar o usuário"));
        }
    }

    private void update() {
        if (mb.update(fichaSelecionada) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", "Usuário salvo"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro o salvar", "Erro ao salvar o usuário"));
        }
    }

    public void saveOrUpdate() {
        if (fichaSelecionada.getId() == null || fichaSelecionada.getId().equals(0)) {
            save();
        } else {
            update();
        }
        atualizaListaFicha();
    }

}
