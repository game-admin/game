package org.game.trainee.quiz;

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
import org.game.trainee.kurs.Voraussetzung;
import org.game.trainee.kurs.VoraussetzungEJB;
import org.game.trainee.trainee.Trainee;
import org.game.trainee.trainee.TraineeEJB;

/**
 *
 * @author Eric
 */
@Named
@SessionScoped
public class QuizController implements Serializable {

    private List<Quiz> quizzes;
    private List<Results> results;
    private int score;
    private Trainee trainee;
    private int ricounter;
    private String emblem = "javapro.png";
    private List<FrageModell> fragemodell;
    private String qid;

    @Inject
    private FrageModellCreator creator;

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

    @Inject
    private VoraussetzungEJB voraussetzungejb;

    @PostConstruct
    public void init() {
        fragemodell = creator.createModell(qid);
        results = new ArrayList<>();
        ricounter = 0;
    }

    public String checkAnswersSingleChoice() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        String varqid = params.get("qid");
        this.qid = varqid;
        evaluateScoreRadio();
        return "result.xhtml";
    }

    public String checkAnswersMultipleChoice() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        String varqid = params.get("qid");
        this.qid = varqid;
        evaluateScoreMultiple();
        return "result.xhtml";
    }

	// tag::multiple[]
    public void evaluateScoreMultiple() {
        List<Integer> falsche = new ArrayList<>();
        int richtige=0;
        for(int i=0; i<fragemodell.size(); i++ ) {
            List<Integer> indexrichtig = fragemodell.get(i).indexrichtig;
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
    }
	// end::multiple[]
	// tag::radio[]
    public void evaluateScoreRadio() {
        List<Integer> falsche = new ArrayList<>();
        //fragemodell = creator.createModell(qid);
        int indexri=0;
        for(int i=0; i<fragemodell.size(); i++) {
            for(int j=0; j<fragemodell.get(i).indexrichtig.size(); j++) {
               if(fragemodell.get(i).indexrichtig.get(j) == 1)
                   indexri = j;
            }
            if(fragemodell.get(i).selectedAnswer.equals(fragemodell.get(i).antworten.get(indexri))) {
                score+=10;
                ricounter++;
                falsche.add(9999);
            } else {
                falsche.add(i);
            }
        }
        checkResults(falsche);
    }
	// end::radio[]
	// tag:quizUebergabe[]
    public String quizUebergabe(String qid) {
        this.qid = qid;
        fragemodell = creator.createModell(qid);
        ricounter = 0;
        score=0;
        if(quizbean.find(qid).getMultiplechoice()) {
            return "takeQuizMultipleChoice.xhtml";
        } else {
            return "takequiz.xhtml";
        }
    }
	// end::quizUebergabe[]
	// tag::checkResults[]
    public void checkResults(List<Integer> falsche) {
        results = new ArrayList<>();
        for(int i=0; i<fragemodell.size(); i++) {
            List<Integer> indexrichtig = fragemodell.get(i).indexrichtig;
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
    // end::checkResults[]
	// tag::isTakeable[]
    public Boolean isTakeable(String qid, String mitid) {
        List<QuizVoraussetzung> quizvor = quizvoraussetzung.findAllQuizVoraussetzzungen(qid);
        if(quizvor.isEmpty()) {
            return TRUE;
        }

        //Von quizvor das vorrausgesetzte Quiz/die id des vorrausgesetzten Quiz holen und rauslesen
        Voraussetzung vor = voraussetzungejb.find(quizvor.get(0).getQuizVorraussetzID());
        String id = vor.getQuiz().getQID();
        List<Quizbeantwortung> list = quizbeantw.findByQIDAndMITID(id, mitid);
        if(list.get(0).isIstbestanden()) {
            return TRUE;
        }

        return FALSE;
    }
    // end::isTakeable[]

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
           fragemodell = creator.createModell(qid);
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