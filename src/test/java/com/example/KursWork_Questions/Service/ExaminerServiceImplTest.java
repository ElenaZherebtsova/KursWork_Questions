package com.example.KursWork_Questions.Service;

import com.example.KursWork_Questions.DTO.Question;
import com.example.KursWork_Questions.Exceptions.NotEnoughtQuestions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionsService questionsService;

    @InjectMocks
    ExaminerServiceImpl underTest;

    @Test
    void getQuestion_shouldThrowExceptionWhenNotEnoughtQuestion() {
        when(questionsService.getAll()).
                thenReturn(Collections.emptySet());
        assertThrows(NotEnoughtQuestions.class,
                () -> underTest.getQuestion(1));
    }

    @Test
    void getQuestion_shouldReturnUniqueQuestionCollection() {
        int amount = 2;
        Question question1 = new Question("question1", "answer1");
        Question question2 = new Question("question2", "answer2");
        Set<Question> testSet = Set.of(question1, question2);
        when(questionsService.getAll()).
                thenReturn(testSet);
        when(questionsService.getRandomQuestion()).
                thenReturn(question1, question2);
        Collection<Question> result = underTest.getQuestion(amount);

        assertEquals(testSet, result);
        assertEquals(amount, result.stream().distinct().count());
    }


}