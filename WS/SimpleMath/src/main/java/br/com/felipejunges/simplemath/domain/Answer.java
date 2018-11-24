package br.com.felipejunges.simplemath.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private boolean unactive;
    private long time;

    @ManyToOne
    @JoinColumn(name="alternative_id")
    private Alternative alternative;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="quiz_id")
    private Quiz quiz;

    //private Question question;


    public Answer() {
    }

    public Answer(int id, long time, Alternative alternative) {
        this.id = id;
        this.time = time;
        this.alternative = alternative;
    }


    public Answer(int id, long time, Alternative alternative, Quiz quiz) {
        this.id = id;
        this.time = time;
        this.alternative = alternative;
        this.quiz = quiz;
    }

    public Answer(boolean unactive, long time, Alternative alternative, Quiz quiz) {
        this.unactive = unactive;
        this.time = time;
        this.alternative = alternative;
        this.quiz = quiz;
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
