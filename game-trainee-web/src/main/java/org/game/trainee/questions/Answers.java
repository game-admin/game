/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.questions;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan
 */
@Entity
public class Answers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int antwid;
    @ManyToOne
    private int fnr;
    @NotNull
    private String antwort;
    @NotNull
    private boolean richtigeAntwort;

    public int getId() {
        return antwid;
    }

    public void setId(int id) {
        this.antwid = antwid;
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    public boolean isRichtigeAntwort() {
        return richtigeAntwort;
    }

    public void setRichtigeAntwort(boolean richtigeAntwort) {
        this.richtigeAntwort = richtigeAntwort;
    }
    
    
    
}
