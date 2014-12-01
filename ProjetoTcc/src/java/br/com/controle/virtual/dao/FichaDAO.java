package br.com.controle.virtual.dao;

import br.com.controle.virtual.entity.Ficha;
import java.util.List;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class FichaDAO extends GenericDAO<Long, Ficha> {

    @Override
    public void delete(Ficha ficha) {
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        ficha = entityManager.getReference(Ficha.class, ficha.getId());
        super.delete(ficha);
    }

    public List<Ficha> find(String nome) {
        List<Ficha> list;
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        Session session = (Session) entityManager.getDelegate();
        list = session.createCriteria(Ficha.class).add(Restrictions.ilike("usuario.nome", nome, MatchMode.ANYWHERE)).list();
        entityManager.close();
        factory.close();
        return list;
    }
}
