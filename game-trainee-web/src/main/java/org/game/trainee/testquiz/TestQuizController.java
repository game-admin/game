package org.game.trainee.testquiz;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import org.game.trainee.traineeview.Trainee;
import org.game.trainee.traineeview.TraineeEJB;

/**
 *
 * @author Eric
 */
@Named
@RequestScoped
public class TestQuizController implements Serializable {
     
    private List<Quiz> quizzes;
    //private List<Frage> fragen; used?
    private List<Results> results;
    private int score;
    private Trainee trainee;
    private int ricounter;
    private String emblem = "javapro.png";
    private List<String> selectedAnswer; //nur für Test -> ghört ins Model
    private List<FrageModell> fragemodell;
    
    @Inject 
    private ModellCreator creator;
    
    @Inject
    private TraineeEJB traineebean;
    
    @Inject
    private FrageEJB fragebean;
    
    @Inject
    private QuizEJB quizbean;
     
    @PostConstruct
    public void init() {
        //quiz = speicher.createQuiz(4, false); //hier sollte 1. mittels EJB das Quiz geholt werden
                                              //und 2. sollte hier mittels qid das jeweilige quiz geholt werden
                                                 //sollte auch über EJB gehen
                                                      //und unten wenn score erhöht wird auch
        //trainee = traineebean.find("1");
        
        results = new ArrayList<>();
        ricounter = 0;
    }
    
    public String checkAnswersSingleChoice() {
        evaluateScoreRadio();
        return "result.xhtml";
    }
    
    public String checkAnswersMultipleChoice() {
        evaluateScoreMultiple();
        return "result.xhtml";
    }
    
    public void evaluateScoreMultiple() {
        List<Integer> falsche = new ArrayList<>();
        int richtige=0;  
        for(int i=0; i<4; i++ ) { //hier sollten dann zur fragensize durchgegeangen werden
            List<Integer> indexrichtig = umwandler(fragemodell.get(i).indexrichtig);
            for(int z=0; z<4; z++) {
                if(indexrichtig.get(z) == 1 && !fragemodell.get(i).buttons[z] || indexrichtig.get(z) == 0 && fragemodell.get(i).buttons[z]) {
                    falsche.add(i);
                    z=999;
                } else {
                    richtige++;
                }
            }
            if(richtige==4) {
                score+=10;
                ricounter++;
                falsche.add(9999);
            }
            richtige = 0;
        } 
        checkResults(falsche); 
        //Hier sollte dann noch der Score der Trainees geupdated werden
    } 
    
    public void evaluateScoreRadio() {
        List<Integer> falsche = new ArrayList<>();
        //List<Frage> test = fragebean.findAll();
        //List<Antwortmoeglichkeiten> antworten = test.get(1).getAntworten();
        for(int i=0; i<4; i++) { //hier sollten dann zur fragensize durchgegeangen werden
            if(fragemodell.get(i).selectedAnswer.equals(fragemodell.get(i).antworten.get(fragemodell.get(i).indexrichtig))) {
                score+=10;
                ricounter++;
                falsche.add(9999);
            } else {
                falsche.add(i);
            }
        }
        checkResults(falsche); 
        //Hier sollt dann noch der Score vom Trainee geupdated werden
    }
    
    public String quizUebergabe(String qid) {
        //hier drin sollt auch nach Vorraussetzungen geschaut werden, wenn diese nicht erfüllt sind, kommt eine Fehlermeldung
        //hier kann gleich die Fragenliste gesetzt werden, zu dem Quiz auf das geklickt wurde!
        if(qid.equals("1")) {
            return "takequiz.xhtml";
        } else {
            return "takequiz.xhtml"; 
        }
        
    }
    
    public List<Integer> umwandler(int indexrichtig) {
        List<Integer> liste = new ArrayList<>();
        
        for(int i=0; i<4; i++)
            if(indexrichtig==i) {
                liste.add(1);
            } else {
                liste.add(0);
            }
        return liste;
    }
    public int makeListToIndexRichtig(List<Antwortmoeglichkeiten> antworten) { //Used here?
        for (int i = 0; i < 4; i++) {
            if(antworten.get(i).isRichtigeAntwort()) {
                return i;
            }
        }
        return 0;
    }
    
    public void checkResults(List<Integer> falsche) {
     /*  for(int i=0; i<quiz.size(); i++) {
            List<Integer> indexrichtig = umwandler(quiz.get(i).indexrichtig);
            if(falsche.get(i) == i) {
                results.add(new Results(quiz.get(i).frage, quiz.get(i).antworten, indexrichtig, true));
            } else {
                results.add(new Results(quiz.get(i).frage, quiz.get(i).antworten, indexrichtig, false));
            }
        } */
    }
    
    public String getQuizBezeichnung() {
        return quizbean.find("1").getBeschreibung(); //hier mit qid arbeiten

    } 

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
    
    public List<Quiz> getQuizzes() {
        if(quizzes==null) {
            quizzes = quizbean.findAll();
        }
        return quizzes;
    }
    
    /*public List<Frage> getFragen() { //ich brauch hier nur die Fragen zu einem bestimmten Quiz!!
        if(fragen == null) {
            fragen = fragemodell.getAllFragen();
        }
        return fragen;
    } */ 
   
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public List<String> getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(List<String> selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public List<FrageModell> getFragemodell() {
        if(fragemodell==null) {
           fragemodell = creator.createModell(4, false);
        }
        return fragemodell;
    }

    public void setFragemodell(List<FrageModell> fragemodell) {
        this.fragemodell = fragemodell;
    }
    
    
}