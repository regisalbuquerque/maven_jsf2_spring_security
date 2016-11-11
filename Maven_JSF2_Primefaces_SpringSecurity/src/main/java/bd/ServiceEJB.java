package bd;

import javax.ejb.Stateless;

@Stateless
public class ServiceEJB {
    public String nomeCampo()
    {
        return "Usuário: ";
    }
}
