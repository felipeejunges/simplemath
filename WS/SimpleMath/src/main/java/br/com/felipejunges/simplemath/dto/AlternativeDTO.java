package br.com.felipejunges.simplemath.dto;

import br.com.felipejunges.simplemath.domain.Alternative;

import java.io.Serializable;

public class AlternativeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String answer;
    private boolean correct;
    private boolean unactive;

    public AlternativeDTO() {

    }

    public AlternativeDTO(Alternative alternative) {
        this.id = alternative.getId();
        this.answer = alternative.getAnswer();
        this.correct = alternative.isCorrect();
        this.unactive = alternative.isUnactive();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isUnactive() {
        return unactive;
    }

    public void setUnactive(boolean unactive) {
        this.unactive = unactive;
    }
}
