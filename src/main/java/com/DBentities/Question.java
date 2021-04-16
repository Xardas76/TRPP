package com.DBentities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@SuppressWarnings("unused")
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    private String text;
    private String type;
    private String[] options;
}
