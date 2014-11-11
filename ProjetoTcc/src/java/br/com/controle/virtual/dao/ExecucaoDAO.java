package br.com.controle.virtual.dao;

import br.com.controle.virtual.entity.Execucao;
import javax.persistence.Persistence;

public class ExecucaoDAO extends GenericDAO<Long, Execucao> {

    @Override
    public void delete(Execucao execucao) {
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        execucao = entityManager.getReference(Execucao.class, execucao.getId());
        super.delete(execucao);
    }
}
