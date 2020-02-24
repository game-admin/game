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
import org.game.trainee.traineeview.Trainee;

/**
 *
 * @author Jan
 */
@Entity
@Table(name = "quizbeantwortung", schema = "game")
public class Quizbeantwortung implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int QBEID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="QID")
    private Quiz quiz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MitID")
    private Trainee trainee;
    @NotNull
    @Column(name="ERREICHTEPUNKTE")
    private int erreichtePunkte;

    public int getQBEID() {
        return QBEID;
    }

    public void setQBEID(int QBEID) {
        this.QBEID = QBEID;
    }

    public int getErreichtePunkte() {
        return erreichtePunkte;
    }

    public void setErreichtePunkte(int erreichtePunkte) {
        this.erreichtePunkte = erreichtePunkte;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }
    
    
}
