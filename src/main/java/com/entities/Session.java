package com.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Session {
    private Date startDate;
    private Date finishDate;
    private String name;
    private String group;
    private Map<Long, String> answers; //question id: chosen answer
    private Integer questionsNumber;

    public Session(String name, String group) {
        startDate = Calendar.getInstance().getTime();
        questionsNumber = 10;
        answers = new HashMap<>();
        
        this.name = name;
        this.group = group;
    }

    public void finish() {
        finishDate = Calendar.getInstance().getTime();
    }
}
