package br.com.controle.virtual.managedBean;

import br.com.controle.virtual.dao.UsuarioDAO;
import br.com.controle.virtual.entity.Usuario;
import java.util.List;

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
    
    public List<Usuario> getFind(String nome) {
        List<Usuario> lista = dao.find(nome);
        return lista;
    }
}
