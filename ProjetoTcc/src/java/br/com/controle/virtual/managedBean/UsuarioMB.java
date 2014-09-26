package br.com.controle.virtual.managedBean;

import br.com.controle.virtual.entity.Usuario;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author filipe_soares
 */
@ManagedBean
public class UsuarioMB {

    private Usuario bean;

    public UsuarioMB() {
        bean = new Usuario();
    }

    public Usuario getBean() {
        return bean;
    }

    public void setBean(Usuario bean) {
        this.bean = bean;
    }

    public Usuario save() {
        bean.setNome(bean.getNome() + " Soares");
        return bean;
    }
}
