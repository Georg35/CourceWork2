package pro.sky.coursework.service;

import pro.sky.coursework.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question find(String question);

    Question getRandomQuestion();

    int size();
}
