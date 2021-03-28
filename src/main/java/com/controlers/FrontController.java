package com.controlers;

import com.Student;
import com.services.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {
    TestService service;

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
    }
}
