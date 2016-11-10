package bd;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.springframework.security.core.context.SecurityContextHolder;

@Named
@RequestScoped
public class LoggedBean {
    
    public String getUser()
    {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
}
