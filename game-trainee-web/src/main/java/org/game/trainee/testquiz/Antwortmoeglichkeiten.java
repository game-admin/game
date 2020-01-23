/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan
 */

@Entity
public class Antwortmoeglichkeiten implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int AntwID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FID")
    private Frage frage;
    @NotNull
    private String antwort;
    private boolean richtigeAntwort;

    public int getAntwID() {
        return AntwID;
    }

    public void setAntwID(int AntwID) {
        this.AntwID = AntwID;
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String Antwort) {
        this.antwort = Antwort;
    }

    public boolean isRichtigeAntwort() {
        return richtigeAntwort;
    }

    public void setRichtigeAntwort(boolean richtigeAntwort) {
        this.richtigeAntwort = richtigeAntwort;
    }
    
    
}
