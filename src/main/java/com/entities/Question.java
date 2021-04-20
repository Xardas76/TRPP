package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@SuppressWarnings("unused")
public class Question {
    @GeneratedValue
    @Id
    private Long id;
    private String text;
    private String type;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
}
