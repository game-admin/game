/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.quiz;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Eric
 */
public class Quiz implements Serializable {
    public List<Frage> fragen;
    
    public Quiz(List<Frage> fragen) {
        this.fragen=fragen;
    }
    public Quiz() {}
    
    public List<Frage> getFragen() {
        return fragen;
    }

    public void setFragen(List<Frage> fragen) {
        this.fragen = fragen;
    }
    
}
