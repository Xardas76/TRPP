package com.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {
    @RequestMapping("/")
    public String greeting(){
        System.out.println("Hello in console");
        return "index";
    }

}
