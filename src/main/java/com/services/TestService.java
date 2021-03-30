package com.services;

import com.serializable.Student;
import com.entities.Session;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/** Сервис с логикой для выдачи вопросов и обработки ответов. */
@Component
public class TestService {
    private List<Session> currentSessions;

    public TestService() {
        currentSessions = new ArrayList<>();
    }

    /** Запускает новую сессию для студента. */
    public void startTestSession(Student student) {
        currentSessions.add(new Session(student.getName(), student.getGroup()));
    }

    public String getQuestionPage(Integer pageNum) {
        return "test";
    }

    public void addAnswer(int questionNum, String answer) {

    }
}
