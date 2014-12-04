package br.com.controle.virtual.dao;

import br.com.controle.virtual.entity.Execucao;
import java.util.List;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ExecucaoDAO extends GenericDAO<Long, Execucao> {

    @Override
    public void delete(Execucao execucao) {
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        execucao = entityManager.getReference(Execucao.class, execucao.getId());
        super.delete(execucao);
    }

    public List<Execucao> findByFicha(Integer fkFicha) {
        List<Execucao> list;
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        Session session = (Session) entityManager.getDelegate();
        list = session.createCriteria(Execucao.class).add(Restrictions.eq("ficha.id", fkFicha)).list();
        entityManager.close();
        factory.close();
        return list;
    }

    public List<Execucao> findByGrupo(Integer fkGrupo, Integer fkFicha) {
        List<Execucao> list;
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        Session session = (Session) entityManager.getDelegate();
        list = session.createCriteria(Execucao.class)
                .createAlias("exercicio", "exercicio")
                .createAlias("exercicio.grupo", "exercicio.grupo")
                .add(Restrictions.and(Restrictions.eq("exercicio.grupo.id", fkGrupo), Restrictions.eq("ficha.id", fkFicha))).list();
        entityManager.close();
        factory.close();
        return list;
    }
}
