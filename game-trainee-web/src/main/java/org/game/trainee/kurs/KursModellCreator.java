/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.kurs;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Eric
 */
public class KursModellCreator {
    
    @Inject
    KursEJB kursbean;
    
    public List<KursModell> createModell() {
       List<Kurs> kurse = kursbean.findAll(); 
       List<KursModell> list = new ArrayList<>();
       
       for(Kurs kurs : kurse){
           list.add(new KursModell(kurs.getKursID(), kurs.getTitel(), kurs.getBeschreibung(), kurs.getBeschreibung()));
        }
        return list;
    }
    
}
