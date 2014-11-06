package br.com.controle.virtual.dao;

import br.com.controle.virtual.entity.Exercicio;
import javax.persistence.Persistence;

public class ExercicioDAO extends GenericDAO<Long, Exercicio> {

    @Override
    public void delete(Exercicio exercicio) {
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        exercicio = entityManager.getReference(Exercicio.class, exercicio.getId());
        super.delete(exercicio);
    }
}
