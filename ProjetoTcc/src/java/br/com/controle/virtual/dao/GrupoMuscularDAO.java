package br.com.controle.virtual.dao;

import br.com.controle.virtual.entity.GrupoMuscular;
import javax.persistence.Persistence;

public class GrupoMuscularDAO extends GenericDAO<Long, GrupoMuscular> {

    @Override
    public void delete(GrupoMuscular grupo) {
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        grupo = entityManager.getReference(GrupoMuscular.class, grupo.getId());
        super.delete(grupo);
    }
}
