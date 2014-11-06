package br.com.controle.virtual.managedBean;

import br.com.controle.virtual.dao.ExercicioDAO;
import br.com.controle.virtual.entity.Exercicio;
import java.util.List;

public class ExercicioMB {
    
    private final ExercicioDAO dao;
    
    public ExercicioMB() {
        dao = new ExercicioDAO();
    }
    
    public Exercicio save(Exercicio exercicio) {
        exercicio = dao.save(exercicio);
        return exercicio;
    }
    
    public Exercicio update(Exercicio exercicio) {
        exercicio = dao.update(exercicio);
        return exercicio;
    }
    
    public List<Exercicio> getListFind() {
        List<Exercicio> lista = dao.findAll();
        return lista;
    }
    
    public List<Exercicio> getFind(String nome) {
        List<Exercicio> lista = dao.find(nome);
        return lista;
    }
    
    public void delete(Exercicio exercicio){
        dao.delete(exercicio);
    }   
}
