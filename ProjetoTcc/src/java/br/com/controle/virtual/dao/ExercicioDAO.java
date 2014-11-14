package br.com.controle.virtual.dao;

import br.com.controle.virtual.entity.Exercicio;
import java.util.List;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ExercicioDAO extends GenericDAO<Long, Exercicio> {

    @Override
    public void delete(Exercicio exercicio) {
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        exercicio = entityManager.getReference(Exercicio.class, exercicio.getId());
        super.delete(exercicio);
    }

    public List<Exercicio> findByGrupo(Integer fkGrupo) {
        List<Exercicio> list;
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        Session session = (Session) entityManager.getDelegate();
        list = session.createCriteria(Exercicio.class).add(Restrictions.eq("grupo.id", fkGrupo)).list();
        entityManager.close();
        factory.close();
        return list;
    }
}
