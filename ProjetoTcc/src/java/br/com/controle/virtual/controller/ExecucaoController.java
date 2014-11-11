package br.com.controle.virtual.controller;

import br.com.controle.virtual.entity.Execucao;
import br.com.controle.virtual.managedBean.ExecucaoMB;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "execucaoController")
@SessionScoped
@ViewScoped
public class ExecucaoController implements Serializable {

    private ExecucaoMB mb;
    private Execucao execucaoSearch;
    private Execucao execucaoSelecionado;
    private List<Execucao> listExecucao;

    public ExecucaoController() {
        mb = new ExecucaoMB();
        execucaoSearch = new Execucao();
        listExecucao = mb.getListFind();
    }

    public Date getMaxDate() {
        return new Date();
    }

    public Execucao getNovo() {
        return new Execucao();
    }

    public Execucao getExecucaoSearch() {
        return execucaoSearch;
    }

    public void setExecucaoSearch(Execucao execucaoSearch) {
        this.execucaoSearch = execucaoSearch;
    }

    public List<Execucao> getListExecucao() {
        return listExecucao;
    }

    public void setListExecucao(List<Execucao> listExecucao) {
        this.listExecucao = listExecucao;
    }

    public Execucao getExecucaoSelecionado() {
        return execucaoSelecionado;
    }

    public void setExecucaoSelecionado(Execucao execucaoSelecionado) {
        this.execucaoSelecionado = execucaoSelecionado;
    }

    public void atualizaListaExecucao() {
        listExecucao = mb.getListFind();
    }

    public void delete() {
        if (execucaoSelecionado != null && execucaoSelecionado.getId() != null) {
            mb.delete(execucaoSelecionado);
            atualizaListaExecucao();
        }
    }

    private void save() {
        if (mb.save(execucaoSelecionado) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", "Usuário salvo"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro o salvar", "Erro ao salvar o usuário"));
        }
    }

    private void update() {
        if (mb.update(execucaoSelecionado) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", "Usuário salvo"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro o salvar", "Erro ao salvar o usuário"));
        }
    }

    public void saveOrUpdate() {
        if (execucaoSelecionado.getId() == null || execucaoSelecionado.getId().equals(0)) {
            save();
        } else {
            update();
        }
        atualizaListaExecucao();
    }
}
