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
    
    
         
    public ModellCreator() {
    }
    
    public List<TestQuiz> createModell(int size, boolean isMultipleChoice) {
        List<TestQuiz> list = new ArrayList<>();
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
        return fragebean.find(""+index).getFrage();
    }
    
    public List<Antwortmoeglichkeiten> getAntwortenFromIndex(int index) {
        return fragebean.find(""+index).getAntworten();
    }
    
    public List<Antwortmoeglichkeiten> getAntwortenZuIndex(String index) {
        return fragebean.find(index).getAntworten();
    }
    
    public int getIndexRichtigFromIndex(List<Antwortmoeglichkeiten> antworten) {
        for (int i = 0; i < 4; i++) {
            if(antworten.get(i).isRichtigeAntwort()) {
                return i;
            }
        }
        return 0;
    }

    public List<String> getFragen() {
        return fragen;
    }

    public String[][] getAntworten() {
        return antworten;
    }

    public List<Integer> getIndexrichtig() {
        return indexrichtig;
    }   
}
