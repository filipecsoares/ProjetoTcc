package br.com.controle.virtual.dao;

import br.com.controle.virtual.entity.Ficha;
import javax.persistence.Persistence;

public class FichaDAO extends GenericDAO<Long, Ficha> {

    @Override
    public void delete(Ficha ficha) {
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        ficha = entityManager.getReference(Ficha.class, ficha.getId());
        super.delete(ficha);
    }
}
