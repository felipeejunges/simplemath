package br.com.felipejunges.simplemath.dto;

import br.com.felipejunges.simplemath.domain.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UsuarioNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message="Preenchimento obrigatório")
    private String question;
    @NotEmpty(message="Preenchimento obrigatório")
    private String a;
    @NotEmpty(message="Preenchimento obrigatório")
    private String b;
    @NotEmpty(message="Preenchimento obrigatório")
    private String c;
    @NotEmpty(message="Preenchimento obrigatório")
    private String d;
    @NotEmpty(message="Preenchimento obrigatório")
    private String e;
    @NotEmpty(message="Preenchimento obrigatório")
    private int correct;
    @NotEmpty(message="Preenchimento obrigatório")
    private long maxtime;
    

    public UsuarioNewDTO(){

    }

    public UsuarioNewDTO(Question question) {
        this.question = question.getDescription();
        this.a = question.getAlternatives().get(0).getAnswer();
        this.b = question.getAlternatives().get(1).getAnswer();
        this.c = question.getAlternatives().get(2).getAnswer();
        this.d = question.getAlternatives().get(3).getAnswer();
        this.e = question.getAlternatives().get(4).getAnswer();
        for(i = 0; i < 5; i++) {
            if(question.getAlternatives().get(i).isCorrect()) {
                this.correct = i + 1;
                break;
            }
        }
        this.maxtime = question.getMaxtime();
    }


}
