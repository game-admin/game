/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan
 */

@Entity
public class Antwort implements Serializable {
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private int gewaehlteAntwortID;
    @NotNull
    private String gewaehlteAntwort;

    public int getGewaehlteAntwortID() {
        return gewaehlteAntwortID;
    }

    public void setGewaehlteAntwortID(int GewaehlteAntwortID) {
        this.gewaehlteAntwortID = GewaehlteAntwortID;
    }

    public String getGewaehlteAntwort() {
        return gewaehlteAntwort;
    }

    public void setGewaehlteAntwort(String gewaehlteAntwort) {
        this.gewaehlteAntwort = gewaehlteAntwort;
    }
    
    
    
}
