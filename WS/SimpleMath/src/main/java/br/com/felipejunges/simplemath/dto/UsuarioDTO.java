package br.com.felipejunges.simplemath.dto;

import br.com.felipejunges.simplemath.domain.Usuario;

import java.io.Serializable;
import java.util.UUID;

public class UsuarioDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private String email;
    private String celphoneNumber;

    public UsuarioDTO(){

    }

    public UsuarioDTO(Usuario obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
}
