/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

import java.net.URL;
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
    
    
    public URL takeKurs(String kursid) {
        //Vorraussetzung checken, und Vorraussetzung updated
        return kursbean.find(kursid).getLink();
        //return "https://www.tutorialspoint.com/java/index.htm/";
        //je nachdem welcher Kurs geklick wurde, sollte hier auch der richtige Link zurückgegeben werden
        //ideal aus der Datenbank raus mittels KursID
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
    
    
}
