package br.com.controle.virtual.controller;

import br.com.controle.virtual.entity.Execucao;
import br.com.controle.virtual.entity.Exercicio;
import br.com.controle.virtual.entity.Ficha;
import br.com.controle.virtual.entity.GrupoMuscular;
import br.com.controle.virtual.managedBean.ExecucaoMB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean(name = "execucaoController")
@ViewScoped
public class ExecucaoController implements Serializable {

    private ExecucaoMB mb;
    private Execucao execucaoSearch;
    private Execucao execucaoSelecionado;
    private List<Execucao> listExecucao;
    private List<GrupoMuscular> listGrupo;
    private List<Exercicio> listExercicio;
    private static Ficha fichaStatic;
    private Ficha ficha;
    private GrupoMuscular grupo;
    private Exercicio exercicio;

    public ExecucaoController() {
        mb = new ExecucaoMB();
        execucaoSearch = new Execucao();
        execucaoSelecionado = new Execucao();
        execucaoSelecionado.setExercicio(new Exercicio());
        GrupoMuscularController grupoController = new GrupoMuscularController();
        listGrupo = grupoController.getListGrupoCombo();
        listExercicio = new ArrayList<>();
        if (fichaStatic != null) {
            this.ficha = fichaStatic;
        }
        if (ficha != null && ficha.getId() != null) {
            listExecucao = mb.getFindByFicha(ficha.getId());
        } else {
            listExecucao = new ArrayList<>();
        }
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

    public List<GrupoMuscular> getListGrupo() {
        return listGrupo;
    }

    public void setListGrupo(List<GrupoMuscular> listGrupo) {
        this.listGrupo = listGrupo;
    }

    public List<Exercicio> getListExercicio() {
        return listExercicio;
    }

    public void setListExercicio(List<Exercicio> listExercicio) {
        this.listExercicio = listExercicio;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
        if (ficha != null && ficha.getId() != null) {
            listExecucao = mb.getFindByFicha(ficha.getId());
        } else {
            listExecucao = new ArrayList<>();
        }
    }

    public GrupoMuscular getGrupo() {
        if (execucaoSelecionado != null && execucaoSelecionado.getExercicio() != null && execucaoSelecionado.getExercicio().getGrupo() != null) {
            ExercicioController ex = new ExercicioController();
            listExercicio = ex.findByGrupo(execucaoSelecionado.getExercicio().getGrupo().getId());
            return execucaoSelecionado.getExercicio().getGrupo();
        } else {
            if (grupo == null || grupo.getId() == null) {
                listExercicio = new ArrayList<>();
            }
            return grupo;
        }
    }

    public void setGrupo(GrupoMuscular grupo) {
        this.grupo = grupo;
    }

    public Exercicio getExercicio() {
        if (execucaoSelecionado != null && execucaoSelecionado.getExercicio() != null && execucaoSelecionado.getExercicio().getId() != null) {
            if (execucaoSelecionado.getExercicio().getGrupo() != null) {
                ExercicioController ex = new ExercicioController();
                listExercicio = ex.findByGrupo(execucaoSelecionado.getExercicio().getGrupo().getId());
            }
            exercicio = execucaoSelecionado.getExercicio();
        }
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public void atualizaListaExecucao() {
        listExecucao = mb.getFindByFicha(getFicha().getId());
    }

    public String abrir(Ficha ficha) {
        this.fichaStatic = ficha;
        listExecucao = mb.getFindByFicha(ficha.getId());
        return "execucaoListar.xhtml";
    }

    public void atualizaCombo(AjaxBehaviorEvent event) {
        try {
            UIInput input = (UIInput) event.getComponent();
            GrupoMuscular grupo = (GrupoMuscular) input.getValue();
            ExercicioController exController = new ExercicioController();
            listExercicio = exController.findByGrupo(grupo.getId());
        } catch (Exception e) {
            listExercicio = new ArrayList<>();
        }
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
        if (execucaoSelecionado.getFicha() == null) {
            execucaoSelecionado.setFicha(ficha);
        }
        execucaoSelecionado.setExercicio(exercicio);
        if (execucaoSelecionado.getId() == null || execucaoSelecionado.getId().equals(0)) {
            save();
        } else {
            update();
        }
        atualizaListaExecucao();
    }

    public void pesquisaExecucaoPorGrupo() {
        if (grupo != null && grupo.getId() != null && !grupo.getId().equals(0)) {
            listExecucao = mb.getFindByGrupo(grupo.getId(), ficha.getId());
        } else {
            listExecucao = mb.getFindByFicha(ficha.getId());
        }
    }
}
