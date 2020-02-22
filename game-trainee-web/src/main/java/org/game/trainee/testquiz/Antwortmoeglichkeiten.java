/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan
 */

@Entity
@Table(name = "antwortmoeglichkeiten", schema = "game")
public class Antwortmoeglichkeiten implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ANTWID")
    private int AntwID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FID")
    private Frage frage;
    @NotNull
    @Column(name="ANTWORT")
    private String antwort;
    @Column(name="RICHTIGEANTWORT")
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
