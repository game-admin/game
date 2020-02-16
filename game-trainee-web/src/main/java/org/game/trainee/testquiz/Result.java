/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;


/**
 *
 * @author Eric
 */
public class Result implements Serializable {
    public String falscheFrage;
    public String richtigeAntwort;
    public String farbe;

    public Result(String falscheFrage, String richtigeAntwort, String farbe) {
        this.falscheFrage = falscheFrage;
        this.richtigeAntwort = richtigeAntwort;
        this.farbe = farbe;
    }

    public String getFalscheFrage() {
        return falscheFrage;
    }

    public void setFalscheFrage(String falscheFrage) {
        this.falscheFrage = falscheFrage;
    }

    public String getRichtigeAntwort() {
        return richtigeAntwort;
    }

    public void setRichtigeAntwort(String richtigeAntwort) {
        this.richtigeAntwort = richtigeAntwort;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
    
}