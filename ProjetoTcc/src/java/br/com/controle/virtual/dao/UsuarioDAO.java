package br.com.controle.virtual.dao;

import br.com.controle.virtual.entity.Usuario;
import javax.persistence.EntityManager;

public class UsuarioDAO extends GenericDAO<Long, Usuario> {

    public UsuarioDAO(EntityManager entityManaged) {
        super(entityManaged);
    }
}
