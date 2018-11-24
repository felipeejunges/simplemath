package br.com.felipejunges.simplemath.domain;

import br.com.felipejunges.simplemath.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique=true)
    private String email;
    @Column(unique=true)
    private String celphoneNumber;
    @JsonIgnore
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    List<Quiz> quizzes = new ArrayList<>();

    @JsonIgnore
    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    public Usuario(){
    }

    public Usuario(int id){
        this.id = id;
    }

    public Usuario(String name, String email, String celphoneNumber, String password) {
        this.name = name;
        this.email = email;
        this.celphoneNumber = celphoneNumber;
        this.password = password;
    }

    public Usuario(int id, String name, String email, String celphoneNumber, String password) {
        super();
        this.id = id;
        this.name = name;
        this.celphoneNumber = celphoneNumber;
        this.email = email;
        this.password = password;
        addPerfil(Perfil.CLIENTE);
    }

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil.getCod());
    }
}

