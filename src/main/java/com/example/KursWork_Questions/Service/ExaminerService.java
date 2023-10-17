package com.example.KursWork_Questions.Service;

import com.example.KursWork_Questions.DTO.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);}
