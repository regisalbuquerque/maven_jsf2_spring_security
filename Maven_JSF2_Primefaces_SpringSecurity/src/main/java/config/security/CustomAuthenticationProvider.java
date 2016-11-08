package config.security;

import bd.Usuario;
import bd.UsuarioDAO;
import java.util.Collection;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        Usuario usuario = usuarioDAO.loadUserByUsername(name);
        
        if (usuario == null || !usuario.getUsername().equalsIgnoreCase(name))
        {
            throw new BadCredentialsException("Username not found");
            
        }
        
        if (!password.equals(usuario.getPassword()))
        {
            throw  new BadCredentialsException("Wrong password");
        }
        
        Collection<? extends GrantedAuthority> authorities = usuario.getAuthorities();
        
        return new UsernamePasswordAuthenticationToken(usuario, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
