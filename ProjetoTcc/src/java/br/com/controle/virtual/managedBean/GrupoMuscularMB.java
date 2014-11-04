package br.com.controle.virtual.managedBean;

import br.com.controle.virtual.dao.GrupoMuscularDAO;
import br.com.controle.virtual.entity.GrupoMuscular;
import java.util.List;

public class GrupoMuscularMB {
    
    private final GrupoMuscularDAO dao;
    
    public GrupoMuscularMB() {
        dao = new GrupoMuscularDAO();
    }
    
    public GrupoMuscular save(GrupoMuscular grupo) {
        grupo = dao.save(grupo);
        return grupo;
    }
    
    public GrupoMuscular update(GrupoMuscular grupo) {
        grupo = dao.update(grupo);
        return grupo;
    }
    
    public List<GrupoMuscular> getListFind() {
        List<GrupoMuscular> lista = dao.findAll();
        return lista;
    }
    
    public List<GrupoMuscular> getFind(String nome) {
        List<GrupoMuscular> lista = dao.find(nome);
        return lista;
    }
    
    public void delete(GrupoMuscular grupo){
        dao.delete(grupo);
    }   
}
