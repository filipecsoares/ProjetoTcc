package teste;

import br.com.controle.virtual.entity.Usuario;
import br.com.controle.virtual.managedBean.UsuarioMB;
import java.util.Calendar;

public class UsuarioTeste {
    public static void main(String[] args) {
        Usuario u = new Usuario();
        u.setId(1);
        u.setCpf("333777");
        u.setNome("333777");
        u.setDtNascimento(Calendar.getInstance());
        u.setLogin("222");
        u.setSenha("222");
        
        UsuarioMB mb = new UsuarioMB();
        u = mb.update(u);
        System.out.println(u.getId());
    }
}
