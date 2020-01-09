/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.quiz;

import java.io.Serializable;

/**
 *
 * @author Eric
 */
public class Frage implements Serializable {
    public String frage;
    public String[] antworten;
    public int indexrichtig;
    
    public Frage(String frage, String[] antworten, int indexrichtig) {
        this.frage=frage;
        this.antworten=antworten;
        this.indexrichtig=indexrichtig;
    }

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public String[] getAntworten() {
        return antworten;
    }

    public void setAntworten(String[] antworten) {
        this.antworten = antworten;
    }

    public int getIndexrichtig() {
        return indexrichtig;
    }

    public void setIndexrichtig(int indexrichtig) {
        this.indexrichtig = indexrichtig;
    }
    
    
}
