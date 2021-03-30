package com.entities;

import java.util.*;

/** Класс сессии решения теста.
 * Содержит время начала и конца тестирования, данные студента, ответы на вопросы.  */
public class Session {
    private Date startDate;
    private Date finishDate;
    private String name;
    private String group;
    private List<String> answers; //question num in test: chosen answer
    private List<Long> questions; //question num in test: id in DB
    //private Integer numberOfQuestions;

    public Session(String name, String group) {
        startDate = Calendar.getInstance().getTime();
        answers = new ArrayList<>();
        questions = new ArrayList<>();

        this.name = name;
        this.group = group;
    }

    /** Завершает сессию и фиксирует время сдачи. */
    public void finish() {
        finishDate = Calendar.getInstance().getTime();
    }
}
