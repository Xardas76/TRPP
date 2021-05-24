package com.controlers;

import com.services.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/** Контроллер для работы с тестом*/
@Controller
public class FrontController {
    private TestService service;

    private int currentQuestion; //indicates current page num (from 1)

    public FrontController(TestService service) {
        this.service = service;
    }

    /** Возвращает начальную страницу. */
    @GetMapping("/")
    public String greeting(){
        System.out.println("Hello in console");
        return "index";
    }
}
