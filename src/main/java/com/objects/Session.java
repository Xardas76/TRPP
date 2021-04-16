package com.objects;

import com.DBentities.Question;

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

    public Session(String name, String group, Integer numberOfQuestions) {
        startDate = Calendar.getInstance().getTime();
        answers = new ArrayList<>(numberOfQuestions);
        questions = new ArrayList<>(numberOfQuestions);

        this.name = name;
        this.group = group;
    }

    /** Завершает сессию и фиксирует время сдачи. */
    public void finish() {
        finishDate = Calendar.getInstance().getTime();
    }

    public void addAnswer(Integer qNum, String answer) {
        answers.add(qNum-1, answer);
    }

    public void setQuestions(List<Long> questions) {
        this.questions = questions;
    }

    public Long getQuestion(int qNum) {
        return questions.get(qNum-1);
    }
}
