/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.quiz;

import java.util.List;

/**
 *
 * @author Eric
 */
public class Results {
    private String frage;
    private List<String> antworten;
    private List<Integer> richtigeAntworten;
    private boolean istfalsch;
    
    public Results(String frage, List<String> antworten, List<Integer> richtigeAntworten, boolean istfalsch) {
        this.frage=frage;
        this.antworten=antworten;
        this.richtigeAntworten=richtigeAntworten;
        this.istfalsch=istfalsch;
    }

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public List<String> getAntworten() {
        return antworten;
    }

    public void setAntworten(List<String> antworten) {
        this.antworten = antworten;
    }

    public List<Integer> getRichtigeAntworten() {
        return richtigeAntworten;
    }

    public void setRichtigeAntworten(List<Integer> richtigeAntworten) {
        this.richtigeAntworten = richtigeAntworten;
    }

    public boolean isIstfalsch() {
        return istfalsch;
    }

    public void setIstfalsch(boolean isfalsch) {
        this.istfalsch = isfalsch;
    }
    
}
