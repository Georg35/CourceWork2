package pro.sky.coursework.service;

import pro.sky.coursework.model.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestion(int amount);
}
