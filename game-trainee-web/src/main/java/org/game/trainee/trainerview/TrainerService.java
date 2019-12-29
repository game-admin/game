/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.trainerview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Eric
 */
@Named
@ApplicationScoped
public class TrainerService {
     
    private final static String[] roles; 
    private final static String[] branches;
    private final static String[] names;
     
    static {
        roles = new String[4];
        roles[0] = "Abteilungsleiter";
        roles[1] = "Gruppenleiter";
        roles[2] = "Projektleiter";
        roles[3] = "Projektmitglied";
         
        branches = new String[3];
        branches[0] = "Development";
        branches[1] = "Architecture";
        branches[2] = "Design";
        
        names = new String[10];
        names[0] = "Max";
        names[1] = "Peter";
        names[2] = "Tim";
        names[3] = "Tom";
        names[4] = "Alex";
        names[5] = "Josef";
        names[6] = "Mr. Knolle";
        names[7] = "BensiBoi";
        names[8] = "Michael";
        names[9] = "Martin";
      
    }
     
    public List<Trainer> createTrainers(int size) {
        List<Trainer> list = new ArrayList<>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Trainer(getRandomName(), getRandomBranch(), getRandomRole()));
        }
         
        return list;
    }
     
    private String getRandomName() {
        return names[(int) (Math.random() * 10)];
        
    }
     
    private String getRandomRole() {
        return roles[(int) (Math.random() * 4)];
    }
     
    private String getRandomBranch() {
        return branches[(int) (Math.random() * 3)];
    }
     
    public List<String> getRoles() {
        return Arrays.asList(roles);
    }
     
    public List<String> getBranches() {
        return Arrays.asList(branches);
    }
    
    public List<String> getNames() {
        return Arrays.asList(names);
    }
}
