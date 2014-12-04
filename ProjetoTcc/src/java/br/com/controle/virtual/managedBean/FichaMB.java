package br.com.controle.virtual.managedBean;

import br.com.controle.virtual.dao.FichaDAO;
import br.com.controle.virtual.entity.Ficha;
import java.util.List;

public class FichaMB {

    private FichaDAO dao;

    public FichaMB() {
        dao = new FichaDAO();
    }

    public Ficha save(Ficha ficha) {
        ficha = dao.save(ficha);
        return ficha;
    }

    public Ficha update(Ficha ficha) {
        ficha = dao.update(ficha);
        return ficha;
    }

    public List<Ficha> getListFind() {
        List<Ficha> lista = dao.findAll();
        return lista;
    }

    public List<Ficha> getFind(String nome) {
        List<Ficha> lista = dao.find(nome);
        return lista;
    }

    public List<Ficha> getFind(Integer fkUsuario) {
        List<Ficha> lista = dao.find(fkUsuario);
        return lista;
    }

    public List<Ficha> getFindComplete(String nome) {
        List<Ficha> lista = dao.findComplete(nome);
        return lista;
    }

    public void delete(Ficha ficha) {
        dao.delete(ficha);
    }
}
