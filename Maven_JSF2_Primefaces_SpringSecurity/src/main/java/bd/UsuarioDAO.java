package bd;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioDAO implements UserDetailsService{
    

    @Override
    public Usuario loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = new Usuario();
                
        if (login != null && login.equals("admin"))
        {
            usuario.setLogin("admin");
            usuario.setSenha("admin");
            usuario.setRoles(new ArrayList<Role>());
            Role role = new Role();
            role.setNome("ROLE_ADMIN");
            usuario.getRoles().add(role);
        }
        else if (login != null && login.equals("user"))
        {
            usuario.setLogin("user");
            usuario.setSenha("user");
            usuario.setRoles(new ArrayList<Role>());
            Role role = new Role();
            role.setNome("ROLE_USER");
            usuario.getRoles().add(role);
        }
        else
        {
            throw  new UsernameNotFoundException("Usuário não encontrado!");
        }
        return usuario;
    }
}
