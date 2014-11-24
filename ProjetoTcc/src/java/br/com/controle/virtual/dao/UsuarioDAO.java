package br.com.controle.virtual.dao;

import br.com.controle.virtual.entity.Usuario;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsuarioDAO extends GenericDAO<Long, Usuario> {

    @Override
    public void delete(Usuario usuario) {
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        usuario = entityManager.getReference(Usuario.class, usuario.getId());
        super.delete(usuario);
    }

    public Usuario getFindLoginSenha(String login, String senha) {
        try {
            factory = Persistence.createEntityManagerFactory("controlevirtual");
            entityManager = factory.createEntityManager();
            Query query = entityManager.createQuery("select c from Usuario c where c.login = :login AND c.senha = :senha", Usuario.class);
            query.setParameter("login", login);
            query.setParameter("senha", senha);
            return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
