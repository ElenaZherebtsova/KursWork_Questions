package com.example.KursWork_Questions.Service;

import com.example.KursWork_Questions.DTO.Question;
import com.example.KursWork_Questions.Exceptions.NotEnoughtQuestions;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private Random random = new Random();
    private QuestionsService questionsService;

    public ExaminerServiceImpl(QuestionsService questionsService) {

        this.questionsService = questionsService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (questionsService.getAll().size() < amount) {
            throw new NotEnoughtQuestions();
        }
        Set<Question> spisokNaVivod = new HashSet<>();
        while (spisokNaVivod.size() < amount) {
            spisokNaVivod.add(questionsService.getRamndomQuestion());
        }

        return spisokNaVivod;
    }
}
