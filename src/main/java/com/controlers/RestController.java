package com.controlers;

import com.entities.Question;
import com.entities.Session;
import com.serializable.Student;
import com.services.DBService;
import com.services.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private TestService service;
    private DBService dbService;
    private Integer currentPage; //starts with 0

    public RestController(TestService service) {
        this.service = service;
    }

    /**
     * Функция принимает вопрос и  добавляет его в БД
     * @param question
     * @return Question с id
     */
    @PostMapping("/library")
    public ResponseEntity<Question> addQuestionToDB(@RequestBody Question question) {
        try {
            return ResponseEntity.ok().body(dbService.addQuestion(question));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Получить следующий вопрос.
     * Принимает в параметрах запроса страницу вопроса и ответ на предыдущий вопрос
     * @return Возвращает JSON с запрошенным вопросом*/
    @GetMapping("/test")
    public ResponseEntity<Question> getQuestion(@RequestParam(required = false, name = "page") Integer askQuestionNum,
        @RequestParam(required = false) String answer) {
        if (answer != null) {
            service.addAnswer(currentPage, answer);
        }
        if (askQuestionNum != null) {
            currentPage = askQuestionNum - 1; //cause we re not yet on requested page
        }
        try {
            return ResponseEntity.ok(service.getQuestion(++currentPage)); //forms html doc with question
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Начать решение теста.
     * Принимает JSON файл с именем и группой студента
     * Возвращает статус сессии теста*/
    @PostMapping("/start")
    public ResponseEntity<String> startTest(@RequestBody Student student) { //returns String status
        service.startTestSession(student);
        currentPage = 0;
        return ResponseEntity.accepted().body("Test started");
    }

    /**
     * Заканчивает сессию
     * @return Session с finishDate
     */
    @PostMapping("/finish")
    public  ResponseEntity<Session> finishTest() {
        return ResponseEntity.ok(service.finishTestSession());
    }
}
