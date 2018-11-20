package br.com.felipejunges.simplemath.dto;

import br.com.felipejunges.simplemath.domain.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UsuarioNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=1, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String name;
    @NotEmpty(message="Preenchimento obrigatório")
    @Email(message="Email inválido")
    private String email;
    @NotEmpty(message="Preenchimento obrigatório")
    private String celphoneNumber;
    @NotEmpty(message="Preenchimento obrigatório")
    private String password;

    public UsuarioNewDTO(){

    }

    public UsuarioNewDTO(Usuario obj) {
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.celphoneNumber = obj.getCelphoneNumber();
        this.password = obj.getPassword();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelphoneNumber() {
        return celphoneNumber;
    }

    public void setCelphoneNumber(String celphoneNumber) {
        this.celphoneNumber = celphoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
