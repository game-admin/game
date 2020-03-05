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
        List<Frage> fragen = fragebean.findFrageByQID(qid);
        List<FrageModell> list = new ArrayList<>(fragen.size());
        
        for(Frage frage : fragen){
            List<Antwortmoeglichkeiten> antwortMoeglichkeiten = frage.getAntworten();
            List<String> antwortTexte = new ArrayList<>(antwortMoeglichkeiten.size());
            for(Antwortmoeglichkeiten moeglichkeit : antwortMoeglichkeiten){
                antwortTexte.add(moeglichkeit.getAntwort());
            }
            list.add(new FrageModell(frage.getFrage(), antwortTexte, getIndexRichtigFromIndex(antwortMoeglichkeiten)));
        }
        return list;
    }
    
    public String getFragenFromIndex(String qid, int index) {
        return fragebean.findFrageByQID(qid).get(index).getFrage();
    }
    
    public List<String> getAntwortenFromIndex(int i, String qid) {
        Frage frage = fragebean.find(Integer.toString(i));
        List<Antwortmoeglichkeiten> var = frage.getAntworten();    //hier bekommt er eine 0er Liste wenn ich nach qid und fid suche
        List<String> antworten = new ArrayList<>();
        for(int j=0; j < var.size(); j++) {
           antworten.add(var.get(j).getAntwort());
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
