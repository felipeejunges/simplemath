package br.com.felipejunges.simplemath.dto;

import br.com.felipejunges.simplemath.domain.Answer;
import br.com.felipejunges.simplemath.domain.Quiz;

import java.io.Serializable;
import java.sql.Timestamp;

public class ResumoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long tempo;
    private int erros;
    private int acertos;
    private Timestamp data;

    public ResumoDTO() {
    }

    public ResumoDTO(long tempo, int erros, int acertos, Timestamp data) {
        this.tempo = tempo;
        this.erros = erros;
        this.acertos = acertos;
        this.data = data;
    }

    public ResumoDTO(Quiz quiz) {
        this.tempo = 0;
        this.erros = 0;
        this.acertos = 0;
        this.data = quiz.getData();
        for (Answer answer: quiz.getAnswers()) {
            tempo += answer.getTime();
            if(answer.getAlternative().isCorrect()) acertos += 1;
            else erros += 1;
        }
    }

    public long getTempo() {
        return tempo;
    }

    public void setTempo(long tempo) {
        this.tempo = tempo;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }
}
