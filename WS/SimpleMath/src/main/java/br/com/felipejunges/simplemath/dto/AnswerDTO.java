package br.com.felipejunges.simplemath.dto;

import br.com.felipejunges.simplemath.domain.Answer;

import java.io.Serializable;

public class AnswerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private boolean unactive;
    private long time;
    private int alternativeId;

    public AnswerDTO() {

    }

    public AnswerDTO(Answer answer) {
        this.id = answer.getId();
        this.time = answer.getTime();
        this.unactive = answer.isUnactive();
        this.alternativeId = answer.getAlternative().getId();
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

    public int getAlternativeId() {
        return alternativeId;
    }

    public void setAlternativeId(int alternativeId) {
        this.alternativeId = alternativeId;
    }
}
