package org.game.trainee.testquiz;

import java.io.Serializable;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.game.trainee.traineeview.Trainee;
import org.game.trainee.traineeview.TraineeEJB;

/**
 *
 * @author Eric
 */
@Named
@SessionScoped
public class TestQuizController implements Serializable {
     
    private List<Quiz> quizzes;
    private List<Results> results;
    private int score;
    private Trainee trainee;
    private int ricounter;
    private String emblem = "javapro.png";
    private List<FrageModell> fragemodell;
    private String qid;
    
    @Inject 
    private ModellCreator creator;
    
    @Inject
    private TraineeEJB traineebean;
    
    @Inject
    private FrageEJB fragebean;
    
    @Inject
    private QuizEJB quizbean;
    
    @Inject
    private QuizbeantwortungEJB quizbeantw;
    
    @Inject
    private QuizVoraussetzungEJB quizvoraussetzung;
     
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
        //Hier sollte bei QuizBesuch das geaddet werden
    } 
    
    public void evaluateScoreRadio() {
        List<Integer> falsche = new ArrayList<>();
        //List<Frage> test = fragebean.findAll();
        //List<Antwortmoeglichkeiten> antworten = test.get(1).getAntworten();
        getFragemodell();
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
        //Hier sollte bei Quizbesuch alles geaddet werden 
        //Hier sollt dann noch der Score vom Trainee geupdated werden
        //hier muss der isDone Wert, von dem Quiz in Vorrausetzung auf true gesetzt werden
        //EJB."Methode"(quid) -> damit wird der Wert auf true gesetzt
    }
    
    public String quizUebergabe(String qid) {
        //hier drin sollt auch nach Vorraussetzungen geschaut werden, wenn diese nicht erfüllt sind, kommt eine Fehlermeldung
        //hier kann gleich die Fragenliste gesetzt werden, zu dem Quiz auf das geklickt wurde!
        //-> QuizVorraussetzungEJB -> bean.find(qid), -> wenn null: keine Vorraussetzung, 
        //-> ein boolean Feld isDone -> when done true is, dann is die Vorraussetzung erledigt, dann sols weitergehen
        //-> wenn false drinsteht in dem Wert zur QID dann wurde die Vorrausetzung nicht erledigt -> Fehler
        this.qid = qid;
        fragemodell = creator.createModell(4, qid, false);
        if(quizbean.find(qid).getMultiplechoice()) {
            return "takeQuizMultipleChoice.xhtml";
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
        for(int i=0; i<fragemodell.size(); i++) {
            List<Integer> indexrichtig = umwandler(fragemodell.get(i).indexrichtig);
            if(falsche.get(i) == i) {
                results.add(new Results(fragemodell.get(i).frage, fragemodell.get(i).antworten, indexrichtig, true));
            } else {
                results.add(new Results(fragemodell.get(i).frage, fragemodell.get(i).antworten, indexrichtig, false));
            }
        }
     trainee = traineebean.find("1");
     trainee.setProgress(trainee.getProgress()+score);
     traineebean.update(trainee);
     List<Quizbeantwortung> list =  quizbeantw.findByQIDAndMITID(qid, "1");
     list.get(0).setErreichtePunkte(score);
     if(score > fragemodell.size()*10/2) {
        list.get(0).setIstbestanden(true);
     }
     quizbeantw.update(list.get(0));
    }
    
    public Boolean isTakeable(String qid, String mitid) {
        List<QuizVoraussetzung> quizvor = quizvoraussetzung.findAllQuizVoraussetzzungen(qid);
        if(quizvor.isEmpty()) {
            return TRUE;
        }
        List<Quizbeantwortung> list = quizbeantw.findByQIDAndMITID(qid, mitid);
        if(list.get(0).isIstbestanden()) {
            return TRUE;
        }
        
        return FALSE;
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

    public List<FrageModell> getFragemodell() {
        if(fragemodell==null || fragemodell.isEmpty()) {
           fragemodell = creator.createModell(4, qid, false);
        }
        return fragemodell;
    }
    


    public void setFragemodell(List<FrageModell> fragemodell) {
        this.fragemodell = fragemodell;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }   
}