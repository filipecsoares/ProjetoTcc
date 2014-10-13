package br.com.controle.virtual.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SuppressWarnings("unchecked")
public class GenericDAO<PK, T> {

    private EntityManager entityManager;
    private EntityManagerFactory factory;

    public GenericDAO() {
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
    }

    public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }

    public T save(T entity) {
        entity = entityManager.merge(entity);
        transaction();
        return entity;
    }

    public T update(T entity) {
        entity = entityManager.merge(entity);
        transaction();
        return entity;
    }

    public void delete(T entity) {
        entityManager.remove(entity);
        transaction();
    }

    public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }

    private void transaction() {
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        factory.close();
    }
}
