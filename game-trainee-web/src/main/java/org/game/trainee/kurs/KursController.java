package org.game.trainee.kurs;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.game.trainee.trainee.Trainee;
import org.game.trainee.trainee.TraineeEJB;

/**
 *
 * @author Eric
 */
@Named
@RequestScoped
public class KursController {
    //hier soll, wenn man auf einen Kurs klickt, die Vorraussetzung geupdated werden
    private List<Kurs> kurse;
    private List<KursModell> kursmodel;
    
    @Inject
    private KursEJB kursbean;
    @Inject
    private KursModellCreator kurscreator;
    @Inject
    private KursVoraussetzungEJB kursvoraussetzung;
    @Inject
    private VoraussetzungEJB voraussetzungejb;
    @Inject
    private KursBesuchEJB kursbesuch;
    @Inject
    private TraineeEJB traineebean;
    
    @PostConstruct
    public void init() {
        kursmodel = kurscreator.createModell();
    }
    
    public String takeKurs(String kursid) { //deprecated?
        //Vorraussetzung checken, und Vorraussetzung updated
        return kursbean.find(kursid).getLink();
    }
    
    public String updateKurs(String kursid) {
     //Trainee trainee = traineebean.find("1");
     List<KursBesuch> list =  kursbesuch.findByKursIDAndMITID(kursid, "1");
     list.get(0).setIstbesucht(true);
     kursbesuch.update(list.get(0)); 
     return "index.xhtml";
    }
    
    public Boolean isTakeable(String kursid, String mitid) {
        List<KursVoraussetzung> kursvor = kursvoraussetzung.findAllKursVoraussetzzungen(kursid);
        if(kursvor.isEmpty()) {
            return TRUE;
        }

        //Von quizvor das vorrausgesetzte Quiz/die id des vorrausgesetzten Quiz holen und rauslesen
        Voraussetzung vor = voraussetzungejb.find(kursvor.get(0).getVoraussetzung().getVoraussetzID());
        String id = vor.getKurs().getKursID();
        List<KursBesuch> list = kursbesuch.findByKursIDAndMITID(id, mitid);
        if(list.get(0).isIstbesucht()) {
            return TRUE;
        }

        return FALSE;
    }

    public List<Kurs> getKurse() {
        if(kurse == null) {
            kurse = kursbean.findAll();
        }
        return kurse;
    }

    public void setKurse(List<Kurs> kurse) {
        this.kurse = kurse;
    }

    public KursEJB getKursbean() {
        return kursbean;
    }

    public List<KursModell> getKursmodel() {
        if(kursmodel == null) {
            kursmodel = kurscreator.createModell();
        }
        return kursmodel;
    }

    public void setKursmodel(List<KursModell> kursmodel) {
        this.kursmodel = kursmodel;
    }
    
}
