package pro.sky.coursework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework.exception.FullSet;
import pro.sky.coursework.model.Question;
import pro.sky.coursework.service.QuestionService;
import pro.sky.coursework.serviceImpl.ExaminerServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;


    public static final Question QUESTION_1 = new Question("Вопрос1", "Ответ1");
    public static final Question QUESTION_2 = new Question("Вопрос2", "Ответ2");
    public static final Question QUESTION_3 = new Question("Вопрос3", "Ответ3");
    public static final Question QUESTION_4 = new Question("Вопрос4", "Ответ4");
    public static final Question QUESTION_5 = new Question("Вопрос5", "Ответ5");


    @Test
    public void getQuestionTestOnThrow() {
        when(questionService.size()).thenReturn(5);
        assertThrows(FullSet.class, () -> out.getQuestion(7));
    }

    @Test
    public void getQuestionTest() {
        when(questionService.getRandomQuestion())
                .thenReturn(QUESTION_1, QUESTION_2, QUESTION_3,
                        QUESTION_4, QUESTION_5);
        when(questionService.size()).thenReturn(10);
        assertEquals(out.getQuestion(5).size(), 5);

    }

    @Test
    public void getQuestionTestOnContains() {
        when(questionService.getRandomQuestion())
                .thenReturn(QUESTION_1, QUESTION_2, QUESTION_3,
                        QUESTION_4, QUESTION_5);
        when(questionService.size()).thenReturn(10);
        assertTrue(out.getQuestion(5).contains(QUESTION_3));
    }
}
