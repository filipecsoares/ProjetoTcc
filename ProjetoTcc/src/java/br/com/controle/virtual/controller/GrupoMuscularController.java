package br.com.controle.virtual.controller;

import br.com.controle.virtual.entity.GrupoMuscular;
import br.com.controle.virtual.managedBean.GrupoMuscularMB;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "grupoController")
@SessionScoped
@ViewScoped
public class GrupoMuscularController implements Serializable {

    private GrupoMuscularMB mb;
    private GrupoMuscular grupoSearch;
    private GrupoMuscular grupoSelecionado;
    private List<GrupoMuscular> listGrupo;

    public GrupoMuscularController() {
        mb = new GrupoMuscularMB();
        grupoSearch = new GrupoMuscular();
        listGrupo = mb.getListFind();
    }

    public Date getMaxDate() {
        return new Date();
    }

    public GrupoMuscular getNovo() {
        return new GrupoMuscular();
    }

    public GrupoMuscularMB getMb() {
        return mb;
    }

    public void setMb(GrupoMuscularMB mb) {
        this.mb = mb;
    }

    public GrupoMuscular getGrupoSearch() {
        return grupoSearch;
    }

    public void setGrupoSearch(GrupoMuscular grupoSearch) {
        this.grupoSearch = grupoSearch;
    }

    public GrupoMuscular getGrupoSelecionado() {
        return grupoSelecionado;
    }

    public void setGrupoSelecionado(GrupoMuscular grupoSelecionado) {
        this.grupoSelecionado = grupoSelecionado;
    }

    public List<GrupoMuscular> getListGrupo() {
        return listGrupo;
    }

    public void setListGrupo(List<GrupoMuscular> listGrupo) {
        this.listGrupo = listGrupo;
    }
    
    public List<GrupoMuscular> getListGrupoCombo() {
        return mb.getListFind();
    }

    public String pesquisaGrupoPorNome() {
        if (grupoSearch.getNome() != null) {
            listGrupo = mb.getFind(grupoSearch.getNome());
        }
        return "";
    }

    public void atualizaListaGrupo() {
        listGrupo = mb.getListFind();
    }
    
    public List<GrupoMuscular> listGrupo(){
        return mb.getListFind();
    }

    public void delete() {
        if (grupoSelecionado != null && grupoSelecionado.getId() != null) {
            mb.delete(grupoSelecionado);
            atualizaListaGrupo();
        }
    }

    private void save() {
        if (mb.save(grupoSelecionado) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", "Grupo salvo"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro o salvar", "Erro ao salvar o grupo"));
        }
    }

    private void update() {
        if (mb.update(grupoSelecionado) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", "Grupo salvo"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro o salvar", "Erro ao salvar o grupo"));
        }
    }

    public void saveOrUpdate() {
        if (grupoSelecionado.getId() == null || grupoSelecionado.getId().equals(0)) {
            save();
        } else {
            update();
        }
        atualizaListaGrupo();
    }
}
