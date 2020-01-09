/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
//import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Eric
 */
@Named
@RequestScoped
public class TestQuizAnzeigen implements Serializable {
     
    private List<TestQuiz> quiz;
     
    private TestQuiz selectedQuestion;
    private String selectedAnswer;
    private Boolean[] buttons = new Boolean[2];
     
    @Inject
    private TestQuizSpeicher speicher;
     
    @PostConstruct
    public void init() {
        quiz = speicher.createQuiz(4);
        //buttons = speicher.createButtons(2);
    }
 
    public List<TestQuiz> getQuiz() {
        return quiz;
    }
 
    public void setSpeicher(TestQuizSpeicher speicher) {
        this.speicher = speicher;
    }
 
    public TestQuiz getSelectedQuestion() {
        return selectedQuestion;
    }
 
    public void setSelectedQuestion(TestQuiz selectedQuestion) {
        this.selectedQuestion = selectedQuestion;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public Boolean[] getButtons() {
        return buttons;
    }

    public void setButtons(Boolean[] buttons) {
        this.buttons = buttons;
    }
    
     public String checkAnswers() {
        if(buttons[quiz.get(0).indexrichtig] == true) {
            if(buttons[quiz.get(1).indexrichtig] == true)
                if(buttons[quiz.get(2).indexrichtig] == true)
                    if(buttons[quiz.get(3).indexrichtig] == true)
                        return "index.xhtml";
        } else {
        return "courses.xhtml";
        }
        return "leaderboard.xhtml";
    } 
     
    public String checkTest() {
        if(selectedAnswer.compareToIgnoreCase(quiz.get(0).antworten[0]) == 0) {
            return "result.xhtml";
        }
        return "leaderboard.xhtml";
    }
}