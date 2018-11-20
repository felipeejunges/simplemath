package br.com.felipejunges.simplemath.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String description;
    private boolean unactive;
    private long maxtime;

    @JsonIgnore
    @OneToMany(mappedBy="question")
    private List<Alternative> alternatives = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy="questions")
    private List<Quiz> quizzes = new ArrayList<>();

    public Question() {
    }

    public Question(String description, boolean unactive, long maxtime) {
        this.description = description;
        this.unactive = unactive;
        this.maxtime = maxtime;
    }

    public Question(UUID id, String description, long maxtime, List<Alternative> alternatives) {
        this.id = id;
        this.description = description;
        this.maxtime = maxtime;
        this.alternatives = alternatives;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isUnactive() {
        return unactive;
    }

    public void setUnactive(boolean unactive) {
        this.unactive = unactive;
    }

    public long getMaxtime() {
        return maxtime;
    }

    public void setMaxtime(long maxtime) {
        this.maxtime = maxtime;
    }

    public List<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
