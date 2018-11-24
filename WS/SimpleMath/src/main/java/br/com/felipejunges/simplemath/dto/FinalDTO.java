package br.com.felipejunges.simplemath.dto;

import br.com.felipejunges.simplemath.domain.Answer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FinalDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long tempoTotal;
    private long tempoMedio;
    private long tempoEsperado;
    private List<Answer> answer = new ArrayList<>();

    public FinalDTO() {
    }

    public FinalDTO(long tempoTotal, long tempoMedio, long tempoEsperado) {
        this.tempoTotal = tempoTotal;
        this.tempoMedio = tempoMedio;
        this.tempoEsperado = tempoEsperado;
    }

    public long getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(long tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    public long getTempoMedio() {
        return tempoMedio;
    }

    public void setTempoMedio(long tempoMedio) {
        this.tempoMedio = tempoMedio;
    }

    public long getTempoEsperado() {
        return tempoEsperado;
    }

    public void setTempoEsperado(long tempoEsperado) {
        this.tempoEsperado = tempoEsperado;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }
}
