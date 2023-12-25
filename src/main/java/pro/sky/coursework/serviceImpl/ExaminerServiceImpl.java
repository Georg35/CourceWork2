package pro.sky.coursework.serviceImpl;

import org.springframework.stereotype.Service;
import pro.sky.coursework.exception.FullSet;
import pro.sky.coursework.model.Question;
import pro.sky.coursework.service.ExaminerService;
import pro.sky.coursework.service.QuestionService;

import java.util.HashSet;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Override
    public Set<Question> getQuestion(int amount) {
        if (amount > questionService.size()) {
            throw new FullSet("Максимальное количество вопросов = " + questionService.size());
        }

        Set<Question> list = new HashSet<>();
        while (list.size() < amount) {
            list.add(questionService.getRandomQuestion());
        }
        return list;
    }
}
