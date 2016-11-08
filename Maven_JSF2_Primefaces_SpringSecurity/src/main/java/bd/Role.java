
package bd;

import org.springframework.security.core.GrantedAuthority;

class Role implements GrantedAuthority{
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return this.nome;
    }
    
    
}
