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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan
 */
@Entity
public class Frage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int FID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="QID")
    private Quiz quiz;
    @NotNull
    @Column(name="FRAGE")
    private String Frage;
    @NotNull
    @Column(name="PUNKTEZAHL")
    private int punktezahl;

    public int getFID() {
        return FID;
    }

    public void setId(int FID) {
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
}
