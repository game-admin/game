package org.game.trainee.kurs;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Eric
 */
@Named
@RequestScoped
public class KursController {
    //hier soll, wenn man auf einen Kurs klickt, die Vorraussetzung geupdated werden
    private List<Kurs> kurse;
    
    @Inject
    private KursEJB kursbean;
    
    
    public String takeKurs(String kursid) {
        //Vorraussetzung checken, und Vorraussetzung updated
        return kursbean.find(kursid).getLink();
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
}
