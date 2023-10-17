package com.example.KursWork_Questions.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason = "Недостаточно вопросов в списке.")
public class NotEnoughtQuestions extends RuntimeException{
}
