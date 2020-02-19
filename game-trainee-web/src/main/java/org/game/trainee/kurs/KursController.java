/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Eric
 */
@Named
@RequestScoped
public class KursController {
    //hier soll, wenn man auf einen Kurs klickt, die Vorraussetzung geupdated werden
    
    public String takeKurs() {
        //Vorraussetzung checken, und Vorraussetzung updated
        return "https://www.tutorialspoint.com/java/index.htm/";
        //je nachdem welcher Kurs geklick wurde, sollte hier auch der richtige Link zurückgegeben werden
        //ideal aus der Datenbank raus mittels KursID
    }
}
