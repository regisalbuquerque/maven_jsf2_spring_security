package bd;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.security.core.context.SecurityContextHolder;

@Named
@RequestScoped
public class LoggedBean {
    
    @Inject
    ServiceEJB service;
    
    public String getUser()
    {
        return service.nomeCampo() + SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
}
