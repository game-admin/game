/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game.trainee.testquiz;

import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jan
 */
@NamedQuery(name = Quiz.QUERY_FINDBY_BESCHREIBUNG, query = "SELECT quiz FROM Quiz quiz WHERE quiz.beschreibung like :beschreibung")
@Entity
@Table(name = "quiz", schema = "game")
public class Quiz implements Serializable {
    public static final String QUERY_FINDBY_BESCHREIBUNG="Quiz.findByBeschreibung";
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int QID;
    @NotNull @Column(name = "TITEL")
    private String titel;
    @Column(name = "BESCHREIBUNG")
    private String beschreibung;
    @NotNull @Column(name = "REWARD")
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
