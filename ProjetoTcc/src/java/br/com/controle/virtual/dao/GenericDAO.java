package br.com.controle.virtual.dao;

import br.com.controle.virtual.entity.Usuario;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
        entityManager.getTransaction().begin();
        System.out.println(entityManager.getTransaction().isActive());
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
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

    public List<T> find(String nome) {
        Session session = (Session) entityManager.getDelegate();
        return session.createCriteria(Usuario.class).add(Restrictions.eq("nome", nome)).list();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }

    private void transaction() {
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
}
