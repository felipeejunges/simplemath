package br.com.felipejunges.simplemath.dto;

import br.com.felipejunges.simplemath.domain.Question;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class QuestionNewDTO implements Serializable {
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
    

    public QuestionNewDTO(){

    }

    public QuestionNewDTO(Question question) {
        this.question = question.getDescription();
        this.a = question.getAlternatives().get(0).getAnswer();
        this.b = question.getAlternatives().get(1).getAnswer();
        this.c = question.getAlternatives().get(2).getAnswer();
        this.d = question.getAlternatives().get(3).getAnswer();
        this.e = question.getAlternatives().get(4).getAnswer();
        for(int i = 0; i < 5; i++) {
            if(question.getAlternatives().get(i).isCorrect()) {
                this.correct = i + 1;
                break;
            }
        }
        this.maxtime = question.getMaxtime();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public long getMaxtime() {
        return maxtime;
    }

    public void setMaxtime(long maxtime) {
        this.maxtime = maxtime;
    }
}
