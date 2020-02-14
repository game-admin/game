/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import org.game.trainee.traineeview.TraineeGenerator;

/**
 *
 * @author Eric
 */
@Named
@RequestScoped
public class TestQuizController implements Serializable {
     
    private List<TestQuiz> quiz;
    private List<Result> results;
    private int score; //Der Score sollte später injected werden, und mit einer DB verbunden sein
    private int ricounter;
    private String emblem = "emblem.png";
    
    @Inject 
    private TraineeGenerator trainee;
          
    @Inject
    private TestQuizSpeicher speicher;
     
    @PostConstruct
    public void init() {
        quiz = speicher.createQuiz(4, false);
        score = (int)trainee.getProgressFromIndex(0);
        results = new ArrayList<>();
        ricounter = 0;
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

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public int getRicounter() {
        return ricounter;
    }

    public void setRicounter(int ricounter) {
        this.ricounter = ricounter;
    }

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }
    
    public String checkAnswersSingleChoice() {
        evaluateScoreRadio();
        if(ricounter==quiz.size())
            return "success.xhtml";
        return "result.xhtml";
    }
    
    public String checkAnswersMultipleChoice() {
        evaluateScoreMultiple();
        if(ricounter==quiz.size())
            return "success.xhtml";
        return "result.xhtml";
    }
    
    public void evaluateScoreMultiple() {
        List<Integer> falsche = new ArrayList<>();
        for(int i=0; i<quiz.size();i++) {
            if(quiz.get(i).buttons[0] && quiz.get(i).indexrichtig == 0 || quiz.get(i).buttons[1] && quiz.get(i).indexrichtig == 1) {
                score+=20;
                ricounter++;
            } else {
                falsche.add(i);
            }
        }   
        for(int i=0; i<falsche.size(); i++) {
            results.add(new Result(quiz.get(falsche.get(i)).frage, quiz.get(falsche.get(i)).antworten[quiz.get(falsche.get(i)).indexrichtig]));
        }
        //Hier sollte dann noch der Score der Trainees geupdated werden
    }
    
    public void evaluateScoreRadio() {
        List<Integer> falsche = new ArrayList<>();
        for(int i=0; i<quiz.size(); i++) {
            if(quiz.get(i).selectedAnswer.equals(quiz.get(i).antworten[quiz.get(i).indexrichtig])) {
                score+=20;
                ricounter++;
            } else {
                falsche.add(i);
            }
        }
        for(int i=0; i<falsche.size(); i++) {
            results.add(new Result(quiz.get(falsche.get(i)).frage, quiz.get(falsche.get(i)).antworten[quiz.get(falsche.get(i)).indexrichtig]));
        }
    }
   
}