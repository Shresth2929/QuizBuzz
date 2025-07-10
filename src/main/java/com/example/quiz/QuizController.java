package com.example.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class QuizController {
    private QuizSystem quizSystem;

    public QuizController() {
        this.quizSystem = new QuizSystem();
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("topics", quizSystem.getTopics());
        return "categories";
    }

    @PostMapping("/start")
    public String startQuiz(@RequestParam("topic") String topic, HttpSession session) {
        if (!quizSystem.getTopics().contains(topic)) {
            return "redirect:/";
        }
        QuizSystem newQuiz = new QuizSystem();
        newQuiz.startQuiz(topic);
        session.setAttribute("quizSystem", newQuiz);
        return "redirect:/question";
    }

    @GetMapping("/question")
    public String showQuestion(Model model, HttpSession session) {
        QuizSystem quiz = (QuizSystem) session.getAttribute("quizSystem");
        if (quiz == null) {
            return "redirect:/";
        }
        QuizSystem.Question question = quiz.getCurrentQuestion();
        if (question == null) {
            return "redirect:/results";
        }
        model.addAttribute("question", question);
        model.addAttribute("canGoBack", quiz.hasPreviousQuestion());
        return "question";
    }

    @PostMapping("/answer")
    public String submitAnswer(@RequestParam("answer") int answer, HttpSession session) {
        QuizSystem quiz = (QuizSystem) session.getAttribute("quizSystem");
        if (quiz != null) {
            quiz.submitAnswer(answer);
            quiz.nextQuestion();
        }
        return "redirect:/question";
    }

    @PostMapping("/back")
    public String goBack(HttpSession session) {
        QuizSystem quiz = (QuizSystem) session.getAttribute("quizSystem");
        if (quiz != null && quiz.hasPreviousQuestion()) {
            quiz.previousQuestion();
        }
        return "redirect:/question";
    }

    @GetMapping("/results")
    public String showResults(Model model, HttpSession session) {
        QuizSystem quiz = (QuizSystem) session.getAttribute("quizSystem");
        if (quiz == null) {
            return "redirect:/";
        }
        model.addAttribute("score", quiz.getScore());
        model.addAttribute("total", quiz.getTotalQuestions());
        model.addAttribute("questions", quiz.getQuestions());
        return "results";
    }
}