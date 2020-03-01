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
    
    public List<FrageModell> createModell(int size, boolean isMultipleChoice) {
        List<FrageModell> list = new ArrayList<>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new FrageModell(getFragenFromIndex(i), getAntwortenFromIndex(i), getIndexRichtigFromIndex(getAntwortenZuIndex(""+i))));
        }
        return list;
    }
    
    public boolean[] createButtons(int size) { //Deprecated?
        boolean[] b = new boolean[size];
        for(int i=0; i<b.length; i++)
            b[i] = false;
        return b;
    }
    
    public String getFragenFromIndex(int index) {
        int i = index+1;
        return fragebean.find(""+i).getFrage();
    }
    
    public List<String> getAntwortenFromIndex(int index) {
        int j = index+1;
        List<Antwortmoeglichkeiten> var = antwortbean.findAntwortenByFID(""+j); //Hier kommt eine Liste mit der Size 1
        List<String> antworten = new ArrayList<>();
        for(int i=0; i<var.size(); i++) {
           antworten.add(var.get(i).getAntwort()); 
        }
        return antworten; //dh hier wird auch eine Liste mit size 1 zurückgegeben, sollte eig size 4 sein
    }
    
    public List<Antwortmoeglichkeiten> getAntwortenZuIndex(String index) {
        int j = Integer.parseInt(index)+1;
        return antwortbean.findAntwortenByFID(""+j);
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
