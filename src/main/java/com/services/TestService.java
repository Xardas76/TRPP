package com.services;

import com.repositories.QuestionRepository;
import com.serializable.Student;
import com.objects.Session;
import org.springframework.stereotype.Component;

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

    /** Запускает новую сессию для студента. */
    public void startTestSession(Student student) {
        currentSession = new Session(student.getName(), student.getGroup(), TEST_LENGTH);

        Long NUMBER_OF_QUESTIONS = 10L; //!! Get num from DB !!
        Set<Long> generated = new LinkedHashSet<>();
        while (generated.size() < TEST_LENGTH)
        {
            Long next = ThreadLocalRandom.current().nextLong(NUMBER_OF_QUESTIONS) + 1;
            // As we're adding to a set, this will automatically do a containment check
            generated.add(next);
        }
        currentSession.setQuestions(new ArrayList<>(generated));
    }

    public String getQuestionPage(Integer pageNum) {
        return "test";
    }

    public void addAnswer(int questionNum, String answer) {
        currentSession.addAnswer(questionNum, answer);
    }
}
