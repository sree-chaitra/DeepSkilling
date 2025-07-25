package com.example.quiz;

import com.example.quiz.service.AttemptService;
import com.example.quiz.entity.Attempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizApplication implements CommandLineRunner {

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testGetAttemptDetails();
    }

    private void testGetAttemptDetails() {
        Attempt attempt = attemptService.getAttempt(1, 1);
        System.out.println("Username: " + attempt.getUser().getName());
        System.out.println("Attempt Date: " + attempt.getDate());
        attempt.getAttemptQuestions().forEach(aq -> {
            System.out.println(aq.getQuestion().getText());
            aq.getAttemptOptions().forEach(ao -> System.out.println(ao.getOption().getText() + " 	" +
                    ao.getOption().getScore() + " 	" + ao.isSelected()));
            System.out.println();
        });
    }
}