package com.example.KursWork_Questions.Controller;

import com.example.KursWork_Questions.DTO.Question;
import com.example.KursWork_Questions.Service.QuestionsService;
import com.example.KursWork_Questions.Service.QuestionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/java")
public class JavaQuestionCotroller {
    private QuestionsService service;

    public JavaQuestionCotroller(QuestionsService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping
    public Collection<Question> getQestions() {
        return service.getAll();

    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }


}
