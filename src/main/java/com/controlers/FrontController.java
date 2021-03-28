package com.controlers;

import com.serializable.Student;
import com.services.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FrontController {
    private TestService service;

    private int currentQuestion;

    public FrontController(TestService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String greeting(){
        System.out.println("Hello in console");
        return "index";
    }

    @PostMapping("/start")
    public String startTest(@RequestBody Student student) { //returns HTML testPage
        service.startTestSession(student);
        currentQuestion = 0;
        return getQuestion(null, null);
    }

    @GetMapping("/test")
    public String getQuestion(@RequestParam(required = false, name = "page") Integer askQuestionNum,
                               @RequestParam(required = false) String answer) {
        if (answer != null) {
            service.addAnswer(currentQuestion, answer);
        }
        if (askQuestionNum != null) {
            currentQuestion = askQuestionNum - 1;
        }
        return service.getQuestionPage(++currentQuestion); //forms html doc with question
    }
}
