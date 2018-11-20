package br.com.felipejunges.simplemath.dto;

import br.com.felipejunges.simplemath.domain.Alternative;
import br.com.felipejunges.simplemath.domain.Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuestionDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String description;
    private boolean unactive;
    private long maxtime;
    private List<AlternativeDTO> alternativeDTOs = new ArrayList<>();

    public QuestionDTO(){

    }

    public QuestionDTO(Question question) {
        this.id = question.getId();
        this.description = question.getDescription();
        this.unactive = question.isUnactive();
        this.maxtime = question.getMaxtime();
        getAlternativesToAlternativeDto(question.getAlternatives());
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

    public List<AlternativeDTO> getAlternativeDTOs() {
        return alternativeDTOs;
    }

    public void setAlternativeDTOs(List<AlternativeDTO> alternativeDTOs) {
        this.alternativeDTOs = alternativeDTOs;
    }

    private void getAlternativesToAlternativeDto(List<Alternative> alternatives) {
        for (Alternative alternative : alternatives) {
            alternativeDTOs.add(new AlternativeDTO(alternative));
        }
    }
}
