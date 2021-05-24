package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Answer {
    @Id
    @GeneratedValue
    private Long id;
    private String answer;

    public Answer(Long id, String answer) {
        this.id = id;
        this.answer = answer;
    }
}
