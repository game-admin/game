/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan
 */
@Entity
@Table(name = "frage", schema = "game")
public class Frage implements Serializable {
    @Id
    private String FID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="QID")
    private Quiz quiz;
    @NotNull
    @Column(name="FRAGE")
    private String Frage;
    @NotNull
    @Column(name="PUNKTEZAHL")
    private int punktezahl;
    
    public Frage() {
        
    }
    
    public Frage(String FID) {
        this.FID = FID;
    }

    public String getFID() {
        return FID;
    }

    public void setId(String FID) {
        this.FID = FID;
    }

    public String getFrage() {
        return Frage;
    }

    public void setFrage(String Frage) {
        this.Frage = Frage;
    }

    public int getPunktezahl() {
        return punktezahl;
    }

    public void setPunktezahl(int Punktezahl) {
        this.punktezahl = Punktezahl;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
