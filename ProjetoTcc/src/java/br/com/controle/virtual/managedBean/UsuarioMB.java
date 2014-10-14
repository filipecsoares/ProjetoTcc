package br.com.controle.virtual.managedBean;

import br.com.controle.virtual.dao.UsuarioDAO;
import br.com.controle.virtual.entity.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author filipe_soares
 */
@ManagedBean
@SessionScoped
public class UsuarioMB {

    private UsuarioDAO dao;

    public UsuarioMB() {
        dao = new UsuarioDAO();
    }

    public Usuario save(Usuario usuario) {
        usuario = dao.save(usuario);
        return usuario;
    }

    public Usuario update(Usuario usuario) {
        usuario = dao.update(usuario);
        return usuario;
    }

    public List<Usuario> getListFind() {
        List<Usuario> lista = dao.findAll();
        return lista;
    }
}
