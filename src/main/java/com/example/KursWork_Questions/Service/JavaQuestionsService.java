package com.example.KursWork_Questions.Service;

import com.example.KursWork_Questions.DTO.Question;
import com.example.KursWork_Questions.Exceptions.NotEnoughtQuestions;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionsService implements QuestionsService {

    private Set<Question> questionSpisok = new HashSet<>();
    private Random rnd = new Random();
    @Override
    public Question add(String question, String answer) {
        Question noviiQuestion = new Question(question, answer);
        questionSpisok.add(noviiQuestion);

        return add(noviiQuestion);
    }

    @Override
    public Question add(Question question) {
        questionSpisok.add(question);

        return question ;
    }

    @Override
    public Question remove(Question question) {
        questionSpisok.remove(question);
                return question ;
    }

    @Override
    public Collection<Question> getAll() {

        return questionSpisok;
    }

    @Override
    public Question getRamndomQuestion() {
        if (questionSpisok.size() == 0) {
            throw new NotEnoughtQuestions();
        }


        return null;
    }
}
