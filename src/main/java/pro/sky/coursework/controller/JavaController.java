package pro.sky.coursework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework.model.Question;
import pro.sky.coursework.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaController {
    private final JavaQuestionService ques;

    public JavaController(JavaQuestionService question) {
        this.ques = question;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        Question question1 = new Question(question, answer);
        return ques.add(question1);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        Question question1 = new Question(question, answer);
        return ques.remove(question1);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return ques.getAll();
    }

    @GetMapping("/find")
    public Question find(@RequestParam String question) {
        return ques.find(question);
    }
}
