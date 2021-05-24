package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@SuppressWarnings("unused")
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    private String text;
    private String type;
    @OneToMany
    private String[] options;

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getText() {
        return text;
    }
}
