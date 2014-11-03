package br.com.controle.virtual.dao;

import br.com.controle.virtual.entity.Usuario;
import javax.persistence.Persistence;

public class UsuarioDAO extends GenericDAO<Long, Usuario> {

    @Override
    public void delete(Usuario usuario) {
        factory = Persistence.createEntityManagerFactory("controlevirtual");
        entityManager = factory.createEntityManager();
        usuario = entityManager.getReference(Usuario.class, usuario.getId());
        super.delete(usuario);
    }
}
