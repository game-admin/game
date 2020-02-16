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
        int j;
        for(int i=0; i<quiz.size(); i++) {
            for(j=0; j<quiz.get(i).antworten.length; j++) {
            /*    if(quiz.get(i).frage.get(j).richtig && quiz.get(i).buttons[j] != 1) 
                    j=1000;
                if(!quiz.get(i).frage.get(j).richtig && quiz.get(i).buttons[j] != 0)
                    j=1000; */
            }
            if(j<500) {
                score+=10;
                ricounter++;
            } else {
                falsche.add(i);
            }
        }
          /*  if(quiz.get(i).buttons[0] && quiz.get(i).indexrichtig == 0 || quiz.get(i).buttons[1] && quiz.get(i).indexrichtig == 1) {              
                score+=10;  
                ricounter++;
            } else {
                falsche.add(i);
            } */
         
        for(int i=0; i<falsche.size(); i++) {
            results.add(new Result(quiz.get(falsche.get(i)).frage, quiz.get(falsche.get(i)).antworten[quiz.get(falsche.get(i)).indexrichtig], "color: red"));
        }
        //Hier sollte dann noch der Score der Trainees geupdated werden
    }
    
    public void evaluateScoreRadio() {
        List<Integer> falsche = new ArrayList<>();
        for(int i=0; i<quiz.size(); i++) {
            if(quiz.get(i).selectedAnswer.equals(quiz.get(i).antworten[quiz.get(i).indexrichtig])) {
                score+=10;
                ricounter++;
                falsche.add(9999);
            } else {
                falsche.add(i);
            }
        }
        for(int j=0; j<quiz.size(); j++) {
                if(falsche.get(j) == j) {
                    results.add(new Result(quiz.get(falsche.get(j)).frage, quiz.get(falsche.get(j)).antworten[quiz.get(falsche.get(j)).indexrichtig], "color: red"));
                } else {
                    results.add(new Result(quiz.get(j).frage, quiz.get(j).antworten[quiz.get(j).indexrichtig], "color: green"));
                }
        }
    }
}