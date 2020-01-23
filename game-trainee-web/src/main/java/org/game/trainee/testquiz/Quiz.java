/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
import java.sql.Blob;
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
public class Quiz implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int QID;
    @NotNull
    private String titel;
    private String beschreibung;
    @NotNull
    private Blob reward;

    public int getQID() {
        return QID;
    }

    public void setQID(int QID) {
        this.QID = QID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String Titel) {
        this.titel = Titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String Beschreibung) {
        this.beschreibung = Beschreibung;
    }

    public Blob getReward() {
        return reward;
    }

    public void setReward(Blob reward) {
        this.reward = reward;
    }
    
    
}
