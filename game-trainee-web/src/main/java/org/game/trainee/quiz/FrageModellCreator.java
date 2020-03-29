/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.quiz;

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
public class FrageModellCreator {
    
    @Inject
    FrageEJB fragebean;
    
    @Inject
    AntwortmoeglichkeitenEJB antwortbean;
         
    public FrageModellCreator() {
    }
    
    public List<FrageModell> createModell(String qid) {
        List<Frage> fragen = fragebean.findFrageByQID(qid);
        List<FrageModell> list = new ArrayList<>(fragen.size());
        
        for(Frage frage : fragen){
            List<Antwortmoeglichkeiten> antwortMoeglichkeiten = frage.getAntworten();
            List<String> antwortTexte = new ArrayList<>(antwortMoeglichkeiten.size());
            for(Antwortmoeglichkeiten moeglichkeit : antwortMoeglichkeiten){
                antwortTexte.add(moeglichkeit.getAntwort());
            }
            list.add(new FrageModell(frage.getFrage(), antwortTexte, getIndexRichtigFromIndex(antwortMoeglichkeiten), qid));
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
    
    public List<Integer> getIndexRichtigFromIndex(List<Antwortmoeglichkeiten> antworten) {
        List<Integer> list = new ArrayList<>(antworten.size());
        for (int i = 0; i < antworten.size(); i++) {
            if(antworten.get(i).isRichtigeAntwort()) {
                list.add(1);
            }
            list.add(0);
        }
        return list;
    }
}
