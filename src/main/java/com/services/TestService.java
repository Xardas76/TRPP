package com.services;

import com.entities.Question;
import com.repositories.QuestionRepository;
import com.repositories.SessionRepository;
import com.serializable.Student;
import com.entities.Session;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/** Сервис с логикой для выдачи вопросов и обработки ответов. */
@Component
public class TestService {
    public final static int TEST_LENGTH = 10;
    private Session currentSession;
    private QuestionRepository allQuestions;
    private SessionRepository allSessions;

    /** Запускает новую сессию для студента. */
    public void startTestSession(Student student) {
        currentSession = new Session(student.getName(), student.getGroup(), TEST_LENGTH);

        Long NUMBER_OF_ALL_QUESTIONS = 10L; //!! Get num from DB !!
        Set<Long> generated = new LinkedHashSet<>();
        while (generated.size() < TEST_LENGTH)
        {
            Long next = ThreadLocalRandom.current().nextLong(NUMBER_OF_ALL_QUESTIONS) + 1;
            // As we're adding to a set, this will automatically do a containment check
            generated.add(next);
        }
        currentSession.setQuestions(new ArrayList<>(generated));
    }

    /** Возвращает страну с вопросом. */
    public Question getQuestion(Integer pageNum) throws IOException {
        Long questId = currentSession.getQuestion(pageNum);
        return allQuestions.getOne(questId);
    }

    public void addAnswer(int questionNum, String answer) {
        currentSession.addAnswer(questionNum, answer);
    }

    public Session finishTestSession() {
        currentSession.finish();
        return allSessions.save(currentSession);
    }
}
