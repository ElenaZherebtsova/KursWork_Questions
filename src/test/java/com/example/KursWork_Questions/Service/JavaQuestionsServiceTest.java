package com.example.KursWork_Questions.Service;

import com.example.KursWork_Questions.DTO.Question;
import com.example.KursWork_Questions.Exceptions.NotEnoughtQuestions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionsServiceTest {
    private JavaQuestionsService underTest = new JavaQuestionsService();
    private Question testQuestion = new Question("questionTest", "answerTest");
    @Test
    void add_shouldAddQuestionToSetAndReturnQuestion() {
        Question result = underTest.add(testQuestion.getQuestion(),
                testQuestion.getAnswer());

        assertTrue(underTest.getAll().contains(testQuestion));
        assertEquals(testQuestion, result);

    }

    @Test
    void remove_shouldDeleteQuestionFromSetAndReturnQuestion() {
        Question result = underTest.remove(testQuestion);

        assertFalse(underTest.getAll().contains(testQuestion));
        assertEquals(testQuestion, result);
    }

    @Test
    void getAll_shouldReturnQuestionCollection() {
        Question testQuestion2 = new Question("testQuest2", "testAnsw2");
        underTest.add(testQuestion);
        underTest.add(testQuestion2);
        Collection<Question> result = underTest.getAll();

        assertEquals(Set.of(testQuestion, testQuestion2), result);
    }

    @Test
    void getRandomQuestion_shouldThrowExceptionWhenSetIsEmpty() {

        assertThrows(NotEnoughtQuestions.class,
                () -> underTest.getRandomQuestion());
    }

    @Test
    void getRandomQuestion_shouldReturnQuestionWhenSetIsNotEmpty() {
        underTest.add(testQuestion);
        Question result = underTest.getRandomQuestion();
        assertEquals(testQuestion, result);

    }
}