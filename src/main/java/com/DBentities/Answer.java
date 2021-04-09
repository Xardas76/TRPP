package com.DBentities;

import javax.persistence.Entity;

@Entity
public class Answer {
    private Long id;
    private String answer;

    public Answer(Long id, String answer) {
        this.id = id;
        this.answer = answer;
    }
}
