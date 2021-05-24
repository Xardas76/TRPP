package com.services;

import com.entities.Question;
import com.repositories.QuestionRepository;
import org.springframework.stereotype.Component;

@Component
public class DBService {
    private QuestionRepository allQuestions;

    public Question addQuestion(Question question) {
        return allQuestions.save(question);
    }
}
