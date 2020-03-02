/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author Eric/Jan
 */
@Named
@ApplicationScoped
public class ModellCreator {
    
    @Inject
    FrageEJB fragebean;
    
    @Inject
    AntwortmoeglichkeitenEJB antwortbean;
         
    public ModellCreator() {
    }
    
    public List<FrageModell> createModell(int size, String qid, boolean isMultipleChoice) {
        List<FrageModell> list = new ArrayList<>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new FrageModell(getFragenFromIndex(qid,i), getAntwortenFromIndex(i,qid), getIndexRichtigFromIndex(getAntwortenZuIndex(i))));
        }
        return list;
    }
    
    public String getFragenFromIndex(String qid, int index) {
        return fragebean.findFrageByQID(qid).get(index).getFrage();
    }
    
    public List<String> getAntwortenFromIndex(int index, String qid) {
        String test = "2";
        if(qid==test) {
            index = index + 5;
        } else {
            index = index +1;
        }
        List<Antwortmoeglichkeiten> var = antwortbean.findAntwortenByFID(""+index);    //hier bekommt er eine 0er Liste wenn ich nach qid und fid suche
        List<String> antworten = new ArrayList<>();
        for(int i=0; i<var.size(); i++) {
           antworten.add(var.get(i).getAntwort()); 
        }
        return antworten; 
    }
    
    public List<Antwortmoeglichkeiten> getAntwortenZuIndex(int index) {
        index++;
        return antwortbean.findAntwortenByFID(""+index);
    }
    
    public int getIndexRichtigFromIndex(List<Antwortmoeglichkeiten> antworten) {
        for (int i = 0; i < antworten.size(); i++) {
            if(antworten.get(i).isRichtigeAntwort()) {
                return i;
            }
        }
        return 0;
    }
}
