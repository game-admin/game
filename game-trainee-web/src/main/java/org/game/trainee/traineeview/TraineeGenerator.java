/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.traineeview;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Eric
 */
@Named
@ApplicationScoped
public class TraineeGenerator {
   
    private final List<String> names = new ArrayList<>();
    private final List<String> nicknames = new ArrayList<>();
    private final List<String> abteilungen = new ArrayList<>();
    private final List<Double> progress = new ArrayList<>();
    
    public TraineeGenerator() {
        names.add("Eric Haneder");
        names.add("Jan Binder");
        names.add("Alex Saliger");
        names.add("Alexander Wurst");
        
        nicknames.add("ericbensi");
        nicknames.add("Syreax");
        nicknames.add("SaAlexX");
        nicknames.add("Wursti");
        
        abteilungen.add("Management");
        abteilungen.add("Serverwartung");
        abteilungen.add("Softwaredevelopment ");
        abteilungen.add("Softwarearchitektur");
        
        progress.add(50.0);
        progress.add(80.0);
        progress.add(60.0);
        progress.add(30.0);
    }
    
    public List<Trainee> createTrainees(int size) {
        List<Trainee> list = new ArrayList<>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Trainee(getNameFromIndex(i), getNicknameFromIndex(i), getAbteilungFromIndex(i), getProgressFromIndex(i)));
            list.get(i).embleme.add("emblem.png");
        }
        return list;
    }
    
    public String getNameFromIndex(int i) {
        return names.get(i);
    }
    public String getAbteilungFromIndex(int i) {
        return abteilungen.get(i);
    }
    public String getNicknameFromIndex(int i) {
        return nicknames.get(i);
    }
    public double getProgressFromIndex(int i) {
        return progress.get(i);
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getNicknames() {
        return nicknames;
    }

    public List<String> getAbteilungen() {
        return abteilungen;
    }

    public List<Double> getScores() {
        return progress;
    }
    
}

