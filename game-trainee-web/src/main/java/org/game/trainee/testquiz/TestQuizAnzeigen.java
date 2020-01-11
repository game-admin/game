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
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import org.game.trainee.traineeview.TraineeGenerator;

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
    private double score; //Der Score sollte später injected werden, und mit einer DB verbunden sein
    
    @Inject 
    private TraineeGenerator trainee;
          
    @Inject
    private TestQuizSpeicher speicher;
     
    @PostConstruct
    public void init() {
        quiz = speicher.createQuiz(4);
        score = trainee.getProgressFromIndex(0);
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
    public String checkAnswers() {
        evaluateScore();
        checkForDoubleChecked();
        return "result.xhtml";
        
    }
    
    public void evaluateScore() {
       if(buttons[quiz.get(0).indexrichtig])
           score+=100;
       if(buttons[quiz.get(1).indexrichtig])
           score+=1000;
       if(buttons[quiz.get(2).indexrichtig])
           score+=10000;
       if(buttons[quiz.get(3).indexrichtig])
           score+=100000;
       //Hier sollte dann noch der Score der Trainees geupdated werden
    }
    
    public String checkForDoubleChecked() {
        if(buttons[0].booleanValue() == buttons[1].booleanValue())
            return "index.xhtml"; //Hier sollte man eine Error-Message einbauen
        return "result.xhtml";
        
    }
    public String checkTest() {
        if(selectedAnswer.compareToIgnoreCase(quiz.get(0).antworten[0]) == 0) {
            return "result.xhtml";
        }
        return "leaderboard.xhtml";
    }
}