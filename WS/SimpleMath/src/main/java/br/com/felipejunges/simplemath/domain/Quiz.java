package br.com.felipejunges.simplemath.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Quiz implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private boolean unactive;

    @OneToMany(mappedBy="quiz")
    private List<Answer> answers = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="QUIZ_QUESTION",
            joinColumns= @JoinColumn(name="quiz_id"),
            inverseJoinColumns = @JoinColumn(name="question_ids")
    )
    private List<Question> questions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="user_id")
    private Usuario user;

    public Quiz() {
    }

    public Quiz(int id) {
        this.id = id;
    }

    public Quiz(boolean unactive, Usuario user) {
        this.unactive = unactive;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isUnactive() {
        return unactive;
    }

    public void setUnactive(boolean unactive) {
        this.unactive = unactive;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
