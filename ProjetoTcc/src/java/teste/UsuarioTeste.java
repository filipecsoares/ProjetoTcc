package teste;

import br.com.controle.virtual.entity.Usuario;
import br.com.controle.virtual.managedBean.UsuarioMB;
import java.util.Calendar;
import java.util.Date;

public class UsuarioTeste {
    public static void main(String[] args) {
        Usuario u = new Usuario();
        u.setCpf("17");
        u.setNome("17");
        u.setDtNascimento(new Date());
        u.setLogin("97");
        u.setSenha("97");
        
        UsuarioMB mb = new UsuarioMB();
        u = mb.update(u);
        System.out.println(u.getId());
    }
}
