package br.com.controle.virtual.dao;

import br.com.controle.virtual.entity.Usuario;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("unchecked")
public class GenericDAO<PK, T> {

    protected EntityManager entityManager;
    protected EntityManagerFactory factory;

    public GenericDAO() {
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
    }

    public T getById(PK pk) {
        T entity;
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entity = (T) entityManager.find(getTypeClass(), pk);
        entityManager.close();
        factory.close();
        return entity;
    }

    public T save(T entity) {
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
        return entity;
    }

    public T update(T entity) {
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
        return entity;
    }

    public void delete(T entity) {
        entityManager.remove(entity);
        transaction();
    }

    public List<T> findAll() {
        List<T> list;
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        list = entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
        entityManager.close();
        factory.close();
        return list;
    }

    public List<T> find(String nome) {
        List<T> list;
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        Session session = (Session) entityManager.getDelegate();
        list = session.createCriteria(Usuario.class).add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE)).list();
        entityManager.close();
        factory.close();
        return list;
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
