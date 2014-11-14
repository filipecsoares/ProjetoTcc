package br.com.controle.virtual.managedBean;

import br.com.controle.virtual.dao.ExecucaoDAO;
import br.com.controle.virtual.entity.Execucao;
import java.util.List;

public class ExecucaoMB {

    private ExecucaoDAO dao;

    public ExecucaoMB() {
        dao = new ExecucaoDAO();
    }

    public Execucao save(Execucao execucao) {
        execucao = dao.save(execucao);
        return execucao;
    }

    public Execucao update(Execucao execucao) {
        execucao = dao.update(execucao);
        return execucao;
    }

    public List<Execucao> getListFind() {
        List<Execucao> lista = dao.findAll();
        return lista;
    }

    public List<Execucao> getFind(String nome) {
        List<Execucao> lista = dao.find(nome);
        return lista;
    }
    
    public List<Execucao> getFindByFicha(Integer fkFicha) {
        List<Execucao> lista = dao.findByFicha(fkFicha);
        return lista;
    }

    public void delete(Execucao execucao) {
        dao.delete(execucao);
    }
}
