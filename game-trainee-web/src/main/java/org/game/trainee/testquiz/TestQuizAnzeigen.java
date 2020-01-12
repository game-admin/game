/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
import java.util.ArrayList;
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
@ApplicationScoped
public class TestQuizAnzeigen implements Serializable {
     
    private List<TestQuiz> quiz;
    private List<String> results;
    private int score; //Der Score sollte später injected werden, und mit einer DB verbunden sein
    
    @Inject 
    private TraineeGenerator trainee;
          
    @Inject
    private TestQuizSpeicher speicher;
     
    @PostConstruct
    public void init() {
        quiz = speicher.createQuiz(4);
        score = (int)trainee.getProgressFromIndex(0);
        results = new ArrayList<>();
    }
 
    public List<TestQuiz> getQuiz() {
        return quiz;
    }
 
    public void setSpeicher(TestQuizSpeicher speicher) {
        this.speicher = speicher;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
    
    public String checkAnswers() {
        evaluateScore();
        //checkForDoubleChecked();
        return "result.xhtml";
    }
    
    public void evaluateScore() {
        if(quiz.get(0).buttons[0] && quiz.get(0).indexrichtig == 0 || quiz.get(0).buttons[1] && quiz.get(0).indexrichtig == 1) 
            score+=100;
        if(quiz.get(1).buttons[0] && quiz.get(1).indexrichtig == 0 || quiz.get(1).buttons[1] && quiz.get(1).indexrichtig == 1) 
            score+=1000;
        if(quiz.get(2).buttons[0] && quiz.get(2).indexrichtig == 0 || quiz.get(2).buttons[1] && quiz.get(2).indexrichtig == 1) 
            score+=10000;
        if(quiz.get(3).buttons[0] && quiz.get(3).indexrichtig == 0 || quiz.get(3).buttons[1] && quiz.get(3).indexrichtig == 1) 
            score+=100000;
        //Hier sollte dann noch der Score der Trainees geupdated werden
        if(score==111150) {
            results.add("Du hast alle Fragen richtig beantwortet!");
            results.add("Du erhälst 80/80 Punkten!");
        }
    }
    
    /*public String checkForDoubleChecked() {
        if(buttons[0].booleanValue() == buttons[1].booleanValue())
            return "index.xhtml"; //Hier sollte man eine Error-Message einbauen
        return "result.xhtml";
    } */
   
}