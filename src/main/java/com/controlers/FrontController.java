package com.controlers;

import com.serializable.Student;
import com.services.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/** Контроллер для работы с тестом*/
@Controller
public class FrontController {
    private TestService service;

    private int currentQuestion;

    public FrontController(TestService service) {
        this.service = service;
    }

    /** Возвращает начальную страницу. */
    @RequestMapping("/")
    public String greeting(){
        System.out.println("Hello in console");
        return "index";
    }

    /**
     * Начать решение теста.
     * Принимает JSON файл с именем и группой студента
     * Возвращает страницу с первым вопросом*/
    @PostMapping("/start")
    public String startTest(@RequestBody Student student) { //returns HTML testPage
        service.startTestSession(student);
        currentQuestion = 0;
        return getQuestion(null, null);
    }

    /**
     * Получить следующий вопрос.
     * Принимает JSON в параметрах запроса страницу вопроса и ответ на предыдущий вопрос
     * Возвращает страницу с запрошенным вопросом*/
    @GetMapping("/test")
    public String getQuestion(@RequestParam(required = false, name = "page") Integer askQuestionNum,
                               @RequestParam(required = false) String answer) {
        if (answer != null) {
            service.addAnswer(currentQuestion, answer);
        }
        if (askQuestionNum != null) {
            currentQuestion = askQuestionNum - 1;
        }
        try {
            return service.getQuestionPage(++currentQuestion); //forms html doc with question
        } catch (IOException e) {
            return "Error occurred";
        }
    }
}
