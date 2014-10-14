package br.com.controle.virtual.controller;

import br.com.controle.virtual.entity.Usuario;
import br.com.controle.virtual.managedBean.UsuarioMB;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.SessionScoped;

@SessionScoped
public class UsuarioController implements Serializable {

    private UsuarioMB mb;

    public UsuarioController() {
        mb = new UsuarioMB();
    }

    public List<Usuario> getListUsuario() {
        System.out.println("É:" + mb.getListFind());
        return mb.getListFind();
    }
}
