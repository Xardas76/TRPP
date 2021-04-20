package com.controlers;

import com.DBentities.Question;
import com.services.DBService;
import com.services.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private DBService service;

    public RestController(DBService service) {
        this.service = service;
    }

    @PostMapping("/library")
    public ResponseEntity<Question> addQuestionToDB(@RequestBody Question question) {
        try {
            return ResponseEntity.ok().body(service.addQuestion(question));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
