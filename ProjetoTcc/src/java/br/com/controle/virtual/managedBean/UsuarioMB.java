package br.com.controle.virtual.managedBean;

import br.com.controle.virtual.dao.UsuarioDAO;
import br.com.controle.virtual.entity.Usuario;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author filipe_soares
 */
@ManagedBean
public class UsuarioMB {

    public UsuarioMB() {
    }

    public Usuario save(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO();
        usuario = dao.save(usuario);
        return usuario;
    }
    
    public Usuario update(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO();
        usuario = dao.update(usuario);
        return usuario;
    }
}
