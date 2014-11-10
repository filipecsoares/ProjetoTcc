package br.com.controle.virtual.controller;

import br.com.controle.virtual.entity.Exercicio;
import br.com.controle.virtual.entity.GrupoMuscular;
import br.com.controle.virtual.managedBean.ExercicioMB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean(name = "exercicioController")
@SessionScoped
@ViewScoped
public class ExercicioController implements Serializable {

    private ExercicioMB mb;
    private Exercicio exercicioSearch;
    private String nome;
    private Exercicio exercicioSelecionado;
    private List<Exercicio> listExercicio;
    private List<SelectItem> listGrupo;

    public ExercicioController() {
        mb = new ExercicioMB();
        exercicioSearch = new Exercicio();
        listExercicio = mb.getListFind();
        listGrupo = new ArrayList<SelectItem>();
        GrupoMuscularController grupoController = new GrupoMuscularController();
        for (GrupoMuscular gm : grupoController.getListGrupoCombo()) {
            listGrupo.add(new SelectItem(gm, gm.getNome()));
        }
        exercicioSelecionado = new Exercicio();
        exercicioSelecionado.setGrupo(new GrupoMuscular());
    }

    public Date getMaxDate() {
        return new Date();
    }

    public Exercicio getNovo() {
        return new Exercicio();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ExercicioMB getMb() {
        return mb;
    }

    public void setMb(ExercicioMB mb) {
        this.mb = mb;
    }

    public Exercicio getExercicioSearch() {
        return exercicioSearch;
    }

    public void setExercicioSearch(Exercicio exercicioSearch) {
        this.exercicioSearch = exercicioSearch;
    }

    public Exercicio getExercicioSelecionado() {
        return exercicioSelecionado;
    }

    public void setExercicioSelecionado(Exercicio exercicioSelecionado) {
        this.exercicioSelecionado = exercicioSelecionado;
    }

    public List<Exercicio> getListExercicio() {
        return listExercicio;
    }

    public void setListExercicio(List<Exercicio> listExercicio) {
        this.listExercicio = listExercicio;
    }

    public List<SelectItem> getListGrupo() {
        return listGrupo;
    }

    public void setListGrupo(List<SelectItem> listGrupo) {
        this.listGrupo = listGrupo;
    }

    public String pesquisaExercicioPorNome() {
        if (exercicioSearch.getNome() != null && !exercicioSearch.getNome().equals("")) {
            listExercicio = mb.getFind(exercicioSearch.getNome());
        }
        return "";
    }

    public void atualizaListaExercicio() {
        listExercicio = mb.getListFind();
    }

    public void delete() {
        if (exercicioSelecionado != null && exercicioSelecionado.getId() != null) {
            mb.delete(exercicioSelecionado);
            atualizaListaExercicio();
        }
    }

    private void save() {
        if (mb.save(exercicioSelecionado) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", "Exercicio salvo"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro o salvar", "Erro ao salvar o exercicio"));
        }
    }

    private void update() {
        if (mb.update(exercicioSelecionado) != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso", "Usuário salvo"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro o salvar", "Erro ao salvar o usuário"));
        }
    }

    public void saveOrUpdate() {
        if (exercicioSelecionado.getId() == null || exercicioSelecionado.getId().equals(0)) {
            save();
        } else {
            update();
        }
        atualizaListaExercicio();
    }
}
