package br.com.controle.virtual.controller;

import br.com.controle.virtual.entity.Exercicio;
import br.com.controle.virtual.entity.GrupoMuscular;
import br.com.controle.virtual.managedBean.ExercicioMB;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "exercicioController")
@ViewScoped
public class ExercicioController implements Serializable {

    private ExercicioMB mb;
    private Exercicio exercicioSearch;
    private String nome;
    private Exercicio exercicioSelecionado;
    private List<Exercicio> listExercicio;
    private List<GrupoMuscular> listGrupo;

    public ExercicioController() {
        mb = new ExercicioMB();
    }

    @PostConstruct
    public void init() {
        exercicioSearch = new Exercicio();
        listExercicio = mb.getListFind();
        GrupoMuscularController grupoController = new GrupoMuscularController();
        listGrupo = grupoController.getListGrupoCombo();
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

    public List<GrupoMuscular> getListGrupo() {
        return listGrupo;
    }

    public void setListGrupo(List<GrupoMuscular> listGrupo) {
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

    public List<Exercicio> findByGrupo(Integer fkGrupo) {
        return mb.getFindByGrupo(fkGrupo);
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
