package com.example.KursWork_Questions.Service;

import com.example.KursWork_Questions.DTO.Question;

import java.util.Collection;

public interface QuestionsService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection getAll();

    Question getRandomQuestion();
}
